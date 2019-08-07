package coreJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Dfs {

    public <K> String dfsStackImpl(Map<K, List<K>> graph) {

	Set<K> nodes = graph.keySet();
	Iterator<K> iterator = nodes.iterator();
	String dfs = null;
	Set<K> history = new HashSet<>();
	Stack<K> stack = new Stack<>();
	// Needed to handel a graph that is composed sub cluster graph
	while (iterator.hasNext()) {
	    K node = iterator.next();
	    if (!history.contains(node)) {
		stack.push(node);
		history.add(node);
	    }

	    while (!stack.isEmpty()) {
		K vertex = stack.pop();
		dfs = dfs == null ? vertex.toString() : dfs + "-" + vertex;
		List<K> neighbors = graph.get(vertex);

		// dfs fro left to right
		int i = neighbors.size() - 1;
		while (i >= 0) {
		    K neighbor = neighbors.get(i);
		    if (!history.contains(neighbor)) {
			stack.push(neighbor);
			history.add(neighbor);
		    }

		    i--;
		}
	    }
	}

	return dfs;
    }

    public <T> List<T> postOrder_recursion(Map<T, List<T>> graph) {
	Set<T> visited = new HashSet<>();
	Set<T> vertices = graph.keySet();
	List<T> result = new ArrayList<>();

	for (T vertex : vertices) {

	    List<T> postOrder = postOrder_recursion(graph, visited, vertex);
	    result.addAll(postOrder);
	}

	return result;
    }

    private <T> List<T> postOrder_recursion(Map<T, List<T>> graph,
	    Set<T> visited, T vertex) {
	List<T> postOrder = new ArrayList<>();

	if (visited.contains(vertex)) {
	    return postOrder;
	}

	visited.add(vertex);
	List<T> neighbors = graph.get(vertex);

	for (T neighbor : neighbors) {
	    postOrder.addAll(postOrder_recursion(graph, visited, neighbor));
	}

	postOrder.add(vertex);

	return postOrder;
    }

    /**
     * The idea is to record all leafs or all nodes whose children have all been
     * recorded to result_stack. Otherwise, if a node has children that are not
     * recorded to result stack than that node should be pushed onto the
     * stackParents. Note, if node has children not in the memory processor that
     * basically means that they are not yet recorder to result stack, hence
     * that node should be pushed onto the parentStack. If the node has children
     * in the processor memory but that does not mean that the stack processor
     * has processed then and recorded them to the stack result. You will only
     * record a node with children to the result stack if all its children have
     * been recorded into the stack result.
     * 
     * @param graph
     * @return
     */
    public <T> List<T> topologicalSort_stack(Map<T, List<T>> graph) {

	Stack<T> stack = postOrder_stack(graph);
	List<T> result = new ArrayList<>();
	while (!stack.isEmpty()) {
	    result.add(stack.pop());
	}
	return result;
    }

    public <T> Stack<T> postOrder_stack(Map<T, List<T>> graph) {

	Stack<T> result = new Stack<>();
	Iterator<T> iterator = graph.keySet().iterator();
	while (iterator.hasNext()) {
	    T vertex = iterator.next();
	    postOrder_stack(graph, result, vertex);

	}
	return result;
    }

    public <T> void postOrder_stack(Map<T, List<T>> graph, Stack<T> result,
	    T node) {

	Stack<T> processor = new Stack<T>();

	if (result.contains(node))
	    return;

	processor.push(node);

	while (!processor.isEmpty()) {
	    T vertex = processor.pop();
	    if (result.contains(vertex)) {
		continue;
	    }

	    List<T> neighbors = graph.get(vertex);

	    if (neighbors.isEmpty()) {
		result.push(vertex);
		continue;
	    }

	    processor.push(vertex);
	    boolean flag = true;
	    for (T neighbor : neighbors) {
		if (!result.contains(neighbor)) {
		    flag = false;
		    processor.push(neighbor);
		}

	    }

	    if (flag) {
		processor.pop();
		result.push(vertex);
	    }
	}

    }

    public <T> List<T> topologicalSort_rec(Map<T, List<T>> graph) {

	Iterator<T> iterator = graph.keySet().iterator();

	List<T> result = new ArrayList<T>();
	while (iterator.hasNext()) {
	    T vertex = iterator.next();
	    topologicalSort_rec(vertex, graph, result);
	}

	int i = 0;
	int size = result.size();
	int limit = size / 2;
	while (i < limit) {
	    int j = size - 1 - i;
	    T temp_j = result.get(j);
	    T temp_i = result.get(i);
	    result.set(j, temp_i);
	    result.set(i, temp_j);
	    i++;

	}

	return result;
    }

    private <T> void topologicalSort_rec(T vertex, Map<T, List<T>> graph,
	    List<T> result) {

	if (result.contains(vertex)) {
	    return;
	}

	List<T> neighbors = graph.get(vertex);

	if (neighbors.isEmpty()) {
	    result.add(vertex);
	    return ;
	}

	for (T neighbor : neighbors) {
	    topologicalSort_rec(neighbor, graph, result);
	}

	result.add(vertex);
	return;
    }

    public <T> String cyclicPath_recursion(Map<T, List<T>> graph) {

	List<T> postOrderPath = new ArrayList<>();
	Stack<T> cyclicPath = new Stack<>();
	Iterator<T> iterator = graph.keySet().iterator();
	boolean isCyclic = false;
	while (iterator.hasNext()) {
	    T vertex = iterator.next();
	    if (!postOrderPath.contains(vertex)) {
		isCyclic = cyclicPath_recursion(graph, cyclicPath,
			postOrderPath, vertex);
		if (isCyclic) {
		    break;
		}
	    }
	}

	String result = cyclicPath.stream().map(x -> x.toString())
		.reduce((x, y) -> x + "-" + y).orElse("");
	// System.out.println(postOrderPath);
	return result;
    }

    public <T> boolean cyclicPath_recursion(Map<T, List<T>> graph,
	    Stack<T> cyclicPath, List<T> postOrderPath, T vertex) {

	List<T> neighbors = graph.get(vertex);
	if (neighbors.isEmpty()) {
	    postOrderPath.add(vertex);
	    return false;
	}

	cyclicPath.push(vertex);
	for (T neighbor : neighbors) {
	    if (cyclicPath.contains(neighbor)) {
		cyclicPath.push(neighbor);
		return true;
	    }

	    if (!postOrderPath.contains(neighbor)) {
		if (cyclicPath_recursion(graph, cyclicPath, postOrderPath,
			neighbor)) {
		    return true;
		}

	    }
	}
	postOrderPath.add(vertex);
	cyclicPath.pop();
	return false;

    }

    public <T> String cyclicPath_stack(Map<T, List<T>> graph) {
	Stack<T> processor = new Stack<>();
	Stack<T> postOrderTraversal = new Stack<>();
	Stack<T> isBeingVisited = new Stack<>();

	Iterator<T> iterator = graph.keySet().iterator();
	exit: while (iterator.hasNext()) {
	    T vertex = iterator.next();
	    if (!postOrderTraversal.contains(vertex)) {
		processor.add(vertex);
		while (!processor.isEmpty()) {
		    T node = processor.pop();
		    if (postOrderTraversal.contains(node)) {
			continue;
		    }
		    List<T> neighbors = graph.get(node);
		    if (neighbors.isEmpty()) {
			postOrderTraversal.add(node);
			continue;
		    }

		    processor.push(node);

		    boolean flag = true;
		    for (T neighbor : neighbors) {
			if (!postOrderTraversal.contains(neighbor)) {
			    flag = false;
			    processor.push(neighbor);
			}
		    }

		    if (flag) {
			/*
			 * System.out.println(processor);
			 * System.out.println(isBeingVisited);
			 * System.out.println("******");
			 */
			processor.pop();
			postOrderTraversal.add(node);
			isBeingVisited.remove(node);
		    } else {
			if (isBeingVisited.contains(node)) {
			    isBeingVisited.push(node);
			    break exit;
			}
			isBeingVisited.push(node);
		    }

		}
	    }
	}

	String result = isBeingVisited.stream().map(x -> x.toString())
		.reduce((a, b) -> a + "-" + b).orElse("");

	return result;
    }

    public List<String> solveMaze_rescursion(char[][] maze, int start_x,
	    int start_y) {

	List<Character> isBeingVisited = new ArrayList<>();
	List<Stack<Character>> result_stack = solveMaze_rescursion(maze,
		start_x, start_y, isBeingVisited);
	List<String> paths = result_stack.stream().map(stack -> {
	    String path = "";
	    while (!stack.isEmpty()) {
		path = path + "-" + stack.pop();
	    }

	    path = path.substring(1);

	    return path;
	}).collect(Collectors.toList());

	return paths;
    }

    private List<Stack<Character>> solveMaze_rescursion(char[][] maze,
	    int start_x, int start_y, List<Character> isBeingVisited) {
	List<Stack<Character>> paths = new ArrayList<>();

	int row = maze.length;
	int col = maze[0].length;
	if (start_x < 0 || start_y < 0 || start_x >= row || start_y >= col)
	    return paths;

	char vertex = maze[start_x][start_y];
	if (isBeingVisited.contains(vertex)) {
	    return paths;
	}
	if (vertex == 'X')
	    return paths;

	if (vertex == 'Z') {
	    Stack<Character> stack = new Stack<>();
	    stack.push(vertex);
	    paths.add(stack);
	    return paths;
	}

	isBeingVisited.add(vertex);
	List<Stack<Character>> upPaths = solveMaze_rescursion(maze,
		start_x - 1, start_y, isBeingVisited);
	List<Stack<Character>> rightPaths = solveMaze_rescursion(maze, start_x,
		start_y + 1, isBeingVisited);
	List<Stack<Character>> downPaths = solveMaze_rescursion(maze,
		start_x + 1, start_y, isBeingVisited);
	List<Stack<Character>> leftPaths = solveMaze_rescursion(maze, start_x,
		start_y - 1, isBeingVisited);
	isBeingVisited.remove(new Character(vertex));
	for (Stack<Character> upPath : upPaths) {
	    upPath.push(vertex);
	    paths.add(upPath);
	}

	for (Stack<Character> rightPath : rightPaths) {
	    rightPath.push(vertex);
	    paths.add(rightPath);
	}

	for (Stack<Character> leftPath : leftPaths) {
	    leftPath.push(vertex);
	    paths.add(leftPath);
	}

	for (Stack<Character> downPath : downPaths) {
	    downPath.push(vertex);
	    paths.add(downPath);
	}
	return paths;
    }

    public static class Node {
	int x;
	int y;
	Character name;

	public Node(char[][] maze, int x, int y) {

	    int row = maze.length;
	    int col = maze[0].length;
	    this.x = x;
	    this.y = y;

	    if (x < 0 || x >= row || y < 0 || y >= col) {
		name = null;

	    } else {

		name = maze[x][y];

		if (name == 'X')
		    name = null;
	    }

	}

	@Override
	public boolean equals(Object obj) {

	    Node node = (Node)obj;
	    if(node.name == name)
	    {
		return true;
	    }
	    
	    return false;
	}
	
	@Override
	public String toString() {
	  
	    String result = Character.toString(name);
	    return result;
	}

    }

    public List<String> solveMaze_stack(char[][] maze, int start_x, int start_y) {

	List<String> paths = new ArrayList<>();

	Stack<Node> processor = new Stack<>();
	List<Node> memory = new ArrayList<>();

	Node vertex = new Node(maze, start_x, start_y);
	if (vertex.name == null)
	    return paths;

	processor.push(vertex);
	while (!processor.isEmpty()) {
	    vertex = processor.pop();

		
	    if (memory.contains(vertex)) {
		memory.remove(vertex);
		continue;
	    }

	    if (vertex.name == 'Z') {
	
		String path = memory.stream().map(n -> Character.toString(n.name)).collect(Collectors.joining("-")) + "-" + vertex.name;
		paths.add(path);
		continue;
	    }

	    List<Node> neighbors = getNeighbors(maze, vertex);
	    if (neighbors.isEmpty()) {
		continue;
	    }

	    processor.push(vertex);
	    boolean flag = false;
	    for (Node neighbor : neighbors) {
		if (!memory.contains(neighbor)) {
		    flag = true;
		    processor.push(neighbor);
		}
	    }

	    if (flag) {
		memory.add(vertex);
	    } else {
		processor.pop();
	    }

	}
	return paths;
    }

    private List<Node> getNeighbors(char[][] maze, Node node) {

	List<Node> neighbors = new ArrayList<>();
	int x = node.x;
	int y = node.y;
	Node upNeighbor = new Node(maze, x, y+1);
	Node rightNeighbor = new Node(maze, x + 1, y);
	Node downNeighbor = new Node(maze, x, y - 1);
	Node leftNeighbor = new Node(maze, x - 1, y);

	Consumer<Node> consumer = vertex -> {
	    if (vertex.name != null) {
		neighbors.add(vertex);
	    }
	};

	consumer.accept(upNeighbor);
	consumer.accept(rightNeighbor);
	consumer.accept(downNeighbor);
	consumer.accept(leftNeighbor);

	return neighbors;
    }


}

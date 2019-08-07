package coreJava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Dijkatra {

    Map<Character, Map<Character, Integer>> graph = null;
    Map<Character, Node> table = null;
    Queue<Node> processor = new PriorityQueue<Node>();

    static class Node implements Comparable<Node> {

	Character name = null;
	Character predecessor = null;
	int distance = Integer.MAX_VALUE;
	boolean isVisited = false;

	public Node(Character predecessor, int distance) {
	    this.predecessor = predecessor;
	    this.distance = distance;

	}

	private Node() {
	}

	@Override
	public boolean equals(Object obj) {

	    if (obj == null)
		return false;

	    if (obj == this)
		return true;

	    if (!(obj instanceof Node))
		return false;

	    Node node = (Node) obj;
	    if (node.predecessor == null) {
		if (predecessor == null && node.distance == distance) {
		    return true;
		}
		return false;
	    }

	    if (node.predecessor.equals(predecessor)
		    && node.distance == distance)
		return true;

	    return false;

	}

	@Override
	public int compareTo(Node o) {

	    if (distance < o.distance)
		return -1;
	    if (distance == o.distance)
		return 0;

	    return 1;

	}

	@Override
	public String toString() {

	    String result = "{predecessor= " + predecessor + ", distance= "
		    + distance + "}";
	    return result;
	}

    }

    public Dijkatra(Map<Character, Map<Character, Integer>> graph) {
	this.graph = graph;

	Iterator<Character> iterator = graph.keySet().iterator();
	table = new HashMap<>();
	while (iterator.hasNext()) {
	    Node node = new Node();
	    Character name = iterator.next();
	    node.name = name;
	    table.put(name, node);
	}

    }

    public String findShortestPath(char from, char to) {

	calculateDijkatraTable(from);
	Node node = table.get(to);
	String path = null;
	while (node.predecessor != null) {
	    path = (path == null) ? node.name.toString() : node.name.toString()
		    + "-" + path;
	    node = table.get(node.predecessor);
	}
	return from + "-" +path;
    }

    private void calculateDijkatraTable(char from) {

	Node node = table.get(from);
	node.distance = 0;

	processor.add(node);
	while (!processor.isEmpty()) {
	    node = processor.remove();

	    Set<Entry<Character, Integer>> neighbors = graph.get(node.name)
		    .entrySet();
	    for (Entry<Character, Integer> neighbor : neighbors) {
		Character name = neighbor.getKey();
		Node neighborNode = table.get(name);
		int distance = neighbor.getValue();

		if (neighborNode.isVisited)
		    continue;

		int tentativeShortestDistance = node.distance + distance;

		if (neighborNode.distance > tentativeShortestDistance) 
		{
		    neighborNode.distance = tentativeShortestDistance;
		    neighborNode.predecessor = node.name;
		    processor.remove(neighborNode);
		    processor.add(neighborNode);

		}
	    }
	    node.isVisited = true;
	}

    }

    public Map<Character, Node> getDijkatraTable() {

	Map<Character, Node> copy = new HashMap<Character, Dijkatra.Node>(table);
	return copy;
    }

}

package coreJava;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class AdjacencyListGraph {

    static class BreadthFirstNode {
	Integer shortesDistance = null;
	Integer predecessor = null;
    }

    static class Node implements Cloneable {
	Integer id = null;
	Integer distance = null;

	@Override
	public Node clone() {
	    Node clone = null;
	    try {
		clone = (Node) super.clone();
	    } catch (CloneNotSupportedException e) {
		e.printStackTrace();
	    }
	    return clone;
	}
    }

    private Map<Integer, List<Node>> vertices = new HashMap<>();
    private Map<Integer, BreadthFirstNode> breadthFirstTable = new HashMap<>();

    public void add(Integer vertex, Integer edge) {
	add(vertex, edge, 1);
    }

    public Map<Integer, List<Node>> getVertices() {

	Map<Integer, List<Node>> copyVertices = new HashMap<Integer, List<Node>>();

	vertices.forEach((k, v) -> {
	    Integer copyKey = new Integer(k.intValue());
	    List<Node> copyList = new ArrayList<>();
	    v.forEach(node -> {
		copyList.add(node.clone());
	    });
	    copyVertices.put(copyKey, copyList);
	});

	return copyVertices;
    }

    @Override
    public AdjacencyListGraph clone() {
	AdjacencyListGraph clone = new AdjacencyListGraph();
	clone.vertices = getVertices();
	return clone;
    }

    public void breadthFirst(Integer endVertex) {

	Set<Integer> vertexAddedToQueue = new HashSet<Integer>();
	Queue<Integer> vertexIds = new ArrayDeque<Integer>();
	vertexIds.add(endVertex);
	vertexAddedToQueue.add(endVertex);

	while (!vertexIds.isEmpty()) {
	    Integer nodeId = vertexIds.remove();
	    List<Node> neighbors = vertices.get(nodeId);

	    Set<Integer> newVertexIdTobeVisited = neighbors.stream()
		    .map(node -> node.id).collect(Collectors.toSet());
	    newVertexIdTobeVisited.removeAll(vertexAddedToQueue);
	    vertexIds.addAll(newVertexIdTobeVisited);
	    // Only add in the queue new Vertex neighbors to be visited
	    // otherwise, infinite loop especially for aj undirected graph
	    vertexAddedToQueue.addAll(newVertexIdTobeVisited);

	    BreadthFirstNode breadthFirstNode = breadthFirstTable.get(nodeId);
	    if (breadthFirstNode == null) {
		breadthFirstNode = new BreadthFirstNode();
		breadthFirstTable.put(nodeId, breadthFirstNode);
	    }

	    // Update the BreathFirstTable for my neighbor
	    for (Node neighbor : neighbors) {
		BreadthFirstNode breadthFirstNeighborNode = breadthFirstTable
			.get(neighbor.id);
		int candidateShortestDistance = breadthFirstNode.shortesDistance
			+ neighbor.distance;
		if (breadthFirstNeighborNode == null) {
		    // If no entries were present for my neighbor in the
		    // breadthFirstTable then shortestPath to endPoint is
		    // through me (nodeId) for now
		    breadthFirstNeighborNode = new BreadthFirstNode();
		    breadthFirstNeighborNode.predecessor = nodeId;
		    breadthFirstNeighborNode.shortesDistance = candidateShortestDistance;
		    breadthFirstTable
			    .put(neighbor.id, breadthFirstNeighborNode);
		} else {

		    // If an entry is already present then lets do the math to
		    // see if path through is shorter than what is present in
		    // BreathFirstTable
		    if (candidateShortestDistance < breadthFirstNeighborNode.shortesDistance) {
			breadthFirstNeighborNode.predecessor = nodeId;
			breadthFirstNeighborNode.shortesDistance = candidateShortestDistance;

		    }
		}
	    }

	}

    }

    Map<Integer, BreadthFirstNode> getBreadthFirstTable() {
	return breadthFirstTable;
    }

    void setBreadthFirstTable(Map<Integer, BreadthFirstNode> breadthFirstTable) {
	this.breadthFirstTable = breadthFirstTable;
    }

    public String findShortestPath(int startVertex, int endVertex) {
	breadthFirst(endVertex);
	String shortesPath = Integer.valueOf(startVertex).toString();
	while (startVertex != endVertex) {
	    Integer predecessor = breadthFirstTable.get(startVertex).predecessor;
	    shortesPath = shortesPath + ", " + predecessor.toString();
	    startVertex = predecessor;
	}

	return shortesPath;
    }

    public Integer findShortestDistance(int startVertex, int endVertex) {

	breadthFirst(endVertex);
	BreadthFirstNode breadthFirstNode = breadthFirstTable.get(startVertex);
	if (breadthFirstNode != null) {
	    return breadthFirstNode.shortesDistance;
	}
	return null;
    }

    public void add(Integer vertex, Integer edge, Integer distance) {

	List<Node> edges = new ArrayList<Node>();

	Node node = new Node();
	node.id = edge;
	node.distance = distance;

	edges.add(node);
	vertices.merge(vertex, edges, (oldValue, newValue) -> {
	    oldValue.addAll(newValue);
	    return oldValue;
	});
    }

    public void breadthFirst_1(int endVertex) {

	Queue<Integer> queue = new ArrayDeque<Integer>();
	Set<Integer> visitedNode = new HashSet<Integer>();

	BreadthFirstNode bfEndNode = new BreadthFirstNode();
	bfEndNode.shortesDistance = 0;
	breadthFirstTable.put(endVertex, bfEndNode);
	visitedNode.add(endVertex);
	queue.add(endVertex);
	while (!queue.isEmpty()) {
	    int nodeId = queue.remove();
	    List<Node> neighbors = vertices.get(nodeId);
	    Set<Integer> neighborsIds = neighbors.stream().map(node -> node.id)
		    .collect(Collectors.toSet());
	    neighborsIds.removeAll(visitedNode);
	    queue.addAll(neighborsIds);
	    visitedNode.addAll(neighborsIds);
	    
	    BreadthFirstNode bfNode = breadthFirstTable.get(nodeId);
	    for (Node neighbor : neighbors) {
		BreadthFirstNode bfNeighborNode = breadthFirstTable
			.get(neighbor.id);
		if(bfNeighborNode == null)
		{
		    bfNeighborNode = new BreadthFirstNode();
		    bfNeighborNode.predecessor=nodeId;
		    bfNeighborNode.shortesDistance=neighbor.distance+bfNode.shortesDistance;
		    breadthFirstTable.put(neighbor.id, bfNeighborNode);
		}
		else
		{
		    int shortestDistance = bfNeighborNode.shortesDistance;
		    int candidateShortestDistance = neighbor.distance+bfNode.shortesDistance;
		    if(candidateShortestDistance < shortestDistance)
		    {
			bfNeighborNode.predecessor=nodeId;
			bfNeighborNode.shortesDistance=candidateShortestDistance;
		    }
		}
	    }
	}

    }

}

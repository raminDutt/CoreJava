package coreJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import annotations.Todo;

/**
 * 
 * KruskalAlgorithm works on a undirected graph
 *
 * 
 */
public class KruskalAlgorithm<T> {

    Queue<Edge> edges = new PriorityQueue<>();
    List<Edge> spanningTree = new ArrayList<>();
    int minPathValue = 0;

    class Node {

	T name;
	Node parent;
	int height = 0;

	Node(T name) {
	    this.name = name;
	    parent = null;
	}

	public String toString() {
	    return name.toString();
	}
    }

    class Edge implements Comparable<Edge> {
	int weight;
	Node startVertex;
	Node endVertex;

	public String toString() {
	    String result = startVertex.toString() + endVertex.toString();
	    return result;
	}

	@Override
	public int compareTo(KruskalAlgorithm<T>.Edge o) {
	    if (weight > o.weight)
		return 1;
	    if (weight == o.weight)
		return 0;

	    return -1;
	}

    }

    class DisjointSets {

	Map<T, Node> sets = new HashMap<>();
	int size = 0;

	public Node makeSet(T t) {

	    Node node = new Node(t);
	    sets.put(t, node);
	    size++;
	    return node;
	}

	public boolean merge(Node startVertex, Node endVertex) {

	    Node startRep = findRepresentative(startVertex);
	    Node endRep = findRepresentative(endVertex);

	    if (startRep == endRep) {
		return false;
	    }
	    if (startRep.height < endRep.height) {
		startRep.parent = endRep;

	    }

	    if (startRep.height > endRep.height) {
		endRep.parent = startRep;

	    }

	    if (startRep.height == endRep.height) {
		startRep.parent = endRep;
		endRep.height++;
	    }

	    size--;
	    return true;
	}

	public Node findRepresentative(Node node) {
	    if (node.parent == null)
		return node;
	    node.parent = findRepresentative(node.parent);

	    return node.parent;

	}

	public int size() {
	    return size;
	}

    }

    public void apply(Map<T, Map<T, Integer>> graph) {

	DisjointSets disjointSets = new DisjointSets();
	Iterator<T> iterator = graph.keySet().iterator();
	while (iterator.hasNext()) {
	    T vertex = iterator.next();
	    if (disjointSets.sets.get(vertex) == null) {
		disjointSets.makeSet(vertex);
	    }

	    Set<Entry<T, Integer>> neighbors = graph.get(vertex).entrySet();
	    for (Entry<T, Integer> neighbor : neighbors) {
		Edge edge = new Edge();

		edge.startVertex = disjointSets.sets.get(vertex);
		Node endVertex = disjointSets.sets.get(neighbor.getKey());
		if (endVertex == null) {
		    endVertex = disjointSets.makeSet(neighbor.getKey());

		}
		edge.endVertex = endVertex;
		edge.weight = neighbor.getValue();
		edges.add(edge);
	    }

	}

	while (disjointSets.size() > 1) {
	    Edge edge = edges.remove();
	    boolean status = disjointSets.merge(edge.startVertex,
		    edge.endVertex);
	    if (status) {
		minPathValue = minPathValue + edge.weight;
		spanningTree.add(edge);
	    }

	}

    }

    public String[] getSpanningTree() {

	return spanningTree.stream().map(edge -> edge.toString())
		.toArray(size -> new String[size]);

    }

    public int getMinPathValue() {
	return minPathValue;

    }

}

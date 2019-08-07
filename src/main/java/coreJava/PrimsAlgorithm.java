package coreJava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


/**
 * 
 * Prime algorithm works on a undirected graph
 *
 */
public class PrimsAlgorithm<T> {


    private class Edge implements Comparable<Edge> {
	T startVertex;
	T endVertex;
	Integer weight;

	@Override
	public int compareTo(PrimsAlgorithm<T>.Edge o) {
	    return Integer.compare(weight, o.weight);
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj == null)
		return false;
	    if (obj == this)
		return true;
	    if (!(obj instanceof PrimsAlgorithm.Edge))
		return false;
	    Edge other = (Edge) obj;

	    if (other.startVertex.equals(startVertex)
		    && other.endVertex.equals(endVertex)
		    && other.weight.equals(weight)) {
		return true;
	    }
	    return false;
	}

	@Override
	public int hashCode() {

	    return Objects.hash(startVertex, endVertex, weight);
	}

    }

    Set<T> visitedVertices = new HashSet<>();
    List<Edge> spanningTree = new ArrayList<>();
    Queue<Edge> heap = new PriorityQueue<>();

    public void apply(Map<T, Map<T, Integer>> graph) {
	int numberOfVertices = graph.keySet().size();

	Iterator<T> iterator = graph.keySet().iterator();
	if (iterator.hasNext()) {
	    T vertex = iterator.next();
	    visitedVertices.add(vertex);

	    Set<Entry<T, Integer>> neighbors = graph.get(vertex).entrySet();

	    for (Entry<T, Integer> neighbor : neighbors) {
		Edge edge = new Edge();
		edge.startVertex = vertex;
		edge.endVertex = neighbor.getKey();
		edge.weight = neighbor.getValue();
		heap.add(edge);

	    }
	}

	while (visitedVertices.size() != numberOfVertices) {
	    Edge edge = heap.remove();

	    if (visitedVertices.contains(edge.endVertex))
		continue;

	    spanningTree.add(edge);
	    visitedVertices.add(edge.endVertex);

	    Set<Entry<T, Integer>> neighbors = graph.get(edge.endVertex)
		    .entrySet();
	    for (Entry<T, Integer> neighbor : neighbors) {

		if (visitedVertices.contains(neighbor.getKey()))
		    continue;

		Edge e = new Edge();
		e.startVertex = edge.endVertex;
		e.endVertex = neighbor.getKey();
		e.weight = neighbor.getValue();
		heap.add(e);

	    }

	}

    }

    public List<String> getSpanningTree() {

	return spanningTree.stream().map(e -> {
	    return e.startVertex.toString() + e.endVertex.toString();
	}).collect(Collectors.toList());

    }

    public int getMinPathValue() {
	return spanningTree.stream().mapToInt(e -> e.weight).sum();
    }

}

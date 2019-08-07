package coreJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;

import coreJava.Dijkatra.Node;

public class DAG {

    private class Vertex {
	String name;
	List<Edge> edges = new ArrayList<>();
	int shortestPath = Integer.MAX_VALUE;
	Vertex previous = null;

	public String toString() {
	    String result = "{name:" + name + ", neighbors:[" + edges + "]}";
	    return name;
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj == null)
		return false;
	    if (obj == this)
		return true;
	    if (!(obj instanceof Vertex))
		return false;

	    Vertex vertex = (Vertex) obj;
	    if (name.equals(vertex.name))
		return true;
	    return false;
	}

    }

    private class Edge {
	Vertex start;
	Vertex end;
	Integer weight;

	public String toString() {
	    String result = "{start:" + start.name + ", end:" + end.name
		    + ", weight:" + weight + "}";

	    return result;
	}
    }

    Map<String, Vertex> graph = new HashMap<>();

    public DAG(Map<Character, Map<Character, Integer>> graph) {
	Set<Entry<Character, Map<Character, Integer>>> entries = graph
		.entrySet();
	for (Entry<Character, Map<Character, Integer>> entry : entries) {
	    String v = entry.getKey().toString();
	    Vertex vertex = this.graph.get(v);
	    if (vertex == null) {
		vertex = new Vertex();
		vertex.name = v;
		this.graph.put(vertex.name, vertex);
	    }

	    Iterator<Entry<Character, Integer>> it = entry.getValue()
		    .entrySet().iterator();
	    while (it.hasNext()) {
		Edge edge = new Edge();

		Entry<Character, Integer> e = it.next();
		String endVertexName = e.getKey().toString();
		Vertex endVertex = this.graph.get(endVertexName);
		if (endVertex == null) {
		    endVertex = new Vertex();
		    endVertex.name = endVertexName;
		    this.graph.put(endVertex.name, endVertex);
		}

		edge.start = vertex;
		edge.end = endVertex;
		edge.weight = e.getValue();
		vertex.edges.add(edge);
	    }

	}

    }

    public Map<String, Integer> findShortestPath(Character from, Character to) {

	List<Vertex> topologicalOrder = findTopologicalOrder(from);
	graph.get(from.toString()).shortestPath = 0;
	Iterator<Vertex> iterator = topologicalOrder.iterator();
	while (iterator.hasNext()) {
	    Vertex vertex = iterator.next();
	    List<Edge> edges = vertex.edges;
	    Consumer<? super Edge> relaxEdge = e -> {
		Vertex neighbor = e.end;
		int distance = vertex.shortestPath + e.weight;
		if (neighbor.shortestPath > distance) {
		    neighbor.shortestPath = distance;
		    neighbor.previous = vertex;
		}
	    };
	    edges.forEach(relaxEdge);
	}

	String path = null;
	Vertex v = graph.get(to.toString());
	while (v != null) {
	    if (path == null) {
		path = v.name;
	    } else {
		path = v.name + "-" + path;
	    }
	    v = v.previous;
	}
	Map<String,Integer> map = new HashMap<>();
	map.put(path, graph.get(to.toString()).shortestPath);
	return map;
    }

    private List<Vertex> findTopologicalOrder(Character from) {

	Stack<Vertex> processor = new Stack<>();
	Set<Vertex> memory = new HashSet();
	List<Vertex> result = new ArrayList();

	Vertex vertex = graph.get(from.toString());
	processor.push(vertex);
	while (!processor.empty()) {
	    vertex = processor.pop();
	    if (result.contains(vertex)) {
		continue;
	    }

	    List<Edge> edges = vertex.edges;
	    if (edges.isEmpty()) {
		result.add(vertex);
		continue;
	    }

	    processor.push(vertex);
	    memory.add(vertex);
	    boolean flag = true;
	    boolean cycle = false;
	    for (Edge edge : edges) {
		Vertex neighbor = edge.end;

		if (memory.contains(neighbor)) {
		    System.out.println("Cycle detected: exiting ...");
		    cycle = true;
		    break;
		}

		if (!result.contains(neighbor)) {

		    processor.push(neighbor);
		    flag = false;

		}
	    }

	    if (cycle) {
		result = Collections.EMPTY_LIST;
		break;
	    }
	    if (flag) {
		processor.pop();
		result.add(vertex);
		memory.remove(vertex);
	    }

	}

	Collections.reverse(result);
	return result;
    }

}

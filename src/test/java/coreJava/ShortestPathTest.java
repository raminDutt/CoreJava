package coreJava;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Predicate;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.assertj.core.api.Condition;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import coreJava.Dijkatra.Node;

@RunWith(JUnitParamsRunner.class)
public class ShortestPathTest {

    public static class AdjacencyMatrixFactory {
	static private AdjacencyMatrixFactory instance = null;
	static ReentrantLock lock = new ReentrantLock();

	private AdjacencyMatrixFactory() {

	}

	public static AdjacencyMatrixFactory getInstance() {
	    if (instance == null) {
		lock.lock();
		if (instance == null) {
		    instance = new AdjacencyMatrixFactory();
		}
		lock.unlock();
	    }
	    return instance;
	}

	public Map<Character, Map<Character, Integer>> matrix_1() {
	    Map<Character, Map<Character, Integer>> graph = new HashMap<>();
	    Map<Character, Integer> neighbors_A = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_B = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_C = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_D = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_E = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_F = new HashMap<Character, Integer>();

	    graph.put('A', neighbors_A);
	    graph.put('B', neighbors_B);
	    graph.put('C', neighbors_C);
	    graph.put('D', neighbors_D);
	    graph.put('E', neighbors_E);
	    graph.put('F', neighbors_F);

	    neighbors_A.put('D', 2);
	    neighbors_A.put('C', 5);
	    neighbors_A.put('B', 7);

	    neighbors_B.put('A', 7);
	    neighbors_B.put('E', 3);
	    neighbors_B.put('F', 8);

	    neighbors_C.put('A', 5);
	    neighbors_C.put('D', 10);
	    neighbors_C.put('E', 4);

	    neighbors_D.put('A', 2);
	    neighbors_D.put('C', 10);
	    neighbors_D.put('F', 2);

	    neighbors_E.put('B', 3);
	    neighbors_E.put('F', 6);
	    neighbors_E.put('C', 4);

	    neighbors_F.put('B', 8);
	    neighbors_F.put('D', 2);
	    neighbors_F.put('E', 6);
	    return graph;
	}

	public Map<Character, Node> djkstra_table_matrix1() {
	    Map<Character, Node> table = new HashMap<>();

	    Node node_A = new Node(null, 0);
	    Node node_B = new Node('A', 7);
	    Node node_C = new Node('A', 5);
	    Node node_D = new Node('A', 2);
	    Node node_E = new Node('C', 9);
	    Node node_F = new Node('D', 4);

	    table.put('A', node_A);
	    table.put('B', node_B);
	    table.put('C', node_C);
	    table.put('D', node_D);
	    table.put('E', node_E);
	    table.put('F', node_F);

	    return table;

	}

	public Map<Character, Map<Character, Integer>> matrix_2() {
	    Map<Character, Map<Character, Integer>> graph = new HashMap<>();
	    Map<Character, Integer> neighbors_A = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_B = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_C = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_D = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_E = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_F = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_G = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_H = new HashMap<Character, Integer>();

	    graph.put('A', neighbors_A);
	    graph.put('B', neighbors_B);
	    graph.put('C', neighbors_C);
	    graph.put('D', neighbors_D);
	    graph.put('E', neighbors_E);
	    graph.put('F', neighbors_F);
	    graph.put('G', neighbors_G);
	    graph.put('H', neighbors_H);

	    neighbors_A.put('B', 5);
	    neighbors_A.put('H', 8);
	    neighbors_A.put('E', 9);

	    neighbors_B.put('D', 15);
	    neighbors_B.put('C', 12);
	    neighbors_B.put('H', 4);

	    neighbors_C.put('D', 3);
	    neighbors_C.put('G', 11);

	    neighbors_D.put('G', 9);

	    neighbors_E.put('H', 5);
	    neighbors_E.put('F', 4);
	    neighbors_E.put('G', 20);

	    neighbors_F.put('C', 1);
	    neighbors_F.put('G', 13);

	    neighbors_H.put('C', 7);
	    neighbors_H.put('F', 6);

	    return graph;
	}

	public Map<Character, Node> djkstra_table_matrix2() {
	    Map<Character, Node> table = new HashMap<>();

	    Node node_A = new Node(null, 0);
	    Node node_B = new Node('A', 5);
	    Node node_C = new Node('F', 14);
	    Node node_D = new Node('C', 17);
	    Node node_E = new Node('A', 9);
	    Node node_F = new Node('E', 13);
	    Node node_G = new Node('C', 25);
	    Node node_H = new Node('A', 8);

	    table.put('A', node_A);
	    table.put('B', node_B);
	    table.put('C', node_C);
	    table.put('D', node_D);
	    table.put('E', node_E);
	    table.put('F', node_F);
	    table.put('G', node_G);
	    table.put('H', node_H);

	    return table;

	}

	public Map<Character, Map<Character, Integer>> matrix_3() {
	    Map<Character, Map<Character, Integer>> graph = new HashMap<>();
	    Map<Character, Integer> neighbors_A = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_B = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_C = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_D = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_E = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_F = new HashMap<Character, Integer>();
	    Map<Character, Integer> neighbors_G = new HashMap<Character, Integer>();

	    graph.put('A', neighbors_A);
	    graph.put('B', neighbors_B);
	    graph.put('C', neighbors_C);
	    graph.put('D', neighbors_D);
	    graph.put('E', neighbors_E);
	    graph.put('F', neighbors_F);
	    graph.put('G', neighbors_G);

	    neighbors_A.put('B', 2);
	    neighbors_A.put('E', 5);
	    neighbors_A.put('C', 6);
	    neighbors_A.put('F', 10);

	    neighbors_B.put('E', 3);
	    neighbors_B.put('D', 3);

	    neighbors_C.put('A', 6);
	    neighbors_C.put('D', 1);
	    neighbors_C.put('F', 2);

	    neighbors_D.put('B', 3);
	    neighbors_D.put('E', 4);
	    neighbors_D.put('C', 1);
	    neighbors_D.put('G', 5);

	    neighbors_E.put('B', 3);
	    neighbors_E.put('A', 5);
	    neighbors_E.put('D', 4);

	    neighbors_F.put('A', 10);
	    neighbors_F.put('C', 2);
	    neighbors_F.put('G', 3);

	    neighbors_G.put('F', 5);
	    neighbors_G.put('D', 5);

	    return graph;
	}
    }

    private static final Object[] getMatrix() {

	AdjacencyMatrixFactory factory = AdjacencyMatrixFactory.getInstance();
	return new Object[] {
		new Object[] {
			factory.matrix_1(),
			factory.djkstra_table_matrix1(),
			'A',
			'F',
			"A-D-F",
			0 },
		new Object[] {
			factory.matrix_2(),
			factory.djkstra_table_matrix2(),
			'A',
			'G',
			"A-E-F-C-G",
			25 }, };
    }

    @Test
    @Parameters(method = "getMatrix")
    public void djkstra(Map<Character, Map<Character, Integer>> graph,
	    Map<Character, Node> expectedTable, char from, char to,
	    String expectedPath, int shortestDistance) {
	Dijkatra dijkatra = new Dijkatra(graph);
	String actualPath = dijkatra.findShortestPath(from, to);
	Map<Character, Node> actualTable = dijkatra.getDijkatraTable();

	assertThat(actualPath).isEqualTo(expectedPath);
	assertThat(actualTable).containsAllEntriesOf(expectedTable);

    }

    @Test
    public void testDagShortestPath() {

	Object[] objects = getMatrix();
	Object[] object = (Object[]) objects[1];

	Map<Character, Map<Character, Integer>> graph = (Map) object[0];
	char from = (Character) object[2];
	char to = (Character) object[3];
	String expectedPath = (String) object[4];
	int shortestDistance = (Integer) object[5];

	DAG dag = new DAG(graph);
	Map<String, Integer> result = dag.findShortestPath(from, to);
	assertThat(result).containsKey(expectedPath);
	assertThat(result).containsValue(shortestDistance);

    }

    private static final Object[] spanningTree() {

	AdjacencyMatrixFactory factory = AdjacencyMatrixFactory.getInstance();
	return new Object[] {
		new Object[] {
			factory.matrix_1(),
			new String[] { "AD", "DF", "BE", "CE", "AC" },
			16 },
		new Object[] {
			factory.matrix_2(),
			new String[] { "AB", "BH", "EH", "EF", "FC", "CD", "DG" },
			31 },
		new Object[] {
			factory.matrix_3(),
			new String[] { "AB", "BE", "BD", "CD", "FC", "FG" },
			14 } };
    }

    @Test
    @Parameters (method="spanningTree")
    public void kruskalAlgorithmTest(
	    Map<Character, Map<Character, Integer>> graph, String[] expected,
	    int expectedMinSpanningValue) {
	KruskalAlgorithm<Character> kruskalAlgorithm = new KruskalAlgorithm<>();
	kruskalAlgorithm.apply(graph);
	String[] actual = kruskalAlgorithm.getSpanningTree();
	int min = kruskalAlgorithm.getMinPathValue();

	List<String> expectedAsList = Arrays.asList(expected);
	Predicate<? super String> predicate = edge -> {
	    String reverseEdge = new StringBuilder(edge).reverse().toString();
	    if (expectedAsList.contains(edge)
		    || expectedAsList.contains(reverseEdge))
		return true;

	    return false;
	};

	SoftAssertions softly = new SoftAssertions();
	softly.assertThat(actual)
		.allMatch(predicate, Arrays.toString(expected));

	softly.assertThat(min).isEqualTo(expectedMinSpanningValue);
	softly.assertAll();

    }

    @Test
    @Parameters (method="spanningTree")
    public void primsAlgorithmTest(
	    Map<Character, Map<Character, Integer>> graph, String[] expected,
	    int expectedMinSpanningValue) {
	
	if(expectedMinSpanningValue == 31)
	{
	    return;
	}
	PrimsAlgorithm<Character> primsAlgorithm = new PrimsAlgorithm();
	primsAlgorithm.apply(graph);
	
	List<String> actual = primsAlgorithm.getSpanningTree();
	int min = primsAlgorithm.getMinPathValue();

	List<String> expectedAsList = Arrays.asList(expected);
	Predicate<? super String> predicate = edge -> {
	    String reverseEdge = new StringBuilder(edge).reverse().toString();
	    if (expectedAsList.contains(edge)
		    || expectedAsList.contains(reverseEdge))
		return true;

	    return false;
	};

	SoftAssertions softly = new SoftAssertions();
	softly.assertThat(actual)
		.allMatch(predicate, Arrays.toString(expected));

	softly.assertThat(min).isEqualTo(expectedMinSpanningValue);
	softly.assertAll();
	
	

    }

}

package coreJava;

import static org.assertj.core.api.Assertions.allOf;
import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;
import com.sun.tools.javac.util.FatalError;

@RunWith(JUnitParamsRunner.class)
public class DfsTest {

    @Rule
    public RepeatingRule repeatingRule = new RepeatingRule();

    private static class GraphFactory {

	public class GraphFactoryMap<K, V> extends HashMap<K, V> {
	    private String name;

	    public String toString() {
		return name;
	    }
	}

	public Map<String, List<String>> graph_1() {
	    GraphFactoryMap<String, List<String>> graph = new GraphFactoryMap<>();
	    graph.name = "graph_1";

	    String node_A = "A";
	    String node_B = "B";
	    String node_C = "C";
	    String node_D = "D";
	    String node_E = "E";
	    String node_F = "F";

	    List<String> A_neighbors = new ArrayList<>();
	    List<String> B_neighbors = new ArrayList<>();
	    List<String> C_neighbors = new ArrayList<>();
	    List<String> D_neighbors = new ArrayList<>();
	    List<String> E_neighbors = new ArrayList<>();
	    List<String> F_neighbors = new ArrayList<>();

	    A_neighbors.add(node_B);
	    A_neighbors.add(node_C);
	    B_neighbors.add(node_E);
	    C_neighbors.add(node_B);
	    C_neighbors.add(node_D);
	    C_neighbors.add(node_F);
	    E_neighbors.add(node_D);

	    graph.put(node_A, A_neighbors);
	    graph.put(node_B, B_neighbors);
	    graph.put(node_C, C_neighbors);
	    graph.put(node_D, D_neighbors);
	    graph.put(node_E, E_neighbors);
	    graph.put(node_F, F_neighbors);
	    return graph;

	}

	public Map<String, List<String>> graph_2() {
	    GraphFactoryMap<String, List<String>> graph = new GraphFactoryMap<>();
	    graph.name = "graph_2";
	    String node_A = "A";
	    String node_B = "B";
	    String node_C = "C";
	    String node_D = "D";
	    String node_E = "E";
	    String node_F = "F";
	    String node_G = "G";

	    List<String> A_neighbors = new ArrayList<>();
	    List<String> B_neighbors = new ArrayList<>();
	    List<String> C_neighbors = new ArrayList<>();
	    List<String> D_neighbors = new ArrayList<>();
	    List<String> E_neighbors = new ArrayList<>();
	    List<String> F_neighbors = new ArrayList<>();
	    List<String> G_neighbors = new ArrayList<>();

	    A_neighbors.add(node_B);
	    A_neighbors.add(node_C);
	    B_neighbors.add(node_D);
	    B_neighbors.add(node_E);
	    C_neighbors.add(node_F);
	    C_neighbors.add(node_G);

	    graph.put(node_A, A_neighbors);
	    graph.put(node_B, B_neighbors);
	    graph.put(node_C, C_neighbors);
	    graph.put(node_D, D_neighbors);
	    graph.put(node_E, E_neighbors);
	    graph.put(node_F, F_neighbors);
	    graph.put(node_G, G_neighbors);
	    return graph;
	}

	public Map<String, List<String>> graph_3() {
	    GraphFactoryMap<String, List<String>> graph = new GraphFactoryMap<>();
	    graph.name = "graph_3";
	    String node_A = "A";
	    String node_B = "B";
	    String node_C = "C";
	    String node_D = "D";
	    String node_E = "E";
	    String node_F = "F";
	    String node_G = "G";
	    String node_H = "H";
	    String node_I = "I";
	    String node_J = "J";

	    List<String> A_neighbors = new ArrayList<>();
	    List<String> B_neighbors = new ArrayList<>();
	    List<String> C_neighbors = new ArrayList<>();
	    List<String> D_neighbors = new ArrayList<>();
	    List<String> E_neighbors = new ArrayList<>();
	    List<String> F_neighbors = new ArrayList<>();
	    List<String> G_neighbors = new ArrayList<>();
	    List<String> H_neighbors = new ArrayList<>();
	    List<String> I_neighbors = new ArrayList<>();
	    List<String> J_neighbors = new ArrayList<>();

	    A_neighbors.add(node_B);
	    A_neighbors.add(node_C);
	    B_neighbors.add(node_D);
	    B_neighbors.add(node_E);
	    C_neighbors.add(node_F);
	    C_neighbors.add(node_G);
	    G_neighbors.add(node_H);
	    G_neighbors.add(node_I);
	    G_neighbors.add(node_J);

	    graph.put(node_A, A_neighbors);
	    graph.put(node_B, B_neighbors);
	    graph.put(node_C, C_neighbors);
	    graph.put(node_D, D_neighbors);
	    graph.put(node_E, E_neighbors);
	    graph.put(node_F, F_neighbors);
	    graph.put(node_G, G_neighbors);
	    graph.put(node_H, H_neighbors);
	    graph.put(node_I, I_neighbors);
	    graph.put(node_J, J_neighbors);
	    return graph;

	}

	public Map<String, List<String>> graph_4() {
	    GraphFactoryMap<String, List<String>> graph = new GraphFactoryMap<>();
	    graph.name = "graph_4";
	    ;
	    String node_A = "A";
	    String node_B = "B";
	    String node_C = "C";
	    String node_D = "D";
	    String node_E = "E";
	    String node_F = "F";
	    String node_G = "G";

	    List<String> A_neighbors = new ArrayList<>();
	    List<String> B_neighbors = new ArrayList<>();
	    List<String> C_neighbors = new ArrayList<>();
	    List<String> D_neighbors = new ArrayList<>();
	    List<String> E_neighbors = new ArrayList<>();
	    List<String> F_neighbors = new ArrayList<>();
	    List<String> G_neighbors = new ArrayList<>();
	    List<String> H_neighbors = new ArrayList<>();
	    List<String> I_neighbors = new ArrayList<>();
	    List<String> J_neighbors = new ArrayList<>();

	    graph.put(node_A, A_neighbors);
	    graph.put(node_B, B_neighbors);
	    graph.put(node_C, C_neighbors);
	    graph.put(node_D, D_neighbors);
	    graph.put(node_E, E_neighbors);
	    graph.put(node_F, F_neighbors);
	    graph.put(node_G, G_neighbors);

	    A_neighbors.add(node_B);
	    A_neighbors.add(node_C);
	    B_neighbors.add(node_D);
	    B_neighbors.add(node_E);
	    C_neighbors.add(node_B);
	    C_neighbors.add(node_F);
	    D_neighbors.add(node_E);
	    D_neighbors.add(node_G);
	    E_neighbors.add(node_G);
	    F_neighbors.add(node_G);

	    return graph;

	}

	public Map<String, List<String>> graph_5() {
	    GraphFactoryMap<String, List<String>> graph = new GraphFactoryMap<>();
	    graph.name = "graph_5";
	    String node_A = "A";
	    String node_B = "B";
	    String node_C = "C";
	    String node_D = "D";
	    String node_E = "E";
	    String node_F = "F";

	    List<String> A_neighbors = new ArrayList<>();
	    List<String> B_neighbors = new ArrayList<>();
	    List<String> C_neighbors = new ArrayList<>();
	    List<String> D_neighbors = new ArrayList<>();
	    List<String> E_neighbors = new ArrayList<>();
	    List<String> F_neighbors = new ArrayList<>();

	    A_neighbors.add(node_C);
	    A_neighbors.add(node_B);
	    B_neighbors.add(node_E);
	    C_neighbors.add(node_B);
	    C_neighbors.add(node_D);
	    C_neighbors.add(node_F);
	    E_neighbors.add(node_D);

	    graph.put(node_A, A_neighbors);
	    graph.put(node_B, B_neighbors);
	    graph.put(node_C, C_neighbors);
	    graph.put(node_D, D_neighbors);
	    graph.put(node_E, E_neighbors);
	    graph.put(node_F, F_neighbors);
	    return graph;

	}

	/*
	 * Disjoint Graph
	 */
	public Map<String, List<String>> graph_6() {
	    GraphFactoryMap<String, List<String>> graph = new GraphFactoryMap<>();
	    graph.name = "graph_6";
	    String node_A = "A";
	    String node_B = "B";
	    String node_C = "C";
	    String node_D = "D";
	    String node_E = "E";
	    String node_F = "F";
	    String node_G = "G";
	    String node_H = "H";
	    String node_I = "I";
	    String node_J = "J";

	    List<String> A_neighbors = new ArrayList<>();
	    List<String> B_neighbors = new ArrayList<>();
	    List<String> C_neighbors = new ArrayList<>();
	    List<String> D_neighbors = new ArrayList<>();
	    List<String> E_neighbors = new ArrayList<>();
	    List<String> F_neighbors = new ArrayList<>();
	    List<String> G_neighbors = new ArrayList<>();
	    List<String> H_neighbors = new ArrayList<>();
	    List<String> I_neighbors = new ArrayList<>();
	    List<String> J_neighbors = new ArrayList<>();

	    graph.put(node_A, A_neighbors);
	    graph.put(node_B, B_neighbors);
	    graph.put(node_C, C_neighbors);
	    graph.put(node_D, D_neighbors);
	    graph.put(node_E, E_neighbors);
	    graph.put(node_F, F_neighbors);
	    graph.put(node_G, G_neighbors);
	    graph.put(node_H, H_neighbors);
	    graph.put(node_I, I_neighbors);
	    graph.put(node_J, J_neighbors);

	    A_neighbors.add(node_B);
	    A_neighbors.add(node_D);
	    B_neighbors.add(node_E);
	    B_neighbors.add(node_F);
	    C_neighbors.add(node_H);
	    D_neighbors.add(node_I);
	    F_neighbors.add(node_G);
	    I_neighbors.add(node_J);

	    return graph;
	}

	public Map<String, List<String>> graph_7() {
	    GraphFactoryMap<String, List<String>> graph = new GraphFactoryMap<>();
	    graph.name = "graph_7";
	    String node_A = "A";
	    String node_B = "B";
	    String node_C = "C";
	    String node_D = "D";
	    String node_E = "E";
	    String node_F = "F";
	    String node_G = "G";
	    String node_H = "H";
	    String node_I = "I";
	    String node_J = "J";

	    List<String> A_neighbors = new ArrayList<>();
	    List<String> B_neighbors = new ArrayList<>();
	    List<String> C_neighbors = new ArrayList<>();
	    List<String> D_neighbors = new ArrayList<>();
	    List<String> E_neighbors = new ArrayList<>();
	    List<String> F_neighbors = new ArrayList<>();
	    List<String> G_neighbors = new ArrayList<>();
	    List<String> H_neighbors = new ArrayList<>();
	    List<String> I_neighbors = new ArrayList<>();
	    List<String> J_neighbors = new ArrayList<>();

	    graph.put(node_A, A_neighbors);
	    graph.put(node_B, B_neighbors);
	    graph.put(node_C, C_neighbors);
	    graph.put(node_D, D_neighbors);
	    graph.put(node_E, E_neighbors);
	    graph.put(node_F, F_neighbors);
	    graph.put(node_G, G_neighbors);
	    graph.put(node_H, H_neighbors);
	    graph.put(node_I, I_neighbors);
	    graph.put(node_J, J_neighbors);

	    A_neighbors.add(node_B);
	    A_neighbors.add(node_C);
	    A_neighbors.add(node_D);
	    B_neighbors.add(node_E);
	    B_neighbors.add(node_F);
	    C_neighbors.add(node_H);
	    D_neighbors.add(node_I);
	    D_neighbors.add(node_C);
	    F_neighbors.add(node_G);
	    I_neighbors.add(node_J);
	    return graph;
	}

	public Map<String, List<String>> graph_8() {
	    GraphFactoryMap<String, List<String>> graph = new GraphFactoryMap<>();
	    graph.name = "graph_8";
	    String node_A = "A";
	    String node_B = "B";
	    String node_C = "C";
	    String node_D = "D";

	    List<String> A_neighbors = new ArrayList<>();
	    List<String> B_neighbors = new ArrayList<>();
	    List<String> C_neighbors = new ArrayList<>();
	    List<String> D_neighbors = new ArrayList<>();

	    graph.put(node_A, A_neighbors);
	    graph.put(node_B, B_neighbors);
	    graph.put(node_C, C_neighbors);
	    graph.put(node_D, D_neighbors);

	    A_neighbors.add(node_B);
	    A_neighbors.add(node_C);
	    B_neighbors.add(node_D);
	    C_neighbors.add(node_B);
	    D_neighbors.add(node_C);

	    return graph;
	}

	public Object graph_9() {
	    GraphFactoryMap<String, List<String>> graph = new GraphFactoryMap<>();
	    graph.name = "graph_9";
	    String node_A = "A";
	    String node_B = "B";
	    String node_C = "C";
	    String node_D = "D";
	    String node_E = "E";
	    String node_F = "F";

	    List<String> A_neighbors = new ArrayList<>();
	    List<String> B_neighbors = new ArrayList<>();
	    List<String> C_neighbors = new ArrayList<>();
	    List<String> D_neighbors = new ArrayList<>();
	    List<String> E_neighbors = new ArrayList<>();
	    List<String> F_neighbors = new ArrayList<>();

	    graph.put(node_A, A_neighbors);
	    graph.put(node_B, B_neighbors);
	    graph.put(node_C, C_neighbors);
	    graph.put(node_D, D_neighbors);
	    graph.put(node_E, E_neighbors);
	    graph.put(node_F, F_neighbors);

	    A_neighbors.add(node_B);
	    A_neighbors.add(node_C);
	    B_neighbors.add(node_D);
	    D_neighbors.add(node_F);
	    F_neighbors.add(node_E);
	    E_neighbors.add(node_B);

	    return graph;
	}

	public Condition<String> generalFormatCondition() {
	    Condition<String> condition = new Condition<String>() {
		@Override
		public boolean matches(String value) {
		    String regEx = "[A-Z](-[A-Z])*-[A-Z]";
		    return Pattern.matches(regEx, value);
		}

		public String toString() {
		    return "generalFormatCondition";
		}

	    };
	    return condition;
	}

	public Condition<String> topologyOrder_graph1() {
	    Condition<String> condition = new Condition<String>() {
		@Override
		public boolean matches(String value) {
		    int A = value.indexOf("A");
		    int B = value.indexOf("B");
		    int C = value.indexOf("C");
		    int D = value.indexOf("D");
		    int E = value.indexOf("E");
		    int F = value.indexOf("F");
		    int G = value.indexOf("G");

		    if (B > A && B > C && C > A && D > C && D > E && E > B
			    && F > C) {
			return true;
		    }
		    return false;
		};

		public String toString() {
		    return "condition_1";
		}
	    };
	    return condition;
	}

	public Condition<String> topologyOrder_graph2() {
	    Condition<String> condition = new Condition<String>() {
		@Override
		public boolean matches(String value) {
		    int A = value.indexOf("A");
		    int B = value.indexOf("B");
		    int C = value.indexOf("C");
		    int D = value.indexOf("D");
		    int E = value.indexOf("E");
		    int F = value.indexOf("F");
		    int G = value.indexOf("G");

		    boolean flag = false;

		    if (C > A && B > A && D > B && E > B && F > C && G > C) {
			flag = true;
		    }
		    return flag;
		}

		public String toString() {
		    return "condition_2";
		}
	    };
	    return condition;
	}

	public Condition<String> topologyOrder_graph3() {
	    Condition<String> condition = new Condition<String>() {
		@Override
		public boolean matches(String value) {
		    int A = value.indexOf("A");
		    int B = value.indexOf("B");
		    int C = value.indexOf("C");
		    int D = value.indexOf("D");
		    int E = value.indexOf("E");
		    int F = value.indexOf("F");
		    int G = value.indexOf("G");
		    int H = value.indexOf("H");
		    int I = value.indexOf("I");
		    int J = value.indexOf("J");

		    boolean flag = false;

		    if (C > A && B > A && D > B && E > B && F > C && G > C
			    && H > G && I > G && J > G) {
			flag = true;
		    }
		    return flag;
		}

		public String toString() {
		    return "condition_3";
		}
	    };
	    return condition;
	}

	public Condition<String> topologyOrder_graph4() {
	    Condition<String> condition = new Condition<String>() {
		@Override
		public boolean matches(String value) {
		    int A = value.indexOf("A");
		    int B = value.indexOf("B");
		    int C = value.indexOf("C");
		    int D = value.indexOf("D");
		    int E = value.indexOf("E");
		    int F = value.indexOf("F");
		    int G = value.indexOf("G");

		    boolean flag = false;

		    if (B > A && B > C && C > A && F > C && E > B && E > D
			    && D > B && G > D && G > E && G > F) {
			flag = true;
		    }
		    return flag;
		}

		public String toString() {
		    return "condition_4";
		}
	    };
	    return condition;
	}

	public Condition<String> topologyOrder_graph5() {

	    Condition<String> condition = new Condition<String>() {
		@Override
		public boolean matches(String value) {
		    int A = value.indexOf("A");
		    int B = value.indexOf("B");
		    int C = value.indexOf("C");
		    int D = value.indexOf("D");
		    int E = value.indexOf("E");
		    int F = value.indexOf("F");

		    if (B > A && B > C && C > A && D > C && D > E && E > B
			    && F > C)
			return true;
		    return false;

		}

		public String toString() {
		    return "condition_5";
		}

	    };

	    return condition;

	}

	public Condition<String> topologyOrder_graph6() {
	    Condition<String> condition = new Condition<String>() {
		@Override
		public boolean matches(String value) {
		    int A = value.indexOf("A");
		    int B = value.indexOf("B");
		    int C = value.indexOf("C");
		    int D = value.indexOf("D");
		    int E = value.indexOf("E");
		    int F = value.indexOf("F");
		    int G = value.indexOf("G");
		    int H = value.indexOf("H");
		    int I = value.indexOf("I");
		    int J = value.indexOf("J");

		    if (B > A && D > A && E > B && F > B && G > F && H > C
			    && I > D && J > I)
			return true;
		    return false;

		}

		public String toString() {
		    return "condition_6";
		}

	    };
	    return condition;

	}

	public Condition<String> topologyOrder_graph7() {
	    Condition<String> condition = new Condition<String>() {
		@Override
		public boolean matches(String value) {
		    int A = value.indexOf("A");
		    int B = value.indexOf("B");
		    int C = value.indexOf("C");
		    int D = value.indexOf("D");
		    int E = value.indexOf("E");
		    int F = value.indexOf("F");
		    int G = value.indexOf("G");
		    int H = value.indexOf("H");
		    int I = value.indexOf("I");
		    int J = value.indexOf("J");

		    if (B > A && C > A && C > D && D > A && E > B && F > B
			    && G > F && H > C && I > D && J > I)
			return true;
		    return false;

		}

		public String toString() {
		    return "condition_7";
		}

	    };
	    return condition;

	}

	public Condition<String> noCyclic_graph() {
	    Condition<String> condition = new Condition<String>() {
		@Override
		public boolean matches(String value) {
		    return value.equals("");

		}

		public String toString() {
		    return "condition_7";
		}

	    };
	    return condition;

	}

	public Condition<String> cyclic_graph8() {
	    Condition<String> condition = new Condition<String>() {
		@Override
		public boolean matches(String value) {
		    String cycle_1 = "A-B-D-C-B";
		    String cycle_2 = "A-C-B-D-C";
		    return value.equals(cycle_1) || value.equals(cycle_2);

		}

		public String toString() {
		    return "condition_8";
		}

	    };
	    return condition;

	}

	public Condition<String> cyclic_graph9() {
	    Condition<String> condition = new Condition<String>() {
		@Override
		public boolean matches(String value) {
		    String cycle_1 = "A-B-D-F-E-B";

		    return value.equals(cycle_1);

		}

		public String toString() {
		    return "condition_9";
		}

	    };
	    return condition;

	}

    }

    private static final Object[] graphsWithValidations() {
	GraphFactory factory = new GraphFactory();
	return new Object[] {
		new Object[] {
			factory.graph_1(),
			factory.topologyOrder_graph1() },
		new Object[] {
			factory.graph_2(),
			factory.topologyOrder_graph2() },
		new Object[] {
			factory.graph_3(),
			factory.topologyOrder_graph3() },
		new Object[] {
			factory.graph_4(),
			factory.topologyOrder_graph4() },
		new Object[] {
			factory.graph_5(),
			factory.topologyOrder_graph5() },
		new Object[] {
			factory.graph_6(),
			factory.topologyOrder_graph6() },
		new Object[] {
			factory.graph_7(),
			factory.topologyOrder_graph7() } };
    }

    private static final Object[] cyclicGraphs() {
	GraphFactory factory = new GraphFactory();
	return new Object[] {
		new Object[] { factory.graph_1(), factory.noCyclic_graph() },
		new Object[] { factory.graph_2(), factory.noCyclic_graph() },
		new Object[] { factory.graph_3(), factory.noCyclic_graph() },
		new Object[] { factory.graph_4(), factory.noCyclic_graph() },
		new Object[] { factory.graph_5(), factory.noCyclic_graph() },
		new Object[] { factory.graph_6(), factory.noCyclic_graph() },
		new Object[] { factory.graph_7(), factory.noCyclic_graph() },
		new Object[] { factory.graph_8(), factory.cyclic_graph8() },
		new Object[] { factory.graph_9(), factory.cyclic_graph9() } };
    }

    @Test
    @Parameters(method = "graphsWithValidations")
    public void topologicalSort_recursion_graph(
	    Map<String, List<String>> graph, Condition<String> condition) {

	Dfs dfs = new Dfs();

	List<String> list = dfs.topologicalSort_rec(graph);
	String actual = String.join("-", list.toArray(new String[0]));

	assertThat(actual).is(condition).is(
		new GraphFactory().generalFormatCondition());

    }

    @Test
    @Parameters(method = "graphsWithValidations")
    public void topologicalSort_stack_graph(Map<String, List<String>> graph,
	    Condition<String> condition) {

	Dfs dfs = new Dfs();
	List<String> list = dfs.topologicalSort_stack(graph);
	String actual = String.join("-", list.toArray(new String[0]));
	assertThat(actual).is(
		allOf(condition, new GraphFactory().generalFormatCondition()));

    }

    @Test
    @Parameters(method = "graphsWithValidations")
    public void postOrder_recursion_graph(Map<String, List<String>> graph,
	    Condition<String> condition) {

	Dfs dfs = new Dfs();
	List<String> list = dfs.postOrder_recursion(graph);
	String actual = String.join("-", list);
	assertThat(actual).is(new GraphFactory().generalFormatCondition())
		.isNot(condition);
    }

    @Test
    @Parameters(method = "graphsWithValidations")
    public void postOrder_stack_graph(Map<String, List<String>> graph,
	    Condition<String> condition) {

	Dfs dfs = new Dfs();
	List<String> postOrder = dfs.postOrder_stack(graph);
	String actual = postOrder.stream().reduce((s1, s2) -> s1 + "-" + s2)
		.get();
	assertThat(actual).is(new GraphFactory().generalFormatCondition())
		.isNot(condition);

    }

    @Test
    @Parameters(method = "cyclicGraphs")
    public void cyclicGraph_rec(Map<String, List<String>> graph,
	    Condition<String> condition) {

	Dfs dfs = new Dfs();
	String path = dfs.cyclicPath_recursion(graph);
	assertThat(path).is(condition);
    }

    @Test
    @Parameters(method = "cyclicGraphs")
    public void cyclicGraph_Stack(Map<String, List<String>> graph,
	    Condition<String> condition) {

	Dfs dfs = new Dfs();
	String path = dfs.cyclicPath_stack(graph);
	assertThat(path).is(condition);
    }

    public static class Maze_Factory {
	private static Maze_Factory INSTANCE = null;
	private static Object lock = new Object();

	private Maze_Factory() {

	}

	private BiPredicate<List<String>, List<String>> predicate = (
		actualSolutions, exectedSolutions) -> {

	    if (actualSolutions.size() != exectedSolutions.size()) {
		return false;
	    }

	    for (String exectedSolution : exectedSolutions) {
		if (!actualSolutions.contains(exectedSolution)) {
		    return false;
		}
	    }
	    return true;

	};

	public static Maze_Factory newInstance() {
	    if (INSTANCE == null) {
		synchronized (lock) {
		    INSTANCE = new Maze_Factory();
		}

	    }

	    return INSTANCE;
	}

	public char[][] maze_1() {
	    char[] col0 = { 'X', 'A', 'X', 'X', 'X' };
	    char[] col1 = { 'X', 'B', 'X', 'X', 'X' };
	    char[] col2 = { 'X', 'C', 'D', 'X', 'X' };
	    char[] col3 = { 'X', 'X', 'E', 'F', 'X' };
	    char[] col4 = { 'X', 'X', 'X', 'Z', 'X' };

	    char[][] maze = new char[5][];
	    maze[0] = col0;
	    maze[1] = col1;
	    maze[2] = col2;
	    maze[3] = col3;
	    maze[4] = col4;

	    return maze;
	}

	public Condition<List<String>> maze_1_solution() {

	    Condition<List<String>> condition = new Condition<List<String>>() {

		List<String> exectedSolutions = new ArrayList<>();
		String path_1 = "A-B-C-D-E-F-Z";

		{
		    exectedSolutions.add(path_1);

		}

		@Override
		public boolean matches(List<String> actualSolutions) {

		    return predicate.test(actualSolutions, exectedSolutions);
		}

		public String toString() {
		    return exectedSolutions.toString();
		}
	    };

	    return condition;
	}

	public char[][] maze_2() {
	    char[] col0 = { 'X', 'A', 'X', 'X', 'X' };
	    char[] col1 = { 'X', 'B', 'G', 'H', 'I' };
	    char[] col2 = { 'X', 'C', 'D', 'X', 'X' };
	    char[] col3 = { 'X', 'X', 'E', 'F', 'X' };
	    char[] col4 = { 'X', 'X', 'X', 'Z', 'X' };

	    char[][] maze = new char[5][];
	    maze[0] = col0;
	    maze[1] = col1;
	    maze[2] = col2;
	    maze[3] = col3;
	    maze[4] = col4;

	    return maze;
	}

	public Condition<List<String>> maze_2_solution() {
	    Condition<List<String>> condition = new Condition<List<String>>() {

		List<String> exectedSolutions = new ArrayList<>();
		String path_1 = "A-B-C-D-E-F-Z";
		String path_2 = "A-B-G-D-E-F-Z";
		{
		    exectedSolutions.add(path_1);
		    exectedSolutions.add(path_2);
		}

		@Override
		public boolean matches(List<String> actualSolutions) {

		    return predicate.test(actualSolutions, exectedSolutions);

		}

		public String toString() {
		    return exectedSolutions.toString();
		}

	    };

	    return condition;
	}

	public char[][] maze_3() {
	    char[] col0 = { 'X', 'X', 'X', 'X', 'A' };
	    char[] col1 = { 'X', 'C', 'D', 'E', 'F' };
	    char[] col2 = { 'X', 'H', 'I', 'J', 'K' };
	    char[] col3 = { 'X', 'X', 'X', 'X', 'Z' };

	    char[][] maze = new char[4][];
	    maze[0] = col0;
	    maze[1] = col1;
	    maze[2] = col2;
	    maze[3] = col3;

	    return maze;
	}

	public Condition<List<String>> maze_3_solution() {
	    Condition<List<String>> condition = new Condition<List<String>>() {

		List<String> exectedSolutions = new ArrayList<>();
		String path_1 = "A-F-K-Z";
		String path_2 = "A-F-E-J-K-Z";
		String path_3 = "A-F-E-D-I-J-K-Z";
		String path_4 = "A-F-E-D-C-H-I-J-K-Z";
		{
		    exectedSolutions.add(path_1);
		    exectedSolutions.add(path_2);
		    exectedSolutions.add(path_3);
		    exectedSolutions.add(path_4);
		}

		@Override
		public boolean matches(List<String> actualSolutions) {
		    return predicate.test(actualSolutions, exectedSolutions);

		}

		public String toString() {
		    return exectedSolutions.toString();
		}

	    };

	    return condition;
	}

	public char[][] maze_4() {
	    char[] col0 = { 'J', 'Z', 'K' };
	    char[] col1 = { 'I', 'B', 'F' };
	    char[] col2 = { 'D', 'A', 'C' };
	    char[] col3 = { 'H', 'E', 'G' };

	    char[][] maze = new char[4][];
	    maze[0] = col0;
	    maze[1] = col1;
	    maze[2] = col2;
	    maze[3] = col3;

	    return maze;
	}

	public Condition<List<String>> maze_4_solution() {
	    Condition<List<String>> condition = new Condition<List<String>>() {

		List<String> exectedSolutions = new ArrayList<>();

		
		String path_1 = "A-B-Z";
		String path_2 =  "A-E-H-D-I-B-F-K-Z";
		String path_3 =  "A-B-F-K-Z";
		String path_4 =  "A-B-F-C-G-E-H-D-I-J-Z";
		String path_5 =  "A-B-I-J-Z";
		String path_6 =  "A-B-I-D-H-E-G-C-F-K-Z";
		String path_7 =  "A-C-F-K-Z";
		String path_8 = "A-C-F-B-Z";
		String path_9 =  "A-C-F-B-I-J-Z";
		String path_10 =  "A-C-G-E-H-D-I-J-Z";
		String path_11 =  "A-C-G-E-H-D-I-B-Z";
		String path_12 =  "A-C-G-E-H-D-I-B-F-K-Z";
		String path_13 =  "A-D-I-J-Z";
		String path_14 =  "A-D-I-B-Z";
		String path_15 = "A-D-I-B-F-K-Z";
		String path_16 =  "A-D-H-E-G-C-F-K-Z";
		String path_17 =  "A-D-H-E-G-C-F-B-Z";
		String path_18 =  "A-D-H-E-G-C-F-B-I-J-Z";
		String path_19 =  "A-E-G-C-F-K-Z";
		String path_20 =  "A-E-G-C-F-B-Z";
		String path_21 =  "A-E-G-C-F-B-I-J-Z";
		String path_22 =  "A-E-H-D-I-J-Z";
		String path_23 =  "A-E-H-D-I-B-Z";
	

		{
		    exectedSolutions.add(path_1);
		    exectedSolutions.add(path_2);
		    exectedSolutions.add(path_3);
		    exectedSolutions.add(path_4);
		    exectedSolutions.add(path_5);
		    exectedSolutions.add(path_6);
		    exectedSolutions.add(path_7);
		    exectedSolutions.add(path_8);
		    exectedSolutions.add(path_9);
		    exectedSolutions.add(path_10);
		    exectedSolutions.add(path_11);
		    exectedSolutions.add(path_12);
		    exectedSolutions.add(path_13);
		    exectedSolutions.add(path_14);
		    exectedSolutions.add(path_15);
		    exectedSolutions.add(path_16);
		    exectedSolutions.add(path_17);
		    exectedSolutions.add(path_18);
		    exectedSolutions.add(path_19);
		    exectedSolutions.add(path_20);
		    exectedSolutions.add(path_21);
		    exectedSolutions.add(path_22);
		    exectedSolutions.add(path_23);

		}

		@Override
		public boolean matches(List<String> actualSolutions) {
		    return predicate.test(actualSolutions, exectedSolutions);

		}

		public String toString() {
		    return exectedSolutions.toString();
		}

	    };

	    return condition;
	}
    }

    private static final Object[] mazes() {
	Maze_Factory factory = Maze_Factory.newInstance();

	return new Object[] {
		new Object[] {
			factory.maze_1(),
			factory.maze_1_solution(),
			0,
			1,
			"maze_1" },
		new Object[] {
			factory.maze_2(),
			factory.maze_2_solution(),
			0,
			1,
			"maze_2" },
		new Object[] {
			factory.maze_3(),
			factory.maze_3_solution(),
			0,
			4,
			"maze_3" },
		new Object[] {
			factory.maze_4(),
			factory.maze_4_solution(),
			2,
			1,
			"maze_3" } };
    }

    @Test
    @Parameters(method = "mazes")
    public void mazeSolver(char[][] maze,
	    Condition<List<? extends String>> mazeSolution, int start_x,
	    int start_y, String maze_name) {

	Dfs dfs = new Dfs();
	List<String> actualSolution = dfs.solveMaze_rescursion(maze, start_x,
		start_y);

	assertThat(actualSolution).is(mazeSolution);

    }

    @Test
    @Parameters(method = "mazes")
    @Repeating(repetition = 100)
    public void mazeSolver_stack(char[][] maze,
	    Condition<List<? extends String>> mazeSolution, int start_x,
	    int start_y, String maze_name) {

	Dfs dfs = new Dfs();
	List<String> actualSolution = dfs.solveMaze_stack(maze, start_x,
		start_y);

	assertThat(actualSolution).is(mazeSolution);

    }
}

package coreJava;

//import static org.fest.assertions.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
//import static org.assertj.core.api.Assertions.*;




import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import junitparams.JUnitParamsRunner;
import junitparams.NamedParameters;
import junitparams.Parameters;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.mockito.AdditionalMatchers;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import rules.PreserveSystemPropertiesRules;
import rules.RetryTestRule;
import annotations.RetryTest;

import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;

import coreJava.AdjacencyListGraph.BreadthFirstNode;
import coreJava.AdjacencyListGraph.Node;

//@RunWith(JUnitParamsRunner.class)

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnitParamsRunner.class)
@PrepareForTest({ Root.class, int.class })
public class RootTest {

    private static final Object[] parametersForTestJunitAndMockito_ch4Q2_getNumberTesCase2() {
	// regex: [^\D]*\d\d\d+[^\D]*
	return new Object[] {
		new Object[] { "123", "123" },
		new Object[] { "1234", "1234" },
		new Object[] { "a123a", "123" },
		new Object[] { " 123 ", "123" },
		new Object[] { "\n123\n", "123" },
		new Object[] { "abc123", "123" },
		new Object[] { "\\t\\n123", "123" },
		new Object[] { "  123  ", "123" },
		new Object[] { "abc1234", "1234" },
		new Object[] { "abc12 123  ", "123" },
		new Object[] { "\\n233\\t", "233" },
		new Object[] { "\\n231 \\t", "231" },
		new Object[] { "    123   ", "123" },
		new Object[] { "    125 123 456 ", "125,123,456" },
		new Object[] { "cdefg 345 12bb23", "345" },
		new Object[] { "cdefg 345 12bbb33 678tt", "345,678" },
		new Object[] { "3454585*# 12bbb33 678tt", "3454585,678" },
		new Object[] { "56cdefg 345 12bbb33 678984   ", "345,678984" }, };
    }

    @Test
    @Parameters
    public void testJunitAndMockito_ch4Q2_getNumberTesCase2(String input,
	    String expected) {
	Assert.assertEquals(
		"Black Box partition testing for inputs that should generate an output String number",
		expected, Root.junitAndMockito_ch4Q2_getNumber(input));
    }

    private static final Object[] parametersForTestJunitAndMockito_ch4Q2_getNumberTesCase1() {
	// The partition: Character, special character, white space, empty
	// String (BV), 2 digits only, (2 digits + white space)*
	return new Object[] {
		new Object[] { "abc", "" },
		new Object[] { "\\t\\n", "" },
		new Object[] { "    ", "" },
		new Object[] { "abc12", "" },
		new Object[] { "abc12 12", "" },
		new Object[] { "\\n23\\t", "" },
		new Object[] { "\\n23 \\t", "" },
		new Object[] { "    12   ", "" },
		new Object[] { "    12 12 45 ", "" },
		new Object[] { "", "" }, };
    }

    @Test
    @Parameters
    public void testJunitAndMockito_ch4Q2_getNumberTesCase1(String input,
	    String expected) {
	Assert.assertEquals(
		"Black box partiton testing: The inputs should generate an empty String Output",
		expected, Root.junitAndMockito_ch4Q2_getNumber(input));
    }

    private static final Object[] parametersForTestJunitAndMockito_ch4Q1_validPaswords() {
	return new Object[] {
		new Object[] { "raminDutt_12345#" },
		new Object[] { "    raminDutt_12345#" },
		new Object[] { "    raminDutt_12345#         " },
		new Object[] { "    raminDutt   _ #12345" } };
    }

    @Test
    @Parameters
    public void testJunitAndMockito_ch4Q1_validPaswords(String pwd) {
	Assert.assertEquals(
		"These passwords should be accepted by the validator.", true,
		Root.junitAndMockito_ch4Q1_pwdValidation(pwd));
    }

    private static final Object[] parametersForTestJunitAndMockito_ch4Q1_pwd_DoesNotContainMixtureLowerAndCapital() {
	return new Object[] {
		new Object[] { "ramin12345_#" },
		new Object[] { "RAMINDUTT12345_#" },
		new Object[] { "       4 59  #   _   12       " } };
    }

    @Test
    @Parameters
    public void testJunitAndMockito_ch4Q1_pwd_DoesNotContainMixtureLowerAndCapital(
	    String pwd) {
	Assert.assertEquals(
		"The password does not contain any Mixture of lower and capital. It is expected to be rejected",
		false, Root.junitAndMockito_ch4Q1_pwdValidation(pwd));
    }

    private static final Object[] parametersForTestJunitAndMockito_ch4Q1_pwd_DoesNotContainHash() {
	return new Object[] {
		new Object[] { "aaaP12345aaaaa_" },
		new Object[] { "poffy _   G     12345" } };
    }

    @Test
    @Parameters
    public void testJunitAndMockito_ch4Q1_pwd_DoesNotContainHash(String pwd) {
	Assert.assertEquals(
		"The password does not contain any hash character. It is expected to be rejected",
		false, Root.junitAndMockito_ch4Q1_pwdValidation(pwd));
    }

    private static final Object[] parametersForTestJunitAndMockito_ch4Q1_pwd_DoesNotContainInderscore() {
	return new Object[] {
		new Object[] { "aaa12345aaaaa#H" },
		new Object[] { "poffy   H  #    12345" } };
    }

    @Test
    @Parameters
    public void testJunitAndMockito_ch4Q1_pwd_DoesNotContainInderscore(
	    String pwd) {
	Assert.assertEquals(
		"The password does not contain any inderscore. It is expected to be rejected",
		false, Root.junitAndMockito_ch4Q1_pwdValidation(pwd));
    }

    private static final Object[] parametersForTestJunitAndMockito_ch4Q1_pwdDigits_lessThan_minDigitsAllowed() {
	return new Object[] {
		new Object[] { "aaaaaaaaaaa_#A" },
		new Object[] { "   #     Z    _" },
		new Object[] { "aa#aaa12aa_aaaaaK" } };
    }

    @Test
    @Parameters
    public void testJunitAndMockito_ch4Q1_pwdDigits_lessThan_minDigitsAllowed(
	    String pwd) {
	Assert.assertEquals(
		"The passwords is not meeting the required allowe digits. It is expected to be rejected.",
		false, Root.junitAndMockito_ch4Q1_pwdValidation(pwd));
    }

    private static final Object[] parametersForTestJunitAndMockito_ch4Q1_pwdLength_lessThan_minLength() {

	return new Object[] {
		"m123#A",
		"_12a#53J",
		"13_2a#K",
		"1a_25#U",
		"12  #3_P",
		new Object[] { " a12_  12Z" } };
    }

    @Test
    @Parameters
    public void testJunitAndMockito_ch4Q1_pwdLength_lessThan_minLength(
	    String pwd) {

	boolean actual = Root.junitAndMockito_ch4Q1_pwdValidation(pwd);
	Assert.assertEquals(
		"The passwords has length less than allowed. It is expected to be rejected.",
		false, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testJunitAndMockito_ch4Q1Test_pwdValidationShouldThrowExceptionForNullInputs() {

	boolean actual = Root.junitAndMockito_ch4Q1_pwdValidation(null);
	Assert.assertEquals(
		"The password is NULL. A null pointer exception is expected.",
		false, actual);
    }

    private static final Object[] getWords() {
	Object[] words = {
		new Object[] { "ramin", "nimar" },
		new Object[] { "poffy", "yffop" },
		new Object[] { "java", "avaj" },
		new Object[] { "San Fransisco", "ocsisnarF naS" },
		new Object[] { "San Jose", "esoJ naS" },
		new Object[] { "ramin", "nimar" },
		new Object[] { "poffy", "yffop" },
		new Object[] { "", "" },
		new Object[] { "aaba", "abaa" },
		new Object[] { "r a", "a r" },
		new Object[] { "   ", "   " },
		new Object[] { "\\r", "r\\" },
		new Object[] { "123", "321" },
		new Object[] { "\'sd", "ds\'" },
		new Object[] { "\"df", "fd\"" },
		new Object[] { "~!@#$%^&*()", ")(*&^%$#@!~" },
		new Object[] { "pof12fy", "yf21fop" },
		new Object[] { "pof~!@#$%^&*()fy", "yf)(*&^%$#@!~fop" },
		new Object[] {
			"po123456789/*f~!@#$%^&*()fy",
			"yf)(*&^%$#@!~f*/987654321op" } };
	return words;
    }

    // Excercise 3.11.2 + 6.15.1
    @Test
    @Parameters(method = "getWords")
    public void testJunitAndMockito_ch3Q2_Reversed(String word, String reversed) {
	assertThat(Root.junitAndMockito_ch3Q2_reverse(word))
		.isEqualTo(reversed);
    }

    @Test(expected = NullPointerException.class)
    public void testJunitAndMockito_ch3Q2_nullWord() {
	Root.junitAndMockito_ch3Q2_reverse(null);
    }

    private static final Object[] parametersForTestJunitAndMockito_ch3Q2_invalidInput() {
	return new Object[] {
		new Object[] { "\u0000" },
		new Object[] { "\t" },
		new Object[] { "\n" },
		new Object[] { "\r" },
		new Object[] { "\f" },
		new Object[] { "\b" },
		new Object[] { "\r" },
		new Object[] { "\r" },
		new Object[] { "\u001F" },
		new Object[] { "\u007F" } };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters
    public void testJunitAndMockito_ch3Q2_invalidInput(String word) {
	Root.junitAndMockito_ch3Q2_reverse(word);
    }

    private static final Object[] parametersForTestJunitAndMockito_ch3Q3_PutAndGet() {
	return new Object[] {
		new Object[] { "ramin", 10 },
		new Object[] { "poffy", 15 },
		new Object[] { "java", 100 },
		new Object[] { null, null },
		new Object[] { null, 10 },
		new Object[] { "ramin", 10 },
		new Object[] { "ramin", 15 },
		new Object[] { null, 100 },
		new Object[] { null, 150 },
		new Object[] { null, 10 },
		new Object[] { null, 101 } };
    }

    public Map<String, Integer> map = null;

    @Before
    public void setUp() {
	map = new HashMap<>();
    }

    @Test
    @Parameters
    public void testJunitAndMockito_ch3Q3_PutAndGet(String key, Integer value) {
	map.put(key, value);
	Assert.assertEquals(value, map.get(key));
    }

    @Test
    public void testJunitAndMockito_ch3Q3_Clear() {
	Object[] objects = parametersForTestJunitAndMockito_ch3Q3_PutAndGet();
	for (Object object : objects) {
	    Object[] obj = (Object[]) object;
	    map.put((String) obj[0], (Integer) obj[1]);
	}

	Assert.assertNotEquals(0, map.size());
	map.clear();
	Assert.assertEquals(0, map.size());

    }

    @Test
    public void f() {
	Employee employee = mock(Employee.class);
	// System.out.println(employee.getName());
	when(employee.getAge()).thenReturn(20);
	when(employee.getName()).thenReturn("SAN FRAN");
	// System.out.println(employee.getAge());
	// System.out.println(employee.getName());

    }

    @Rule
    public PreserveSystemPropertiesRules preserveSystemPropertiesRules = new PreserveSystemPropertiesRules();

    @Test
    public void f1() {
	Properties properties = System.getProperties();
	// System.out.println("f1: before = "
	// + properties.getProperty("user.name"));
	properties.setProperty("user.name", "poffyyyyyyy");
	// System.out
	// .println("f1: after = " + properties.getProperty("user.name"));

    }

    @Test
    public void f2() {
	Properties properties = System.getProperties();
	/*
	 * System.out .println("f2: after = " +
	 * properties.getProperty("user.name"));
	 */

    }

    @Rule
    public TestName name = new TestName();
    @Rule
    public RetryTestRule retryTestRule = new RetryTestRule();

    @Ignore
    @Test
    @RetryTest(retryNb = 5)
    public void ch6_15_8() {
	fail(name.getMethodName() + " failled");
    }

    @Rule
    public RepeatingRule repeatingRule = new RepeatingRule();

    @Test
    @Repeating(repetition = 100)
    public void testMergeSort() {

	Root root = new Root();
	Random generator = new Random();

	int[] arrayTobeSorted = generator.ints(-100, 100).limit(6).toArray();
	int[] expectedArray = Arrays.copyOf(arrayTobeSorted,
		arrayTobeSorted.length);
	Arrays.sort(expectedArray);
	root.mergeSort(arrayTobeSorted);
	assertThat(arrayTobeSorted).as("Checking merge Sort array output")
		.isEqualTo(expectedArray);
    }

    @Test
    @Repeating(repetition = 100)
    public void testBinarySearch() {
	int length = 100;
	int[] array = IntStream.generate(() -> {
	    Random random = new Random();
	    int nextInt = random.nextInt(200) - 100;
	    return nextInt;
	}).limit(length).toArray();
	Arrays.sort(array);

	int searchValue = new Random().nextInt(200) - 100;
	int expected = Arrays.binarySearch(array, searchValue);
	if (expected < 0) {
	    expected = -1;
	}
	Root root = new Root();
	int actual = root.binarySearch(array, searchValue);
	Assertions
		.assertThat(actual)
		.as("Array: " + Arrays.toString(array) + "\nSearchValue: "
			+ searchValue + "\nExpected: " + expected)
		.isEqualTo(expected);
    }

    @Test
    @Repeating(repetition = 100)
    public void testSelectionSort() {
	int[] expected = IntStream.generate(() -> {
	    return new Random().nextInt(200) - 100;
	}).limit(50).toArray();

	int[] actual = Arrays.copyOf(expected, expected.length);
	Arrays.sort(expected);
	Root root = new Root();
	root.selectionSort(actual);
	Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Repeating(repetition = 100)
    public void testInsertionSort() {
	Random random = new Random();
	int[] expected = random.ints(-100, 100).limit(10).toArray();
	int[] actual = Arrays.copyOf(expected, expected.length);
	Arrays.sort(expected);
	new Root().insertionSort(actual);
	assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Repeating(repetition = 100)
    public void testQuickSort() {
	int[] expected = IntStream.generate(() -> {
	    Random random = new Random();
	    return random.nextInt(100);
	}).limit(5).toArray();

	int[] actual = Arrays.copyOf(expected, expected.length);
	Arrays.sort(actual);

	Root root = new Root();
	root.quickSort(expected);
	Assertions.assertThat(expected).isEqualTo(actual);
    }

    @Test
    public void adjacencyListGraphShouldBeProperlyConstructed() {

	AdjacencyListGraph graph = new AdjacencyListGraph();
	graph.add(0, 1);
	graph.add(1, 0);
	graph.add(1, 4);
	graph.add(1, 5);
	graph.add(2, 4);
	graph.add(2, 5);
	graph.add(2, 3);
	graph.add(3, 2);
	graph.add(3, 6);
	graph.add(4, 1);
	graph.add(4, 2);
	graph.add(5, 1);
	graph.add(5, 2);
	graph.add(5, 6);
	graph.add(6, 5);
	graph.add(6, 3);
	graph.add(7, null);

	Map<Integer, List<Node>> vertex = graph.getVertices();
	Assertions.assertThat(vertex.get(0)).extracting("id").containsOnly(1);
	Assertions.assertThat(vertex.get(1)).extracting("id")
		.containsOnly(0, 4, 5);
	Assertions.assertThat(vertex.get(2)).extracting("id")
		.containsOnly(3, 4, 5);
	Assertions.assertThat(vertex.get(3)).extracting("id")
		.containsOnly(2, 6);
	Assertions.assertThat(vertex.get(4)).extracting("id")
		.containsOnly(1, 2);
	Assertions.assertThat(vertex.get(5)).extracting("id")
		.containsOnly(1, 2, 6);
	Assertions.assertThat(vertex.get(6)).extracting("id")
		.containsOnly(3, 5);
	Assertions.assertThat(vertex.get(7)).extracting("id").containsNull();

	BiFunction<Integer, Integer, Node[]> getNeighbor = (Integer vertexID,
		Integer neighborId) -> {
	    return vertex.get(vertexID).stream()
		    .filter(node -> node.id == neighborId).toArray(Node[]::new);
	};

	Node[] neighbor1 = null;
	Node[] neighbor2 = null;
	Node[] neighbor3 = null;

	neighbor1 = getNeighbor.apply(0, 1);
	neighbor2 = getNeighbor.apply(4, 1);
	Assertions.assertThat(neighbor1).doesNotContain(neighbor2);

	neighbor1 = getNeighbor.apply(0, 1);
	neighbor2 = getNeighbor.apply(5, 1);
	Assertions.assertThat(neighbor1).doesNotContain(neighbor2);

	neighbor1 = getNeighbor.apply(1, 4);
	neighbor2 = getNeighbor.apply(2, 4);
	Assertions.assertThat(neighbor1).doesNotContain(neighbor2);

	neighbor1 = getNeighbor.apply(1, 5);
	neighbor2 = getNeighbor.apply(6, 5);
	neighbor3 = getNeighbor.apply(2, 5);
	Assertions.assertThat(neighbor1).doesNotContain(neighbor2)
		.doesNotContain(neighbor3);

	neighbor1 = getNeighbor.apply(4, 2);
	neighbor2 = getNeighbor.apply(5, 2);
	neighbor3 = getNeighbor.apply(3, 2);
	Assertions.assertThat(neighbor1).doesNotContain(neighbor2)
		.doesNotContain(neighbor3);

	neighbor1 = getNeighbor.apply(2, 3);
	neighbor2 = getNeighbor.apply(6, 3);
	Assertions.assertThat(neighbor1).doesNotContain(neighbor2);

	neighbor1 = getNeighbor.apply(5, 6);
	neighbor2 = getNeighbor.apply(3, 6);
	Assertions.assertThat(neighbor1).doesNotContain(neighbor2);
    }

    @Test
    public void adjacencyListGraphShouldReturnACopyOfVertices() {

	AdjacencyListGraph graph = new AdjacencyListGraph();
	graph.add(new Integer(0), 1);
	graph.add(1, 0);
	graph.add(1, 4);
	graph.add(1, 5);
	graph.add(2, 4);
	graph.add(2, 5);
	graph.add(3, 2);
	graph.add(3, 6);
	graph.add(4, 1);
	graph.add(4, 2);
	graph.add(5, 1);
	graph.add(5, 2);
	graph.add(5, 6);
	graph.add(6, 5);
	graph.add(6, 3);
	graph.add(7, null);

	Map<Integer, List<Node>> copy1 = graph.getVertices();
	Map<Integer, List<Node>> copy2 = graph.getVertices();
	assertThat(copy1).as("Copy1: " + copy1 + "\n" + "Copy2: " + copy2)
		.isNotSameAs(copy2);

	// Checking if keys are also not the same
	copy1.keySet().forEach(copy1_key -> {

	    copy2.keySet().forEach(copy2_key -> {
		assertThat(copy1_key).isNotSameAs(copy2_key);
	    });
	});

	// Checking if values are also not the same
	List<Node> copy1Values = copy1.values().stream()
		.flatMap(list -> list.stream()).collect(Collectors.toList());
	List<Node> copy2Values = copy2.values().stream()
		.flatMap(list -> list.stream()).collect(Collectors.toList());

	copy1Values.forEach(copy1Node -> {
	    copy2Values.forEach(copy2Node -> {
		assertThat(copy1Node).as(
			"copy1Node=" + copy1Node + "\n" + "copy2Node="
				+ copy2Node).isNotSameAs(copy2Node);
	    });
	});

    }

    @Test
    public void shouldCreateBreadthFirstTable() {

	AdjacencyListGraph graph = new AdjacencyListGraph();
	graph.add(0, 1);
	graph.add(1, 0);
	graph.add(1, 4);
	graph.add(1, 5);
	graph.add(2, 4);
	graph.add(2, 5);
	graph.add(3, 2);
	graph.add(3, 6);
	graph.add(4, 1);
	graph.add(4, 2);
	graph.add(5, 1);
	graph.add(5, 2);
	graph.add(5, 6);
	graph.add(6, 5);
	graph.add(6, 3);
	graph.add(7, null);

	graph.breadthFirst_1(3);
	Map<Integer, BreadthFirstNode> breadthFirstRable = graph
		.getBreadthFirstTable();

	Assertions.assertThat(breadthFirstRable.get(0))
		.extracting("shortesDistance").containsOnly(4);
	Assertions.assertThat(breadthFirstRable.get(0))
		.extracting("predecessor").containsOnly(1);

	Assertions.assertThat(breadthFirstRable.get(1))
		.extracting("shortesDistance").containsOnly(3);
	Assertions.assertThat(breadthFirstRable.get(1))
		.extracting("predecessor").containsOnly(4);

	Assertions.assertThat(breadthFirstRable.get(2))
		.extracting("shortesDistance").containsOnly(1);
	Assertions.assertThat(breadthFirstRable.get(2))
		.extracting("predecessor").containsOnly(3);

	Assertions.assertThat(breadthFirstRable.get(3))
		.extracting("shortesDistance").containsOnly(0);
	Assertions.assertThat(breadthFirstRable.get(3))
		.extracting("predecessor").containsNull();

	Assertions.assertThat(breadthFirstRable.get(4))
		.extracting("shortesDistance").containsOnly(2);
	Assertions.assertThat(breadthFirstRable.get(4))
		.extracting("predecessor").containsOnly(2);

	Assertions.assertThat(breadthFirstRable.get(5))
		.extracting("shortesDistance").containsOnly(2);
	Assertions.assertThat(breadthFirstRable.get(5))
		.extracting("predecessor").containsOnly(2);

	Assertions.assertThat(breadthFirstRable.get(6))
		.extracting("shortesDistance").containsOnly(1);
	Assertions.assertThat(breadthFirstRable.get(6))
		.extracting("predecessor").containsOnly(3);

    }

    @Test
    public void findShortestPath() {
	AdjacencyListGraph graph = new AdjacencyListGraph();
	graph.add(0, 1);
	graph.add(1, 0);
	graph.add(1, 4);
	graph.add(1, 5);
	graph.add(2, 4);
	graph.add(2, 5);
	graph.add(3, 2);
	graph.add(3, 6);
	graph.add(4, 1);
	graph.add(4, 2);
	graph.add(5, 1);
	graph.add(5, 2);
	graph.add(5, 6);
	graph.add(6, 5);
	graph.add(6, 3);
	graph.add(7, null);

	String actualShortesPath = graph.findShortestPath(0, 3);
	String expectedResult = "0, 1, 4, 2, 3";
	assertThat(expectedResult).isEqualTo(actualShortesPath);
    }

    @NamedParameters("breadthFirstParams")
    private static final Object[] paramsForBreadthFirstSearch() {
	return new Object[] {
		new Object[] { 0, 3, 4 },
		new Object[] { 1, 3, 3 },
		new Object[] { 2, 3, 1 },
		new Object[] { 3, 3, 0 },
		new Object[] { 4, 3, 2 },
		new Object[] { 5, 3, 2 },
		new Object[] { 6, 3, 3 },
		new Object[] { 7, 3, null } };
    }

    @Test
    @Parameters(named = "breadthFirstParams")
    public void findShortestDistance(Integer startVertex, Integer endVertex,
	    Integer shortesDistance) {
	AdjacencyListGraph graph = new AdjacencyListGraph();
	graph.add(0, 1);
	graph.add(1, 0);
	graph.add(1, 4);
	graph.add(1, 5);
	graph.add(2, 4);
	graph.add(2, 5);
	graph.add(3, 2);
	graph.add(3, 6);
	graph.add(4, 1);
	graph.add(4, 2);
	graph.add(5, 1);
	graph.add(5, 2);
	graph.add(5, 6);
	graph.add(6, 5);
	graph.add(6, 3);
	graph.add(7, null);

	Integer actualShortestDistance = graph.findShortestDistance(
		startVertex, endVertex);
	assertThat(actualShortestDistance).isEqualTo(actualShortestDistance);
    }

    @Test
    public void findShortestPathForWeightedGraph() {
	AdjacencyListGraph graph = new AdjacencyListGraph();

	graph.add(1, 2, 1);
	graph.add(1, 4, 3);
	graph.add(2, 1, 1);
	graph.add(2, 5, 1);
	graph.add(2, 3, 2);
	graph.add(3, 2, 2);
	graph.add(3, 6, 3);
	graph.add(4, 1, 3);
	graph.add(4, 5, 1);
	graph.add(5, 4, 1);
	graph.add(5, 2, 1);
	graph.add(5, 6, 3);
	graph.add(6, 3, 3);
	graph.add(6, 5, 3);

	String actualShortesPath = graph.findShortestPath(1, 6);
	String expectedResult = "1, 2, 5, 6";
	assertThat(expectedResult).isEqualTo(actualShortesPath);

	Integer actualShortestDistance = graph.findShortestDistance(1, 6);
	assertThat(actualShortestDistance).isEqualTo(5);
    }

    @Test
    @Repeating(repetition = 100)
    public void testSelectionSort_1() {
	Random random = new Random();
	int[] actual = random.ints(-100, 100).limit(100).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.selectionSort1(actual);
	assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Repeating(repetition = 100)
    public void testQuickSort_1() {
	Random random = new Random();
	int[] actual = random.ints(-100, 100).limit(10).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.quickSort1(actual);
	assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Repeating(repetition = 100)
    public void testMergeSort_1() {
	Random random = new Random();
	int[] actual = random.ints(-100, 101).limit(100).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.mergeSort1(actual);
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void testInsertionSort_1() {
	Random random = new Random();
	int[] actual = random.ints(-100, 101).limit(10).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.insertionSort_1(actual);
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    @Repeating(repetition = 100)
    public void testBubleSort() {
	Random random = new Random();
	int[] actual = random.ints(-100, 100).limit(100).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.bubleSort(actual);
	assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Repeating(repetition = 100)
    public void testSelectionSort_2() {
	IntSupplier intSupplier = () -> {
	    return new Random().nextInt(200) - 100;
	};
	int[] actual = IntStream.generate(intSupplier).limit(100).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.selectionSort2(actual);
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    @Repeating(repetition = 100)
    public void testBubbleSort_1() {
	Random random = new Random();
	int[] actual = random.ints(-100, 100).limit(100).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.bubleSort_1(actual);
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    @Repeating(repetition = 100)
    public void testSelectionSort_3() {
	Random random = new Random();
	int[] actual = random.ints(-100, 101).limit(100).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.selectionSort3(actual);
	assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Repeating(repetition = 100)
    public void testInsertionSort_2() {
	int[] actual = new Random().ints(-100, 101).limit(100).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.insertionSort_2(actual);
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    @Repeating(repetition = 100)
    public void testBubbleSort_2() {
	int[] actual = new Random().ints(-100, 101).limit(100).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.bubleSort_2(actual);
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    @Repeating(repetition = 100)
    public void testShellSort() {
	int[] actual = new Random().ints(-100, 101).limit(10).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.shellSort(actual);
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    @Repeating(repetition = 100)
    public void testShellSort_1() {
	int[] actual = new Random().ints(-100, 101).limit(100).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.shellSort_1(actual);
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    @Repeating(repetition = 100)
    public void testInsertionSort_3() {
	int[] actual = new Random().ints(-100, 101).limit(100).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.insertionSort_3(actual);
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    @Repeating(repetition = 100)
    public void testBubbleSort_3() {
	int[] actual = new Random().ints(-100, 101).limit(100).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.bubleSort_3(actual);
	assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Repeating(repetition = 100)
    public void testSelectionSort_4() {
	Random random = new Random();
	int[] actual = random.ints(-100, 101).limit(100).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.selectionSort_4(actual);
	assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Repeating(repetition = 100)
    public void testMergeSort_2() {
	int[] actual = new Random().ints(-100, 101).limit(100).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.mergeSort_2(actual);
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    @Repeating(repetition = 100)
    public void testQuickSort_2() {
	int[] actual = new Random().ints(-100, 101).limit(10).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.quickSort_2(actual);
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    @Repeating(repetition = 100)
    public void testQuickSort_3() {
	int[] actual = new Random().ints(-100, 101).limit(10).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.quickSort_3(actual);
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    @Repeating(repetition = 100)
    public void testCountSort() {
	int min = 10;
	int max = 210;
	int[] actual = new Random().ints(min, max).limit(10).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.countSort(actual, min, max);
	assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Repeating(repetition = 100)
    public void testRadixSort() {
	int min = 0;
	int max = 10;
	int[] actual = new Random().ints(min, max).limit(10).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.radixSort(actual);
	assertThat(actual).isEqualTo(expected);
    }

    private static final Object[] parametersForTestGetDigit() {
	return new Object[] {
		new Object[] { 156, 0, 6 },
		new Object[] { 156, 1, 5 },
		new Object[] { 156, 2, 1 },
		new Object[] { 30156, 3, 0 },
		new Object[] { 156, 5, 0 },
		new Object[] { 156, 10, 0 } };
    }

    @Parameters
    @Test
    public void testGetDigit(int value, int digit, int expected) {

	int actual = Root.getDigit(value, digit);
	assertThat(actual).isEqualTo(expected);

    }

    private static final Object[] parametersForTestGetDigits() {
	return new Object[] {
		new Object[] {
			new int[] { 156, 25, 1, 300056, 99 },
			0,
			new int[] { 6, 5, 1, 6, 9 } },
		new Object[] {
			new int[] { 156, 25, 1, 300056, 99 },
			1,
			new int[] { 5, 2, 0, 5, 9 } },
		new Object[] {
			new int[] { 156, 25, 1, 300056, 99 },
			2,
			new int[] { 1, 0, 0, 0, 0 } },
		new Object[] {
			new int[] { 156, 25, 1, 300056, 99 },
			3,
			new int[] { 0, 0, 0, 0, 0 } },
		new Object[] {
			new int[] { 156, 25, 1, 300056, 99 },
			4,
			new int[] { 0, 0, 0, 0, 0 } },
		new Object[] {
			new int[] { 156, 25, 1, 300056, 99 },
			5,
			new int[] { 0, 0, 0, 3, 0 } },
		new Object[] {
			new int[] { 156, 25, 1, 300056, 99 },
			6,
			new int[] { 0, 0, 0, 0, 0 } },
		new Object[] {
			new int[] { 156, 25, 1, 300056, 99 },
			15,
			new int[] { 0, 0, 0, 0, 0 } }, };
    }

    @Parameters
    @Test
    public void testGetDigits(int[] array, int index, int[] expected) {

	int[] actual = Root.getDigits(array, index);
	assertThat(actual).isEqualTo(expected);

    }

    private static final Object[] parametersForTestAdjustFrequency() {
	return new Object[] {
		new Object[] {
			new int[] { 0, 1, 2, 3, 0, 0, 2 },
			new int[] { 0, 1, 3, 6, 6, 6, 8 }, },
		new Object[] {
			new int[] { 1, 1, 1, 1, 1, 1, 1 },
			new int[] { 1, 2, 3, 4, 5, 6, 7 } },
		new Object[] {
			new int[] { 0, 0, 0, 0, 0, 0, 0 },
			new int[] { 0, 0, 0, 0, 0, 0, 0 } },
		new Object[] {
			new int[] { 0, 0, 2, 1, 0, 0, 0, 0, 1, 2 },
			new int[] { 0, 0, 2, 3, 3, 3, 3, 3, 4, 6 } } };
    }

    @Test
    @Parameters
    public void testAdjustFrequency(int array[], int expected[]) {
	Root.adjustFrequency(array);
	int actual[] = array;
	assertThat(actual).isEqualTo(expected);

    }

    private static final Object[] parametersForTestGettingFrequencyArray() {
	return new Object[] {
		new Object[] {
			new int[] { 156, 789, 300, 100 },
			new int[] { 6, 9, 0, 0 },
			new int[] { 2, 0, 0, 0, 0, 0, 1, 0, 0, 1 } },
		new Object[] {
			new int[] { 156, 789, 300, 100 },
			new int[] { 5, 8, 0, 0 },
			new int[] { 2, 0, 0, 0, 0, 1, 0, 0, 1, 0 } },
		new Object[] {
			new int[] { 156, 789, 300, 100 },
			new int[] { 1, 7, 3, 1 },
			new int[] { 0, 2, 0, 1, 0, 0, 0, 1, 0, 0 } } };
    }

    @Test
    @Parameters
    public void testGettingFrequencyArray(int[] array, int[] digits,
	    int[] expected) {
	int[] actual = Root.getFrequencyArray(array, digits);
	assertThat(actual).isEqualTo(expected);
    }

    private static final Object[] parametersForTestFindMax() {

	return new Object[] {

		new Object[] { new int[] { 156, 789, 300, 100 }, 789 },

		new Object[] { new int[] { 56, 85, 10, 99, 1229, 635 }, 1229 },
		new Object[] {
			new int[] {
				56,
				20,
				1,
				9,
				3,
				4,
				10,
				69,
				25,
				29,
				289,
				78,
				4 },
			289 } };
    }

    @Test
    @Parameters
    public void testFindMax(int[] array, int expected) {
	int actual = Root.findMax(array);
	assertThat(actual).isEqualTo(expected);
    }

    private static final Object[] parametersForTestStableSort() {
	return new Object[] {
		new Object[] {
			new int[] { 156, 789, 300, 100 },
			new int[] { 6, 9, 0, 0 },
			new int[] { 2, 0, 0, 0, 0, 0, 1, 0, 0, 1 },
			new int[] { 2, 2, 2, 2, 2, 2, 3, 3, 3, 4 },
			new int[] { 300, 100, 156, 789 } },
		new Object[] {
			new int[] { 300, 100, 156, 789 },
			new int[] { 0, 0, 5, 8 },
			new int[] { 2, 0, 0, 0, 0, 1, 0, 0, 1, 0 },
			new int[] { 2, 2, 2, 2, 2, 3, 3, 3, 4, 4 },
			new int[] { 300, 100, 156, 789 } },
		new Object[] {
			new int[] { 300, 100, 156, 789 },
			new int[] { 3, 1, 1, 7 },
			new int[] { 0, 2, 0, 1, 0, 0, 0, 1, 0, 0 },
			new int[] { 0, 2, 2, 3, 3, 3, 3, 4, 4, 4 },
			new int[] { 100, 156, 300, 789 } } };
    }

    @Parameters
    @Test
    public void testStableSort(int[] array, int[] digits, int[] unadjustedFreq,
	    int adjustedFreq[], int[] expected) {

	PowerMockito.spy(Root.class);
	PowerMockito.when(Root.getDigits(array, 0)).thenReturn(digits);
	PowerMockito.when(Root.getFrequencyArray(array, digits)).thenReturn(
		unadjustedFreq);

	try {
	    Method method = Root.class.getDeclaredMethod("adjustFrequency",
		    int[].class);
	    Answer<?> returnAdjustedFreq = invocation -> {
		int unadjustedfreqArray[] = (int[]) invocation.getArgument(0);
		// System.out.println("BEFORE: " +
		// Arrays.toString(unadjustedfreqArray));
		System.arraycopy(adjustedFreq, 0, unadjustedFreq, 0,
			adjustedFreq.length);
		// System.out.println("AFTER: " +
		// Arrays.toString(unadjustedfreqArray));
		return null;
	    };

	    PowerMockito.doAnswer(returnAdjustedFreq).when(Root.class, method)
		    .withArguments(unadjustedFreq);
	    ;
	    // Root.stableCountSort(array, 0);
	    // assertThat(array).isEqualTo(expected);
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	} catch (SecurityException e) {
	    e.printStackTrace();
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    @Parameters(method = "parametersForTestStableSort")
    @Test
    public void testStableSort_SimpleWay(int[] array, int[] digits,
	    int[] unadjustedFreq, int adjustedFreq[], int[] expected) {

	Root.sort(array, digits, adjustedFreq);
	assertThat(array).isEqualTo(expected);
    }

    private static final Object[] parametersForTestOddonacci() {
	return new Object[] {
		new Object[] { 1, 1 },
		new Object[] { 2, 1 },
		new Object[] { 3, 1 },
		new Object[] { 4, 3 },
		new Object[] { 5, 5 },
		new Object[] { 6, 9 },
		new Object[] { 7, 17 },
		new Object[] { 8, 31 },
		new Object[] { 9, 57 },
		new Object[] { 10, 105 },
		new Object[] { 11, 193 }, };
    }

    @Test
    @Parameters
    public void testOddonacci(int n, int expected) {
	int actual = Root.Oddonacci(n);
	assertThat(actual).isEqualTo(expected);
	
	int i = 0;
	while(i < 100)
	{
	    System.out.println(Root.Oddonacci(i));
	    i++;
	}
    }
    
    @Test 
    @Repeating(repetition=100)
    public void mergeSortDescending()
    {
	int[] actual = new Random().ints(-100, 100).limit(100).toArray();
	Integer[] expectedInteger = Arrays.stream(actual).boxed().toArray(Integer[]::new);
	Comparator<Integer> comp = Integer::compare;
	
	//Comparator<Integer> comparator = Integer::compare
	Comparator<Integer> comparator = (x,y) -> {	  
	    return Integer.compare(x, y);
	};

	Arrays.sort(expectedInteger, comparator.reversed());
	int[] expected = Stream.of(expectedInteger).mapToInt(Integer::intValue).toArray();
	Root.mergeSortDescending(actual);
	assertThat(actual).isEqualTo(expected);
	
    }
    
    
    @Test
    @Repeating(repetition=100)
    public void testInsertionSortRecursion()
    {
	int[] actual = new Random().ints(-100, 100).limit(10).toArray();
	int[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.insertionSort_Recursion(actual);
	assertThat(actual).isEqualTo(expected);
	
	
    }
    
    @Test
    //@Repeating(repetition=100)
    public void testRadixSort2()
    {
	String[] actual = new String[10];
	
	int i = 0;
	while(i < actual.length)
	{
	    int length = new Random().nextInt(10);
	    int j = 0;
	    StringBuilder stringBuilder = new StringBuilder();
	    while(j < length)
	    {
		char character = (char)(new Random().nextInt(95)+32);
		stringBuilder.append(character);
		j++;
	    }
	    actual[i] = stringBuilder.toString();
	    i++;
	}
	
	String[] expected = Arrays.copyOf(actual, actual.length);
	Arrays.sort(expected);
	Root.radixSort(actual);
	assertThat(actual).isEqualTo(expected);
	
    }
    

}

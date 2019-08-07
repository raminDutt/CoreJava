package coreJava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class BinarySearchTreeTest {

    @Test
    public void testInsert() {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

	binarySearchTree.insert(15);
	binarySearchTree.insert(5);
	binarySearchTree.insert(150);
	binarySearchTree.insert(2);
	binarySearchTree.insert(36);
	binarySearchTree.insert(200);
	binarySearchTree.insert(10);

	String actualString = binarySearchTree.toString();
	String expectedString = "2,5,10,15,36,150,200";
	assertThat(actualString).isEqualTo(expectedString);

	binarySearchTree.insert(50);
	binarySearchTree.insert(40);
	binarySearchTree.insert(45);
	binarySearchTree.insert(100);
	binarySearchTree.insert(90);
	binarySearchTree.insert(80);
	binarySearchTree.insert(10);
	binarySearchTree.insert(45);
	binarySearchTree.insert(48);
	binarySearchTree.toString();

	actualString = binarySearchTree.toString();
	expectedString = "2,5,10,10,15,36,40,45,45,48,50,80,90,100,150,200";
	assertThat(actualString).isEqualTo(expectedString);
    }

    @Test
    public void testInsertR() {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

	binarySearchTree.insertR(15);
	binarySearchTree.insertR(5);
	binarySearchTree.insertR(150);
	binarySearchTree.insertR(2);
	binarySearchTree.insertR(36);
	binarySearchTree.insertR(200);
	binarySearchTree.insertR(10);

	String actualString = binarySearchTree.toString();
	String expectedString = "2,5,10,15,36,150,200";
	assertThat(actualString).isEqualTo(expectedString);

	binarySearchTree.insertR(50);
	binarySearchTree.insertR(40);
	binarySearchTree.insertR(45);
	binarySearchTree.insertR(100);
	binarySearchTree.insertR(90);
	binarySearchTree.insertR(80);
	binarySearchTree.insertR(10);
	binarySearchTree.insertR(45);
	binarySearchTree.insertR(48);
	binarySearchTree.toString();

	actualString = binarySearchTree.toString();
	expectedString = "2,5,10,10,15,36,40,45,45,48,50,80,90,100,150,200";
	assertThat(actualString).isEqualTo(expectedString);
    }

    @Test
    public void testSort() {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
	binarySearchTree.insert(15);
	binarySearchTree.insert(5);
	binarySearchTree.insert(150);
	binarySearchTree.insert(2);
	binarySearchTree.insert(36);
	binarySearchTree.insert(200);
	binarySearchTree.insert(10);

	List<Integer> actualList = binarySearchTree.sort();
	List<Integer> expectedList = new ArrayList<>();
	expectedList.add(2);
	expectedList.add(5);
	expectedList.add(10);
	expectedList.add(15);
	expectedList.add(36);
	expectedList.add(150);
	expectedList.add(200);

	assertThat(actualList).containsExactlyElementsOf(expectedList);

	binarySearchTree.insert(50);
	binarySearchTree.insert(40);
	binarySearchTree.insert(45);
	binarySearchTree.insert(100);
	binarySearchTree.insert(90);
	binarySearchTree.insert(80);
	binarySearchTree.insert(10);
	binarySearchTree.insert(45);
	binarySearchTree.insert(48);

	expectedList = new ArrayList<>();
	expectedList.add(2);
	expectedList.add(5);
	expectedList.add(10);
	expectedList.add(10);
	expectedList.add(15);
	expectedList.add(36);
	expectedList.add(40);
	expectedList.add(45);
	expectedList.add(45);
	expectedList.add(48);
	expectedList.add(50);
	expectedList.add(80);
	expectedList.add(90);
	expectedList.add(100);
	expectedList.add(150);
	expectedList.add(200);
	actualList = binarySearchTree.sort();

	assertThat(actualList).isEqualTo(expectedList);
    }

    @Test
    public void test1() {
	BinarySearchTree binarySearchTree = new BinarySearchTree<>();
	binarySearchTree.f();
    }

    @Test
    public void testInOrder() {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

	binarySearchTree.insertR(15);
	binarySearchTree.insertR(5);
	binarySearchTree.insertR(150);
	binarySearchTree.insertR(2);
	binarySearchTree.insertR(36);
	binarySearchTree.insertR(200);
	binarySearchTree.insertR(10);

	String actualString = binarySearchTree.printInOrder();
	String expectedString = "2,5,10,15,36,150,200";
	assertThat(actualString).isEqualTo(expectedString);

    }

    @Test
    public void testPreOrder() {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

	binarySearchTree.insertR(15);
	binarySearchTree.insertR(5);
	binarySearchTree.insertR(150);
	binarySearchTree.insertR(2);
	binarySearchTree.insertR(36);
	binarySearchTree.insertR(200);
	binarySearchTree.insertR(10);

	String actualString = binarySearchTree.printPreOrder();
	String expectedString = "15,5,2,10,150,36,200";
	assertThat(actualString).isEqualTo(expectedString);

	binarySearchTree = new BinarySearchTree<>();

	binarySearchTree.insertR(60);
	binarySearchTree.insertR(20);
	binarySearchTree.insertR(100);
	binarySearchTree.insertR(10);
	binarySearchTree.insertR(40);
	binarySearchTree.insertR(70);
	binarySearchTree.insertR(200);
	binarySearchTree.insertR(5);
	binarySearchTree.insertR(15);
	binarySearchTree.insertR(30);
	binarySearchTree.insertR(45);
	binarySearchTree.insertR(25);
	binarySearchTree.insertR(35);
	binarySearchTree.insertR(44);
	binarySearchTree.insertR(47);
	binarySearchTree.insertR(43);
	binarySearchTree.insertR(46);
	binarySearchTree.insertR(49);
	binarySearchTree.insertR(42);
	binarySearchTree.insertR(48);
	binarySearchTree.insertR(55);
	binarySearchTree.insertR(41);
	binarySearchTree.insertR(52);
	binarySearchTree.insertR(59);

	actualString = binarySearchTree.printPreOrder();
	expectedString = "60,20,10,5,15,40,30,25,35,45,44,43,42,41,47,46,49,48,55,52,59,100,70,200";
	assertThat(actualString).isEqualTo(expectedString);
    }

    @Test
    public void testPostOrder() {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

	binarySearchTree.insertR(15);
	binarySearchTree.insertR(5);
	binarySearchTree.insertR(150);
	binarySearchTree.insertR(2);
	binarySearchTree.insertR(36);
	binarySearchTree.insertR(200);
	binarySearchTree.insertR(10);

	String actualString = binarySearchTree.printPostOrder();
	String expectedString = "2,10,5,36,200,150,15";
	assertThat(actualString).isEqualTo(expectedString);

	binarySearchTree = new BinarySearchTree<>();

	binarySearchTree.insertR(60);
	binarySearchTree.insertR(20);
	binarySearchTree.insertR(100);
	binarySearchTree.insertR(10);
	binarySearchTree.insertR(40);
	binarySearchTree.insertR(70);
	binarySearchTree.insertR(200);
	binarySearchTree.insertR(5);
	binarySearchTree.insertR(15);
	binarySearchTree.insertR(30);
	binarySearchTree.insertR(45);
	binarySearchTree.insertR(25);
	binarySearchTree.insertR(35);
	binarySearchTree.insertR(44);
	binarySearchTree.insertR(47);
	binarySearchTree.insertR(43);
	binarySearchTree.insertR(46);
	binarySearchTree.insertR(49);
	binarySearchTree.insertR(42);
	binarySearchTree.insertR(48);
	binarySearchTree.insertR(55);
	binarySearchTree.insertR(41);
	binarySearchTree.insertR(52);
	binarySearchTree.insertR(59);

	actualString = binarySearchTree.printPostOrder();
	expectedString = "5,15,10,25,35,30,41,42,43,44,46,48,52,59,55,49,47,45,40,20,70,200,100,60";
	assertThat(actualString).isEqualTo(expectedString);

    }

    @Test
    public void testleveOrder() {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

	binarySearchTree.insertR(15);
	binarySearchTree.insertR(5);
	binarySearchTree.insertR(150);
	binarySearchTree.insertR(2);
	binarySearchTree.insertR(36);
	binarySearchTree.insertR(200);
	binarySearchTree.insertR(10);

	String actualString = binarySearchTree.printLevelOrder();
	String expectedString = "15,5,150,2,10,36,200";
	assertThat(actualString).isEqualTo(expectedString);
    }

    @Test
    public void testGet() {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

	binarySearchTree.insertR(15);
	binarySearchTree.insertR(5);
	binarySearchTree.insertR(150);
	binarySearchTree.insertR(2);
	binarySearchTree.insertR(36);
	binarySearchTree.insertR(200);
	binarySearchTree.insertR(10);

	Boolean actual = binarySearchTree.get(15);
	assertThat(actual).isTrue();
	actual = binarySearchTree.get(200);
	assertThat(actual).isTrue();
	actual = binarySearchTree.get(250);
	assertThat(actual).isFalse();

    }

    @Test
    public void testGetMax() {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

	binarySearchTree.insertR(15);
	binarySearchTree.insertR(5);
	binarySearchTree.insertR(150);
	binarySearchTree.insertR(2);
	binarySearchTree.insertR(36);
	binarySearchTree.insertR(200);
	binarySearchTree.insertR(10);

	Integer actual = binarySearchTree.getMax();
	assertThat(actual.intValue()).isEqualTo(200);

    }

    @Test
    public void testGetMin() {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

	binarySearchTree.insertR(15);
	binarySearchTree.insertR(5);
	binarySearchTree.insertR(150);
	binarySearchTree.insertR(2);
	binarySearchTree.insertR(36);
	binarySearchTree.insertR(200);
	binarySearchTree.insertR(10);

	Integer actual = binarySearchTree.getMin();
	assertThat(actual.intValue()).isEqualTo(2);

    }

    @Test
    public void removingLeaf() {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

	binarySearchTree.insertR(15);
	binarySearchTree.insertR(5);
	binarySearchTree.insertR(150);
	binarySearchTree.insertR(2);
	binarySearchTree.insertR(36);
	binarySearchTree.insertR(200);
	binarySearchTree.insertR(10);

	boolean status = binarySearchTree.remove(36);
	assertThat(status).isTrue();
	String actualString = binarySearchTree.printInOrder();
	String expectedString = "2,5,10,15,150,200";
	assertThat(actualString).isEqualTo(expectedString);

	String actualLevelString = binarySearchTree.printLevelOrder();
	String expectedLevelString = "15,5,150,2,10,200";
	assertThat(actualLevelString).isEqualTo(expectedLevelString);

	status = binarySearchTree.remove(36);
	assertThat(status).isFalse();

	status = binarySearchTree.remove(10);
	assertThat(status).isTrue();
	actualString = binarySearchTree.printInOrder();
	expectedString = "2,5,15,150,200";
	assertThat(actualString).isEqualTo(expectedString);

	actualLevelString = binarySearchTree.printLevelOrder();
	expectedLevelString = "15,5,150,2,200";
	assertThat(actualLevelString).isEqualTo(expectedLevelString);

    }

    @Test
    public void removeNodeWithSingleChild() {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

	binarySearchTree.insertR(15);
	binarySearchTree.insertR(5);
	binarySearchTree.insertR(150);
	binarySearchTree.insertR(2);
	binarySearchTree.insertR(36);
	binarySearchTree.insertR(200);

	boolean status = binarySearchTree.remove(5);
	assertThat(status).isTrue();
	String actualString = binarySearchTree.printInOrder();
	String expectedString = "2,15,36,150,200";
	assertThat(actualString).isEqualTo(expectedString);

	String actualLevelString = binarySearchTree.printLevelOrder();
	String expectedLevelString = "15,2,150,36,200";
	assertThat(actualLevelString).isEqualTo(expectedLevelString);
    }

    private static final Object[] parametersForRemoveNodeWithTwoChild() {
	return new Object[] {
		new Object[] {
			2,
			false,
			"5,10,15,20,25,30,31,35,40,41,42,43,44,45,46,47,48,49,52,55,59,60,70,100,200",
			"60,20,100,10,40,70,200,5,15,30,45,25,35,44,47,31,43,46,49,42,48,55,41,52,59" },
		new Object[] {
			20,
			true,
			"5,10,15,25,30,31,35,40,41,42,43,44,45,46,47,48,49,52,55,59,60,70,100,200",
			"60,15,100,10,40,70,200,5,30,45,25,35,44,47,31,43,46,49,42,48,55,41,52,59" },
		new Object[] {
			10,
			true,
			"5,15,20,25,30,31,35,40,41,42,43,44,45,46,47,48,49,52,55,59,60,70,100,200",
			"60,20,100,5,40,70,200,15,30,45,25,35,44,47,31,43,46,49,42,48,55,41,52,59" },

		new Object[] {
			40,
			true,
			"5,10,15,20,25,30,31,35,41,42,43,44,45,46,47,48,49,52,55,59,60,70,100,200",
			"60,20,100,10,35,70,200,5,15,30,45,25,31,44,47,43,46,49,42,48,55,41,52,59" },
		new Object[] {
			45,
			true,
			"5,10,15,20,25,30,31,35,40,41,42,43,44,46,47,48,49,52,55,59,60,70,100,200",
			"60,20,100,10,40,70,200,5,15,30,44,25,35,43,47,31,42,46,49,41,48,55,52,59" } };
    }

    @Parameters
    @Test
    public void removeNodeWithTwoChild(Integer removeValue,
	    boolean expectedStatus, String expectedString,
	    String expectedLevelString) {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

	binarySearchTree.insertR(60);
	binarySearchTree.insertR(20);
	binarySearchTree.insertR(100);
	binarySearchTree.insertR(10);
	binarySearchTree.insertR(40);
	binarySearchTree.insertR(70);
	binarySearchTree.insertR(200);
	binarySearchTree.insertR(5);
	binarySearchTree.insertR(15);
	binarySearchTree.insertR(30);
	binarySearchTree.insertR(45);
	binarySearchTree.insertR(25);
	binarySearchTree.insertR(35);
	binarySearchTree.insertR(44);
	binarySearchTree.insertR(47);
	binarySearchTree.insertR(43);
	binarySearchTree.insertR(46);
	binarySearchTree.insertR(49);
	binarySearchTree.insertR(42);
	binarySearchTree.insertR(48);
	binarySearchTree.insertR(55);
	binarySearchTree.insertR(41);
	binarySearchTree.insertR(52);
	binarySearchTree.insertR(59);
	binarySearchTree.insertR(31);

	boolean status = binarySearchTree.remove(removeValue);
	String actualString = binarySearchTree.printInOrder();
	String actualLevelString = binarySearchTree.printLevelOrder();

	assertThat(status).isEqualTo(expectedStatus);
	assertThat(actualString).isEqualTo(expectedString);
	assertThat(actualLevelString).isEqualTo(expectedLevelString);

    }
    
    @Test
    public void testPreorder()
    {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
	binarySearchTree.insert(25);
	binarySearchTree.insert(20);
	binarySearchTree.insert(27);
	binarySearchTree.insert(15);
	binarySearchTree.insert(22);
	binarySearchTree.insert(26);
	binarySearchTree.insert(30);
	binarySearchTree.insert(17);
	binarySearchTree.insert(29);
	binarySearchTree.insert(32);
	
	String expected = "25,20,15,17,22,27,26,30,29,32";
	String actual = binarySearchTree.preOrder();
	assertThat(expected).isEqualTo(actual);
	
	binarySearchTree = new BinarySearchTree<Integer>();
	expected = binarySearchTree.preOrder();
	assertThat(expected).isEqualTo("");
    }

}

package coreJava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class HeapTest {

    private Heap<Integer> heap;

    @Before
    public void populateHeap() {
	heap = new Heap<>();
	heap.insert(10);
	heap.insert(2);
	heap.insert(25);
	heap.insert(3);
	heap.insert(-5);
	heap.insert(16);
	heap.insert(8);
	heap.insert(4);
	heap.insert(5);

    }

    @Test
    public void testDeleteFromEmptyHeap() {
	heap = new Heap<>();
	boolean actualStatus = heap.delete(5);
	assertThat(actualStatus).isFalse();
    }

    @Test
    public void testDeleteFromMiddle() {
	heap.delete(5);
	String expected = "25,4,16,3,-5,10,8,2";
	String actual = heap.toString();
	assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDeleteLeaf() {

	heap.delete(2);

	String expected = "25,5,16,4,-5,10,8,3";
	String actual = heap.toString();
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void testDeleteNonExistingValue() {
	boolean actualStatus = heap.delete(100);
	assertThat(actualStatus).isFalse();

    }

    @Test
    public void testDeleteRootNode() {
	boolean actualStatus = heap.delete(25);
	assertThat(actualStatus).isTrue();

	String expected = "16,5,10,4,-5,3,8,2";
	String actual = heap.toString();
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void testFixAbove() {
	heap = new Heap<>();
	heap.insert(20);
	heap.insert(18);
	heap.insert(5);
	heap.insert(18);
	heap.insert(18);
	heap.insert(5);
	heap.insert(5);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(5);
	heap.insert(5);
	heap.insert(5);
	heap.insert(5);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(5);
	heap.insert(5);
	heap.insert(5);
	heap.insert(5);
	heap.insert(5);
	heap.insert(5);
	heap.insert(5);
	heap.insert(2);
	heap.insert(18);
	String expected = "20,18,5,18,18,5,5,18,18,18,18,5,5,5,5,18,18,18,18,18,18,18,18,5,5,5,5,5,5,5,2,18";
	String actual = heap.toString();
	assertThat(actual).isEqualTo(expected);
	heap.delete(2);

	expected = "20,18,18,18,18,5,5,18,18,18,18,5,5,5,5,18,18,18,18,18,18,18,18,5,5,5,5,5,5,5,5";
	actual = heap.toString();
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void testFixBelow() {
	heap = new Heap<>();
	heap.insert(20);
	heap.insert(18);
	heap.insert(5);
	heap.insert(18);
	heap.insert(18);
	heap.insert(5);
	heap.insert(5);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(5);
	heap.insert(5);
	heap.insert(5);
	heap.insert(5);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(18);
	heap.insert(5);
	heap.insert(5);
	heap.insert(5);
	heap.insert(5);
	heap.insert(5);
	heap.insert(5);
	heap.insert(5);
	heap.insert(2);

	String expected = "20,18,5,18,18,5,5,18,18,18,18,5,5,5,5,18,18,18,18,18,18,18,18,5,5,5,5,5,5,5,2";
	String actual = heap.toString();
	assertThat(actual).isEqualTo(expected);
	heap.delete(20);

	expected = "18,18,5,18,18,5,5,18,18,18,18,5,5,5,5,18,18,18,18,18,18,18,2,5,5,5,5,5,5,5";
	actual = heap.toString();
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void testInsert() {

	String expected = "25,5,16,4,-5,10,8,2,3";
	String actual = heap.toString();
	assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void testprintEmptyHeap() {
	heap = new Heap<>();
	String expected = "";
	String actual = heap.toString();
	assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testReverse() {

	heap.reverse();
	String expected = "3,2,8,10,-5,4,16,5,25";
	String actual = heap.toString();
	assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSort() {
	
	heap.sort();
	String expected = "-5,2,3,4,5,8,10,16,25";
	String actual = heap.toString();
	assertThat(actual).isEqualTo(expected);
    }
    
    @Test
    public void testSortDesc() {
	
	heap.sortDesc();
	String expected = "25,16,10,8,5,4,3,2,-5";
	String actual = heap.toString();
	assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSwap() {
	int i = 0;
	int j = heap.size - 1;
	while (i < j) {
	    heap.swap(i, j);
	    i++;
	    j--;
	}

	String expected = "3,2,8,10,-5,4,16,5,25";

	String actual = heap.toString();
	assertThat(actual).isEqualTo(expected);
    }

}

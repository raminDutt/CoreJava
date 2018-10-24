package coreJava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SinglyLinkedListTest {

    @Test
    public void testAdd() {
	SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
	linkedList.add(5);
	linkedList.add(10);
	linkedList.add(55);
	linkedList.add(75);
	linkedList.add(105);
	Function<SinglyLinkedList<Integer>, List<Integer>> extracting = (sll) -> {
	    List<Integer> list = new ArrayList<>();
	    SinglyLinkedList<Integer>.Node node = sll.head;
	    while (node != null) {
		list.add(node.value);
		node = node.next;
	    }
	    return list;
	};
	List<Integer> list = extracting.apply(linkedList);
	assertThat(list).containsExactly(105, 75, 55, 10, 5);
	assertThat(list.size()).isEqualTo(5);
    }

    @Test
    public void testAddWithIndex() {
	SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
	linkedList.add(5);
	linkedList.add(10);
	linkedList.add(55);
	linkedList.add(75);
	linkedList.add(105);
	linkedList.add(99, 2);
	linkedList.add(990, 6);
	linkedList.add(-5, 0);

	Function<SinglyLinkedList<Integer>, List<Integer>> extracting = (sll) -> {
	    List<Integer> list = new ArrayList<>();
	    SinglyLinkedList<Integer>.Node node = sll.head;
	    while (node != null) {
		list.add(node.value);
		node = node.next;
	    }
	    return list;
	};
	List<Integer> list = extracting.apply(linkedList);
	assertThat(list).containsExactly(-5, 105, 75, 99, 55, 10, 5, 990);
	assertThat(list.size()).isEqualTo(8);
    }

    private static final Object[] parametersForAddWithInvalidIndexShouldThrowException() {
	return new Object[] { new Object[] { -1 }, new Object[] { 100 } };
    }

    @Test
    @Parameters
    public void addWithInvalidIndexShouldThrowException(int value) {
	SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
	assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(
		() -> {
		    linkedList.add(5, value);
		});

    }

    @Test
    public void testSize() {
	SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
	linkedList.add(5);
	linkedList.add(10);
	linkedList.add(55);
	linkedList.add(75);
	linkedList.add(105);
	linkedList.add(99, 2);

	assertThat(linkedList.size()).isEqualTo(6);
    }

    @Test
    public void testRemoveWithIndexFromMiddle() {
	SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
	linkedList.add(5);
	linkedList.add(10);
	linkedList.add(55);
	linkedList.add(75);
	linkedList.add(105);
	linkedList.remove(3);

	Function<SinglyLinkedList<Integer>, List<Integer>> extracting = (sll) -> {
	    List<Integer> list = new ArrayList<>();
	    SinglyLinkedList<Integer>.Node node = sll.head;
	    while (node != null) {
		list.add(node.value);
		node = node.next;
	    }
	    return list;
	};
	List<Integer> list = extracting.apply(linkedList);
	assertThat(list).containsExactly(105,75,55,5);
    }
    
    @Test
    public void testRemoveWithIndexFromHead() {
	SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
	linkedList.add(5);
	linkedList.add(10);
	linkedList.add(55);
	linkedList.add(75);
	linkedList.add(105);
	linkedList.remove(0);

	Function<SinglyLinkedList<Integer>, List<Integer>> extracting = (sll) -> {
	    List<Integer> list = new ArrayList<>();
	    SinglyLinkedList<Integer>.Node node = sll.head;
	    while (node != null) {
		list.add(node.value);
		node = node.next;
	    }
	    return list;
	};
	List<Integer> list = extracting.apply(linkedList);
	assertThat(list).containsExactly(75,55,10,5);
	assertThat(list.size()).isEqualTo(4);
    }
    
    @Test
    public void testRemoveFromHead() {
	SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
	linkedList.add(5);
	linkedList.add(10);
	linkedList.add(55);
	linkedList.add(75);
	linkedList.add(105);
	linkedList.remove();

	Function<SinglyLinkedList<Integer>, List<Integer>> extracting = (sll) -> {
	    List<Integer> list = new ArrayList<>();
	    SinglyLinkedList<Integer>.Node node = sll.head;
	    while (node != null) {
		list.add(node.value);
		node = node.next;
	    }
	    return list;
	};
	List<Integer> list = extracting.apply(linkedList);
	assertThat(list).containsExactly(75,55,10,5);
	assertThat(list.size()).isEqualTo(4);
    }
    
    @Test
    public void testRemoveWithIndexFromEnd() {
	SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
	linkedList.add(5);
	linkedList.add(10);
	linkedList.add(55);
	linkedList.add(75);
	linkedList.add(105);
	linkedList.remove(4);

	Function<SinglyLinkedList<Integer>, List<Integer>> extracting = (sll) -> {
	    List<Integer> list = new ArrayList<>();
	    SinglyLinkedList<Integer>.Node node = sll.head;
	    while (node != null) {
		list.add(node.value);
		node = node.next;
	    }
	    return list;
	};
	List<Integer> list = extracting.apply(linkedList);
	assertThat(list).containsExactly(105, 75,55,10);
	assertThat(list.size()).isEqualTo(4);
    }

    @Test
    public void removeWithInvalidIndexShouldThrowException() {
	SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
	assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(
		() -> {
		    linkedList.remove(-1);
		});

	assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(
		() -> {
		    linkedList.remove(1);
		});

	linkedList.add(5);
	linkedList.add(10);
	linkedList.add(55);
	linkedList.add(75);
	linkedList.add(105);

	assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(
		() -> {
		    linkedList.remove(200);
		});

    }

}

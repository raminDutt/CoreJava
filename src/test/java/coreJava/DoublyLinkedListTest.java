package coreJava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.assertj.core.api.Assert;
import org.junit.Before;
import org.junit.Test;

import annotationProcessor.JavaDocProcessor.Return;

public class DoublyLinkedListTest {

    @Test
    public void testAddToFront() {
	DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
	list.addToFront(10);
	list.addToFront(20);
	list.addToFront(30);
	list.addToFront(40);
	list.addToFront(50);

	String actual = list.toString();
	String expected = "50->40->30->20->10->null";
	assertThat(actual).isEqualTo(expected);
	assertThat(list.size()).isEqualTo(5);

    }

    @Test
    public void testAddToTail() {
	DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
	list.addToTail(10);
	list.addToTail(20);
	list.addToTail(30);
	list.addToTail(40);
	list.addToTail(50);

	String actual = list.toString();
	String expected = "10->20->30->40->50->null";
	assertThat(actual).isEqualTo(expected);
	assertThat(list.size()).isEqualTo(5);

    }

    @Test
    public void testAddAtFrontAndAtTail() {
	DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
	list.addToFront(10);
	list.addToFront(20);
	list.addToFront(30);
	list.addToTail(40);
	list.addToTail(50);
	list.addToTail(60);
	String actual = list.toString();
	String expected = "30->20->10->40->50->60->null";
	assertThat(actual).isEqualTo(expected);
	assertThat(list.size()).isEqualTo(6);
    }

    @Test
    public void testAddWithIndex() {
	DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
	list.addToTail(10);
	list.addToTail(20);
	list.addToTail(30);
	list.addToTail(40);
	list.addToTail(50);

	list.add(35, 3);
	list.add(5, 0);
	list.add(45, 6);
	list.add(100, 8);
	String actual = list.toString();
	String expected = "5->10->20->30->35->40->45->50->100->null";
	assertThat(actual).isEqualTo(expected);
	assertThat(list.size()).isEqualTo(9);
    }

    @Test
    public void shouldThrowIndexOutOfBoundExceptionWhenAddingWithIndex() {
	DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

	assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(
		() -> {
		    list.add(10, 10);
		});
    }

    @Test
    public void removeFromHeadWithListOfSizeGreaterThanOne() {
	DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
	list.addToTail(10);
	list.addToTail(20);
	list.addToTail(30);
	list.addToTail(40);
	list.addToTail(50);

	Integer result = list.removeFromHead();
	assertThat(result).isEqualTo(10);
	String actual = list.toString();
	String expected = "20->30->40->50->null";
	assertThat(actual).isEqualTo(expected);
	assertThat(list.size()).isEqualTo(4);
    }

    @Test
    public void removeFromHeadWithListOfSizeEqualThanOne() {
	DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

	list = new DoublyLinkedList<>();
	Integer result = list.removeFromHead();
	assertThat(result).isNull();
	String actual = list.toString();
	String expected = "null";
	assertThat(actual).isEqualTo(expected);
	assertThat(list.size()).isEqualTo(0);

	// use case 3: removing from a list
	list = new DoublyLinkedList<>();
	list.addToTail(10);
	result = list.removeFromHead();
	assertThat(result).isEqualTo(10);
	actual = list.toString();
	expected = "null";
	assertThat(actual).isEqualTo(expected);
	assertThat(list.size()).isEqualTo(0);

    }

    @Test
    public void removeFromHeadWithEmptyList() {
	DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

	list = new DoublyLinkedList<>();
	Integer result = list.removeFromHead();
	assertThat(result).isNull();
	String actual = list.toString();
	String expected = "null";
	assertThat(actual).isEqualTo(expected);
	assertThat(list.size()).isEqualTo(0);

	// use case 3: removing from a list
	list = new DoublyLinkedList<>();
	list.addToTail(10);
	result = list.removeFromHead();
	assertThat(result).isEqualTo(10);
	actual = list.toString();
	expected = "null";
	assertThat(actual).isEqualTo(expected);
	assertThat(list.size()).isEqualTo(0);

    }

    @Test
    public void removeFromTailWithListSizeGreaterThanOne() {
	DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
	list.addToTail(10);
	list.addToTail(20);
	list.addToTail(30);
	list.addToTail(40);
	list.addToTail(50);

	Integer result = list.removeFromTail();
	assertThat(result).isEqualTo(50);
	String actual = list.toString();
	String expected = "10->20->30->40->null";
	assertThat(actual).isEqualTo(expected);
	assertThat(list.size()).isEqualTo(4);

    }

    @Test
    public void removeFromTailWithListSizeGreaterEqualOne() {
	DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
	list.addToTail(10);

	Integer result = list.removeFromTail();
	assertThat(result).isEqualTo(10);
	String actual = list.toString();
	String expected = "null";
	assertThat(actual).isEqualTo(expected);
	assertThat(list.size()).isEqualTo(0);

    }

    @Test
    public void removeFromTailWithEmptyList() {
	DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

	Integer result = list.removeFromTail();
	assertThat(result).isNull();
	String actual = list.toString();
	String expected = "null";
	assertThat(actual).isEqualTo(expected);
	assertThat(list.size()).isEqualTo(0);

    }

    @Test
    public void addBeforeTest() {
	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
	doublyLinkedList.addToTail(10);
	doublyLinkedList.addToTail(20);
	doublyLinkedList.addToTail(30);
	doublyLinkedList.addToTail(40);
	doublyLinkedList.addToTail(50);

	boolean result = doublyLinkedList.addBefore(35, 5);
	assertThat(result).isFalse();
	result = doublyLinkedList.addBefore(35, 30);
	assertThat(result).isTrue();
	Function<DoublyLinkedList<Integer>, int[]> function = doubly -> {
	    int[] array = new int[doublyLinkedList.size()];
	    DoublyLinkedList.Node<Integer> head = doublyLinkedList.head;
	    int i = 0;
	    while (head != null) {
		array[i] = head.element;
		head = head.next;
		i++;
	    }

	    return array;
	};

	int[] array = (int[]) function.apply(doublyLinkedList);
	assertThat(array).containsExactly(10, 20, 35, 30, 40, 50);
	assertThat(doublyLinkedList.size()).isEqualTo(6);

	result = doublyLinkedList.addBefore(5, 10);
	assertThat(result).isTrue();
	array = (int[]) function.apply(doublyLinkedList);
	assertThat(array).containsExactly(5, 10, 20, 35, 30, 40, 50);

	result = doublyLinkedList.addBefore(45, 50);
	assertThat(result).isTrue();
	array = (int[]) function.apply(doublyLinkedList);
	assertThat(array).containsExactly(5, 10, 20, 35, 30, 40, 45, 50);

    }
}

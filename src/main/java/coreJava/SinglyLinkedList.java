package coreJava;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList<T extends Comparable<T>> {

    Node head = null;
    int size = 0;

    class Node {
	T value = null;
	Node next = null;
    }

    public void add(T value) {
	if (head == null) {
	    head = new Node();
	    head.value = value;
	} else {
	    Node temp = head;
	    head = new Node();
	    head.value = value;
	    head.next = temp;
	}
	size++;

    }

    public void add(T value, int index) {
	if (index < 0 || index > size()) {
	    throw new IndexOutOfBoundsException();
	}

	if (index == 0) {
	    add(value);
	    return;
	}

	Node temp = head;
	int i = 0;
	while (i != index - 1) {
	    temp = temp.next;
	    i++;
	}
	Node temp2 = new Node();
	temp2.value = value;
	temp2.next = temp.next;
	temp.next = temp2;
	size++;

    }

    public int size() {
	return size;
    }

    public T remove(int index) {

	if (index < 0 || index >= size)
	    throw new IndexOutOfBoundsException();

	if (index == 0) {
	    T v = remove();
	    return v;
	}

	Node temp = head;
	int i = 0;
	while (i < index - 1) {
	    temp = temp.next;
	    i++;
	}

	Node temp2 = temp.next.next;
	T v = temp.next.value;
	temp.next.next = null;
	temp.next = temp2;
	size--;
	return v;

    }

    public T remove() {

	if (head == null) {
	    return null;
	}

	Node temp = head;
	head = temp.next;
	temp.next = null;
	size--;
	return temp.value;
    }

    public boolean iSort(T t) {

	Node node = new Node();
	node.value = t;

	if (head == null) {
	    head = node;
	    size++;
	    return true;
	}

	Node it = head;
	Node prev = null;
	while (it != null) {
	    if (it.value.compareTo(t) != 1) {
		prev = it;
		it = it.next;
	    } else {
		break;
	    }
	}

	if (prev == null) {
	    // add to front
	    node.next = head;
	    head = node;
	    size++;
	    return true;
	}

	if (it == null) {
	    // add to end
	    prev.next = node;
	    size++;
	    return true;
	}

	if (it != null && prev != null) {
	    // add to middle
	    prev.next = node;
	    node.next = it;
	    size++;
	    return true;
	}

	return false;

    }

    public boolean insertSort(T t) {

	List<T> list = new ArrayList<>();
	if (size != 0) {
	    T v = null;
	    while ((v = remove()) != null) {
		list.add(v);
	    }
	}

	list.add(t);
	boolean flag = true;
	int i = 0;
	while (i < list.size()) {
	    flag = flag && iSort(list.get(i));
	    i++;
	}
	return flag;
    }

}

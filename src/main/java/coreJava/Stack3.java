package coreJava;

public class Stack3<T> {

    private int size = 0;
    private Node head = null;
    private Node tail = null;

    class Node {
	T element = null;
	Node prev = null;
	Node next = null;
    }

    public void push(T element) {

	Node node = new Node();
	node.element = element;
	if (size == 0) {

	    head = node;
	    tail = node;
	    size++;
	    return;
	}

	tail.next = node;
	node.prev = tail;
	tail = node;
	size++;

    }

    public T pop() {

	if (size == 0) {
	    return null;
	}

	if (size == 1) {
	    Node temp = tail;
	    tail = null;
	    head = null;
	    size--;
	    return temp.element;
	}

	Node temp = tail;
	tail = tail.prev;
	tail.next = null;
	temp.prev = null;
	size--;

	return temp.element;
    }

    public T peek() {
	if (size == 0) {
	    return null;
	}

	return tail.element;
    }

    public String toString() {
	Node it = head;
	String result = "";
	while (it != null) {
	    result = result + it.element + "->";
	    it = it.next;
	}
	result = result + "NULL";
	return result;
    }

    public int getSize() {

	return size;
    }

}

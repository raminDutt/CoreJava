package coreJava;

public class DoublyLinkedList<E> {

    Node<E> head = null;
    Node<E> tail = null;
    private int size = 0;

    static class Node<E> {

	Node<E> prev = null;
	E element;
	Node<E> next = null;
    }

    public void addToFront(E e) {
	Node<E> addedNode = new Node<>();
	addedNode.element = e;

	if (head != null) {
	    addedNode.next = head;
	    head.prev = addedNode;
	    head = addedNode;
	} else {
	    head = addedNode;
	    tail = addedNode;
	}
	size++;
    }

    public String toString() {
	String result = "";
	Node<E> iterator = head;
	while (iterator != null) {
	    result = result + iterator.element + "->";
	    iterator = iterator.next;
	}
	result = result + "null";
	return result;
    }

    public int size() {

	return size;
    }

    public void addToTail(E e) {
	Node<E> addedNode = new Node<>();
	addedNode.element = e;

	if (tail != null) {
	    tail.next = addedNode;
	    addedNode.prev = tail;
	    tail = addedNode;

	} else {
	    tail = addedNode;
	    head = addedNode;
	}
	size++;

    }

    public void add(E e, int index) {

	if (index > size)
	    throw new IndexOutOfBoundsException();
	Node<E> node = new Node<>();
	node.element = e;
	if (index == 0) {
	    addToFront(e);
	    return;
	}

	if (index == size) {
	    addToTail(e);
	    return;
	}

	Node<E> iterator = head;
	int i = 0;
	while (i != index) {
	    iterator = iterator.next;
	    i++;
	}

	node.next = iterator;
	node.prev = iterator.prev;
	node.prev.next = node;
	iterator.prev = node;
	size++;
    }

    public E removeFromHead() {
	if (head == null)
	    return null;

	Node<E> temp = head;
	head = head.next;
	if (head != null) {
	    head.prev = null;
	}
	else
	{
	    tail = null;
	}

	temp.prev = null;
	temp.next = null;
	size--;
	return temp.element;
    }

    public E removeFromTail() {

	if(size == 0)
	    return null;
	Node<E> temp = tail;
	tail = tail.prev;
	if (tail != null) {
	    tail.next = null;
	}
	else
	{
	    head = tail;
	}

	temp.prev = null;
	temp.next = null;
	size--;
	return temp.element;
    }

}

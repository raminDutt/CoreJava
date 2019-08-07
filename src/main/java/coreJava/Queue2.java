package coreJava;

import java.util.NoSuchElementException;

public class Queue2<T> {

    private int size = 0;
    private int capacity = 4;
    private Object queue[] = new Object[capacity];
    int front = 0;
    int back = 0;

    public void add(T element) {

	if (size == capacity) {
	    lazyExpand();
	}

	queue[back] = element;
	back = (back + 1) % capacity;
	size++;

    }

    private void lazyExpand() {
	capacity = capacity * 2;
	Object[] temp = new Object[capacity];
	int lastback = back - 1 < 0 ? size - 1 : back - 1;

	if (front < lastback) {
	    System.arraycopy(queue, 0, temp, 0, size);
	} else {
	    System.arraycopy(queue, front, temp, 0, size - front);
	    System.arraycopy(queue, 0, temp, size - front, front);
	}
	queue = temp;
	front = 0;
	back = size;

    }

    public int getSize() {

	return size;
    }

    public int getCapacity() {

	return capacity;
    }

    public String toString() {

	String res = (queue[0] == null) ? "null" : queue[0].toString();
	int i = 1;
	while (i < capacity) {
	    res = res + "," + queue[i];
	    i++;
	}

	return res;

    }

    public String print() {

	String result = "";
	if (size == 0) {
	    return result;
	}
	int it = front;
	result = (queue[it] == null) ? "null" : queue[it].toString();
	int i = 1;
	while (i < size) {

	    it = (it + 1) % capacity;
	    result = result + ","
		    + (queue[it] == null ? "null" : queue[it].toString());
	    i++;
	}
	return result;
    }

    public T remove() {

	if (size == 0) {
	    throw new NoSuchElementException();
	}
	T element = null;
	element = (T) queue[front];
	queue[front] = null;
	front = (front + 1) % capacity;
	size--;
	return element;
    }
}

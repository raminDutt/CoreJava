package coreJava;

import java.util.EmptyStackException;


public class Stack<E> {

    int capacity;
    int head;
    Object[] objects = null;
    E[] es = null;
   
    public Stack()
    {
	head=-1;
	capacity=10;
	objects = new Object[capacity];

    }
    

    
    public Stack(int capacity) {
	head=-1;
	this.capacity=capacity;
	objects = new Object[capacity];
    }
    public int getCapacity() {

	return objects.length;
    }
    public boolean empty() {

	if(head < 0)
	{
	    return true;
	}
	return false;
    }
    public E push(E i) {

	head++;
	objects[head]=i;
	return (E)objects[head];
    }



    public E pop() {

	if(head < 0)
	{
	    throw new EmptyStackException();
	}
	E item = (E)objects[head];
	head--;
	return item;
    }



    public E peek() {
	
	if(head <= -1)
	{
	    throw new EmptyStackException();
	}
	return (E)objects[head];
    }



    public int size() {
	int size = head+1;
	return size;
    }



    public int search(E e) {
	
	int i = 0;
	int size = objects.length;
	
	while(i<size)
	{
	    E e2 = (E)objects[i];
	    if(e.equals(e2))
	    {
		return i;
	    }
	    i++;
	}

	return -1;
    }
	
}

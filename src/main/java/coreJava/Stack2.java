package coreJava;

import java.util.Arrays;

public class Stack2<E> {
    
    int capacity = 10;
    int size = 0;
    Object[] array = new Object[capacity];
    public void push(E element)
    {
	if(size == capacity)
	{
	    increaseCapacity();
	}
	array[size] = element;
	size++;
    }
    
    private void increaseCapacity() {
	capacity = capacity*2;
	array = Arrays.copyOf(array, capacity);
	
    }

    public E pop()
    {
	if(size == 0)
	{
	    return null;
	}
	size--;
	E element = (E)array[size];
	
	
	return element;
    }
    
    public E peek()
    {
	if(size == 0)
	{
	    return null;
	}
	E element = (E)array[size-1];
	return element;
    }
    
    @Override
    public String toString()
    {
	String result = size > 0 ? array[0].toString() : null;
	int i = 1;
	while(i < size)
	{
	    result = result + "," +array[i];
	    i++;
	}
	return result;
    }

    public Integer getSize() {

	return size;
    }

    Integer getCapacity() {

	return capacity;
    }
    

}

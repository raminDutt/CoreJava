package coreJava;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

public class Stack<E> {

	private List<E> stack;
	
	
	public Stack()
	{
		stack = new ArrayList<E>();
		int x=10;
	}
	
	public static <V> Stack<V> getInstance()
	{
		return new Stack<V>();
	}
	
	public void push(E element)
	{
		stack.add(element);
	}
	
	public E pop()
	{
		if(isEmpty())
		{
			return null;
		}
		int index = stack.size()-1;
		E element = stack.remove(index);
		return element;
	}
	
	public boolean isEmpty()
	{
		if(stack.size() == 0)
		{
			return true;
		}
		return false;
	}
	
	
}

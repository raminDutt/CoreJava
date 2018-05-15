package coreJava;

import java.util.Arrays;

import javax.swing.text.rtf.RTFEditorKit;

public class StackObject<E> {
	private E[] stackObject;
	private int size;
	private int index;
	
	public StackObject()
	{
		size=2;
		stackObject = (E[])new Object[size];
	}
	
	public void push(E e)
	{
		if(index==size)
		{
			size=size*2;
			stackObject=Arrays.copyOf(stackObject, size);
		}
		stackObject[index]=e;
		index++;
	}
	
	public boolean isEmpty()
	{
		return index == 0 ?  true: false;
 	}
	
	public E pop()
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			index=index-1;
			E e = stackObject[index];
			stackObject[index] = null;
			return e;
		}
	}
	
	public static void main(String[] args) {
		StackObject<Integer> array = new StackObject();
		int i = 0;
		while (i < 10) {
			array.push(i);
			i++;
		}
		System.out.println("Done");
		 i = 0;
		while (i < 10) {
			System.out.println(array.pop());
			i++;
		}
	}
}

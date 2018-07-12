package coreJava;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class StackArray<E> {
	private E[] stackArray;
	int size;
	int index;

	public StackArray(Class<E> cl, int size) {
		this.size = size;
		index = 0;
		stackArray = (E[]) Array.newInstance(cl, size);

	}

	public void push(E e) {
		if (index == size) {
			expandArray();
			//size = size *2; stackArray = Arrays.copyOf(stackArray, size);
		}
		stackArray[index] = e;
		index++;
	}

	@SuppressWarnings("unchecked")
	private void expandArray() {
		int oldSize = size;
		size = size * 2;
		E[] temp = stackArray;
		stackArray = (E[]) Array
				.newInstance(stackArray[0].getClass(), size);
		int i = 0;
		while (i < oldSize) {

			stackArray[i] = temp[i];
			i++;

		}
		while(i<size)
		{
			stackArray[i]=null;
			i++;
		}
	}
	
	public boolean isEmpty()
	{
		if(index==0)
		{
			return true;
		}
		return false;
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
			E e = stackArray[index];
			stackArray[index] = null;
			return e;
		}
	}
	public static void main(String[] args) {
		StackArray<Integer> array = new StackArray<Integer>(Integer.class, 2);
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

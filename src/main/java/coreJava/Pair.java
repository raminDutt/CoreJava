package coreJava;

import java.util.ArrayList;
import java.util.List;

public class Pair<E extends Comparable<E>> {
	private E x;
	private E y;

	public Pair(E x, E y) {
		this.x = x;
		this.y = y;
	}

	public E getX() {
		return x;
	}

	public E getY() {
		return y;
	}

	public void setX(E x) {
		this.x = x;
	}

	public void setY(E y) {
		this.y = y;
	}

	public E max() {
		return x.compareTo(y) > 0 ? x : y;
	}

	public E min() {
		return x.compareTo(y) <= 0 ? x : y;
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("X = " + x + "\n" + "Y = " + y + "\n");
		return builder.toString();
	}

	public static void main(String[] args) {
		Pair<Integer> one = new Pair<>(10, 20);
		System.out.println(one.max());
		System.out.println(one.min());
		List<Integer> integers = new ArrayList<Integer>();
		int i=0;
		while(i  < 10)
		{
			integers.add(i);
			i++;
		}
		Pair<Integer> pair = Pair.<Integer>firstLast(integers);
		System.out.print(pair);
	}
	
	
	public static <T extends Comparable<T>> Pair<T> firstLast(List<T> a)
	{
		Pair<T> pair = new Pair<>(a.get(0), a.get(a.size()-1));
		return pair;
	}



}

package coreJava;

import java.util.ArrayList;
import java.util.List;

public class Table<K, V> {
	private List<Entry> entries;
	
	public Table()
	{
		entries = new ArrayList<>();
	}
	
	public Table(K k, V v)
	{
		this();
		insert(k, v);
	}
	
	public void insert(K key, V value)
	{
		for(Entry e : entries)
		{
			if(e.key == key)
			{
				e.value=value;
				return;
			}
		}
		Entry entry = new Entry(key,value);
		entries.add(entry);
		
	}
	

	@SuppressWarnings("unchecked")
	public V getValue(K key)
	{
		for(Entry e: entries)
		{
			if(e.key==key)
			{
				return (V)e.value;
			}
		}
		return null;
	}
	
	public void print()
	{
		for(Entry e: entries)
		{
			System.out.println("Key: " + e.key + " " + "Value: " + e.value);
		}
	}
	
	private static class Entry
	{
		private Object key;
		private Object value;
		
		public Entry (Object key, Object value)
		{
			this.key = key;
			this.value = value;
		}
		
	}
	
	public String toString()
	{
		return "Hello from Table";
	}

	public static void main(String[] args)
	{
		Table<Integer, String> table = new Table<>();
		table.insert(10, "Ramin");
		table.insert(11, "Poffy");
		table.insert(10, "Musa");
		table.insert(12, "Isaa");
		table.print();
		System.out.println("Done");
		System.out.println(table.getValue(11));
	}
}

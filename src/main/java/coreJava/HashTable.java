package coreJava;

import java.util.Arrays;
import java.util.Objects;

import coreJava.HashTable.Node;

public class HashTable<K, V> {

    public class Node {
	K key;
	V value;

	@Override
	public String toString() {
	    String res = "[" + key + "," + value + "]";
	    return res;
	}

    }

    private int capacity = 10;
    int size = 0;

    Object[] array = new Object[capacity];

    public boolean put(K k, V v) {
	if (size == capacity) {
	    return false;
	}

	Node node = new Node();
	node.key = k;
	node.value = v;
	int index = getIndex(k);
	int i = index;
	do {
	    Node node2 = (Node) array[i];
	    if (node2 == null) {
		array[i] = node;
		size++;
		return true;
	    }
	    
	    if (node2.key.equals(k)) {
		node2.value = v;
		return true;
	    }
	    i = (i + 1) % capacity;
	} while (i != index);

	return false;
    }

    public int getSize() {

	return size;
    }

    public Object[] getInternalArray() {

	return array;
    }

    int getIndex(K k) {
	
	return Math.abs(k.hashCode()) % capacity;
    }

    public String print() {
	Node node = (Node) array[0];
	String res = array[0] == null ? "null" : "(" + node.key + ","
		+ node.value + ")";
	int i = 1;
	while (i < capacity) {
	    node = (Node) array[i];
	    if (node == null) {
		res = res + "->null";
	    } else {
		res = res + "->" + "(" + node.key + "," + node.value + ")";
	    }
	    i++;
	}
	return res;
    }

    public String toString() {
	String res = "";
	int count = 0;
	int i = 0;
	while (i < capacity) {
	    Node node = (Node) array[i];
	    if (node != null) {
		res = res + node;
		count++;
	    }
	    i++;
	    if (node != null && count != size) {
		res = res + ",";
	    }
	}
	return res;
    }

    public V get(K k) {
	
	int index = getIndex(k);
	int i = index;
	do
	{
	    Node node = (Node)array[i];
	    if(node == null)
	    {
		return null;
	    }

	    if(node.key.equals(k))
	    {
		return node.value;
	    }
	    i = (i+1)%capacity;
	}
	while(i != index);
	return null;
    }
    
    public boolean remove(K k) {
	
	int index = getIndex(k);
	int i = index;
	do
	{
	    Node node = (Node)array[i];
	    if(node != null && node.key.equals(k))
	    {
		array[i]=null;
		size--;
		rehash();
		return true;
	    }
	    i = (i+1)%capacity;
	}
	while(i != index);
	return false;
    }

    private void rehash() 
    {
	 Object[] temp = Arrays.copyOf(array, capacity);
	 array = new Object[capacity];
	 size=0;
	 int i = 0;
	 while(i < capacity)
	 {
	     Node node = (Node)temp[i];
	     if(node != null)
	     {
		 put(node.key, node.value);
	     }
	     
	     i++;
	 }
	
    }

}

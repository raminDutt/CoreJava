package coreJava;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

;

public class HashTable2<K, V> {

    private class Node {
	K key;
	V value;

	public String toString() {
	    String res = "(" + key + "," + value + ")";
	    return res;
	}
    }

    int capacity = 10;
    int size = 0;
    List<Node>[] htable = new LinkedList[capacity];

    public HashTable2() {
	int i = 0;
	while (i < capacity) {
	    htable[i] = new LinkedList<Node>();
	    i++;
	}
    }

    public void put(K key, V value) {
	int index = hashFunction(key);
	Node node = new Node();
	node.key = key;
	node.value = value;
	List<Node> list = htable[index];
	Iterator<Node> iterator = list.iterator();
	boolean found = false;
	while(iterator.hasNext())
	{
	    Node node2 = iterator.next();
	    if(node2.key.equals(key))
	    {
		node2.value=value;
		found = true;
	    }
	    
	}
	if(!found)
	{
	    htable[index].add(node);
	    size++;
	}
	
    }

    int hashFunction(K key) {
	int index = Math.abs(key.hashCode()) % capacity;
	return index;
    }

    public int getSize() {
	return size;
    }

    public String toString() {
	String res = "";
	int i = 0;
	while (i < capacity) {
	    List<Node> linkedList = htable[i];
	    if (linkedList.size() == 0) {
		res = res + "null";
	    } else {
		int j = 0;
		int s = linkedList.size();
		res = res + "[";
		while (j < s) {
		    Node n = linkedList.get(j);
		    res = res + n;
		    j++;
		    if (j != s) {
			res = res + ",";
		    }
		}
		res = res + "]";

	    }
	    i++;
	    if (i != capacity) {
		res = res + "->";
	    }
	}
	return res;
    }

    public String print() {

	String res = "";
	int i = 0;
	int k = 0;
	while (i < capacity) {
	    List<Node> linkedList = htable[i];
	    if (linkedList.size() != 0) {

		int j = 0;
		int s = linkedList.size();
		res = res + "[";
		while (j < s) {
		    Node n = linkedList.get(j);
		    res = res + n;
		    j++;
		    k++;
		    if (j != s) {
			res = res + ",";
		    }
		}
		res = res + "]";
		if (k != size) {
		    res = res + "->";
		}
	    }
	    i++;

	}
	return res;
    }

    public V get(K key) {

	int index = hashFunction(key);
	List<Node> list = htable[index];
	V value = null;
	int i = 0;
	Iterator<Node> iterator = list.iterator();
	
	while (iterator.hasNext()) {

	    Node node = iterator.next();
	    if(node.key.equals(key))
	    {
		value = node.value;
		break;
	    }
	    i++;
	}
	return value;
    }
}

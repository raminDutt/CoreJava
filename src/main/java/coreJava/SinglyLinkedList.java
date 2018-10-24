package coreJava;

public class SinglyLinkedList<T> {
    
    Node head = null;
    int size = 0;
    class Node
    {
	T value = null;
	Node next = null;
    }
    

    
    public void add(T value)
    {
	if(head == null)
	{
	    head = new Node();
	    head.value=value;	    
	}
	else
	{
	    Node temp = head;
	    head = new Node();
	    head.value=value;
	    head.next=temp;
	}
	size++;
		
    }
    
    public void add(T value, int index)
    {
	if(index < 0 || index > size())
	{
	    throw new IndexOutOfBoundsException();
	}
	
	if(index == 0)
	{
	    add(value);
	    return;
	}
	
	Node temp = head;
	int i = 0;
	while(i != index-1)
	{
	    temp = temp.next;
	    i++;
	}
	Node temp2 = new Node();
	temp2.value=value;
	temp2.next = temp.next;
	temp.next = temp2;
	size++;
		
    }
    
    
    
    public int size()
    {
	return size;
    }

    public void remove(int index) {
	
	if(index < 0 || index >= size)
	    throw new IndexOutOfBoundsException();
	
	if(index == 0)
	{
	    remove();
	    return;
	}
	
	Node temp  = head;
	int i = 0;
	while(i < index-1)
	{
	    temp = temp.next;
	    i++;
	}
	

	Node temp2 = temp.next.next;
	temp.next.next = null;
	temp.next = temp2;
	size--;

	
    }

    public void remove() {

	Node temp = head;
	head = temp.next;
	temp.next=null;
	size--;
    }

}

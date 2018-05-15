package coreJava;

public class LinkedList<Type> {
	
	private Node head = null;
	private Node tail = null;
	

	
	public static class Node<Type>
	{
		public Node next;
		public Type object;
		public Node prev;
		
		public Node()
		{
			this(null);
		}
		
		public Node(Type object)
		{
			this.object = object;
		}
	}
	
	public void insert(Type object)
	{
		if(head == null)
		{
			head = new Node(object);
			tail = head;
		}
		else
		{
			head.next = new Node(object);
			head.next.prev = head;
			head = head.next;
		}
	}
	
	public void print()
	{
		Node it = tail;
		while(it != null)
		{
			System.out.print(it.object + " ");
			it = it.next;
		}
	}
	
	
	
	

}

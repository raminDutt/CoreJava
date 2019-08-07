package coreJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class CompositeIterator implements Iterator<Node> {

    Iterator<Node> iterator;
    List<Node> dfs = new ArrayList<>();
    Stack<Iterator<Node>> stack = new Stack<Iterator<Node>>();

    public CompositeIterator(Iterator<Node> iterator) {
	this.iterator = iterator;
	dfs(iterator);
	stack.add(iterator);
    }

    private void dfs(Iterator<Node> it) {
	while(iterator.hasNext())
	{
	    Node node = it.next();
	    dfs.add(node);
	    if(!node.isLeaf())
	    {
		dfs(node.iterator());
	    }
	}
    }

    @Override
    public boolean hasNext() {

	if (stack.isEmpty()) {
	    return false;
	}
	Iterator<Node> it = stack.peek();
	if (it.hasNext()) {
	    return true;
	}

	stack.pop();
	return hasNext();

    }

    @Override
    public Node next() {

	Iterator<Node> it = stack.peek();
	Node node = it.next();
	if (!node.isLeaf()) {
	    Iterator<Node> iterator = node.iterator();
	    stack.push(iterator);
	}

	return node;
    }

}

package coreJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Node {

    List<Node> nodes = new ArrayList<>();
    
    public boolean isLeaf() {
	// TODO Auto-generated method stub
	return false;
    }
        
    public Iterator<Node> iterator()
    {
	return new CompositeIterator(nodes.iterator());
    }

}

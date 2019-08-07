package coreJava;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node root;
    private int ramin = 5;

    private class Node {
	T value;
	Node left;
	Node right;
	int counter = 1;

	public String toString() {
	    String result = value.toString();
	    int i = 1;
	    while (i < counter) {
		result = result + "," + value.toString();
		i++;
	    }
	    return result;
	}
    }

    public void insert(T value) {

	if (root == null) {
	    root = new Node();
	    root.value = value;
	    return;
	}

	Node it = root;
	while (it != null) {
	    if (value.compareTo(it.value) == -1) {

		if (it.left == null) {
		    it.left = new Node();
		    it.left.value = value;
		    it = null;
		} else {
		    it = it.left;
		}

	    } else {
		if (value.compareTo(it.value) == 0) {
		    it.counter++;
		    it = null;
		} else {
		    if (it.right == null) {
			it.right = new Node();
			it.right.value = value;
			it = null;
		    } else {
			it = it.right;
		    }
		}
	    }
	}

    }

    public void insertR(T value) {
	if (root == null) {
	    root = new Node();
	    root.value = value;
	} else {
	    insertR(root, value);
	}
    }

    private void insertR(Node node, T value) {

	if (node.value.compareTo(value) == 0) {
	    node.counter++;
	    return;
	}

	if (node.value.compareTo(value) == -1) {
	    if (node.right == null) {
		node.right = new Node();
		node.right.value = value;
		return;
	    } else {
		insertR(node.right, value);
	    }

	} else {
	    if (node.left == null) {
		node.left = new Node();
		node.left.value = value;
		return;
	    } else {
		insertR(node.left, value);
	    }
	}
    }

    public String print(Node node) {
	String result = "";
	if (node == null) {
	    return result;
	}

	/*
	 * if (node.left == null) result = node.toString(); else { result =
	 * print(node.left) + "," + node; }
	 * 
	 * if (node.right != null) { result = result + "," + print(node.right);
	 * }
	 */

	String lhs_result = print(node.left);
	String rhs_result = print(node.right);
	lhs_result = lhs_result.length() != 0 ? lhs_result + "," : lhs_result;
	rhs_result = rhs_result.length() != 0 ? "," + rhs_result : rhs_result;
	result = lhs_result + node + rhs_result;

	return result;

    }

    public String toString() {
	// return print2(root);
	return root == null ? "" : print(root);
    }

    public String print2(Node node) {
	Node it = root;
	String result = "";
	Deque<Node> deque = new ArrayDeque<>();
	while (it != null) {

	    if (it.left != null) {
		deque.push(it);
		it = it.left;
	    } else {

		result = result.length() == 0 ? it.toString() : result + ","
			+ it;
		// System.out.println(it.value+",");
		if (it.right != null) {
		    it = it.right;
		} else {
		    if (deque.isEmpty()) {
			it = null;

		    } else {

			while (!deque.isEmpty()) {
			    it = deque.pop();
			    result = result.length() == 0 ? it.toString()
				    : result + "," + it;
			    it = it.right;
			    if (it != null) {
				break;
			    }
			}
		    }

		}
	    }

	}
	return result;
    }

    public List<T> sort() {
	List<T> list = new ArrayList<>();
	sort(root, list);

	return list;
    }

    private void sort(BinarySearchTree<T>.Node node, List<T> list) {

	if (node == null) {
	    return;
	}

	sort(node.left, list);
	int i = 0;
	while (i < node.counter) {
	    list.add(node.value);
	    i++;
	}

	sort(node.right, list);

    }

    public void f() {
	Function<Void, Void> function = new Function<Void, Void>() {

	    @Override
	    public Void apply(Void t) {
		BinarySearchTree.this.f2();
		BinarySearchTree.this.ramin = 100;
		BinarySearchTree.this.f2();
		return null;
	    }
	};

	function.apply(null);
    }

    public void f2() {
	System.out.println(ramin);
    }

    public String printInOrder() {
	return root == null ? "" : printInOrder(root);
    }

    private String printInOrder(Node node) {

	if (node == null) {
	    return null;
	}

	String res = node.value.toString();
	String lhs = printInOrder(node.left);
	String rhs = printInOrder(node.right);

	if (lhs != null) {
	    res = lhs + "," + res;
	}

	if (rhs != null) {
	    res = res + "," + rhs;
	}

	return res;
    }

    public String printPreOrder() {

	return printPreOrder(root);
    }

    private String printPreOrder(Node node) {

	if (node == null) {
	    return null;
	}

	String res = node.value.toString();
	String lhs = printPreOrder(node.left);
	String rhs = printPreOrder(node.right);
	if (lhs != null) {
	    res = res + "," + lhs;
	}
	if (rhs != null) {
	    res = res + "," + rhs;
	}
	return res;
    }

    public String printPostOrder() {

	return root == null ? "" : printPostOrder(root);
    }

    private String printPostOrder(Node node) {
	if (node == null) {
	    return null;
	}

	String lhs = printPostOrder(node.left);
	String rhs = printPostOrder(node.right);
	lhs = lhs == null ? "" : lhs + ",";
	rhs = rhs == null ? "" : rhs + ",";
	String res = lhs + rhs + node.value;
	return res;
    }

    public String printLevelOrder() {

	String res = "";
	if (root == null) {
	    return res;
	}
	Deque<Node> deque = new ArrayDeque<>();
	List<T> levelOrder = new ArrayList<>();
	deque.addLast(root);

	while (!deque.isEmpty()) {
	    Node node = deque.removeFirst();
	    levelOrder.add(node.value);
	    if (node.left != null) {
		deque.addLast(node.left);
	    }

	    if (node.right != null) {
		deque.addLast(node.right);
	    }

	}

	res = levelOrder.stream().map(v -> v.toString())
		.collect(Collectors.joining(","));
	return res;

    }

    public Boolean get(T value) {

	Node it = root;
	boolean isFound = false;
	while (it != null) {

	    if (value.compareTo(it.value) == -1) {
		it = it.left;
	    }

	    if (value.compareTo(it.value) == 0) {
		isFound = true;
		break;
	    }
	    if (value.compareTo(it.value) == 1) {
		it = it.right;
	    }
	}
	return isFound;
    }

    public T getMax() {

	T max = null;
	Node it = root;
	while (it != null) {
	    max = it.value;
	    it = it.right;
	}

	return max;
    }

    public T getMin() {

	T min = null;
	Node it = root;
	while (it != null) {
	    min = it.value;
	    it = it.left;
	}

	return min;
    }

    public boolean remove(T value) {

	Node it = root;
	Node parent = root;
	boolean removeStatus = false;
	while (it != null) {
	    if (it.value.compareTo(value) == 0) {
		break;
	    }

	    parent = it;
	    if (it.value.compareTo(value) == -1) {
		it = it.right;
	    } else {
		it = it.left;
	    }
	}

	if (it != null) {
	    // Leaf
	    if (it.left == null && it.right == null) {
		if (parent.left == it) {
		    parent.left = null;
		} else {
		    parent.right = null;
		}
		removeStatus = true;
	    } else if (it.left != null && it.right != null) {

		// 2 childs
		Node temp_parent = it;
		Node temp = it.left;

		while (temp.right != null) {
		    temp_parent = temp;
		    temp = temp.right;
		}

		removeStatus = remove(temp.value);
		it.value = temp.value;

		/*
		 * if (temp_parent.left == temp) { if (temp.left == null) {
		 * temp_parent.left = null; removeStatus = true; } else {
		 * temp_parent.left=temp.left; removeStatus = true; }
		 * 
		 * } else { if(temp.left == null) { temp_parent.right = null;
		 * removeStatus = true; } else { temp_parent.right = temp.left;
		 * removeStatus = true; } }
		 */
	    } else {
		// One child
		if (parent.left == it) {
		    if (it.left != null) {
			parent.left = it.left;
			it.left = null;
			removeStatus = true;
		    } else {
			parent.left = it.right;
			it.right=null;
			removeStatus = true;
		    }

		} else {
		    if (it.left != null) {
			parent.right = it.left;
			it.left=null;
			removeStatus = true;
		    } else {
			parent.right = it.right;
			it.right=null;
			removeStatus = true;
		    }
		}
	    }

	}

	return removeStatus;

    }

    public class Node2<G> {
	G v;
    }

    public void f4() {
	Node2<Integer> node2 = null;
	Node2<Integer>[] array = f3(node2);

    }

    public <Z> Node2<Z>[] f3(Node2<Z>... nodes) {
	return nodes;
    }

    public String preOrder() {

	String result = preOrder(root);
	return result == null ? "" : result;
    }

    private String preOrder(Node node) {
	if (node == null) {
	    return null;
	}
	String lhs = preOrder(node.left);
	if (lhs == null) {
	    lhs = "";
	} else {
	    lhs = "," + lhs;
	}
	String rhs = preOrder(node.right);
	if (rhs == null) {
	    rhs = "";
	} else {
	    rhs = "," + rhs;
	}
	String result = node.value + lhs + rhs;
	return result;
    }

}

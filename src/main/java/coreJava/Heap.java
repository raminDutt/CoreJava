package coreJava;

import java.util.Arrays;

public class Heap<T extends Comparable<T>> {

    int capacity = 4;
    Object[] heap = new Object[capacity];
    int size = 0;

    public T delete() {
	T value = (T) heap[0];
	delete(value);
	return value;
    }

    public boolean delete(T value) {

	int indexValueToDelete = findIndexValue(value);

	if (indexValueToDelete == -1) {
	    return false;
	}

	size--;
	T lastLevelRightMostValue = (T) heap[size];
	heap[size] = null;
	heap[indexValueToDelete] = lastLevelRightMostValue;

	fixHeapAbove(indexValueToDelete);
	//fixHeapBelow(indexValueToDelete);
	fixHeapBelow(indexValueToDelete, size);

	return true;
    }

    public int findIndexValue(T value) {

	int i = 0;
	while (i < size) {
	    if (heap[i].equals(value)) {
		return i;
	    }
	    i++;
	}

	return -1;
    }

    private void fixHeapAbove(int index) {

	int parentIndex = getParentIndex(index);
	T indexValue = (T) heap[index];

	while (true) {
	    if (parentIndex != -1
		    && indexValue.compareTo((T) heap[parentIndex]) == 1) {

		heap[index] = heap[parentIndex];
		index = parentIndex;
		parentIndex = getParentIndex(parentIndex);

	    } else {
		heap[index] = indexValue;
		break;
	    }

	}

    }

    private void fixHeapBelow(int index) {

	T indexValue = (T) heap[index];
	int maxChildIndex = getIndexMaxChild(index, size);

	while (true) {
	    if (maxChildIndex != -1
		    && ((T) heap[maxChildIndex]).compareTo(indexValue) == 1) {
		heap[index] = heap[maxChildIndex];
		index = maxChildIndex;
		maxChildIndex = getIndexMaxChild(maxChildIndex, size);
	    } else {
		heap[index] = indexValue;
		break;
	    }
	}
    }

    private void fixHeapBelow(int index, int length) {

	int maxChildIndex = -1;
	while (true) {
	    maxChildIndex = getIndexMaxChild(index, length);
	    if (maxChildIndex == -1) {
		return;
	    }

	    T value = (T) heap[index];
	    T childValue = (T) heap[maxChildIndex];
	    if (childValue.compareTo(value) == 1) {
		heap[index] = childValue;
		heap[maxChildIndex] = value;
		index = maxChildIndex;
	    } else {
		break;
	    }
	}

    }

    private int getIndexMaxChild(int parent, int size) {
	int firstChildIndex = 2 * parent + 1;
	int secondChildIndex = 2 * parent + 2;

	if (firstChildIndex >= size) {
	    return -1;

	} else {
	    if (secondChildIndex >= size) {
		return firstChildIndex;
	    } else {
		T firstChildValue = (T) heap[firstChildIndex];
		T secondChildValue = (T) heap[secondChildIndex];
		if (firstChildValue.compareTo(secondChildValue) == 1) {
		    return firstChildIndex;
		} else {
		    return secondChildIndex;
		}
	    }
	}

    }

    private int getParentIndex(int index) {
	if (index == 0) {
	    return -1;
	}
	int parentIndex = (index - 1) / 2;
	return parentIndex;
    }

    private void heapify() {

	int childIndex = size;
	boolean flag = true;
	while (flag) {
	    T child = (T) heap[childIndex];
	    int parentIndex = getParentIndex(childIndex);
	    parentIndex = parentIndex == -1 ? 0 : parentIndex;

	    T parent = (T) heap[parentIndex];
	    if (child.compareTo(parent) == 1) {
		heap[parentIndex] = child;
		heap[childIndex] = parent;
		childIndex = parentIndex;
	    } else {
		flag = false;
	    }
	}

    }

    public void insert(T value) {
	if (size >= capacity) {
	    capacity = capacity * 2;
	    heap = Arrays.copyOf(heap, capacity);
	}

	heap[size] = value;
	fixHeapAbove(size);
	// heapify();
	size++;

    }

    public boolean isEmpty() {
	if (size == 0) {
	    return true;
	}

	return false;
    }

    void reverse()
    {
	int i = 0;
	int j = size-1;
	while(i < j)
	{
	    T temp = (T)heap[i];
	    heap[i] = heap[j];
	    heap[j]=temp;
	    i++;
	    j--;
	}
    }
    public void sort() {

	int length = size;
	while (length > 0) {
	    swap(0,length-1);
	    length--;
	    fixHeapBelow(0, length);
	}

    }

    void swap(int index1, int index2)
    {
	T temp = (T)heap[index1];
	heap[index1]=heap[index2];
	heap[index2]=temp;
	
    }
    @Override
    public String toString() {
	String result = "";
	int i = 0;
	while (i < size) {
	    if (i == 0) {
		result = heap[0].toString();
	    } else {
		result = result + "," + heap[i].toString();
	    }
	    i++;
	}

	return result;
    }

    public void sortDesc() {
	
	//Methodolofy 1
	//sort();
	//reverse();
	
	//Methodology 2
	Object[] temp = new Object[size];
	int i = 0;
	while(!isEmpty())
	{
	    temp[i]=delete();
	    i++;
	}
	heap = temp;
	size = temp.length;
    }
    

}

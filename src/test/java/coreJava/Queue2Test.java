package coreJava;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class Queue2Test {

    @Test
    public void addingWithNoResizingNoWrapping() {
	Queue2<Integer> queue = new Queue2<>();
	queue.add(10);
	queue.add(20);
	queue.add(30);
	queue.add(40);

	int expectedSize = 4;
	int actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	int expectedCapacity = 4;
	int actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	String actualQueueRepresentation = queue.toString();
	String expectedQueueRepresentation = "10,20,30,40";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	String actualQueue = queue.print();
	String expectedQueue = "10,20,30,40";
	assertEquals(expectedQueue, actualQueue);

    }

    @Test
    public void removingFromQueueNoResizeNoWrap() {
	Queue2<Integer> queue = new Queue2<>();
	queue.add(10);
	queue.add(20);
	queue.add(30);
	queue.add(40);

	int actualValue = queue.remove();
	int expectedValue = 10;
	assertEquals(expectedValue, actualValue);

	int expectedSize = 3;
	int actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	int expectedCapacity = 4;
	int actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	String actualQueueRepresentation = queue.toString();
	String expectedQueueRepresentation = "null,20,30,40";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	String actualQueue = queue.print();
	String expectedQueue = "20,30,40";
	assertEquals(expectedQueue, actualQueue);

	// Use case 2
	actualValue = queue.remove();
	expectedValue = 20;
	assertEquals(expectedValue, actualValue);

	expectedSize = 2;
	actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	expectedCapacity = 4;
	actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	actualQueueRepresentation = queue.toString();
	expectedQueueRepresentation = "null,null,30,40";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	actualQueue = queue.print();
	expectedQueue = "30,40";
	assertEquals(expectedQueue, actualQueue);

	// Use case 3
	actualValue = queue.remove();
	expectedValue = 30;
	assertEquals(expectedValue, actualValue);

	expectedSize = 1;
	actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	expectedCapacity = 4;
	actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	actualQueueRepresentation = queue.toString();
	expectedQueueRepresentation = "null,null,null,40";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	actualQueue = queue.print();
	expectedQueue = "40";
	assertEquals(expectedQueue, actualQueue);

	// Use case 4
	actualValue = queue.remove();
	expectedValue = 40;
	assertEquals(expectedValue, actualValue);

	expectedSize = 0;
	actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	expectedCapacity = 4;
	actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	actualQueueRepresentation = queue.toString();
	expectedQueueRepresentation = "null,null,null,null";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	actualQueue = queue.print();
	expectedQueue = "";
	assertEquals(expectedQueue, actualQueue);

    }

    @Test
    public void addingWithNoResizingButWrapping() {

	Queue2<Integer> queue = new Queue2<>();
	queue.add(10);
	queue.add(20);
	queue.add(30);
	queue.add(40);
	queue.remove();
	queue.remove();

	queue.add(50);
	int expectedSize = 3;
	int actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	int expectedCapacity = 4;
	int actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	String actualQueueRepresentation = queue.toString();
	String expectedQueueRepresentation = "50,null,30,40";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	String actualQueue = queue.print();
	String expectedQueue = "30,40,50";
	assertEquals(expectedQueue, actualQueue);

	queue.add(60);
	expectedSize = 4;
	actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	expectedCapacity = 4;
	actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	actualQueueRepresentation = queue.toString();
	expectedQueueRepresentation = "50,60,30,40";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	actualQueue = queue.print();
	expectedQueue = "30,40,50,60";
	assertEquals(expectedQueue, actualQueue);

    }

    @Test
    public void removeFromQueueWithNoResizingButWrapping() {

	Queue2<Integer> queue = new Queue2<>();
	queue.add(10);
	queue.add(20);
	queue.add(30);
	queue.add(40);
	queue.remove();
	queue.remove();
	queue.add(50);
	queue.add(60);

	// setup
	int expectedSize = 4;
	int actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	int expectedCapacity = 4;
	int actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	String actualQueueRepresentation = queue.toString();
	String expectedQueueRepresentation = "50,60,30,40";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	String actualQueue = queue.print();
	String expectedQueue = "30,40,50,60";
	assertEquals(expectedQueue, actualQueue);

	// use case 2
	int actualValue = queue.remove();
	int expectedValue = 30;
	assertEquals(expectedValue, actualValue);

	expectedSize = 3;
	actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	expectedCapacity = 4;
	actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	actualQueueRepresentation = queue.toString();
	expectedQueueRepresentation = "50,60,null,40";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	actualQueue = queue.print();
	expectedQueue = "40,50,60";
	assertEquals(expectedQueue, actualQueue);

	// use case 3
	actualValue = queue.remove();
	expectedValue = 40;
	assertEquals(expectedValue, actualValue);

	expectedSize = 2;
	actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	expectedCapacity = 4;
	actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	actualQueueRepresentation = queue.toString();
	expectedQueueRepresentation = "50,60,null,null";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	actualQueue = queue.print();
	expectedQueue = "50,60";
	assertEquals(expectedQueue, actualQueue);

	// use case 4
	actualValue = queue.remove();
	expectedValue = 50;
	assertEquals(expectedValue, actualValue);

	expectedSize = 1;
	actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	expectedCapacity = 4;
	actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	actualQueueRepresentation = queue.toString();
	expectedQueueRepresentation = "null,60,null,null";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	actualQueue = queue.print();
	expectedQueue = "60";
	assertEquals(expectedQueue, actualQueue);

	// use case 5
	actualValue = queue.remove();
	expectedValue = 60;
	assertEquals(expectedValue, actualValue);

	expectedSize = 0;
	actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	expectedCapacity = 4;
	actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	actualQueueRepresentation = queue.toString();
	expectedQueueRepresentation = "null,null,null,null";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	actualQueue = queue.print();
	expectedQueue = "";
	assertEquals(expectedQueue, actualQueue);

    }

    @Test(expected = NoSuchElementException.class)
    public void removingFromEmptyQueue() {
	Queue2<Integer> queue = new Queue2<>();
	queue.remove();
    }

    @Test
    public void addingWithResizingNoWrapping() {
	Queue2<Integer> queue = new Queue2<Integer>();
	queue.add(10);
	queue.add(20);
	queue.add(30);
	queue.add(40);
	queue.add(50);

	int expectedSize = 5;
	int actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	int expectedCapacity = 8;
	int actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	String actualQueueRepresentation = queue.toString();
	String expectedQueueRepresentation = "10,20,30,40,50,null,null,null";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	String actualQueue = queue.print();
	String expectedQueue = "10,20,30,40,50";
	assertEquals(expectedQueue, actualQueue);

    }

    @Test
    public void addTestCase() {
	Queue2<Integer> queue = new Queue2<Integer>();
	queue.add(10);
	queue.add(20);
	queue.add(30);
	queue.add(40);
	queue.remove();
	queue.remove();
	queue.add(50);
	queue.add(60);
	queue.remove();
	queue.remove();
	queue.remove();
	queue.remove();
	queue.add(10);

	int expectedSize = 1;
	int actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	int expectedCapacity = 4;
	int actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	String actualQueueRepresentation = queue.toString();
	String expectedQueueRepresentation = "null,null,10,null";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	String actualQueue = queue.print();
	String expectedQueue = "10";
	assertEquals(expectedQueue, actualQueue);

	int actualValue = queue.remove();
	int expectedValue = 10;
	assertEquals(expectedValue, actualValue);
    }

    @Test
    public void addResizingOnWrapping() {
	Queue2<Integer> queue = new Queue2<Integer>();
	queue.add(10);
	queue.add(20);
	queue.add(30);
	queue.add(40);
	queue.remove();
	queue.remove();
	queue.add(50);
	queue.add(60);
	queue.add(70);

	int expectedSize = 5;
	int actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	int expectedCapacity = 8;
	int actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	String actualQueueRepresentation = queue.toString();
	String expectedQueueRepresentation = "30,40,50,60,70,null,null,null";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	String actualQueue = queue.print();
	String expectedQueue = "30,40,50,60,70";
	assertEquals(expectedQueue, actualQueue);

	// use case 2
	queue.add(80);

	expectedSize = 6;
	actualSize = queue.getSize();
	assertEquals(expectedSize, actualSize);

	expectedCapacity = 8;
	actualCapacity = queue.getCapacity();
	assertEquals(expectedCapacity, actualCapacity);

	actualQueueRepresentation = queue.toString();
	expectedQueueRepresentation = "30,40,50,60,70,80,null,null";
	assertEquals(expectedQueueRepresentation, actualQueueRepresentation);

	actualQueue = queue.print();
	expectedQueue = "30,40,50,60,70,80";
	assertEquals(expectedQueue, actualQueue);

    }

}

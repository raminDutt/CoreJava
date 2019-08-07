package coreJava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Stack2Test {

    @Test
    public void testPush() {

	Stack2<Integer> stack = new Stack2<>();
	stack.push(10);
	stack.push(20);
	stack.push(30);
	stack.push(40);
	String expected = "10,20,30,40";
	String actual = stack.toString();
	assertThat(actual).isEqualTo(expected);
	Integer expectedSize = 4;
	Integer actualSize = stack.getSize();
	assertThat(actualSize).isEqualTo(expectedSize);
    }

    @Test
    public void testPop() {

	Stack2<Integer> stack = new Stack2<>();
	stack.push(10);
	stack.push(20);
	stack.push(30);
	stack.push(40);
	Integer actual = stack.pop();
	Integer expected = 40;
	assertThat(actual).isEqualTo(expected);
	String expectedString = "10,20,30";
	String actualString = stack.toString();
	assertThat(actualString).isEqualTo(expectedString);
	Integer expectedSize = 3;
	Integer actualSize = stack.getSize();
	assertThat(actualSize).isEqualTo(expectedSize);
    }

    @Test
    public void testPopOnEmptyStack() {

	Stack2<Integer> stack = new Stack2<>();

	Integer actual = stack.pop();
	assertThat(actual).isNull();

	String actualString = stack.toString();
	assertThat(actualString).isNull();
	Integer expectedSize = 0;
	Integer actualSize = stack.getSize();
	assertThat(actualSize).isEqualTo(expectedSize);
    }
    
    @Test
    public void testPeek()
    {
	Stack2<Integer> stack = new Stack2<>();
	stack.push(10);
	stack.push(20);
	stack.push(30);
	stack.push(40);
	
	Integer actual = stack.peek();
	Integer expected = 40;
	assertThat(actual).isEqualTo(expected);
	String expectedString = "10,20,30,40";
	String actualString = stack.toString();
	Integer expectedSize = 4;
	Integer actualSize = stack.getSize();
	assertThat(actualSize).isEqualTo(expectedSize);
	
    }
    
    @Test
    public void testPeelOnEmptyStack() {

	Stack2<Integer> stack = new Stack2<>();

	Integer actual = stack.peek();
	assertThat(actual).isNull();

	String actualString = stack.toString();
	assertThat(actualString).isNull();
	Integer expectedSize = 0;
	Integer actualSize = stack.getSize();
	assertThat(actualSize).isEqualTo(expectedSize);
    }
    
    @Test
    public void testCapacityIncrease(){
	Stack2<Integer> stack = new Stack2<>();
	stack.push(10);
	stack.push(20);
	stack.push(30);
	stack.push(40);
	stack.push(50);
	stack.push(60);
	stack.push(70);
	stack.push(80);
	stack.push(90);
	stack.push(100);
	stack.push(110);
	
	String actualString = stack.toString();
	String expectedString = "10,20,30,40,50,60,70,80,90,100,110";
	assertThat(actualString).isEqualTo(expectedString);
	Integer expectedSize = 11;
	Integer actualSize = stack.getSize();
	assertThat(actualSize).isEqualTo(expectedSize);
	
	Integer expectedCapacity = 20;
	Integer actualCapacity = stack.getCapacity();
	assertThat(actualCapacity).isEqualTo(expectedCapacity);
    }

}

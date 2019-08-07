package coreJava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Stack3Test {

    @Test
    public void testPush() {
	Stack3<Integer> stack3 = new Stack3<>();
	stack3.push(10);
	stack3.push(20);
	stack3.push(30);
	stack3.push(40);

	String actual = stack3.toString();
	String expected = "10->20->30->40->NULL";
	assertThat(actual).isEqualTo(expected);

	int actualSize = stack3.getSize();
	int expectedSize = 4;
	assertThat(actualSize).isEqualTo(expectedSize);

    }

    @Test
    public void testPop() {
	Stack3<Integer> stack3 = new Stack3<>();
	stack3.push(10);
	stack3.push(20);
	stack3.push(30);
	stack3.push(40);

	Integer actual = null;
	Integer expected = null;
	String actualString = null;
	String expectedString = null;
	Integer actualSize = null;
	Integer expectedSize = null;
	
	actual = stack3.pop();	
	expected = 40;
	actualString = stack3.toString();
	expectedString = "10->20->30->NULL";
	assertThat(actual).isEqualTo(expected);
	actualSize = stack3.getSize();
	expectedSize = 3;
	assertThat(actualSize).isEqualTo(expectedSize);
	
	actual = stack3.pop();	
	expected = 30;
	actualString = stack3.toString();
	expectedString = "10->20->NULL";
	assertThat(actual).isEqualTo(expected);
	actualSize = stack3.getSize();
	expectedSize = 2;
	assertThat(actualSize).isEqualTo(expectedSize);
	
	actual = stack3.pop();	
	expected = 20;
	actualString = stack3.toString();
	expectedString = "10->NULL";
	assertThat(actual).isEqualTo(expected);
	actualSize = stack3.getSize();
	expectedSize = 1;
	assertThat(actualSize).isEqualTo(expectedSize);
	
	actual = stack3.pop();	
	expected = 10;
	actualString = stack3.toString();
	expectedString = "NULL";
	assertThat(actual).isEqualTo(expected);
	actualSize = stack3.getSize();
	expectedSize = 0;
	assertThat(actualSize).isEqualTo(expectedSize);
	
	actual = stack3.pop();	
	expected = null;
	actualString = stack3.toString();
	expectedString = "NULL";
	assertThat(actual).isNull();
	actualSize = stack3.getSize();
	expectedSize = 0;
	assertThat(actualSize).isEqualTo(expectedSize);

    }
    
    @Test
    public void testPeek()
    {
	Integer actual = null;
	Integer expected = null;
	String actualString = null;
	String expectedString = null;
	Integer actualSize = null;
	Integer expectedSize = null;
	
	Stack3<Integer> stack3 = new Stack3<>();
	actual = stack3.peek();
	assertThat(actual).isNull();
	actualString = stack3.toString();
	expectedString = "NULL";
	actualSize = stack3.getSize();
	expected = 0;
	assertThat(actualSize).isEqualTo(expected);
	
	stack3.push(10);
	stack3.push(20);
	stack3.push(30);
	stack3.push(40);
	actual = stack3.peek();
	expected = 40;
	assertThat(actual).isEqualTo(expected);
	actualString = stack3.toString();
	expectedString = "10->20->30->40->NULL";
	actualSize = stack3.getSize();
	expected = 4;
	assertThat(actualSize).isEqualTo(expected);
	
    }

}

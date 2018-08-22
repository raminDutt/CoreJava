package coreJava;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EmptyStackException;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class StackTest {

    Stack<Integer> stackSUT = new Stack<Integer>();

    @Test
    public void constructorShouldCreateAStackWithInitialCapacity() {
	Assertions.assertThat(stackSUT.getCapacity()).isNotEqualTo(0);
    }

    @Test
    public void constructorShouldCreateStackWithDesiredCapacity() {
	Stack<Integer> stackSUT = new Stack<Integer>(15);
	Assertions.assertThat(stackSUT.getCapacity()).isEqualTo(15);

    }

    @Test
    public void shouldReturnTrueForEmptyStack() {
	Assertions.assertThat(stackSUT.empty()).isEqualTo(true);
    }

    @Test(expected = EmptyStackException.class)
    public void shouleThrowEmptyStackExceptionWhenPoppingEmptyStack() {
	stackSUT.pop();
    }

    @Test
    public void shouldBeAbleToPushItemOnTopOfStack() {
	int item = stackSUT.push(10);
	assertThat(item).isEqualTo(10);
	assertThat(stackSUT.empty()).isEqualTo(false);
    }

    @Test
    public void shouldBeAbleToPpoItemOnTopOfStack() {
	stackSUT.push(10);
	stackSUT.push(15);
	stackSUT.push(20);
	Integer item1 = stackSUT.pop();
	Integer item2 = stackSUT.pop();
	Integer item3 = stackSUT.pop();
	assertThat(item1).isEqualTo(20);
	assertThat(item2).isEqualTo(15);
	assertThat(item3).isEqualTo(10);
    }

    @Test
    public void shouldBeAbleToPeekTopOfStack() {
	stackSUT.push(1);
	stackSUT.push(20);
	stackSUT.push(30);
	stackSUT.push(44);
	int item = stackSUT.peek();
	int size = stackSUT.size();
	assertThat(item).isEqualTo(44);
	assertThat(size).isEqualTo(4);
    }

    @Test(expected = EmptyStackException.class)
    public void shouleThrowEmptyStackExceptionWhenPeekingEmptyStack() {
	
	assertThat(stackSUT.size()).isEqualTo(0);
	stackSUT.peek();
    }

    @Test
    public void shouldReturnCorrectSizeAfterPushing() {
	stackSUT.push(10);
	stackSUT.push(20);
	stackSUT.push(30);
	assertThat(stackSUT.size()).isEqualTo(3);
    }

    @Test
    public void shouldReturnCorrectSizeAfterPoping() {
	stackSUT.push(10);
	stackSUT.push(20);
	stackSUT.push(30);

	stackSUT.pop();
	stackSUT.pop();
	assertThat(stackSUT.size()).isEqualTo(1);

    }

    @Test
    public void shouldReturnZeroSizeForEmptyStack() {
	assertThat(stackSUT.size()).isEqualTo(0);
    }
    
    @Test
    public void shouldReturnIndexOfSearchedItem()
    {
	stackSUT.push(10);
	stackSUT.push(20);
	stackSUT.push(30);
	int index = stackSUT.search(20);
	assertThat(index).isEqualTo(1);
    }

    @Test
    public void shouldReturnNegativeOneForItemsNotFound()
    {
	stackSUT.push(10);
	stackSUT.push(20);
	stackSUT.push(30);
	int index = stackSUT.search(50);
	assertThat(index).isEqualTo(-1);
    }
}

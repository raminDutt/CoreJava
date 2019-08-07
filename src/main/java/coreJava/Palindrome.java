package coreJava;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Palindrome {

    public boolean isPalindrome(String word) {

	BinaryOperator<String> combiner = (String a, String b) -> {
	    return a + b;
	};
	BiFunction<String, Integer, String> accumulator = (String u, Integer t) -> {
	    char c = (char) t.intValue();
	    return u + c;
	};
	word = word.toLowerCase().subSequence(0, word.length()).chars()
		.filter(c -> {

		    if (c >= 97 && c <= 122) {
			return true;
		    }
		    return false;
		}).boxed().reduce("", accumulator, combiner);

	Deque<Character> stack = new LinkedList<>();

	int i = 0;
	while (i < word.length()) {
	    char c = word.charAt(i);
	    Character character = new Character(c);
	    stack.push(character);
	    i++;
	}

	String rev = "";
	try {
	    while (true) {
		rev = rev + stack.pop();
	    }
	} catch (NoSuchElementException ex) {
	    return word.equals(rev);
	}

    }

    public boolean isPalindrome2(String word) {

	word = word.toLowerCase();
	Queue<Character> queue = new LinkedList<>();
	Deque<Character> stack = new LinkedList<>();
	
	int i = 0;
	while (i < word.length()) {
	    char character = word.charAt(i);
	    if (character >= 'a' && character <= 'z') {
		queue.add(character);
		stack.push(character);
	    }
	    i++;
	}
	
	if(queue.size() != stack.size())
	{
	    throw new IllegalStateException();
	}
	
	boolean result = true;
	while(!stack.isEmpty())
	{
	    result = result & queue.remove().equals(stack.pop());
	}
	return result;
    }

}

package coreJava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class PalindromeTest {

    private static final Object[] parametersForIsPalindrome() {
	return new Object[] {
		new Object[] { "abccba", true },
		new Object[] { "Was it a car or a cat I saw?", true },
		new Object[] { "Racecar", true },
		new Object[] { "Don't nod", true },
		new Object[] { "poffy", false },
		new Object[] { "I did, did I", true },
		new Object[] { "hello", false } };
    }

    @Test
    @Parameters
    public void isPalindrome(String word, boolean expected) {
	Palindrome palindrome = new Palindrome();
	boolean actual = palindrome.isPalindrome(word);
	assertThat(actual).isEqualTo(expected);

    }
    
    @Test
    @Parameters(method="parametersForIsPalindrome")
    public void isPalindrome2(String word, boolean expected) {
	Palindrome palindrome = new Palindrome();
	boolean actual = palindrome.isPalindrome2(word);
	assertThat(actual).isEqualTo(expected);
	
    }
    

}

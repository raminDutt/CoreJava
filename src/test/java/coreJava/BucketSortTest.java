package coreJava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;

public class BucketSortTest {


    @Rule 
    public ConcurrentRule concurrentRule = new ConcurrentRule();
    
    @Rule 
    public RepeatingRule repeatingRule = new RepeatingRule();
    
    @Test
    @Concurrent(count=7)
    @Repeating(repetition=100)
    public void testSort()
    {
	Random random = new Random();
	int[] array = random.ints(0, 100).limit(10).toArray();

	int[] actual = BucketSort.sort(array);
	int[] expected = Arrays.copyOf(array, array.length);
	Arrays.sort(expected);
	assertThat(actual).isEqualTo(expected);
	
    }

}

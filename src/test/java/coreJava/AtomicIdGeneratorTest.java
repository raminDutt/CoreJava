package coreJava;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AtomicIdGeneratorTest {

    
    public AtomicIdGeneratorTest()
    {
	System.out.println("Constructor");
    }
    @Rule
    public ConcurrentRule concurrentRule = new ConcurrentRule();

    @Rule
    public RepeatingRule repeatingRule = new RepeatingRule();
    static Set<Integer> hashSet = new CopyOnWriteArraySet<>();
    static Set<Integer> hashSet2 = new CopyOnWriteArraySet<>();

    public static int count = 0;

    @Test
    //@Concurrent(count = 10)
    //@Repeating(repetition = 100)
    public void testIdIsUnique() {

	int nextId = AtomicIdGenerator.nextId();
	
	Assertions
		.assertThat(hashSet.add(nextId))
		.as("Failled to add " + nextId + " The HashSet Content is: "
			+ hashSet).isTrue();

	count++;
    }

    @Test
    public void f() {
	System.out.println(count);
    }
    
    
    @Test
    @Concurrent(count = 10)
    @Repeating(repetition = 100)
    public void testAtomicIdIsUnique()
    {
	int nextId = AtomicIdGenerator.nextAtomicInt();
	
	Assertions
		.assertThat(hashSet2.add(nextId))
		.as("Failled to add " + nextId + " The HashSet Content is: "
			+ hashSet2).isTrue();
    }
    
    @Test
    public void testSize()
    {
	Assertions.assertThat(hashSet2.size()).isEqualTo(1000);
    }

}

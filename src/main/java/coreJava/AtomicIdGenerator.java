package coreJava;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIdGenerator {
    private static int id = 0;
    private static Object lock = new Object();
    
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static int nextId() {
	synchronized (lock) {
	    id++;
	}

	return id;
    }
    
    public static int nextAtomicInt()
    {
	int next = atomicInteger.getAndIncrement();
	return next;
    }

}

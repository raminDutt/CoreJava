package coreJava;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.sleepycat.util.ClassResolver.Stream;

public class Towers {
    private int start;
    private int destination;
    private int pegs;
    private int disk;
    
    Deque<Integer>[] towers;

    public Towers(int pegs, int disk) {
	this.setPegs(pegs);
	this.setDisk(disk);
    }

    protected void init() {
	towers = new ArrayDeque[getPegs()];
	int i = 0;
	while (i < getPegs()) {
	    towers[i] = new ArrayDeque<Integer>();
	    i++;
	}

	Deque deque = IntStream
		.iterate(1, x -> x + 1)
		.limit(getDisk())
		.boxed()
		.collect(
			Collectors
				.toCollection(() -> new ArrayDeque<Integer>()));

	towers[getStart()] = deque;
    }

    public void play(int start, int destination) throws ExecutionException{

	this.setStart(start);
	this.setDestination(destination);
	towers = new ArrayDeque[getPegs()];
	init();

	play(getDisk(), start, destination);
    }

    private void play(int disk, int start, int destination) throws ExecutionException {
	int freePeg = findFreePeg(start, destination);
	if(disk == 0)
	{
	    return;
	}
	play(disk - 1, start, freePeg);
	move(disk, start, destination);
	peek(destination);
	play(disk - 1, freePeg, destination);

    }

    private void move(int disk, int start, int destination) throws ExecutionException{
	int value = towers[start].pop();
	if (value != disk) {
	    throw new ExecutionException(new Throwable(
		    "unexpected Datstructure flaw found. The pop value was "
			    + value + " but " + disk + " was expected"));
	}
	
	towers[destination].push(disk);

    }

    protected int findFreePeg(int st, int dest) {
	Set<Integer> set = IntStream.iterate(0, x -> x + 1).limit(getPegs()).boxed()
		.collect(Collectors.toSet());
	set.remove(st);
	set.remove(dest);
	Integer[] integers = set.toArray(new Integer[set.size()]);
	Random rnd = new Random();
	int free = rnd.nextInt(integers.length);
	return integers[free];
    }

    public String peek(int peg) {
	Deque<Integer> deque = towers[peg];
	System.out.println("Peg ID: " + peg + " ==> " + deque.toString());
	return deque.toString();
    }

    int getStart() {
	return start;
    }

    void setStart(int start) {
	this.start = start;
    }

    int getDestination() {
	return destination;
    }

    void setDestination(int destination) {
	this.destination = destination;
    }

    int getPegs() {
	return pegs;
    }

    void setPegs(int pegs) {
	this.pegs = pegs;
    }

    int getDisk() {
	return disk;
    }

    void setDisk(int disk) {
	this.disk = disk;
    }
}

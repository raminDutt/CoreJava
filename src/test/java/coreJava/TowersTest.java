package coreJava;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutionException;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class TowersTest {

    private Towers towers;
    int pegs;
    int disks;
    int start;
    int destination;

    @Before
    public void setUp() throws Exception {
	pegs = 3;
	disks = 5;
	start = 0;
	destination = 1;

	towers = new Towers(pegs, disks);
	towers.setStart(start);
	towers.setDisk(disks);
	towers.setPegs(pegs);
	towers.setDestination(destination);
	towers.init();
    }

    @Test
    public void testPeek() {

	String diskString = towers.peek(0);
	assertEquals("[1, 2, 3, 4, 5]", diskString);
	assertEquals(0, towers.findFreePeg(1, 2));
    }

    private static final Object[] parametersForTestFindFreePeg() {
	return new Object[] {
		new Object[] { 0, 1, 2 },
		new Object[] { 0, 2, 1 },
		new Object[] { 1, 0, 2 },
		new Object[] { 1, 2, 0 },
		new Object[] { 2, 1, 0 },
		new Object[] { 2, 0, 1 }, };
    }

    @Test
    @Parameters
    public void testFindFreePeg(int start, int destination, int expected) {

	int actual = towers.findFreePeg(start, destination);
	assertEquals(expected, actual);
    }

    @Test
    public void testPlay() {

	try {
	    assertEquals("[1, 2, 3, 4, 5]", towers.peek(start));
	    assertEquals("[]", towers.peek(destination));
	    towers.play(start, destination);
	    assertEquals("[1, 2, 3, 4, 5]", towers.peek(destination));
	    assertEquals("[]", towers.peek(start));
	} catch (ExecutionException e) {
	    e.printStackTrace();
	}

    }

}

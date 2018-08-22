package coreJava;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import coreJava.exceptions.NoSuchItemException;

@RunWith(JUnitParamsRunner.class)
public class FridgeTest {

    private Fridge fridge = null;

    private static final Object[] items() {
	return new Object[] {
		new Object[] { "cheese" },
		new Object[] { "" },
		new Object[] { "!@#$%^&*()_+-=?><|}{" },
		new Object[] { null },
		new Object[] { "123456789" },
		new Object[] { "*/-+" },
		new Object[] { "\n" },
		new Object[] { "\t" },
		new Object[] { "\r" },
		new Object[] { "\f" },
		new Object[] { "\b" },
		new Object[] { "\'" },
		new Object[] { "\"" },
		new Object[] { "\\" },
		new Object[] { "\u0000" } };
    }

    @Before
    public void setUp() throws Exception {
	fridge = new Fridge();
    }

    @Ignore
    @Test
    public void testFridge() {

	fridge.put("cheese");
	assertEquals(true, fridge.contains("cheese"));
	assertEquals(false, fridge.put("cheese"));
	assertEquals(true, fridge.contains("cheese"));
	assertEquals(false, fridge.contains("ham"));
	fridge.put("ham");
	assertEquals(true, fridge.contains("cheese"));
	assertEquals(true, fridge.contains("ham"));
	try {
	    fridge.take("sausage");
	    fail("There was no sausage in the fridge!");
	} catch (NoSuchItemException e) {
	    // ok
	}
    }


    @Test
    @Parameters(method = "items")
    public void shouldBeAbleToAddItems(String item) {
	boolean actual = fridge.put(item);
	assertTrue(actual);
    }

    @Test
    @Parameters(method = "items")
    public void shouldNotAddDuplicateItems(String item) {
	fridge.put(item);
	boolean actual = fridge.put(item);
	assertFalse(actual);
    }

    @Test
    @Parameters(method = "items")
    public void shouldReturnTrueIfFrideAlreadyContainsItem(String item)
    {
	fridge.put(item);
	boolean actual = fridge.contains(item);
	assertTrue(actual);
    }
    
    @Test
    @Parameters(method = "items")
    public void shouldReturnFalseIfFrideDoesNotContainsItem(String item)
    {
	boolean actual = fridge.contains(item);
	assertFalse(actual);
    }
    
    
    @Test
    @Parameters(method = "items")
    public void shouldBeAbleToTakeItemsPresentInFridge(String item) throws NoSuchItemException
    {
	fridge.put(item);
	fridge.take(item); 
	Assertions.assertThat(fridge.contains(item)).isEqualTo(false);
    }
    
    @Test(expected=NoSuchItemException.class)
    @Parameters(method = "items")
    public void shouldThrowExceptionWhenAttemptingToTakeItemNotPresent(String item) throws NoSuchItemException
    {
	fridge.take(item); 
    }
    
    @Ignore
    @Test
    public void testPutTake() throws NoSuchItemException {
	Fridge fridge = new Fridge();
	List<String> food = new ArrayList<String>();
	food.add("yogurt");
	food.add("milk");
	food.add("eggs");
	for (String item : food) {
	    fridge.put(item);
	    assertEquals(true, fridge.contains(item));
	    fridge.take(item);
	    assertEquals(false, fridge.contains(item));
	}
	for (String item : food) {
	    try {
		fridge.take(item);
		fail("there was no " + item + " in the fridge");
	    } catch (NoSuchItemException e) {
		assertEquals(true, e.getMessage().contains(item));
	    }
	}
    }

}

package coreJava;

import java.util.HashMap;
import java.util.Map;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RootTest {

    private static final Object[] getWords() {
	Object[] words = {
		new Object[] { "ramin", "nimar" },
		new Object[] { "poffy", "yffop" },
		new Object[] { "java", "avaj" },
		new Object[] { "San Fransisco", "ocsisnarF naS" },
		new Object[] { "San Jose", "esoJ naS" }, };
	return words;
    }

    // Excercise 3.11.2
    @Test
    @Parameters(method = "getWords")
    public void ch3Q2_Reversed(String word, String reversed) {
	Assert.assertEquals(Root.reverse(word), reversed);
    }

    @Test(expected = NullPointerException.class)
    public void ch3Q2_nullWord() {
	Root.reverse(null);
    }

    private static final Object[] parametersForCh3Q3_PutAndGet() {
	return new Object[] {
		new Object[] { "ramin", 10 },
		new Object[] { "poffy", 15 },
		new Object[] { "java", 100 },
		new Object[] { null, null },
		new Object[] { null, 10 },
		new Object[] { "ramin", 10 },
		new Object[] { "ramin", 15 },
		new Object[] { null, 100 },
		new Object[] { null, 150 },
		new Object[] { null, 10 },
		new Object[] { null, 101 } };
    }

    public Map<String, Integer> map = null;

    @Before
    public void setUp() {
	map = new HashMap<>();
    }

    @Test
    @Parameters
    public void Ch3Q3_PutAndGet(String key, Integer value) {
	map.put(key, value);
	Assert.assertEquals(value, map.get(key));
    }
    
    @Test
    public void Ch3Q3_Clear()
    {
	Object[]  objects = parametersForCh3Q3_PutAndGet();
	for(Object object : objects)
	{
	   Object[] obj = (Object[]) object;
	    map.put((String)obj[0], (Integer)obj[1]);
	}
	
	Assert.assertNotEquals(0,map.size());
	map.clear();
	Assert.assertEquals(0,map.size());
	
    }

}

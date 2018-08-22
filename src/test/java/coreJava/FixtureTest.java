package coreJava;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FixtureTest {

    @BeforeClass
    public static void beforeClass()
    {
	System.out.println("beforeClass");
    }
    
    @AfterClass
    public static void afterClass()
    {
	System.out.println("afterClass");
    }
    
    @Before
    public void beforeTest()
    {
	System.out.println("beforetest");
    }
    
    @After
    public void afterTest()
    {
	System.out.println("afterTest");
    }
    

    
    
    @Test
    public void testMethodA() {
    System.out.println("method A");
    }
    
    @Test
    public void testMethodB() {
    System.out.println("method B");
    }
}

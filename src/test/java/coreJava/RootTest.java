package coreJava;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RootTest {
	
	public RootTest()
	{
		System.out.println("Constructor ...");
	}
	
	@BeforeClass
	public static void beforeClass()
	{
		System.out.println("Before Class ...");
	}
	
	@AfterClass
	public static void afterClass()
	{
		System.out.println("After Class ...");
	}
	
	@Before
	public void before()
	{
		System.out.println("Function Before");
	}
	
	@Test
	public void test1()
	{
		System.out.println("Testing 1  ...");
	}
	
	@Test
	public void test2()
	{
		System.out.println("Testing 2 ...");
	}
	
	@After
	public void after()
	{
		System.out.println("Function After ...");
	}

}

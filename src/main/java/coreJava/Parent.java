package coreJava;

public class Parent {
    public int x = 5;
    public static int y = 0;
    public int z = 15;
    
    public Parent()
    {
	y++;
    }
    
    public void f()
    {
	System.out.println("x = " + x);
    }
    
    public static void g()
    {
	System.out.println("y = " + y);
    }

}

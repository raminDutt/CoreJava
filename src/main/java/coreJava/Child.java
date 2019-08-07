package coreJava;

public class Child extends Parent{
    
   // public int x = 50;
    //public static int y = 100;
    
    public void f()
    {
	//super.x = 5000;
	this.x = 500;
	this.y = 5000;
	System.out.println("x = " + x);
    }
    
    public static void g()
    {
	
	System.out.println("y = " + y);
    }

}

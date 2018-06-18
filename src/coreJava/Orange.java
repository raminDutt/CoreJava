package coreJava;

public class Orange 
{
	int age;
	public static class Inner
	{
		public Inner()
		{
			
		}
		
		public Inner(Orange orange)
		{
			
		}
	}
	
	public class Inner3
	{
/*		public Inner3()
		{
			
		}*/
		
		public Inner3(Orange Orange.this, Orange orange)
		{
			int x = Orange.this.age;
		}
		
		public Inner3(Orange Orange.this)
		{
			int x = Orange.this.age;
		}
		
		public void f()
		{
			int x = Orange.this.age;
		}
	}
}

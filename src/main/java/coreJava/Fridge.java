package coreJava;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.math3.stat.ranking.NaNStrategy;

import coreJava.exceptions.NoSuchItemException;

public class Fridge {

    public String name = null;

    public Fridge()
    {
	
    }
    public Fridge(List<InnerFridge> list)
    {
	    InnerFridge innerFridge = new InnerFridge();
	    list.add(innerFridge);
	    try {
		System.out.println(Thread.currentThread().getName() + ": sleeping...." );
		Thread.sleep(10000);
		name = "Fridge";
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    
    }

    public class InnerFridge {

	String name = "InnerFridge";

	public void changeName() {
	    name = "InnerFridge2";
	    Fridge.this.name = "Fridge2";

	}
	
	public void doSomething()
	{
	    if(Fridge.this.name.equals("Fridge"))
	    {
		
	    }
	}
    }

    private Collection<String> food = new HashSet<String>();

    public boolean put(String item) {
	return food.add(item);
    }

    public boolean contains(String item) {
	return food.contains(item);
    }

    public void take(String item) throws NoSuchItemException {
	boolean result = food.remove(item);
	if (!result) {
	    throw new NoSuchItemException(item + " not found in the fridge");
	}
    }
}

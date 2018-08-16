package runner;

import listener.TimeTestListener;

import org.junit.runner.JUnitCore;

import coreJava.RootTest;

public class Runner {
    public static void main(String ...args)
    {
	JUnitCore core = new JUnitCore();
	core.addListener(new TimeTestListener());
	core.run(RootTest.class);
    }

}

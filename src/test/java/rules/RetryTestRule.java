package rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import annotations.RetryTest;

public class RetryTestRule implements TestRule{

    @Override
    public Statement apply(Statement base, Description description) {
	

	RetryTest retryTest = description.getAnnotation(RetryTest.class);

	Statement result = null;
	Statement forNonAnnotatedRetryTest = new Statement() {
	    
	    @Override
	    public void evaluate() throws Throwable {
		base.evaluate();
		
	    }
	};
	
	Statement forAnnotatedRetryTest = new Statement() {
	    
	    @Override
	    public void evaluate() throws Throwable {
		    int numberOfRetriesRequested = retryTest.retryNb();
		    int numberOfRetries = 0;
		    while(numberOfRetries < numberOfRetriesRequested)
		    {
			try {
			    base.evaluate();
			} catch (Throwable e) {
			    numberOfRetries++;
			    if(numberOfRetries == numberOfRetriesRequested)
			    {
				System.out.println(description.getMethodName() + "execution  : " + numberOfRetries);
				base.evaluate();
			    }
			  
			    System.out.println(description.getMethodName() + "execution  : " + numberOfRetries);
			}	
		    }
		
	    }
	};
	if(retryTest != null)
	{
	    result = forAnnotatedRetryTest;
	}
	else
	{
	    result = forNonAnnotatedRetryTest;
	    //System.out.println("Not running the rule");
	}
	return result;
    }

}

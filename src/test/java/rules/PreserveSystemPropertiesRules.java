package rules;

import java.util.Properties;

import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class PreserveSystemPropertiesRules implements TestRule {

    @Override
    public Statement apply(Statement base, Description description) {
	
	/*System.out.println("base: " + base);
	System.out.println("base.getClass(): " + base.getClass());
	System.out.println("description: " + description);
	System.out.println("description: " + description.getClassName());
	System.out.println("description: " + description.getMethodName());*/
	Statement statement = new Statement() {

	    @Override
	    public void evaluate() throws Throwable {
		Properties properties = (Properties)System.getProperties().clone();
		base.evaluate();
		System.setProperties(properties);
	    }
	};
	return statement;
    }

}

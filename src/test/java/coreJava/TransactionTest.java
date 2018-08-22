package coreJava;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TransactionTest {

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void constructorShouldBuildTransactions() {
	TransactionBuilder transactionBuilder = new TransactionBuilder();
	//Transaction can Immutable
	Transaction transactionSUT = transactionBuilder.withBillingId("A15").withId(10)
		.withMessage("This is a test").withRetryAllowed(false)
		.withState(new State(State.Case.CANCELLED)).build();
	
	//Transaction CANNOT be Immutable
	Transaction transaction = new Transaction();
	transaction.setBillingId("B10");
	transaction.setId(25);
	transaction.setMessage("Another Test");
	transaction.setRetryAllowed(true);
	transaction.setState(new State(State.Case.ERROR));
    }

}

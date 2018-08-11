package coreJava;

import java.util.Calendar;

public class Hello {
    private TimeProvider timeProvider;

    public Hello(TimeProvider timeProvider) {
	this.timeProvider = timeProvider;
    }

    public String sayHello() {

	
	if (timeProvider.isItMorning()) {
	    return "Good Morning!";
	} else {
	    return "Good Afternoon!";
	}
    }

}

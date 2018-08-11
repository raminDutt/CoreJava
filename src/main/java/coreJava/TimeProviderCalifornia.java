package coreJava;

import java.util.Calendar;

public class TimeProviderCalifornia implements TimeProvider {

    @Override
    public Calendar getTime() {
	Calendar current = Calendar.getInstance();
	return current;
    }

    @Override
    public boolean isItMorning() {
	
	Calendar current = getTime();
	int hour = current.get(Calendar.HOUR_OF_DAY);
	if(hour < 12)
	{
	    return true;
	}
	return false;
    }

}

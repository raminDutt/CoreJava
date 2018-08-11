package coreJava;

import java.util.Calendar;

public class HelpDesk {
    public final static int EOB_HOUR = 17;
    private Calendar cal = Calendar.getInstance();



    public boolean willHandleIssue(Issue issue) {
	int dayOfWeek = getCal().get(Calendar.DAY_OF_WEEK);
	if (Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek) {
	    return false;
	}
	if (Calendar.FRIDAY == dayOfWeek) {
	    int hour = getCal().get(Calendar.HOUR_OF_DAY);
	    if (hour > EOB_HOUR) {
		return false;
	    }
	}
	return true;
    }


    protected Calendar getCal() {
	return cal;
    }



    protected void setCal(Calendar cal) {
	this.cal = cal;
    }
}

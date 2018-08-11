package coreJava;

import java.util.Calendar;

public interface TimeProvider {

    Calendar getTime();
    boolean isItMorning();

}

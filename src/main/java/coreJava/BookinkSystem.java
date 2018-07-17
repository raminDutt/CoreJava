package coreJava;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookinkSystem {

    List<LocalTime> localTimes = new ArrayList<>();

    public boolean book(LocalTime bookingTime) {

	if (bookingTime.getMinute() != 0) {
	    System.out
		    .println("BookinkSystem Message: The booking "
			    + bookingTime
			    + " was unsuccesful, you can only book regular whole hours. Please modify your booking time selection.");
	    return false;
	}

	boolean isBookingTimeAvailable = localTimes.stream().anyMatch(
		bookedAppoitment -> bookedAppoitment.equals(bookingTime));
	if (isBookingTimeAvailable) {
	    System.out
		    .println("BookinkSystem Message: Unable to book "
			    + bookingTime
			    + ". That time slot is not available. Please choose a different booking time");
	    return false;
	}
	localTimes.add(bookingTime);
	System.out.println("BookinkSystem Message: The times slot "
		+ bookingTime + " has been booked.");
	return true;
    }

    public String getBookedHours() {

	String bookedHours = localTimes.stream()
		.map(bookedTime -> Integer.toString(bookedTime.getHour())).sorted()
		.collect(Collectors.joining(","));
	return bookedHours;
    }
}

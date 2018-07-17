package coreJava;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.time.ZonedDateTime;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class BookinkSystemTest {

    BookinkSystem bookingSysten;

    @Before
    public void setUp() throws Exception {
	bookingSysten = new BookinkSystem();
    }

    @Test
    @Parameters
    public void testBookingWithValidTime(LocalTime localTime) {

	boolean bookingStatus = bookingSysten.book(localTime);
	assertEquals(true, bookingStatus);

    }

    private Object[] parametersForTestBookingWithValidTime() {
	return new Object[] {
		LocalTime.of(6, 0),
		LocalTime.of(0, 0),
		LocalTime.of(23, 0) };
    }

    @Test
    @Parameters
    public void testBookingWithInvalidTime(LocalTime localTime) {

	boolean bookingStatus = bookingSysten.book(localTime);
	assertEquals(false, bookingStatus);

    }

    private Object[] parametersForTestBookingWithInvalidTime() {
	return new Object[] {
		LocalTime.of(6, 30),
		LocalTime.of(0, 1),
		LocalTime.of(23, 59) };
    }

    @Test
    public void testDoubleBookingRejection() {
	LocalTime firstBooking = LocalTime.of(15, 0);
	LocalTime secondBooking = LocalTime.of(16, 0);
	LocalTime thirdBooking = LocalTime.of(15, 0);
	LocalTime fourthBooking = LocalTime.of(17, 0);
	bookingSysten.book(firstBooking);
	bookingSysten.book(secondBooking);
	boolean thirdBookingStatus = bookingSysten.book(thirdBooking);
	bookingSysten.book(fourthBooking);
	assertEquals(false, thirdBookingStatus);
    }

    @Test
    public void testBookingAfterDoubleBookingRejection() {
	LocalTime firstBooking = LocalTime.of(15, 0);
	LocalTime secondBooking = LocalTime.of(16, 0);
	LocalTime thirdBooking = LocalTime.of(15, 0);
	LocalTime fourthBooking = LocalTime.of(17, 0);
	bookingSysten.book(firstBooking);
	bookingSysten.book(secondBooking);
	bookingSysten.book(thirdBooking);
	boolean fourthBookingStatus = bookingSysten.book(fourthBooking);
	assertEquals(true, fourthBookingStatus);
    }

    private static final Object[] parametersForTestGetBookedHours() {
	return new Object[] {
		new Object[] {
			new LocalTime[] {
				LocalTime.of(15, 0),
				LocalTime.of(16, 0) },
			"15,16" },
		new Object[] {
			new LocalTime[] {
				LocalTime.of(15, 0),
				LocalTime.of(16, 0),
				LocalTime.of(17, 0) },
			"15,16,17" },
		new Object[] {
			new LocalTime[] {
				LocalTime.of(15, 0),
				LocalTime.of(14, 0),
				LocalTime.of(13, 0),
				LocalTime.of(23, 0),
				LocalTime.of(0, 0),
				LocalTime.of(16, 0) },
			"0,13,14,15,16,23" },

	};
    }

    @Test
    @Parameters
    public void testGetBookedHours(LocalTime[] bookedTimes, String expected) {

	for (LocalTime bookedTime : bookedTimes) {
	    bookingSysten.book(bookedTime);
	}

	String bookedHours = bookingSysten.getBookedHours();
	assertEquals(expected, bookedHours);

    }

}

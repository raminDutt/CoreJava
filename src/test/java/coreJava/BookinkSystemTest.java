package coreJava;

import static org.junit.Assert.*;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.bytebuddy.implementation.bytecode.Duplication;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.verification.VerificationMode;

import coreJava.BookinkSystem.AbstractBooking;
import coreJava.BookinkSystem.BookinCalendar;
import coreJava.BookinkSystem.RecurringAppointment;
import coreJava.BookinkSystem.Classroom;
import coreJava.BookinkSystem.Equipment;
import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class BookinkSystemTest {

    private static final Object[] parametersForTestEqualityOfRecurringAppointment() {
	return new Object[] {
		new Object[] {
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(1), "UnitTesting", null),
			true },
		new Object[] {
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.SATURDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(1), "UnitTesting", null),
			false },
		new Object[] {
			new RecurringAppointment(DayOfWeek.SATURDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.SATURDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			true },
		new Object[] {
			new RecurringAppointment(DayOfWeek.SATURDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.SATURDAY,
				LocalTime.of(12, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			false },
		new Object[] {
			new RecurringAppointment(DayOfWeek.SATURDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(1), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.SATURDAY,
				LocalTime.of(12, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			false } };
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

    private static final Object[] parametersForTestListAvaialbleClassRoomsforGivenDayAndHour() {
	Classroom classroom = mock(Classroom.class);
	return new Object[] {
		new Object[] {
			new RecurringAppointment[] {
				new RecurringAppointment(DayOfWeek.FRIDAY,
					LocalTime.of(8, 0), classroom,
					Duration.ofHours(1), "UnitTesting",
					null),
				new RecurringAppointment(DayOfWeek.FRIDAY,
					LocalTime.of(8, 0), classroom,
					Duration.ofHours(1), "UnitTesting",
					null),
				new RecurringAppointment(DayOfWeek.FRIDAY,
					LocalTime.of(8, 0), classroom,
					Duration.ofHours(1), "UnitTesting",
					null) },
			new boolean[] { true, true, true } },
		new Object[] {
			new RecurringAppointment[] {
				new RecurringAppointment(DayOfWeek.MONDAY,
					LocalTime.of(8, 0), classroom,
					Duration.ofHours(1), "UnitTesting",
					null),
				new RecurringAppointment(DayOfWeek.MONDAY,
					LocalTime.of(8, 0), classroom,
					Duration.ofHours(1), "UnitTesting",
					null),
				new RecurringAppointment(DayOfWeek.MONDAY,
					LocalTime.of(8, 0), classroom,
					Duration.ofHours(1), "UnitTesting",
					null) },
			new boolean[] { false, false, false } },
		new Object[] {
			new RecurringAppointment[] {
				new RecurringAppointment(DayOfWeek.FRIDAY,
					LocalTime.of(8, 0), classroom,
					Duration.ofHours(1), "UnitTesting",
					null),
				new RecurringAppointment(DayOfWeek.FRIDAY,
					LocalTime.of(9, 0), classroom,
					Duration.ofHours(1), "UnitTesting",
					null),
				new RecurringAppointment(DayOfWeek.FRIDAY,
					LocalTime.of(10, 0), classroom,
					Duration.ofHours(1), "UnitTesting",
					null) },
			new boolean[] { true, false, false } } };

    }

    private static final Object[] parametersForTestNaturalOrderingOfRecurringAppointment() {
	Predicate<Integer> positive = (Integer t) -> {
	    if (t.intValue() > 0)
		return true;
	    return false;
	};

	Predicate<Integer> negative = (Integer t) -> {
	    if (t.intValue() < 0)
		return true;
	    return false;
	};

	Predicate<Integer> zero = (Integer t) -> {
	    if (t.intValue() == 0)
		return true;
	    return false;
	};

	return new Object[] {
		new Object[] {
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(8, 0), new Classroom("A1", 20),
				Duration.ofHours(1), "UnitTesting", null),
			positive },
		new Object[] {
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(8, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			positive },
		new Object[] {
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			zero },
		new Object[] {
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(8, 0), new Classroom("A1", 20),
				Duration.ofHours(1), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			negative },
		new Object[] {
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(8, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			negative },
		new Object[] {
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(3), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(11, 0), new Classroom("A1", 20),
				Duration.ofHours(1), "UnitTesting", null),
			zero },
		new Object[] {
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(3), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(11, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			zero },
		new Object[] {
			new RecurringAppointment(DayOfWeek.MONDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(3), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(11, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			negative },
		new Object[] {
			new RecurringAppointment(DayOfWeek.SATURDAY,
				LocalTime.of(10, 0), new Classroom("A1", 20),
				Duration.ofHours(3), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.MONDAY,
				LocalTime.of(11, 0), new Classroom("A1", 20),
				Duration.ofHours(2), "UnitTesting", null),
			positive } };

    }

    BookinkSystem bookingSystem;

    private final Object[] parametersForTestBookingOfDifferentClassRoomWithRecurringAppointments() {
	Classroom classroom = mock(Classroom.class);

	return new Object[] {
		new Object[] { new RecurringAppointment[] {
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(8, 0), classroom,
				Duration.ofHours(2), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(8, 0), classroom,
				Duration.ofHours(1), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(8, 0), classroom,
				Duration.ofHours(1), "UnitTesting", null) } },
		new Object[] { new RecurringAppointment[] {
			new RecurringAppointment(DayOfWeek.MONDAY,
				LocalTime.of(8, 0), classroom,
				Duration.ofHours(2), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.TUESDAY,
				LocalTime.of(8, 0), classroom,
				Duration.ofHours(1), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.WEDNESDAY,
				LocalTime.of(8, 0), classroom,
				Duration.ofHours(1), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.THURSDAY,
				LocalTime.of(8, 0), classroom,
				Duration.ofHours(1), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.FRIDAY,
				LocalTime.of(8, 0), classroom,
				Duration.ofHours(1), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.SATURDAY,
				LocalTime.of(8, 0), classroom,
				Duration.ofHours(1), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.SUNDAY,
				LocalTime.of(8, 0), classroom,
				Duration.ofHours(1), "UnitTesting", null),
			new RecurringAppointment(DayOfWeek.MONDAY,
				LocalTime.of(8, 0), classroom,
				Duration.ofHours(1), "UnitTesting", null) } } };

    }

    private final Object[] parametersForTestBookingOfSameClassRoomWithRecurringAppointments() {
	Classroom classroom = mock(Classroom.class);

	return new Object[] {
		new Object[] {
			new RecurringAppointment[] {
				new RecurringAppointment(DayOfWeek.FRIDAY,
					LocalTime.of(8, 0), classroom,
					Duration.ofHours(2), "UnitTesting",
					null),
				new RecurringAppointment(DayOfWeek.FRIDAY,
					LocalTime.of(10, 30), classroom,
					Duration.ofHours(1), "UnitTesting",
					null),
				new RecurringAppointment(DayOfWeek.FRIDAY,
					LocalTime.of(12, 30), classroom,
					Duration.ofHours(1), "UnitTesting",
					null) },
			new boolean[] { true, true, true } },
		new Object[] {
			new RecurringAppointment[] {
				new RecurringAppointment(DayOfWeek.FRIDAY,
					LocalTime.of(8, 0), classroom,
					Duration.ofHours(2), "UnitTesting",
					null),
				new RecurringAppointment(DayOfWeek.FRIDAY,
					LocalTime.of(8, 30), classroom,
					Duration.ofHours(1), "UnitTesting",
					null),
				new RecurringAppointment(DayOfWeek.FRIDAY,
					LocalTime.of(10, 30), classroom,
					Duration.ofHours(1), "UnitTesting",
					null),
				new RecurringAppointment(DayOfWeek.FRIDAY,
					LocalTime.of(10, 45), classroom,
					Duration.ofMinutes(15), "UnitTesting",
					null) },
			new boolean[] { true, false, true, false } } };

    }

    private Object[] parametersForTestBookingWithInvalidTime() {
	return new Object[] {
		LocalTime.of(6, 30),
		LocalTime.of(0, 1),
		LocalTime.of(23, 59) };
    }

    private Object[] parametersForTestBookingWithValidTime() {
	return new Object[] {
		LocalTime.of(6, 0),
		LocalTime.of(0, 0),
		LocalTime.of(23, 0) };
    }

    @Before
    public void setUp() throws Exception {
	bookingSystem = new BookinkSystem();
    }

    @Test
    public void testAllExistingClassroomsAreUnique() {
	List<String> classrooms = bookingSystem.getClassroomsId();
	assertNotNull(classrooms);
	Set<String> set = new HashSet<String>();
	for (String classroom : classrooms) {
	    assertEquals(classrooms + " Duplicate Id: " + classroom, true,
		    set.add(classroom));
	}
    }

    @Test
    public void testBookingAfterDoubleBookingRejection() {
	LocalTime firstBooking = LocalTime.of(15, 0);
	LocalTime secondBooking = LocalTime.of(16, 0);
	LocalTime thirdBooking = LocalTime.of(15, 0);
	LocalTime fourthBooking = LocalTime.of(17, 0);
	bookingSystem.book(firstBooking);
	bookingSystem.book(secondBooking);
	bookingSystem.book(thirdBooking);
	boolean fourthBookingStatus = bookingSystem.book(fourthBooking);
	assertEquals(true, fourthBookingStatus);
    }

    @Test
    public void testBookingCalendar() {

	Map<Integer, AbstractBooking> allBookings = bookingSystem.getBookings();
	assertEquals(allBookings.size(), 0);
	Equipment equipments = Equipment.MICROPHONE;

	String classroomId = bookingSystem.getClassroomsId().get(0);
	DayOfWeek dayOfWeek = DayOfWeek.SUNDAY;
	int hour = 10;
	int minute = 15;
	Duration duration = Duration.ofMinutes(45);
	boolean isPeriodic = true;

	bookingSystem.book(classroomId, dayOfWeek, hour, minute, duration,
		isPeriodic, equipments);
	assertEquals(allBookings.size(), 1);
	AbstractBooking abstractBooking = null;
	Collection<AbstractBooking> bookings = allBookings.values();
	for (AbstractBooking booking : bookings) {
	    assertEquals(classroomId, booking.getClassroom().getClassroomId());
	    assertEquals(hour, booking.getStartTime().getHour());
	    assertEquals(dayOfWeek, booking.getDayOfWeek());
	    assertEquals(duration, booking.getDuration());
	    abstractBooking = booking;

	}

	Set<AbstractBooking> bookingInCalendar = bookingSystem.getClassrooms()
		.get(classroomId).getBookingCalendar()
		.getRecurringAppointments().get(dayOfWeek);

	assertEquals(1, bookingInCalendar.size());
	assertEquals(true, bookingInCalendar.contains(abstractBooking));
    }

    @Test
    public void testBookingClassRoomById() {
	List<String> classrooms = bookingSystem.getClassroomsId();

	String classroom1 = classrooms.get(0);
	String classroom2 = classrooms.get(1);
	String classroom3 = classrooms.get(2);

	int hour = 10;
	int minute = 0;
	DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
	boolean periodic = true;
	Integer bookingId_1 = bookingSystem.book(classroom1, dayOfWeek, hour,
		minute, periodic);
	Integer bookingId_2 = bookingSystem.book(classroom2, dayOfWeek, hour,
		0, periodic);
	Integer bookingId_3 = bookingSystem.book(classroom3, dayOfWeek, hour,
		minute, periodic);
	assertNotNull(bookingId_1);
	assertNotNull(bookingId_2);
	assertNotNull(bookingId_3);

	Map<Integer, AbstractBooking> allBookings = bookingSystem.getBookings();
	assertEquals(3, allBookings.size());

	Predicate<Classroom> isClassroomBooked = (Classroom classroom) -> {
	    String id = classroom.getClassroomId();
	    if (id.equals(classroom1))
		return true;
	    if (id.equals(classroom2))
		return true;
	    if (id.equals(classroom3))
		return true;
	    return false;
	};
	List<AbstractBooking> bookings = new ArrayList<BookinkSystem.AbstractBooking>();
	TreeSet<AbstractBooking> treeSet1 = bookingSystem.getClassrooms()
		.get(classroom1).getBookingCalendar()
		.getRecurringAppointments().get(dayOfWeek);
	TreeSet<AbstractBooking> treeSet2 = bookingSystem.getClassrooms()
		.get(classroom2).getBookingCalendar()
		.getRecurringAppointments().get(dayOfWeek);
	TreeSet<AbstractBooking> treeSet3 = bookingSystem.getClassrooms()
		.get(classroom3).getBookingCalendar()
		.getRecurringAppointments().get(dayOfWeek);

	assertEquals(1, treeSet1.size());
	assertEquals(1, treeSet2.size());
	assertEquals(1, treeSet3.size());
	bookings.add(treeSet1.iterator().next());
	bookings.add(treeSet2.iterator().next());
	bookings.add(treeSet3.iterator().next());

	for (AbstractBooking booking : bookings) {
	    assertEquals(dayOfWeek, booking.getDayOfWeek());
	    assertEquals(hour, booking.getStartTime().getHour());
	    assertEquals(true, isClassroomBooked.test(booking.getClassroom()));
	}

    }

    @Ignore
    @Test
    public void testBookingConstructorWithZonedDateTimeParam() {
	// TODO: Update Test
	/*-
	Classroom classroom = new Classroom("A1", 20);
	int hour = 14;
	DayOfWeek dayOfWeek = DayOfWeek.THURSDAY;
	ZonedDateTime zonedDateTime = ZonedDateTime.of(2018,
		Month.JULY.getValue(), 26, 14, 0, 0, 0, ZoneId.systemDefault());

	BookinkSystem.Booking booking = new Booking(zonedDateTime, classroom,
		false);
	assertEquals(hour, booking.getLocalTime().getHour());
	assertEquals(dayOfWeek, booking.getDayOfWeek());
	 */

	fail();
    }

    @Test
    public void testBookingOfClassRoomWithNoEquipments() {
	String classroomId = bookingSystem.getClassroomsId().get(0);
	Integer bookingId_1 = bookingSystem.book(classroomId, DayOfWeek.MONDAY,
		10, 0, true);
	assertNotNull(bookingId_1);
    }

    @Test
    @Parameters
    public void testBookingOfDifferentClassRoomWithRecurringAppointments(
	    RecurringAppointment[] bookings) {

	List<String> classroomsId = bookingSystem.getClassroomsId();
	// booking different classrooms
	int index = 0;
	for (AbstractBooking booking : bookings) {
	    Integer bookingId_1 = bookingSystem.book(classroomsId.get(index),
		    booking.getDayOfWeek(), booking.getStartTime().getHour(),
		    booking.getStartTime().getMinute(), booking.getDuration(),
		    true);
	    assertNotNull(bookingId_1);
	    index++;
	}

    }

    @Test(expected = NullPointerException.class)
    public void testBookingOfNonExistinClassroom() {
	Integer bookingId_1 = bookingSystem.book("E1", DayOfWeek.MONDAY, 10, 0,
		true, Equipment.PROJECTOR);
	assertNull(bookingId_1);
    }

    @Test
    @Parameters
    public void testBookingOfSameClassRoomWithRecurringAppointments(
	    RecurringAppointment[] bookings, boolean[] expected) {

	List<String> classroomsId = bookingSystem.getClassroomsId();

	int index = 0;
	for (AbstractBooking booking : bookings) {
	    Integer bookingId_1 = bookingSystem.book(classroomsId.get(0),
		    booking.getDayOfWeek(), booking.getStartTime().getHour(),
		    booking.getStartTime().getMinute(), booking.getDuration(),
		    true);
	    if (expected[index]) {
		assertNotNull(bookingId_1);
	    } else {
		assertNull(bookingId_1);
	    }

	    index++;
	}

    }

    @Test
    @Parameters
    public void testBookingWithInvalidTime(LocalTime localTime) {

	boolean bookingStatus = bookingSystem.book(localTime);
	assertEquals(false, bookingStatus);

    }

    @Test
    @Parameters
    public void testBookingWithValidTime(LocalTime localTime) {

	boolean bookingStatus = bookingSystem.book(localTime);
	assertEquals(true, bookingStatus);

    }

    @Test
    public void testClassroomIdName() {
	List<String> classrooms = bookingSystem.getClassroomsId();
	String regex = "[A-C][0-9]|[A-C][1-4][0-9]";
	for (String classroom : classrooms) {
	    assertNotNull(classroom);
	    assertEquals("Id: " + classroom
		    + " did not match the expected regex: " + regex, true,
		    Pattern.matches(regex, classroom));
	}
    }

    @Test
    public void testDoubleBookingRejection() {
	LocalTime firstBooking = LocalTime.of(15, 0);
	LocalTime secondBooking = LocalTime.of(16, 0);
	LocalTime thirdBooking = LocalTime.of(15, 0);
	LocalTime fourthBooking = LocalTime.of(17, 0);
	bookingSystem.book(firstBooking);
	bookingSystem.book(secondBooking);
	boolean thirdBookingStatus = bookingSystem.book(thirdBooking);
	bookingSystem.book(fourthBooking);
	assertEquals(false, thirdBookingStatus);
    }

    @Test
    public void testEqualityOfClassRoom() {
	BookinkSystem.Classroom classroom1 = new BookinkSystem.Classroom("A1",
		10);
	BookinkSystem.Classroom classroom2 = new BookinkSystem.Classroom("A1",
		10);
	assertEquals(true, classroom1.equals(classroom2));
	assertEquals(true, classroom2.equals(classroom1));

    }

    @Test
    @Parameters
    public void testEqualityOfRecurringAppointment(AbstractBooking booking1,
	    AbstractBooking booking2, boolean expected) {

	assertEquals(true, booking1.equals(booking1));
	assertEquals(expected, booking1.equals(booking2));
	assertEquals(expected, booking2.equals(booking1));
    }

    @Test
    @Parameters
    public void testGetBookedHours(LocalTime[] bookedTimes, String expected) {

	for (LocalTime bookedTime : bookedTimes) {
	    bookingSystem.book(bookedTime);
	}

	String bookedHours = bookingSystem.getBookedHours();
	assertEquals(expected, bookedHours);

    }

    @Test
    public void testInitOfBookingCalendars() {

	Set<String> expectedClassrooms = bookingSystem.getClassrooms().keySet();
	Set<String> expectedClassrooms2 = new HashSet<>(
		bookingSystem.getClassroomsId());
	assertEquals(expectedClassrooms, expectedClassrooms2);

	HashSet<DayOfWeek> dayOfWeek = new HashSet<DayOfWeek>(
		Arrays.asList(DayOfWeek.values()));
	assertEquals(
		true,
		bookingSystem
			.getClassrooms()
			.entrySet()
			.stream()
			.allMatch(
				entry -> entry.getValue().getBookingCalendar() != null));

	assertEquals(
		true,
		bookingSystem
			.getClassrooms()
			.entrySet()
			.stream()
			.allMatch(
				entry -> entry.getValue().getBookingCalendar()
					.getRecurringAppointments().keySet()
					.equals(dayOfWeek)));

	assertEquals(
		true,
		bookingSystem
			.getClassrooms()
			.entrySet()
			.stream()
			.allMatch(
				entry -> entry.getValue().getBookingCalendar()
					.getRecurringAppointments().values() != null));
    }

    @Test
    public void testInitOfRecurringAppointmentsInCalendar() {
	BookinCalendar calendar = new BookinCalendar();
	Map<DayOfWeek, TreeSet<AbstractBooking>> recurringAppointments = calendar
		.getRecurringAppointments();

	assertEquals(new HashSet<DayOfWeek>(Arrays.asList(DayOfWeek.values())),
		recurringAppointments.keySet());
	assertEquals(
		true,
		recurringAppointments.values().stream()
			.allMatch(map -> map != null));

    }

    @Test
    public void testInteractionOfBookingClassroomById() {

	Map<Integer, AbstractBooking> allBookingsMock = mock(Map.class);
	Map<String, Classroom> classroomsMapMock = mock(Map.class);
	Classroom classroomMock = mock(Classroom.class);

	BookinkSystem bookinkSystemSpy = spy(bookingSystem);
	when(bookinkSystemSpy.getBookings()).thenReturn(allBookingsMock);
	when(bookinkSystemSpy.getClassrooms()).thenReturn(classroomsMapMock);
	when(classroomsMapMock.get(anyString())).thenReturn(classroomMock);
	when(classroomMock.isAvailable(any())).thenReturn(true);

	int hour = 10;
	int minute = 0;
	DayOfWeek dayOfWeek = DayOfWeek.MONDAY;

	String classroom1 = "unit_Test_classroom1";
	String classroom2 = "unit_Test_classroom2";
	String classroom3 = "unit_Test_classroom3";

	bookinkSystemSpy.book(classroom1, dayOfWeek, hour, minute, true);
	bookinkSystemSpy.book(classroom2, dayOfWeek, hour, minute, true);
	bookinkSystemSpy.book(classroom3, dayOfWeek, hour, minute, true);

	verify(allBookingsMock, times(3)).put(anyInt(), any());
	verify(classroomMock, times(3)).book(any());
	verify(classroomsMapMock, times(3)).get(any());

    }

    @Test
    @Parameters
    public void testListAvaialbleClassRoomsforGivenDayAndHour(
	    AbstractBooking[] bookings, boolean[] expected) {
	List<String> classrooms = bookingSystem.getClassroomsId();

	int i = 0;
	while (i < expected.length) {
	    String classroom = null;
	    if (expected[i]) {
		classroom = classrooms.remove(i);
	    } else {
		classroom = classrooms.get(i);
	    }

	    AbstractBooking booking = bookings[i];
	    bookingSystem.book(classroom, booking.getDayOfWeek(), booking
		    .getStartTime().getHour(), booking.getStartTime()
		    .getMinute(), booking.getDuration(), true);

	    i++;
	}

	int hour = 8;
	int minute = 0;
	DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
	Duration duration = Duration.ofHours(1);
	List<String> freeRooms = bookingSystem.getAvailableClassrooms(
		dayOfWeek, hour, minute, duration);

	assertEquals(new HashSet<String>(classrooms), new HashSet<String>(
		freeRooms));
	assertEquals(bookingSystem.getTotalClassrooms(), bookingSystem
		.getClassroomsId().size());

    }

    @Test
    @Parameters
    public void testNaturalOrderingOfRecurringAppointment(
	    RecurringAppointment appointment,
	    RecurringAppointment appointment2, Predicate<Integer> predicate) {
	assertTrue(predicate.test(appointment.compareTo(appointment2)));
    }

    @Test
    public void testRecurringAppointmentConstructors() {
	Classroom classroom = mock(Classroom.class);
	boolean periodic = false;
	Equipment equipment = Equipment.MICROPHONE;
	int hour = 10;
	int minute = 0;
	LocalTime reservation = LocalTime.of(hour, minute);
	DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
	Duration duration = Duration.ofHours(10);

	AbstractBooking bookingWithDurationAndOneEquipment = new RecurringAppointment(
		dayOfWeek, reservation, classroom, duration, "UnitTesting",
		null, equipment);
	assertEquals(hour, bookingWithDurationAndOneEquipment.getStartTime()
		.getHour());
	assertEquals(dayOfWeek,
		bookingWithDurationAndOneEquipment.getDayOfWeek());
	assertEquals(classroom,
		bookingWithDurationAndOneEquipment.getClassroom());
	assertEquals(duration, bookingWithDurationAndOneEquipment.getDuration());
	assertEquals(true, bookingWithDurationAndOneEquipment.getEquipments()
		.contains(equipment));

	AbstractBooking bookingWithDurationAndEquipments = new RecurringAppointment(
		dayOfWeek, reservation, classroom, duration, "UnitTesting",
		null, equipment, Equipment.PROJECTOR);
	assertEquals(hour, bookingWithDurationAndEquipments.getStartTime()
		.getHour());
	assertEquals(dayOfWeek, bookingWithDurationAndEquipments.getDayOfWeek());
	assertEquals(classroom, bookingWithDurationAndEquipments.getClassroom());
	assertEquals(duration, bookingWithDurationAndEquipments.getDuration());
	assertEquals(true, bookingWithDurationAndEquipments.getEquipments()
		.contains(equipment));
	assertEquals(true, bookingWithDurationAndEquipments.getEquipments()
		.contains(Equipment.PROJECTOR));

	AbstractBooking bookingWithDurationAndNoEquipments = new RecurringAppointment(
		dayOfWeek, reservation, classroom, duration, "UnitTesting",
		null);
	assertEquals(hour, bookingWithDurationAndNoEquipments.getStartTime()
		.getHour());
	assertEquals(dayOfWeek,
		bookingWithDurationAndNoEquipments.getDayOfWeek());
	assertEquals(classroom,
		bookingWithDurationAndNoEquipments.getClassroom());
	assertEquals(duration, bookingWithDurationAndNoEquipments.getDuration());
	assertNull(bookingWithDurationAndNoEquipments.getEquipments());

	AbstractBooking bookingWithDefaultDuration = new RecurringAppointment(
		dayOfWeek, reservation, classroom, "UnitTesting", null);
	assertEquals(hour, bookingWithDefaultDuration.getStartTime().getHour());
	assertEquals(dayOfWeek, bookingWithDefaultDuration.getDayOfWeek());
	assertEquals(classroom, bookingWithDefaultDuration.getClassroom());
	assertEquals(Duration.ofHours(1),
		bookingWithDefaultDuration.getDuration());
	assertNull(bookingWithDefaultDuration.getEquipments());

    }

    @Test
    public void testTotalGeneratedClassrooms() {
	BookinkSystem system = new BookinkSystem(10);
	assertEquals(10, system.getTotalClassrooms());
	assertEquals(10, system.getClassroomsId().size());
    }

    @Test
    public void testUnavailableBooking() {
	String classroomId = bookingSystem.getClassroomsId().get(0);

	bookingSystem.book(classroomId, DayOfWeek.MONDAY, 10, 0, true,
		Equipment.PROJECTOR);
	Integer bookingId_1 = bookingSystem.book(classroomId, DayOfWeek.MONDAY,
		10, 0, true, Equipment.PROJECTOR);
	assertNull(bookingId_1);

    }
    
    @Test
    public void testClassroomCleaningHours()
    {
	String classroomId = bookingSystem.getClassroomsId().get(0);
	Classroom classroom = bookingSystem.getClassrooms().get(classroomId);
	DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
	int hour = 10;
	int minute = 0;
	Integer bookingID = classroom.setCleaningHour(dayOfWeek, hour, minute);
	assertNotNull(bookingID);
	
	Integer bookingId2 = bookingSystem.book(classroomId, dayOfWeek, hour, minute, true);
	assertNull(bookingId2);
	
	Integer bookingId3 = bookingSystem.book(classroomId, DayOfWeek.MONDAY, hour, minute, true);
	assertNotNull(bookingId3);
    }
    
    @Test
    public void testBookingSystemSupportLogging()
    {
	String classroomId = "Unit_Testing_ID";
	BookinkSystem bookinkSystemSpy = spy(bookingSystem);
	Classroom classroomMock = mock(Classroom.class);
	Logger loggerMock = mock(Logger.class);
	Map<String, Classroom> mapClassroomsMock = mock(Map.class);
	when(bookinkSystemSpy.getClassrooms()).thenReturn(mapClassroomsMock);
	when(bookinkSystemSpy.getClassrooms().get(classroomId)).thenReturn(classroomMock);
	when(mapClassroomsMock.get(classroomId)).thenReturn(classroomMock);
	when(classroomMock.isAvailable(any())).thenReturn(true);
	when(bookinkSystemSpy.getSupportNotification()).thenReturn(loggerMock);
	when(classroomMock.book(any())).thenReturn(true);
	int hour = 10;
	int minute = 0;
	DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
	bookinkSystemSpy.book(classroomId, dayOfWeek, hour, minute, true);
	verify(loggerMock).info(anyString());;
	
    }
}

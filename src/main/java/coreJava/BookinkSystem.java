package coreJava;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.sleepycat.je.tree.INKeyRep.Default;
import com.sun.tools.doclets.formats.html.markup.HtmlTag.EndTag;

public class BookinkSystem {

    static abstract class AbstractBooking {
	static AtomicInteger atomicInteger = new AtomicInteger();
	int bookingId;
	Classroom classroom;
	ZonedDateTime dateTime = null;
	DayOfWeek dayOfWeek;
	String description;
	Duration duration = null;
	LocalTime endTime;
	Set<Equipment> equipments = null;
	String name = null;
	LocalTime startTime;

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    AbstractBooking other = (AbstractBooking) obj;
	    if (bookingId != other.bookingId)
		return false;
	    return true;
	}

	int getBookingId() {
	    return bookingId;
	}

	Classroom getClassroom() {
	    return classroom;
	}

	abstract public ZonedDateTime getDateTime();

	DayOfWeek getDayOfWeek() {
	    return dayOfWeek;
	}

	String getDescription() {
	    return description;
	}

	Duration getDuration() {
	    return duration;
	}

	LocalTime getEndTime() {
	    return endTime;
	}

	Set<Equipment> getEquipments() {
	    return equipments;
	}

	String getName() {
	    return name;
	}

	LocalTime getStartTime() {
	    return startTime;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + bookingId;
	    return result;
	}

	void setBookingId(int bookingId) {
	    this.bookingId = bookingId;
	}

	void setClassroom(Classroom classroom) {
	    this.classroom = classroom;
	}

	void setDayOfWeek(DayOfWeek dayOfWeek) {
	    this.dayOfWeek = dayOfWeek;
	}

	void setDescription(String description) {
	    this.description = description;
	}

	void setDuration(Duration duration) {
	    this.duration = duration;
	}

	void setEndTime(LocalTime endTime) {
	    this.endTime = endTime;
	}

	void setEquipments(Set<Equipment> equipments) {
	    this.equipments = equipments;
	}

	void setLocalTime(LocalTime localTime) {
	    this.startTime = localTime;
	}

	void setName(String name) {
	    this.name = name;
	}

	void setStartTime(LocalTime startTime) {
	    this.startTime = startTime;
	}

    }

    static class BookinCalendar {
	private Map<DayOfWeek, TreeSet<AbstractBooking>> recurringAppointments = new HashMap<>();

	// TODO: ZonedDateTime booking

	public BookinCalendar() {
	    initRecurringAppointments();
	}

	private boolean add(AbstractBooking booking) {

	    return recurringAppointments.get(booking.getDayOfWeek()).add(
		    booking);
	}

	public Map<DayOfWeek, TreeSet<AbstractBooking>> getRecurringAppointments() {
	    return recurringAppointments;
	}

	private void initRecurringAppointments() {
	    DayOfWeek[] dayOfWeeks = DayOfWeek.values();
	    for (DayOfWeek dayOfWeek : dayOfWeeks) {
		TreeSet<AbstractBooking> dayBookings = new TreeSet<>();
		recurringAppointments.put(dayOfWeek, dayBookings);
	    }
	}

	private boolean isAvailable(AbstractBooking booking) {
	    return !recurringAppointments.get(booking.getDayOfWeek()).contains(
		    booking);
	}

	void setRecurringAppointments(
		Map<DayOfWeek, TreeSet<AbstractBooking>> recurringAppointments) {
	    this.recurringAppointments = recurringAppointments;
	}
    }

    static class Classroom {
	private BookinCalendar bookingCalendar = new BookinCalendar();
	private int capacity;
	private String classroomId;
	Set<AbstractBooking> cleaningHours = new HashSet<>();

	public Classroom(String classroomId, int capacity) {
	    this.capacity = capacity;
	    this.classroomId = classroomId;

	}

	public boolean book(AbstractBooking booking) {
	    return bookingCalendar.add(booking);
	}

	@Override
	public boolean equals(Object object) {
	    if (object == null)
		return false;
	    if (this == object)
		return true;
	    if (object.getClass() != getClass())
		return false;

	    Classroom classroom = (Classroom) object;
	    if (classroom.getClassroomId().equals(this.getClassroomId()))
		return true;
	    return false;
	}

	BookinCalendar getBookingCalendar() {
	    return bookingCalendar;
	}

	public int getCapacity() {
	    return capacity;
	}

	public String getClassroomId() {
	    return classroomId;
	}

	@Override
	public int hashCode() {
	    return Objects.hash(getClassroomId());
	}

	public boolean isAvailable(AbstractBooking booking) {
	    return bookingCalendar.isAvailable(booking);
	}

	void setBookingCalendar(BookinCalendar bookingCalendar) {
	    this.bookingCalendar = bookingCalendar;
	}

	public void setCapacity(int capacity) {
	    this.capacity = capacity;
	}

	public void setClassroomId(String classroomId) {
	    this.classroomId = classroomId;
	}

	public Integer setCleaningHour(DayOfWeek dayOfWeek, int hour, int minute) {
	    RecurringAppointment cleaningHour = new RecurringAppointment(
		    dayOfWeek, LocalTime.of(hour, minute), this,
		    "Maintainance", "Cleaning");
	    cleaningHours.add(cleaningHour);
	    boolean isBooked = book(cleaningHour);
	    if (isBooked) {
		return cleaningHour.bookingId;
	    }
	    return null;
	}

	@Override
	public String toString() {
	    return getClassroomId();

	}
    }

    public enum Equipment {
	MICROPHONE, PROJECTOR, WHITEBOARD
    }

    static class RecurringAppointment extends AbstractBooking implements
	    Comparable<RecurringAppointment> {

	public RecurringAppointment(DayOfWeek dayOfWeek, LocalTime localTime,
		Classroom classroom, Duration duration, String name,
		String description, Equipment... equipments) {

	    init(dayOfWeek, localTime, classroom, duration, name, description,
		    equipments);

	}

	public RecurringAppointment(DayOfWeek dayOfWeek, LocalTime localTime,
		Classroom classroom, String name, String description,
		Equipment... equipments) {

	    init(dayOfWeek, localTime, classroom, Duration.ofHours(1), name,
		    description, equipments);
	}

	@Override
	public int compareTo(RecurringAppointment o) {

	    int dayOfWeekComparison = this.dayOfWeek.compareTo(o.dayOfWeek);
	    if (dayOfWeekComparison == 0) {
		if (this.endTime.isBefore(o.startTime)
			|| this.endTime.equals(o.startTime)) {
		    return -1;
		}

		if (this.endTime.isAfter(o.startTime)
			&& this.endTime.isBefore(o.endTime)) {
		    return 0;
		}

		if (this.startTime.isAfter(o.startTime)
			&& this.startTime.isBefore(o.endTime)) {
		    return 0;
		}

		if (this.startTime.equals(o.startTime)
			|| this.endTime.equals(o.endTime)) {
		    return 0;
		}

		if (this.startTime.isAfter(o.endTime)
			|| this.startTime.equals(o.endTime)) {
		    return 1;
		}
	    }

	    return dayOfWeekComparison;
	}

	@Override
	public boolean equals(Object object) {

	    boolean isEqual = false;
	    RecurringAppointment o = (RecurringAppointment) object;
	    if (this.dayOfWeek.equals(o.dayOfWeek)) {
		if (this.endTime.isAfter(o.startTime)
			&& this.endTime.isBefore(o.endTime)) {
		    isEqual = true;
		}

		if (this.startTime.isAfter(o.startTime)
			&& this.startTime.isBefore(o.endTime)) {
		    isEqual = true;
		}

		if (this.startTime.equals(o.startTime)
			|| this.endTime.equals(o.endTime)) {
		    isEqual = true;
		}
	    }

	    return isEqual;
	}

	public ZonedDateTime getDateTime() {
	    throw new UnsupportedOperationException();
	}

	private void init(DayOfWeek dayOfWeek, LocalTime localTime,
		Classroom classroom, Duration duration, String name,
		String description, Equipment... equipments) {

	    Objects.requireNonNull(localTime);
	    Objects.requireNonNull(dayOfWeek);
	    Objects.requireNonNull(classroom);
	    Objects.requireNonNull(duration);
	    Objects.requireNonNull(name);

	    this.bookingId = atomicInteger.getAndIncrement();

	    this.startTime = localTime;
	    this.duration = duration;
	    this.endTime = startTime.plus(duration);
	    this.dayOfWeek = dayOfWeek;
	    this.classroom = classroom;
	    this.name = name;
	    this.description = description;

	    if (equipments.length != 0) {
		this.equipments = new HashSet<BookinkSystem.Equipment>();
		this.equipments.addAll(Arrays.asList(equipments));
	    }

	}

	@Override
	public String toString() {

	    return "RecurringAppointment [bookingId=" + bookingId
		    + ", classroom=" + classroom + ", dayOfWeek=" + dayOfWeek
		    + ", description=" + description + ", duration=" + duration
		    + ", endTime=" + endTime + ", equipments=" + equipments
		    + ", name=" + name + ", startTime=" + startTime + "]";
	}

    }

    private Map<Integer, AbstractBooking> bookings = new HashMap<Integer, BookinkSystem.AbstractBooking>();

    private Map<String, Classroom> classrooms = new HashMap<>();;

    private List<LocalTime> localTimes = new ArrayList<>();

    private Logger support = Logger.getGlobal();

    private int totalClassrooms = 20;

    public BookinkSystem() {
	generateClassRooms();
    };

    public BookinkSystem(int totalClassrooms) {
	this.totalClassrooms = totalClassrooms;
	generateClassRooms();
    }

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

    public Integer book(String classroomId, DayOfWeek dayOfWeek, int hour,
	    int minute, boolean isPeriodic, Equipment... equipments) {

	return book(classroomId, dayOfWeek, hour, minute, Duration.ofHours(1),
		isPeriodic, equipments);
    }

    public Integer book(String classroomId, DayOfWeek dayOfWeek, int hour,
	    int minute, Duration duration, boolean isPeriodic,
	    Equipment... equipments) {
	boolean bookingSuccesful = false;
	AbstractBooking booking = null;
	Classroom classroom = getClassrooms().get(classroomId);
	LocalTime reservation = LocalTime.of(hour, minute);

	if (isPeriodic) {
	    booking = new RecurringAppointment(dayOfWeek, reservation,
		    classroom, duration, "UnitTesting", null, equipments);
	}

	// Check if time slot is available
	if (classroom.isAvailable(booking)) {
	    getBookings().put(booking.getBookingId(), booking);
	    bookingSuccesful = classroom.book(booking);
	}

	if (bookingSuccesful) {
	    getSupportNotification().info(booking.toString());
	    return booking.getBookingId();
	}
	return null;
    }

    public void generateClassRooms() {

	int i = 0;
	while (i < totalClassrooms) {
	    // [A-C][1-50]
	    Random randomLetter = new Random();
	    char letter = (char) (randomLetter.nextInt(3) + 65);
	    Random randomNumber = new Random();
	    int number = randomNumber.nextInt(50);
	    String id = letter + Integer.toString(number);

	    int capacity = randomNumber.nextInt(10) + 20;

	    Classroom classroom = new Classroom(id, capacity);

	    boolean alreadyExist = getClassrooms().containsKey(id);
	    if (!alreadyExist) {
		getClassrooms().put(id, classroom);
		i++;
	    }

	}

    }

    public List<String> getAvailableClassrooms(DayOfWeek dayOfWeek, int hour,
	    int minute, Duration duration) {
	List<String> freeClassRoom = new ArrayList<String>();
	LocalTime localTime = LocalTime.of(hour, minute);
	AbstractBooking reservationRequest = new RecurringAppointment(
		dayOfWeek, localTime, new Classroom("SystemReservationRequest",
			10), duration, "SystemReservationRequest", null);

	// Set<String> allClassRoom = new
	// HashSet<String>(getClassrooms().keySet());
	Set<Entry<String, Classroom>> classroomEntries = classrooms.entrySet();
	for (Entry<String, Classroom> classroomEnty : classroomEntries) {
	    String classroomId = classroomEnty.getKey();
	    Classroom classroom = classroomEnty.getValue();
	    boolean isNotFree = classroom.getBookingCalendar().recurringAppointments
		    .get(dayOfWeek).contains(reservationRequest);

	    if (!isNotFree) {
		freeClassRoom.add(classroomId);
	    }
	}

	return freeClassRoom;
    }

    public String getBookedHours() {

	String bookedHours = localTimes.stream()
		.map(bookedTime -> Integer.toString(bookedTime.getHour()))
		.sorted().collect(Collectors.joining(","));
	return bookedHours;
    }

    Map<Integer, AbstractBooking> getBookings() {
	return bookings;
    }

    Map<String, Classroom> getClassrooms() {
	return classrooms;
    }

    public List<String> getClassroomsId() {

	List<String> classRoomId = new ArrayList<String>(getClassrooms()
		.keySet());

	return classRoomId;
    }

    protected Logger getSupportNotification() {
	return support;
    }

    public int getTotalClassrooms() {
	return totalClassrooms;
    }

    void setBookings(Map<Integer, AbstractBooking> allBookings) {
	this.bookings = allBookings;
    }

    void setClassrooms(Map<String, Classroom> classrooms) {
	this.classrooms = classrooms;
    }

    protected void setTotalClassrooms(int totalClassrooms) {
	this.totalClassrooms = totalClassrooms;
    }

}

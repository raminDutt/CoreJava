package coreJava;

import java.time.LocalDateTime;

public class TimeInterval {

	LocalDateTime start;
	LocalDateTime end;

	public TimeInterval(LocalDateTime start, LocalDateTime end) 
	{
		if(start.isAfter(end))
		{
			throw new IllegalArgumentException();
		}
		this.start = start;
		this.end = end;
	}

	public boolean isConfict(TimeInterval interval) {
		boolean result = false;
		if (interval.start.isAfter(start) && interval.start.isBefore(end)) {

			result = true;

		} else {
			if (interval.end.isAfter(start) && interval.end.equals(end)) {
				result = true;
			}
		}

		return result;
	}

}

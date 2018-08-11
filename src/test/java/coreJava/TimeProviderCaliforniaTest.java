package coreJava;

import static org.junit.Assert.*;

import java.util.Calendar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(JUnitParamsRunner.class)
public class TimeProviderCaliforniaTest {

    private static final Object[] parametersForTestIsItMorning() {
	return new Object[] {1,2,3,4,5,6,7,8,9,10,11};
    }

    @Test
    @Parameters
    public void testIsItMorning(int hour) {
	TimeProvider timeProvider = Mockito.spy(TimeProviderCalifornia.class);
	Calendar calendar = Mockito.mock(Calendar.class);
	Mockito.when(timeProvider.getTime()).thenReturn(calendar);
	Mockito.when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(hour);
	Assertions.assertThat(timeProvider.isItMorning()).isEqualTo(true);
    }
    
    private static final Object[] parametersForTestIsNotMorning() {
	return new Object[] {12,13,14,15,16,17,18,19,20,21,22,23};
    }

    @Test
    @Parameters
    public void testIsNotMorning(int hour) {
	TimeProvider timeProvider = Mockito.spy(TimeProviderCalifornia.class);
	Calendar calendar = Mockito.mock(Calendar.class);
	Mockito.when(timeProvider.getTime()).thenReturn(calendar);
	Mockito.when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(hour);
	Assertions.assertThat(timeProvider.isItMorning()).isEqualTo(false);
    }

}

package coreJava;

import static org.junit.Assert.*;

import java.util.Calendar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

public class HelloTest {



    @Test
    public void testSayGoodMorning() {
	TimeProvider timeProvider = mock(TimeProvider.class);
	Hello hello = new Hello(timeProvider);
	when(timeProvider.isItMorning()).thenReturn(false);
	assertThat(hello.sayHello()).isEqualTo("Good Afternoon!");
    }
    

    @Test
    public void testSayGoodAfternoon() {

	TimeProvider timeProvider = mock(TimeProvider.class);
	Hello hello = new Hello(timeProvider);
	when(timeProvider.isItMorning()).thenReturn(true);
	assertThat(hello.sayHello()).isEqualTo("Good Morning!");
    }
    

}

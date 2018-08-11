package coreJava;

import static org.junit.Assert.*;
import io.codearte.catchexception.shade.mockito.Spy;

import java.util.Calendar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.MockSettings;
import org.mockito.internal.creation.MockSettingsImpl;

import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class HelpDeskTest {

    private static final Object[] parametersForTestWillHandleIssue() {
	return new Object[] {
		new Object[] { 1, 0, false },
		new Object[] { 1, 24, false },
		new Object[] { 1, 17, false },
		new Object[] { 1, 12, false },
		new Object[] { 2, 0, true },
		new Object[] { 2, 24, true },
		new Object[] { 2, 17, true },
		new Object[] { 2, 12, true },
		new Object[] { 3, 0, true },
		new Object[] { 3, 24, true },
		new Object[] { 3, 17, true },
		new Object[] { 3, 12, true },
		new Object[] { 4, 0, true },
		new Object[] { 4, 24, true },
		new Object[] { 4, 17, true },
		new Object[] { 4, 12, true },
		new Object[] { 5, 0, true },
		new Object[] { 5, 24, true },
		new Object[] { 5, 17, true },
		new Object[] { 5, 12, true },
		new Object[] { 6, 0, true },
		new Object[] { 6, 24, false },
		new Object[] { 6, 17, true },
		new Object[] { 6, 12, true },
		new Object[] { 7, 0, false },
		new Object[] { 7, 24, false },
		new Object[] { 7, 17, false },
		new Object[] { 7, 12, false } };
    }

    @Test
    @Parameters
    public void testWillHandleIssue(int dayOfWeek, int hourOfDay,
	    boolean expectedResult) {

	Issue issue = mock(Issue.class);
	HelpDesk helpDesk = new HelpDesk();
	HelpDesk helpDeskSpy = spy(helpDesk);
	Calendar calendarMock = mock(Calendar.class, Answers.RETURNS_DEEP_STUBS);
	when(helpDeskSpy.getCal()).thenReturn(calendarMock);
	when(calendarMock.get(Calendar.DAY_OF_WEEK)).thenReturn(dayOfWeek);
	when(calendarMock.get(Calendar.HOUR_OF_DAY)).thenReturn(hourOfDay);
	Assertions.assertThat(helpDeskSpy.willHandleIssue(issue)).isEqualTo(
		expectedResult);

    }

}

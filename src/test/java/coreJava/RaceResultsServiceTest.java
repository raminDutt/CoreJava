package coreJava;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.Locale.Category;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;

import static org.junit.Assert.*;

public class RaceResultsServiceTest {

    RaceResultService raceResultService = spy(RaceResultService.class);

    String MESSAGE = "Hello from RaceResultService";
    String MESSAGE_HORSE_RACE = "Horse Race Results";
    String MESSAGE_F1_RACE = "F1 Race Results";
    String MESSAGE_BOAT_RACE = "Boat Race Results";

    @Mock
    Client client1_mock;
    Client client2_mock = mock(Client.class);
    Client client3_mock = mock(Client.class);

    private void setUpSpies() {
	when(raceResultService.getRaceResults(RaceCategory.BOAT_RACE))
		.thenReturn(MESSAGE_BOAT_RACE);
	when(raceResultService.getRaceResults(RaceCategory.F1_RACE))
		.thenReturn(MESSAGE_F1_RACE);
	when(raceResultService.getRaceResults(RaceCategory.HORSE_RACE))
		.thenReturn(MESSAGE_HORSE_RACE);
    }

    @Before
    public void initMocks() {
	MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUnsubscribedClientDoNotReceiveAnyMessage() {

	raceResultService.sendMessage();
	verify(client1_mock, never()).update(MESSAGE);
	verify(client2_mock, never()).update(MESSAGE);
	verify(client3_mock, never()).update(MESSAGE);
    }

    @Test
    public void testSingleSubscribedClientReceivesMessage() {

	setUpSpies();

	raceResultService.subscribe(client1_mock);
	raceResultService.sendMessage();

	int numOfCategories = RaceCategory.values().length;
	verify(client1_mock, times(numOfCategories)).update(anyString());
	verify(client1_mock).update(MESSAGE_BOAT_RACE);
	verify(client1_mock).update(MESSAGE_F1_RACE);
	verify(client1_mock).update(MESSAGE_HORSE_RACE);
    }

    @Test
    public void testMultipleSubscribedClientsReceiveMessage() {

	raceResultService.subscribe(client1_mock);
	raceResultService.subscribe(client2_mock);
	raceResultService.subscribe(client3_mock);
	raceResultService.sendMessage();
	int numOfCategories = RaceCategory.values().length;
	verify(client1_mock, times(numOfCategories)).update(anyString());
	verify(client2_mock, times(numOfCategories)).update(anyString());
	verify(client3_mock, times(numOfCategories)).update(anyString());

    }

    @Test
    public void testMultipleSubscriptionFromSameClientDoesNotSendMultipleMessages() {
	raceResultService.subscribe(client1_mock);
	raceResultService.subscribe(client1_mock);
	raceResultService.subscribe(client1_mock);
	raceResultService.sendMessage();
	int numOfCategories = RaceCategory.values().length;
	verify(client1_mock, VerificationModeFactory.times(numOfCategories)).update(
		anyString());
    }

    @Test
    public void testClientThatUnsubscribesDoesNoLongerReceiveMessages() {
	raceResultService.subscribe(client1_mock);
	raceResultService.sendMessage();
	verify(client1_mock, times(RaceCategory.values().length))
		.update(anyString());
	boolean actualResult = raceResultService.unsubscribe(client1_mock);
	assertEquals(true, actualResult);
	raceResultService.sendMessage();
	reset(client1_mock);
	verify(client1_mock, never()).update(anyString());

    }

    @Test
    public void testSingleClientReceivingMessageFromSubscibedCategory() {
	raceResultService.subscribe(client1_mock, RaceCategory.BOAT_RACE);
	when(raceResultService.getRaceResults(RaceCategory.BOAT_RACE))
		.thenReturn(MESSAGE_BOAT_RACE);
	raceResultService.sendMessage();
	verify(client1_mock).update(MESSAGE_BOAT_RACE);
    }

    @Test
    public void testClientSubscribesToAllCategoriesAfterSingleCategorySubscription() {

	setUpSpies();

	raceResultService.subscribe(client1_mock, RaceCategory.HORSE_RACE);
	raceResultService.subscribe(client1_mock);
	raceResultService.sendMessage();
	verify(client1_mock,
		VerificationModeFactory.times(RaceCategory.values().length))
		.update(anyString());
	verify(client1_mock).update(MESSAGE_F1_RACE);
	verify(client1_mock).update(MESSAGE_HORSE_RACE);
	verify(client1_mock).update(MESSAGE_BOAT_RACE);

    }

    @Test
    public void testMultipleClientCategorySubscription() {
	setUpSpies();
	raceResultService.subscribe(client1_mock, RaceCategory.BOAT_RACE);
	raceResultService.subscribe(client2_mock, RaceCategory.F1_RACE);
	raceResultService.subscribe(client3_mock, RaceCategory.HORSE_RACE);
	raceResultService.sendMessage();
	verify(client1_mock).update(MESSAGE_BOAT_RACE);
	verify(client2_mock).update(MESSAGE_F1_RACE);
	verify(client3_mock).update(MESSAGE_HORSE_RACE);

    }

    @Test
    public void testLogging() {
	Logger logger = mock(Logger.class);
	raceResultService.logger = logger;
	raceResultService.subscribe(client1_mock);
	raceResultService.sendMessage();
	verify(logger, times(RaceCategory.values().length)).info(anyString());
    }

    @Test
    public void testMultipleUnsubscription() {
	raceResultService.subscribe(client1_mock);
	boolean actualResult = raceResultService.unsubscribe(client1_mock);
	assertEquals(true, actualResult);
	boolean actualResult2 = raceResultService.unsubscribe(client1_mock);
	assertEquals(false, actualResult2);
	boolean actualResult3 = raceResultService.unsubscribe(client1_mock);
	assertEquals(false, actualResult3);
    }
    
    @Test
    public void testUnsubscription() {
	raceResultService.subscribe(client1_mock);
	boolean actualResultClient1 = raceResultService.unsubscribe(client1_mock);
	assertEquals(true, actualResultClient1);
	//Client 2 is not even subscribed
	boolean actualResultClient2 = raceResultService.unsubscribe(client1_mock);
	assertEquals(false, actualResultClient2);
    }

}

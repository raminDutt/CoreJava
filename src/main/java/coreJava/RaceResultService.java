package coreJava;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;
import java.util.Set;

import com.sun.tools.javac.code.Attribute.Array;

public class RaceResultService {

    private Map<Client, Set<RaceCategory>> clients = new HashMap<>();
    Logger logger = Logger.getLogger(RaceResultsServiceTest.class.getName());

    public void subscribe(Client client) {

	Set<RaceCategory> categories = new HashSet<RaceCategory>(
		Arrays.asList(RaceCategory.values()));
	clients.put(client, categories);
	int x = 10;
    }

    public void sendMessage() {

	Set<Entry<Client, Set<RaceCategory>>> entrySet = clients.entrySet();
	for (Entry<Client, Set<RaceCategory>> entry : entrySet) {
	    Client client = entry.getKey();
	    Set<RaceCategory> subscribedCategories = entry.getValue();
	    subscribedCategories.forEach(category -> {
		String message = getRaceResults(category);
		client.update(message);
		ZonedDateTime now = ZonedDateTime.now();
		logger.info("Sending message: \n Client: " + client
			+ "\n Date: " + now + "\n Message: " + message);
	    });
	}

    }

    protected String getRaceResults(RaceCategory raceCategory) {
	String raceResult = null;
	switch (raceCategory) {
	case HORSE_RACE:
	    raceResult = "TBD";
	    break;
	case BOAT_RACE:
	    raceResult = "TBD";
	    break;
	case F1_RACE:
	    raceResult = "TBD";
	    break;
	default:
	    raceResult = "Courtesy of RaceResultService System";
	}
	return raceResult;
    }

    public boolean unsubscribe(Client client) {
	Set<RaceCategory> categories = clients.remove(client);
	if (categories != null) {
	    return true;
	}
	return false;
    }

    public void subscribe(Client client, RaceCategory horseRace) {

	Set<RaceCategory> raceCategories = new HashSet<RaceCategory>();
	raceCategories.add(horseRace);
	clients.put(client, raceCategories);
    }

}

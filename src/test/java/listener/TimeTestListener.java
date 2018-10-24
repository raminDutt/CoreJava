package listener;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TimeTestListener extends RunListener {

    private static class Node {
	boolean faillure = false;
	//String className = null;
	LocalTime start_time = null;
	LocalTime end_time = null;
    }

    Map<String, Node> map = new TreeMap<>();

    public void testRunFinished(Result result) throws Exception {

	int width = map.entrySet().stream().map(entry -> {
	     String key = entry.getKey();
	     return key.substring(0, key.indexOf('(')).length();
	}).max((Integer x, Integer y) -> x.compareTo(y)).get();
	
	

	
	Set<Entry<String, Node>> entrySet = map.entrySet();
	Iterator<Entry<String, Node>> iterator = entrySet.iterator();
	
	while (iterator.hasNext()) {
	    Entry<String, Node> next = iterator.next();
	    String methodeName = next.getKey();
	    int indexOf = methodeName.indexOf('(');
	    String className = "";
	    methodeName = className + "." + methodeName.substring(0, indexOf);
	    Node node = next.getValue();
	    String duration = ChronoUnit.SECONDS.between(node.start_time,
		    node.end_time)
		    + ":"
		    + ChronoUnit.MILLIS.between(node.start_time, node.end_time)
		    + ":"
		    + ChronoUnit.MICROS.between(node.start_time, node.end_time);
	    String status = null;
	    if (node.faillure) {
		status = "FAIL";
	    } else {
		status = "OK";
	    }
	    System.out.printf("%s\t%-"+width+"s\t%s\n", status, methodeName,
		    duration);

	}

    }

    @Override
    public void testStarted(Description description) throws Exception {
	Node node = new Node();
	node.start_time = LocalTime.now();
	map.put(description.getDisplayName(), node);
    }

    @Override
    public void testFinished(Description description) {

	Node node = map.get(description.getDisplayName());
	node.end_time = LocalTime.now();
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
	Node node = map.get(failure.getDescription().getDisplayName());
	node.faillure = true;
    }
    
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
	return super.clone();
    }


}

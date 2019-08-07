package coreJava;

import java.util.*;

import org.w3c.tidy.PPrint;

public class Friend {
    private Collection<Friend> friends;
    private String email;
    boolean isVisited = false;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
        
	//java.util.LinkedList<Friend> processor = new java.util.LinkedList<>();
	
	Queue<Friend> processor = new java.util.LinkedList<>();;
        processor.add(this);
	//processor.push(this);
        friend.isVisited = true;
        boolean isConnected = false;
        while(!processor.isEmpty())
        {
            //Friend f = processor.pop();
            Friend f = processor.remove();
            Collection<Friend> neighbors = f.getFriends();
            for(Friend neighbor: neighbors)
            {
        	if(neighbor.email.equals(friend.email))
        	{
        	    return true;
        	}
        	if(!neighbor.isVisited)
        	{
        	    processor.add(neighbor);
        	}
            }
        }
        return false;
        
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");

        a.addFriendship(b);
        b.addFriendship(c);

        System.out.println(a.canBeConnected(c));
    }
    
}

package coreJava;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable, Cloneable{
	private String sender = "Ramin";
	public ArrayList<String> recipients; // Constructs a new arrayList
	private String text = "Dear Sir, I am writting you this mail for your help";
	
	Message()
	{
		recipients = new ArrayList<String>();
		recipients.add("Amit");
		recipients.add("Roghieh");
		recipients.add("Poffy");
		recipients.add("Vinod");
	}
	
	public void print()
	{
		System.out.println("Sender: " + sender);
		System.out.println("Recipients: " + recipients);
		System.out.println("text: " + text);
	}
	
	public Message clone()
	{
		Message message = this;
		Message clone = null;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream))
		{
			objectOutputStream.writeObject(message);
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
		}
		
		ByteArrayInputStream in = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		try(ObjectInputStream objectInputStream = new ObjectInputStream(in))
		{
			clone = (Message)objectInputStream.readObject();
		}
		catch(IOException | ClassNotFoundException exception)
		{
			exception.printStackTrace();
		}
		return clone;
	}
	
}

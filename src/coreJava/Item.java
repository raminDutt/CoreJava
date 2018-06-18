package coreJava;

import java.util.Objects;

import annotationProcessor.JavaDocProcessor.Param;
import annotationProcessor.JavaDocProcessor.Return;
import annotationProcessor.Resource;
import annotationProcessor.TestCaseProcessor.TestCase;
import annotationProcessor.Todo;

@Todo(message = "Reminder message 2", description = "Item class")
@Todo(message = "Reminder message 3", description = "Item class")
@Serializable
public class Item {
	private String description;

	@Transient
	static double ramin = 56;;
	private boolean flag = true;
	private byte brat = 8;
	private short superUps = 50;
	private int age = 10;
	private long life = 100;
	private float fish = 156;
	private double price = 4.99;
	private char letter = 'j';
	
	@Resource(url="https://www.oracle.com/index.html")
	public String url;
	
	@Resource(url="https://www.google.com/")
	public String url2;
	
	@Resource(url="file:///media/sf_C_DRIVE/GitViewstore/RD_wiki/Java/Java.html")
	public String url3;

	public Point from = new Point(0, 0);
	Point to = new Point(10, 20);
	Line line = new Line(to, from);

	@Todo(message = "Reminder 8")
	public Item() {
		// description=null;
		// price=0;
	}
	
	
	@TestCase(params="45", expected="264")
	@TestCase(params="4", expected="24")
	public static int ramin(int x)
	{
		return 0;
	}

	@Return(description = "ReturnDescription_1")
	@Todo(message = "Reminder message 4", description = "Item class, Methode: toString")
	@Todo(message = "Reminder message 5", description = "Item class, Methode: toString")
	public String toString() {
		String a = "descrption: " + description + "\n";
		String b = "ramin: " + ramin + "\n";
		String c = "flag: " + flag + "\n";
		String d = "brat: " + brat + "\n";
		String e = "superUps = " + superUps + "\n";
		String f = "age: " + age + "\n";
		String g = "life: " + life + "\n";
		String h = "fish: " + fish + "\n";
		String i = "price: " + price + "\n";
		String j = "letter: " + letter + "\n";
		String k = "from: " + from + "\n";
		String l = "to: " + to + "\n";
		String m = "line: " + line + "\n";

		String result = "*****ITEM*****\n" + a + b + c + d + e + f + g + h + i
				+ j + k + l + m;
		return result;

	}

	public Item(String description, double price, int age) {
		this.description = description;
		this.price = price;
		this.age = age;
	}

	@Param(name = "x", description = "Item description1")
	@Param(name = "y", description = "Item description2")
	@Return(description = "ReturnDescription_2")
	public static String f(Integer x, Double y) {
		return null;
	}

	@Param(name = "otherObject", description = "Item description3")
	@Return(description = "ReturnDescription_3")
	@Todo(message = "Reminder message 1", description = "Item class, Methode: equals")
	public boolean equals(Object otherObject) {
		// A quick test to see if the objects are identical
		if (this == otherObject)
			return true;
		// Must return false if the parameter is null
		if (otherObject == null)
			return false;

		if (!(otherObject instanceof Item))
			return false;

		// Test whether the instance variables have identical values
		Item other = (Item) otherObject;
		return Objects.equals(description, other.description)
				&& price == other.price;

	}

}

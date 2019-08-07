package coreJava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.function.BiFunction;

import org.junit.Before;
import org.junit.Test;

import ch.qos.logback.core.pattern.parser.Node;

public class HashTableTest {

    @Test
    public void addingkeysAndValues() {

	HashTable<Integer, String> map = new HashTable();
	assertThat(map.put(1, "San Jose")).isTrue();
	assertThat(map.put(20, "San Fransisco")).isTrue();
	assertThat(map.put(35, "Los Angeles")).isTrue();

	int actualSize = map.getSize();
	int expectedSize = 3;
	assertThat(actualSize).isEqualTo(expectedSize);

	assertThat(isPresent(1, "San Jose", map)).isTrue();
	assertThat(isPresent(2, "San Fransisco", map)).isFalse();
	assertThat(isPresent(20, "San Fransisco", map)).isTrue();
	assertThat(isPresent(35, "Los Angeles", map)).isTrue();

	String expectedImpl = "(20,San Fransisco)->(1,San Jose)->null->null->null->(35,Los Angeles)->null->null->null->null";
	String actualImpl = map.print();
	assertThat(actualImpl).isEqualTo(expectedImpl);

	String expectedString = "[20,San Fransisco],[1,San Jose],[35,Los Angeles]";
	String actualString = map.toString();
	assertThat(actualString).isEqualTo(expectedString);

    }

    @Test
    public void insertionOfIdenticalKeyValuesShouldReplaceOldValue() {
	HashTable<Integer, String> map = new HashTable();
	assertThat(map.put(1, "San Jose")).isTrue();
	assertThat(map.put(20, "San Fransisco")).isTrue();
	assertThat(map.put(35, "Los Angeles")).isTrue();
	assertThat(map.put(20, "Palo Alto")).isTrue();

	int actualSize = map.getSize();
	int expectedSize = 3;
	assertThat(actualSize).isEqualTo(expectedSize);

	assertThat(isPresent(1, "San Jose", map)).isTrue();
	assertThat(isPresent(20, "San Fransisco", map)).isFalse();
	assertThat(isPresent(20, "Palo Alto", map)).isTrue();
	assertThat(isPresent(35, "Los Angeles", map)).isTrue();

	String expectedImpl = "(20,Palo Alto)->(1,San Jose)->null->null->null->(35,Los Angeles)->null->null->null->null";
	String actualImpl = map.print();
	assertThat(actualImpl).isEqualTo(expectedImpl);

	String expectedString = "[20,Palo Alto],[1,San Jose],[35,Los Angeles]";
	String actualString = map.toString();
	assertThat(actualString).isEqualTo(expectedString);
    }

    @Test
    public void linearCollision() {

	HashTable<Integer, String> map = new HashTable();
	assertThat(map.put(1, "San Jose")).isTrue();
	assertThat(map.put(11, "San Fransisco")).isTrue();
	assertThat(map.put(21, "Los Angeles")).isTrue();
	assertThat(map.put(2, "Montreal")).isTrue();

	int actualSize = map.getSize();
	int expectedSize = 4;
	assertThat(actualSize).isEqualTo(expectedSize);

	assertThat(isPresent(1, "San Jose", map)).isTrue();
	assertThat(isPresent(11, "San Fransisco", map)).isTrue();
	assertThat(isPresent(21, "Los Angeles", map)).isTrue();
	assertThat(isPresent(2, "Montreal", map)).isTrue();

	String expectedImpl = "null->(1,San Jose)->(11,San Fransisco)->(21,Los Angeles)->(2,Montreal)->null->null->null->null->null";
	String actualImpl = map.print();
	assertThat(actualImpl).isEqualTo(expectedImpl);

	String expectedString = "[1,San Jose],[11,San Fransisco],[21,Los Angeles],[2,Montreal]";
	String actualString = map.toString();
	assertThat(actualString).isEqualTo(expectedString);

    }

    @Test
    public void shouldReturnValueAssociatedToKey() {
	HashTable<Integer, String> map = new HashTable();
	assertThat(map.put(1, "San Jose")).isTrue();
	assertThat(map.put(20, "San Fransisco")).isTrue();
	assertThat(map.put(35, "Los Angeles")).isTrue();
	assertThat(map.put(20, "Palo Alto")).isTrue();
	assertThat(map.put(2, "Los Gatos")).isTrue();
	assertThat(map.put(12, "Montain View")).isTrue();

	int actualSize = map.getSize();
	int expectedSize = 5;
	assertThat(actualSize).isEqualTo(expectedSize);

	String expectedValue;
	String actualValue;

	expectedValue = "San Jose";
	actualValue = map.get(1);
	assertThat(actualValue).isEqualTo(expectedValue);

	expectedValue = "Palo Alto";
	actualValue = map.get(20);
	assertThat(actualValue).isEqualTo(expectedValue);

	expectedValue = "Los Angeles";
	actualValue = map.get(35);
	assertThat(actualValue).isEqualTo(expectedValue);

	expectedValue = "Los Gatos";
	actualValue = map.get(2);
	assertThat(actualValue).isEqualTo(expectedValue);

	expectedValue = "Montain View";
	actualValue = map.get(12);
	assertThat(actualValue).isEqualTo(expectedValue);

	actualValue = map.get(6);
	assertThat(actualValue).isNull();

    }

    @Test
    public void removing() {
	HashTable<Integer, String> map = new HashTable();
	assertThat(map.put(1, "San Jose")).isTrue();
	assertThat(map.put(11, "San Fransisco")).isTrue();
	assertThat(map.put(21, "Los Angeles")).isTrue();
	assertThat(map.put(2, "Montreal")).isTrue();

	int actualSize = map.getSize();
	int expectedSize = 4;
	assertThat(actualSize).isEqualTo(expectedSize);

	assertThat(map.remove(2)).isTrue();
	actualSize = map.getSize();
	expectedSize = 3;
	assertThat(actualSize).isEqualTo(expectedSize);
	assertThat(map.remove(3)).isFalse();
	actualSize = map.getSize();
	expectedSize = 3;
	assertThat(actualSize).isEqualTo(expectedSize);

	String expectedImpl = "null->(1,San Jose)->(11,San Fransisco)->(21,Los Angeles)->null->null->null->null->null->null";
	String actualImpl = map.print();
	assertThat(actualImpl).isEqualTo(expectedImpl);

	String expectedString = "[1,San Jose],[11,San Fransisco],[21,Los Angeles]";
	String actualString = map.toString();
	assertThat(actualString).isEqualTo(expectedString);
    }

    @Test
    public void removeAndFind() {
	HashTable<Integer, String> map = new HashTable();
	assertThat(map.put(1, "San Jose")).isTrue();
	assertThat(map.put(2, "Montreal")).isTrue();
	assertThat(map.put(11, "San Fransisco")).isTrue();
	assertThat(map.put(21, "Los Angeles")).isTrue();

	String expectedImpl = "null->(1,San Jose)->(2,Montreal)->(11,San Fransisco)->(21,Los Angeles)->null->null->null->null->null";
	String actualImpl = map.print();
	assertThat(actualImpl).isEqualTo(expectedImpl);

	String expectedString = "[1,San Jose],[2,Montreal],[11,San Fransisco],[21,Los Angeles]";
	String actualString = map.toString();
	assertThat(actualString).isEqualTo(expectedString);

	assertThat(map.remove(2)).isTrue();
	expectedImpl = "null->(1,San Jose)->(11,San Fransisco)->(21,Los Angeles)->null->null->null->null->null->null";
	actualImpl = map.print();
	assertThat(actualImpl).isEqualTo(expectedImpl);	
	assertThat(map.get(11)).isEqualTo("San Fransisco");

    }
    
   


    private boolean isPresent(Integer k, String v,
	    HashTable<Integer, String> map) {
	Object[] internalArray = map.getInternalArray();
	int i = 0;
	int size = internalArray.length;
	boolean flag = false;
	int count = 0;
	while (i < size) {
	    HashTable<Integer, String>.Node node = (HashTable<Integer, String>.Node) internalArray[i];
	    if (node != null && k.equals(node.key) && v.equals(node.value)) {
		flag = true;
		count++;
	    }
	    i++;
	}

	return (flag && count == 1) ? true : false;
    }

}

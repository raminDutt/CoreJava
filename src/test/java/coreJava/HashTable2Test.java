package coreJava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HashTable2Test {

    @Test
    public void addingKeyAndValue() {
	HashTable2<Integer, String> hashTable = new HashTable2<>();

	hashTable.put(1, "poffy");
	hashTable.put(5, "mtl");
	hashTable.put(8, "toronto");
	hashTable.put(26, "ottawa");

	String expectedInternal = "null->[(1,poffy)]->null->null->null->[(5,mtl)]->[(26,ottawa)]->null->[(8,toronto)]->null";
	String actualInternal = hashTable.toString();
	assertThat(actualInternal).isEqualTo(expectedInternal);

	int expectedSize = 4;
	int actualSize = hashTable.getSize();
	assertThat(actualSize).isEqualTo(expectedSize);

	String expectedPrint = "[(1,poffy)]->[(5,mtl)]->[(26,ottawa)]->[(8,toronto)]";
	String actualPrint = hashTable.print();
	assertThat(actualPrint).isEqualTo(expectedPrint);

    }
    
    @Test
    public void retrievingValue() {
	HashTable2<Integer, String> hashTable = new HashTable2<>();

	hashTable.put(1, "poffy");
	hashTable.put(5, "mtl");
	hashTable.put(8, "toronto");
	hashTable.put(26, "ottawa");

	assertThat(hashTable.get(1)).isEqualTo("poffy");
	assertThat(hashTable.get(5)).isEqualTo("mtl");
	assertThat(hashTable.get(8)).isEqualTo("toronto");
	assertThat(hashTable.get(26)).isEqualTo("ottawa");
	assertThat(hashTable.get(9)).isNull();
	

    }
    @Test
    public void addingKeyThatCollide() {
	HashTable2<Integer, String> hashTable = new HashTable2<>();

	hashTable.put(1, "poffy");
	hashTable.put(5, "mtl");
	hashTable.put(8, "toronto");
	hashTable.put(11, "gatineau");
	hashTable.put(21, "white rock");
	hashTable.put(15, "palo");
	hashTable.put(26, "ottawa");

	String expectedInternal = "null->[(1,poffy),(11,gatineau),(21,white rock)]->null->null->null->[(5,mtl),(15,palo)]->[(26,ottawa)]->null->[(8,toronto)]->null";
	String actualInternal = hashTable.toString();
	assertThat(actualInternal).isEqualTo(expectedInternal);

	int expectedSize = 7;
	int actualSize = hashTable.getSize();
	assertThat(actualSize).isEqualTo(expectedSize);

	String expectedPrint = "[(1,poffy),(11,gatineau),(21,white rock)]->[(5,mtl),(15,palo)]->[(26,ottawa)]->[(8,toronto)]";
	String actualPrint = hashTable.print();
	assertThat(actualPrint).isEqualTo(expectedPrint);

    }
    
    @Test
    public void retrievingValuesWithKeysThatCollide() {
	HashTable2<Integer, String> hashTable = new HashTable2<>();

	hashTable.put(1, "poffy");
	hashTable.put(5, "mtl");
	hashTable.put(8, "toronto");
	hashTable.put(11, "gatineau");
	hashTable.put(21, "white rock");
	hashTable.put(15, "palo");
	hashTable.put(26, "ottawa");

	assertThat(hashTable.get(1)).isEqualTo("poffy");
	assertThat(hashTable.get(5)).isEqualTo("mtl");
	assertThat(hashTable.get(8)).isEqualTo("toronto");
	assertThat(hashTable.get(26)).isEqualTo("ottawa");
	assertThat(hashTable.get(9)).isNull();
	assertThat(hashTable.get(11)).isEqualTo("gatineau");
	assertThat(hashTable.get(21)).isEqualTo("white rock");
	assertThat(hashTable.get(15)).isEqualTo("palo");

    }
    
    @Test
    public void addingMultipleSimilarKeysShouldUpdateValue()
    {
	HashTable2<Integer, String> hashTable = new HashTable2<>();

	hashTable.put(1, "poffy");
	hashTable.put(5, "mtl");
	hashTable.put(8, "toronto");
	hashTable.put(11, "gatineau");
	hashTable.put(21, "white rock");
	hashTable.put(15, "palo");
	hashTable.put(26, "ottawa");
	hashTable.put(1, "poffy2");
	hashTable.put(5, "mtl2");
	hashTable.put(8, "toronto2");

	String expectedInternal = "null->[(1,poffy2),(11,gatineau),(21,white rock)]->null->null->null->[(5,mtl2),(15,palo)]->[(26,ottawa)]->null->[(8,toronto2)]->null";
	String actualInternal = hashTable.toString();
	assertThat(actualInternal).isEqualTo(expectedInternal);

	int expectedSize = 7;
	int actualSize = hashTable.getSize();
	assertThat(actualSize).isEqualTo(expectedSize);

	String expectedPrint = "[(1,poffy2),(11,gatineau),(21,white rock)]->[(5,mtl2),(15,palo)]->[(26,ottawa)]->[(8,toronto2)]";
	String actualPrint = hashTable.print();
	assertThat(actualPrint).isEqualTo(expectedPrint);
    }
    
}

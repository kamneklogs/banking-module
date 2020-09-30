package HashTableLibrary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Client;
import model.User;
import model.CashierModule.HashTableLibrary.MyHashtable;

class HashTableTest {

	MyHashtable<Integer, Client> myHashTable;

	public void setUp1() {
		myHashTable = new MyHashtable<Integer, Client>();
	}

	public void setUp2() {
		myHashTable = new MyHashtable<Integer, Client>();
		myHashTable.add(123, new Client("Camilo", 123, false, 0, 0, "29/9/2020", 0));
	}

	public void setUp3() {
		myHashTable = new MyHashtable<Integer, Client>();

		myHashTable.add(200, new Client("Andrea", 200, true, 322, 0, "29/09/2020", 0));
		myHashTable.add(100, new Client("Danna", 100, true, 322, 0, "29/09/2020", 0));
		myHashTable.add(50, new Client("Camilo", 50, false, 322, 0, "29/09/2020", 0));
	}

	/**
	 * Test the method isEmpty, where verifies in an empty hash table to check out
	 * if it's really empty, and in a non-empty hash table to check out it is not
	 * empty
	 */
	@Test
	public void isEmptyTest() {
		setUp1();
		assertTrue(myHashTable.isEmpty());

		setUp2();
		assertFalse(myHashTable.isEmpty());
	}

	/**
	 * Test the method get, which gives an element based on the key
	 */
	@Test
	public void getTest() {
		setUp3();

		assertEquals("Danna", myHashTable.get(100).getName());

	}

	/**
	 * Test method remove, which verifies in an empty hash table and removes
	 * something, so it returns null, and in a hast table with elements, wich
	 * returns the element removed
	 * 
	 */
	@Test
	public void removeTest() {
		setUp1();
		Client returned = myHashTable.remove(0);
		assertNull(returned);

		setUp3();
		Client removed = myHashTable.remove(50);
		assertEquals("Camilo", removed.getName());
	}
	
	
}

package LinkedListLibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import model.Client;
import model.CashierModule.LinkedListLibrary.MyDoublyLinkedList;


public class MyDoublyLinkedListTester {

	private static final int LONG_LIST_LENGTH = 10;

	MyDoublyLinkedList<Client> shortList; // 2
	MyDoublyLinkedList<Client> emptyList; // 0
	MyDoublyLinkedList<Client> longerList; // 10
	MyDoublyLinkedList<Client> list1; // 3

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
		shortList = new MyDoublyLinkedList<Client>();
		shortList.add(new Client("Andrea", 100, true, 100, 0, "29/9/2020", 0));
		shortList.add(new Client("Danna", 0, true, 100, 0, "29/9/2020", 0));
		emptyList = new MyDoublyLinkedList<Client>();
		longerList = new MyDoublyLinkedList<Client>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			longerList.add(new Client("Camilo", i, false, 200, 0, "29/9/2020", 0));
		}
		list1 = new MyDoublyLinkedList<Client>();
		list1.add(new Client("Andrea", 100, true, 100, 0, "29/9/2020", 0));
		list1.add(new Client("Danna", 0, true, 100, 0, "29/9/2020", 0));
		list1.add(new Client("Camilo", 20, true, 100, 0, "29/9/2020", 0));

	}

	/**
	 * Test if the get method is working correctly.
	 */
	
	@Test
	public void testGet() {
		// test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}

		// test short list, first contents, then out of bounds
		assertEquals("Check first", "Andrea", shortList.get(0).getName());
		assertEquals("Check second", "Danna", shortList.get(1).getName());

		try {
			shortList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		// test longer list contents
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			assertEquals("Check " + i + " element", i, longerList.get(i).getId());
		}

		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

	}

	/**
	 * Test removing an element from the list. We've included the example from the
	 * concept challenge. You will want to add more tests.
	 */
	@Test
	public void testRemove() {
		Client a = list1.remove(0);
		assertEquals("Remove: check a is correct ", "Andrea", a.getName());
		assertEquals("Remove: check element 0 is correct ", "Danna", list1.get(0).getName());
		assertEquals("Remove: check size is correct ", 2, list1.size());

		try {
			assertEquals((Integer) 1, longerList.remove(-1));
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException i) {

		}
		try {
			assertEquals(1, shortList.remove(-1));
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException i) {

		}
		try {
			assertEquals((Integer) 1, emptyList.remove(-1));
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException i) {

		}
		try {
			assertEquals((Integer) 1, list1.remove(-1));
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException i) {

		}
		// TODO: Add more tests here
	}

	/**
	 * Test adding an element into the end of the list, specifically public boolean
	 * add(E element)
	 */
	@Test
	public void testAddEnd() {
		// TODO: implement this test
		shortList.add(shortList.size, new Client("Andrea", 100, true, 100, 0, "29/9/2020", 0));
		assertEquals("Andrea", shortList.get(shortList.size() - 1).getName());
		emptyList.add(emptyList.size(), new Client("Andrea", 100, true, 100, 0, "29/9/2020", 0));
		assertEquals("Andrea", emptyList.get(emptyList.size() - 1).getName());
		longerList.add(longerList.size(), new Client("Andrea", 100, true, 100, 0, "29/9/2020", 0));
		assertEquals("Andrea", longerList.get(longerList.size() - 1).getName());
		list1.add(list1.size(), new Client("Andrea", 100, true, 100, 0, "29/9/2020", 0));
		assertEquals("Andrea", list1.get(list1.size() - 1).getName());

	}

	/** Test the size of the list */
	@Test
	public void testSize() {

		assertEquals(2, shortList.size());
		assertEquals(0, emptyList.size());
		assertEquals(10, longerList.size());
		assertEquals(3, list1.size());
	}

	

}

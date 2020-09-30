package QueueLibrary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;
import model.User;
import model.QueueModule.QueueLibrary.Queue;

class QueueTest {

	private Queue<User> myQueue;

	/**
	 * setUp limits
	 */

	public void setUp1() {
		myQueue = new Queue<User>();

		myQueue.enqueue(new User("Danna", 001, true, 0));

	}

	public void setUp2() {

		myQueue = new Queue<User>();

		myQueue.enqueue(new User("Danna", 001, true, 0));
		myQueue.enqueue(new User("Andrea", 002, true, 0));

	}

	@Test
	public void isEmptyTest() {
		setUp1();
		assertTrue(myQueue.isEmpty());
	}

	@Test
	public void sizeTest() {
		setUp1();
		assertEquals(1, myQueue.size);
	}

	/**
	 * Test limit case, verifies if the queue generates an Exception if it tries to
	 * delete an element of the queue when there's no element
	 */
	@Test
	public void dequeueTestLimits() {

		setUp1();
		myQueue.dequeue();

		assertNull(myQueue.front());

		assertThrows(NullPointerException.class, () -> myQueue.dequeue());
	}

	/**
	 * Test the dequeue method where the queue has two elements and verifies that
	 * the front is the one who remains when the another element was removed
	 */
	@Test
	public void dequeueTestCaseBase() {
		setUp2();
		myQueue.dequeue();

		assertEquals("Andrea", myQueue.front().getV().getName());
	}

	/**
	 * Test the enqueue method, it catchs a NullPointerException when a null element
	 * is tried to insert to the queue
	 */
	@Test
	public void enqueueTestInterestingCase() {
		setUp1();

		try {
			myQueue.enqueue(null);
			fail("check null pointer");

		} catch (NullPointerException e) {

		}

	}

	/**
	 * Test the enqueue method, it verifies that the last elemement enqueued it's
	 * the last element in the queue
	 */
	@Test
	public void enqueueLastTest() {
		setUp1();

		myQueue.enqueue(new User("Camilo", 8, false, 0));

		assertEquals("Camilo", myQueue.getLast().getV().getName());
	}

}

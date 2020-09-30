package PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.User;
import model.QueueModule.PriorityQueue.PriorityQueueHeap;

class PriorityQueueHeapTest {

	private PriorityQueueHeap myPriorityQueueHeap;

	public void setUp1() {
		myPriorityQueueHeap = new PriorityQueueHeap(10);
	}

	public void setUp2() {
		myPriorityQueueHeap = new PriorityQueueHeap(10);
		myPriorityQueueHeap.enqueue(new User("Andrea", 100, true, 0));
		myPriorityQueueHeap.enqueue(new User("Danna", 2, true, 2));
		myPriorityQueueHeap.enqueue(new User("Camilo", 4, false, 2));
		myPriorityQueueHeap.enqueue(new User("Cristhian", 6, false, 1));

	}

	public void setUp3() {
		myPriorityQueueHeap = new PriorityQueueHeap(10);
		myPriorityQueueHeap.enqueue(new User("Andrea", 100, true, 0));
		myPriorityQueueHeap.enqueue(new User("Danna", 2, true, 2));
		myPriorityQueueHeap.enqueue(new User("Camilo", 4, false, 3));
	}

	/**
	 * Test the enqueue method having into account that the first element in the
	 * array of the heap is in position 1. This priority queue has an initial length
	 * of 10 slots
	 * 
	 */
	@Test
	public void enqueueTest1() {
		setUp1();
		myPriorityQueueHeap.enqueue(new User("Andrea", 100, true, 0));

		assertEquals("Andrea", myPriorityQueueHeap.getHeap()[1].getName());
	}

	/**
	 * Test the enqueue method having into account that the User with highest
	 * priority is the one with special condition of 3 and the lowest priority is 0,
	 * so it verifies that the user whit priority 0 is in last place and the one
	 * with priority 3 is in first place.
	 */
	@Test
	public void enqueueTest2() {
		setUp2();
		assertEquals("Andrea", myPriorityQueueHeap.getHeap()[myPriorityQueueHeap.lastIndex].getName());

		myPriorityQueueHeap.enqueue(new User("Pinina", 4, false, 3));
		assertEquals("Pinina", myPriorityQueueHeap.getHeap()[1].getName());
	}

	/**
	 * Test the dequeue method having into account the this queue it's empty, so it
	 * should return null.
	 */
	@Test
	public void dequeueTest1() {
		setUp1();
		assertNull(myPriorityQueueHeap.dequeue());
	}

	/**
	 * Test the dequeue method having into account that it should dequeue the
	 * element with highest priority which is 3.
	 */
	@Test
	public void dequeueTest2() {
		setUp3();
		assertEquals("Camilo", myPriorityQueueHeap.dequeue().getName());
	}
}

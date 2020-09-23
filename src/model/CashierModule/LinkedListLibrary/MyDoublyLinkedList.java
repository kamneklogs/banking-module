package model.CashierModule.LinkedListLibrary;

import java.util.ArrayList;

public class MyDoublyLinkedList<E> implements IMyDoublyLinkedList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyDoublyLinkedList() {

		head = null;
		tail = null;
	}

	/**
	 * Appends an element to the end of the list
	 * 
	 * @param element The element to add
	 */
	@Override
	public boolean add(E element) throws NullPointerException {

		LLNode<E> theNew = new LLNode<E>(element);
		if (element == null) {
			throw new NullPointerException("cannot store nullpointers");
		} else if (head == null) {

			head = theNew;
			size++;

			/////
			LLNode<E> prevTail = null;
			LLNode<E> tailmine = head;
			while (tailmine != null) {
				prevTail = tailmine;
				tailmine = tailmine.next;
			}
			tail = prevTail;
			return true;
		} else {
			LLNode<E> temp = null;
			LLNode<E> temp1 = head;
			while (temp1 != null) {
				temp = temp1;
				temp1 = temp1.getNext();
			}
			temp.linkAfter(theNew);
			size++;

			////
			LLNode<E> prevTail = null;
			LLNode<E> tailmine = head;
			while (tailmine != null) {
				prevTail = tailmine;
				tailmine = tailmine.next;
			}
			tail = prevTail;

			return true;
		}

	}

	/**
	 * Get the element at position index
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */

	@Override
	public E get(int index) throws IndexOutOfBoundsException {

		if (index < this.size && index >= 0) {
			LLNode<E> goal = head;
			for (int i = 0; i < index; i++) {
				goal = goal.next;
			}
			return goal.data;
		} else {
			throw new IndexOutOfBoundsException("INDEXOUTOFBOUNDS");
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * 
	 * @param The     index where the element should be added
	 * @param element The element to add
	 */
	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException, NullPointerException {
		// TODO: Implement this method

		if (element == null) {
			throw new NullPointerException();
		} else {
			LLNode<E> nuevo = new LLNode<E>(element);
			if (index > size || index < 0) {
				throw new IndexOutOfBoundsException();
			} else {
				if (size == 0) {

					head = nuevo;
					size++;

					////
					LLNode<E> tailmine = head;
					while (tailmine != null) {
						tailmine = tailmine.next;
					}
					tail = tailmine;

				} else {
					int count = 0;
					LLNode<E> temp0 = null;
					LLNode<E> temp = head;
					while (count < index) {
						temp0 = temp;
						temp = temp.next;
						count++;
					}

					if (temp == null) {
						nuevo.next = temp0.next;
						nuevo.prev = temp0;
						temp0.next = nuevo;

						size++;

						////
						LLNode<E> prevTail = null;
						LLNode<E> tailmine = head;
						while (tailmine != null) {
							prevTail = tailmine;
							tailmine = tailmine.next;
						}
						tail = prevTail;
					} else {
						nuevo.next = temp;
						nuevo.prev = temp0;
						temp0.next = nuevo;
						temp.prev = nuevo;

						////

						size++;

						////
						LLNode<E> prevTail = null;
						LLNode<E> tailmine = head;
						while (tailmine != null) {
							prevTail = tailmine;
							tailmine = tailmine.next;
						}
						tail = prevTail;
					}
				}
			}
		}
	}

	/** Return the size of the list */
	@Override
	public int size() {

		return size;
	}

	/**
	 * Remove a node at the specified index and return its data element.
	 * 
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {

		E data;
		if (index > size - 1 || index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			int count = 0;
			LLNode<E> temp0 = null;
			LLNode<E> temp = head;

			while (count < index) {
				temp0 = temp;
				temp = temp.next;
				count++;
			}
			if (temp0 == null) {
				data = head.data;
				head = head.next;
				size--;

			} else {
				temp0.next = temp.next;
				temp0.next.prev = temp0;
				temp.next = null;
				temp.prev = null;
				data = temp.data;
				size--;
			}

		}
		return data;

	}

	/**
	 * Set an index position in the list to a new element
	 * 
	 * @param index   The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	@Override
	public E set(int index, E element) throws IndexOutOfBoundsException, NullPointerException {
		E data;
		if (index > size - 1 || index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (element == null) {
			throw new NullPointerException();
		} else {
			int count = 0;
			LLNode<E> temp0 = null;
			LLNode<E> temp = head;

			while (count < index) {
				temp0 = temp;
				temp = temp.next;
				count++;
			}
			if (temp0 == null) {
				data = head.data;
				head.data = element;

			} else {
				data = temp.data;
				temp.data = element;
			}

		}
		return data;
	}

	/**
	 * Generates an ArrayList with the data stored in the nodes of the linked list
	 * 
	 * @return an ArrayList with the data
	 */
	@Override
	public ArrayList<E> generateArrayList() {

		ArrayList<E> theaL = new ArrayList<E>();

		if (size == 0) {
			throw new NullPointerException();
		} else {
			LLNode<E> temp = head;
			while (temp != null) {
				theaL.add(temp.data);
				temp = temp.getNext();
			}
		}
		return theaL;
	}

}

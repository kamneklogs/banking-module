package model.CashierModule.LinkedListLibrary;

public class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	/**
	 * Create a new LLNode with its previous and its next element pointing to null
	 **/
	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	/**
	 * Returns the LLNode which this LLNode is currently pointing
	 * 
	 * @return LLNode next
	 */
	public LLNode<E> getNext() {
		return next;
	}

	/**
	 * Link after this LLNode a new LLNode
	 * 
	 * @param theNew which is the node to be added next to this one
	 */
	public void linkAfter(LLNode<E> theNew) {
		theNew.next = next;
		if (next != null)
			next.prev = theNew;
		theNew.prev = this;
		next = theNew;

	}
}

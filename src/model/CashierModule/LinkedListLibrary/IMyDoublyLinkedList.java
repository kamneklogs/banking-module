package model.CashierModule.LinkedListLibrary;

import java.util.ArrayList;

public interface IMyDoublyLinkedList<E extends Comparable> {

	public int size();

	public void add(int index, E element);

	public boolean add(E element);

	public E get(int index);

	public E remove(int index);

	public E set(int index, E element);

	public ArrayList<E> generateArrayList();
}

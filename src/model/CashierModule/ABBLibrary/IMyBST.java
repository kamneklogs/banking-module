package model.CashierModule.ABBLibrary;

import java.util.ArrayList;

public interface IMyBST<T extends Comparable> {

	public void addNode(T dato);

	public void removeNode(T dato);

	public NodeBST<T> searchNode(T dato);

	public int getHeight();

	public int getWeight();

	public boolean isEmpty();

	public void inOrden(NodeBST<T> n);

	public void preOrden(NodeBST<T> n);

	public void postOrden(NodeBST<T> n);

	public NodeBST<T> getRoot();

	public ArrayList<T> generateArrayList();

}

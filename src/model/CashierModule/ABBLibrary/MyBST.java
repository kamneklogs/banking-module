package model.CashierModule.ABBLibrary;

import java.util.ArrayList;

public class MyBST<T extends Comparable> implements IMyBST<T> {

	NodeBST<T> root;
	int size;

	public MyBST() {
		root = null;
	}

	@Override
	public void addNode(T dato) {
		NodeBST<T> nuevo = new NodeBST(dato);

		if (root == null)
			root = nuevo;
		else
			root.insertNode(nuevo);
		size++;
	}

	@Override
	public void removeNode(T dato) {
		root = root.remove(dato);
		size--;
	}

	@Override
	public NodeBST<T> searchNode(T dato) {
		return root == null ? null : root.search(dato);
	}

	@Override
	public int getHeight() {
		return root == null ? 0 : root.getHeight();
	}

	@Override
	public int getWeight() {
		return root == null ? 0 : root.getWeight();
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void inOrden(NodeBST<T> n) {
		if (n != null) {
			inOrden(n.getLeft());
			System.out.println(n.data + ", ");
			inOrden(n.getRight());
		}
	}

	@Override
	public void preOrden(NodeBST<T> n) {
		if (n != null) {
			System.out.println(n.data + ", ");
			inOrden(n.getLeft());

			inOrden(n.getRight());
		}
	}

	@Override
	public void postOrden(NodeBST<T> n) {
		if (n != null) {
			inOrden(n.getLeft());

			inOrden(n.getRight());
			System.out.println(n.data + ", ");
		}
	}

	@Override
	public NodeBST<T> getRoot() {
		return root;
	}

	@Override
	public ArrayList<T> generateArrayList() {

		if (root == null) {
			return null;
		} else {
			ArrayList<T> arrayL = new ArrayList<T>();
			root.inorden(arrayL);
			return arrayL;
		}

	}
}

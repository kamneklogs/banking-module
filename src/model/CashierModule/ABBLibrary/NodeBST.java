package model.CashierModule.ABBLibrary;

import java.util.ArrayList;

public class NodeBST<T extends Comparable> {
	NodeBST<T> right;
	NodeBST<T> left;
	T data;
	int repetitions;

	public NodeBST(T t) {
		this.data = t;
		this.right = null;
		this.left = null;
	}

	public NodeBST<T> getRight() {
		return right;
	}

	public NodeBST<T> getLeft() {
		return left;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	public int getHeight() {

		if (isLeaf())
			return 1;
		else {
			int a = (left == null) ? 0 : left.getHeight();
			int b = (right == null) ? 0 : right.getHeight();
			return 1 + Math.max(a, b);
		}
	}

	public int compareTo(Object n) {
		NodeBST<T> nodo = (NodeBST<T>) n;
		return data.compareTo(nodo.data);
	}

	public int getWeight() {
		int p1 = (left == null) ? 0 : left.getWeight();
		int p2 = (right == null) ? 0 : right.getWeight();
		return 1 + p1 + p2;
	}

	public void insertNode(NodeBST<T> nuevo) {

		if (compareTo(nuevo) > 0) {

			if (left == null)
				left = nuevo;
			else
				left.insertNode(nuevo);

		} else {
			if (right == null)
				right = nuevo;
			else
				right.insertNode(nuevo);
		}

		if (compareTo(nuevo) == 0) {
			repetitions++;
		}
	}

	public NodeBST<T> getLeast() {
		return (left == null) ? this : left.getLeast();
	}

	public NodeBST<T> getBiggest() {
		return (right == null) ? this : right.getLeast();

	}

	public NodeBST<T> search(T datoBuscado) {
		if (data.compareTo(datoBuscado) == 0)
			return this;
		else if (data.compareTo(datoBuscado) > 0)
			return (left == null) ? null : left.search(datoBuscado);
		else
			return (right == null) ? null : right.search(datoBuscado);
	}

	public NodeBST<T> remove(T unDato) {
		if (isLeaf() && data.compareTo(unDato) == 0)
			return null;
		if (data.compareTo(unDato) == 0) {
			if (left == null)
				return right;
			if (right == null)
				return left;

			NodeBST<T> sucesor = right.getLeast();
			right = right.remove(sucesor.data);

			sucesor.left = left;
			sucesor.right = right;
			return sucesor;
		} else if (data.compareTo(unDato) > 0)
			left = left.remove(unDato);
		else
			right = right.remove(unDato);
		return this;
	}

	public void inorden(ArrayList<T> totalAmount) {

		if (left != null)
			left.inorden(totalAmount);

		totalAmount.add(data);

		if (right != null)
			right.inorden(totalAmount);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(int repeticiones) {
		this.repetitions = repeticiones;
	}

	public void setRight(NodeBST<T> right) {
		this.right = right;
	}

	public void setLeft(NodeBST<T> left) {
		this.left = left;
	}

}

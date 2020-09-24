package datastructure;

import java.util.ArrayList;

public class MyHeap<T extends Comparable<T>> {

	private ArrayList<T> elements;

	public MyHeap() {
		elements = new ArrayList<T>();
	}

	private void goUp() {
		int k = elements.size() - 1;

		while (k > 0) {
			int p = (k - 1) / 2;
			T element = elements.get(k);
			T parent = elements.get(p);

			if (element.compareTo(parent) > 0) {

				// swap
				elements.set(k, parent);
				elements.set(p, element);

				k = p;

			} else {
				break;
			}
		}
	}

	public void insert(T element) {
		elements.add(element);
		goUp();
	}

	private void goDown() {
		int k = 0;
		int l = 2 * k + 1;
		while (l < elements.size()) {
			int max = l, r = l + 1;

			if (r < elements.size()) { // hay un hijo derecho
				if (elements.get(r).compareTo(elements.get(l)) > 0) {
					// cambiar
					T temp = elements.get(k);
					elements.set(k, elements.get(max));
					elements.set(max, temp);
					k = max;
					l = 2 * k + 1;
				}
			} else {
				break;
			}
		}
	}

	public T deleteElement() {
		if (elements.size() == 0) {

		}
		if (elements.size() == 1) {
			return elements.remove(0);
		}
		T hold = elements.get(0);
		elements.set(0, elements.remove(elements.size() - 1));
		goDown();
		return hold;
	}

}

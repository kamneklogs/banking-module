package model.QueueModule.PriorityQueue;

import model.User;

public class PriorityQueueHeap {

	private User[] heap;
	public int lastIndex;

	public PriorityQueueHeap(Integer size) {
		this.heap = new User[size];
		this.lastIndex = 0;
	}

	public void enqueue(User value) {
		if (lastIndex + 1 > heap.length - 1) {
			User[] tempHeap = heap;
			heap = new User[tempHeap.length * 2];

			for (int i = 0; i < tempHeap.length; i++) {
				heap[i] = tempHeap[i];
			}
		}
		lastIndex++;
		heap[lastIndex] = value;
		goUp();

	}

	private void goUp() {
		int index = lastIndex;
		int parentIndex = parent(index);

		while (parentIndex > 0 && heap[index].getSpecialCondition() > heap[parentIndex].getSpecialCondition()) {
			swap(index, parentIndex);
			index = parentIndex;
			parentIndex = parent(parentIndex);
		}
	}

	private void goDown() {

		int index = 1;

		while (index < lastIndex) {
			int maxValue = heap[index].getSpecialCondition();
			int maxIndex = index;

			int leftIndex = left(index);
			if (leftIndex > 0 && maxValue < heap[leftIndex].getSpecialCondition()) {
				maxValue = heap[leftIndex].getSpecialCondition();
				maxIndex = leftIndex;
			}
			int rightIndex = right(index);
			if (rightIndex > 0 && maxValue < heap[rightIndex].getSpecialCondition()) {
				maxValue = heap[rightIndex].getSpecialCondition();
				maxIndex = rightIndex;
			}

			if (maxIndex == index)
				break;

			swap(maxIndex, index);
			index = maxIndex;
		}
	}

	private int parent(int index) {
		if (index <= 1)
			return 0;
		return index / 2;
	}

	private int left(int index) {
		int leftChild = index * 2;
		return leftChild <= lastIndex ? leftChild : 0;
	}

	private int right(int index) {
		int rightChild = index * 2 + 1;
		return rightChild <= lastIndex ? rightChild : 0;
	}

	private void swap(int index1, int index2) {
		User temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}

	public User dequeue() {

		if (lastIndex <= 0)
			return null;

		User rootValue = heap[1];
		swap(1, lastIndex);
		heap[lastIndex]=null;

		lastIndex--;
		goDown();

		return rootValue;
	}

	public User[] getHeap() {
		return heap;
	}

	public void setHeap(User[] heap) {
		this.heap = heap;
	}

}

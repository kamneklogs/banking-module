package model.CashierModule.HeapSortLibrary;

import model.CashierModule.HeapSortLibrary.GenericArray.GenericArray;

public class HeapSort<V extends Comparable<V>> {

    private int n;

    private GenericArray<V> theArray;

    private void sort() {

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(theArray, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            V temp = theArray.get(0);
            theArray.set(0, theArray.get(i));
            theArray.set(i, temp);

            heapify(theArray, i, 0);
        }

    }

    private void heapify(GenericArray<V> a, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && a.get(left).compareTo(a.get(largest)) < 0) {
            largest = left;
        }

        if (right < n && a.get(right).compareTo(a.get(largest)) < 0) {
            largest = right;
        }

        if (largest != i) {
            V swap = a.get(i);
            a.set(i, a.get(largest));
            a.set(largest, swap);

            heapify(a, n, largest);
        }

    }

    public final GenericArray<V> sortArray(GenericArray<V> theArray) {
        this.theArray = theArray;
        n = theArray.length;
        sort();
        return theArray;
    }

}

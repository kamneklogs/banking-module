package HeapSort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Client;
import model.CashierModule.HeapSortLibrary.HeapSort;
import model.CashierModule.HeapSortLibrary.GenericArray.GenericArray;

class HeapSortTest {

	HeapSort<Client> myHeapSort;
	GenericArray<Client> myGenericArray;

	public void setUp1() {
		myHeapSort = new HeapSort<Client>();
		myGenericArray = new GenericArray<Client>(3);

		myGenericArray.set(0, new Client("Andrea", 100, true, 100, 0, "29/9/2020", 0));
		myGenericArray.set(1, new Client("Danna", 55, true, 100, 0, "29/9/2020", 0));
		myGenericArray.set(2, new Client("Camilo", 200, true, 100, 0, "29/9/2020", 0));

	}

	public void setUp2() {
		myGenericArray = new GenericArray<Client>(0);
		myHeapSort = new HeapSort<Client>();

	}

	public void setUp3() {
		myGenericArray = new GenericArray<Client>(9);
		myHeapSort = new HeapSort<Client>();


		myGenericArray.set(0, new Client("Andrea", 9, true, 100, 0, "29/9/2020", 0));
		myGenericArray.set(1, new Client("Danna", 8, true, 100, 0, "29/9/2020", 0));
		myGenericArray.set(2, new Client("Camilo", 7, true, 100, 0, "29/9/2020", 0));
		myGenericArray.set(3, new Client("Cristhian", 6, true, 100, 0, "29/9/2020", 0));
		myGenericArray.set(4, new Client("Pinina", 5, true, 100, 0, "29/9/2020", 0));
		myGenericArray.set(5, new Client("Niña", 4, true, 100, 0, "29/9/2020", 0));
		myGenericArray.set(6, new Client("Snow", 3, true, 100, 0, "29/9/2020", 0));
		myGenericArray.set(7, new Client("Max", 2, true, 100, 0, "29/9/2020", 0));
		myGenericArray.set(8, new Client("Lucy", 1, true, 100, 0, "29/9/2020", 0));
	}

	@Test
	public void sortTest1() {
		setUp1();
		myGenericArray = myHeapSort.sortArray(myGenericArray);

		assertEquals("Danna", myGenericArray.get(0).getName());
	}

	@Test
	public void sortTest2() {
		setUp2();
		GenericArray<Client> myGenericArray2 = myHeapSort.sortArray(myGenericArray);

		assertEquals(myGenericArray, myGenericArray2);

	}
	
	@Test
	public void sortTest3() {
		setUp3();
		
		myGenericArray = myHeapSort.sortArray(myGenericArray);

		assertEquals("Lucy", myGenericArray.get(0).getName());

	}
	@Test
	public void sortTest4() {
		setUp3();
		
		myGenericArray = myHeapSort.sortArray(myGenericArray);

		assertEquals("Andrea", myGenericArray.get(8).getName());

	}
}

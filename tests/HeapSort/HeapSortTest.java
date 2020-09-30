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
		myHeapSort= new HeapSort<Client>();
		myGenericArray= new GenericArray<Client>(3);
		
		myGenericArray.set(0, new Client("Andrea", 100, true, 100, 0, "29/9/2020", 0) );
		myGenericArray.set(1, new Client("Danna", 55, true, 100, 0, "29/9/2020", 0));
		myGenericArray.set(2, new Client("Camilo", 200, true, 100, 0, "29/9/2020", 0));

	}

	@Test
	public void sortTest() {
		setUp1();
		myGenericArray= myHeapSort.sortArray(myGenericArray);
		
		assertEquals("Danna", myGenericArray.get(0).getName());
	}
}

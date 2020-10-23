package ABBLibrary;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Client;
import model.CashierModule.ABBLibrary.MyBST;

class MyBSTTest {

	private MyBST<Client> myBst;

	public void setUp1() {
		myBst = new MyBST<Client>();
	}

	public void setUp2() {
		myBst = new MyBST<Client>();
		myBst.addNode(new Client("Andrea", 200, true, 322, 0, "29/09/2020", 0));
		myBst.addNode(new Client("Danna", 500, true, 322, 0, "29/09/2020", 0));
		myBst.addNode(new Client("Camilo", 100, true, 322, 0, "29/09/2020", 0));

	}

	/**
	 * Test the addNode method in a BST that is empty, it verifies that the root,
	 * the left children and the right children are added in the right position
	 */
	@Test
	public void addNodeTest1() {
		setUp1();
		myBst.addNode(new Client("Andrea", 200, true, 322, 0, "29/09/2020", 0));
		myBst.addNode(new Client("Danna", 500, true, 322, 0, "29/09/2020", 0));
		myBst.addNode(new Client("Camilo", 100, true, 322, 0, "29/09/2020", 0));

		assertEquals("Andrea", myBst.getRoot().getData().getName());
		assertEquals("Danna", myBst.getRoot().getRight().getData().getName());
		assertEquals("Camilo", myBst.getRoot().getLeft().getData().getName());

	}

	@Test
	public void addNodeTest2() {
		setUp2();
		myBst.addNode(new Client("Cristhian", 500, true, 322, 0, "29/09/2020", 0));

		assertEquals(4, myBst.size);
	}

	/**
	 * Test the removeNode method, first adding a node into the tree and then
	 * removing it, verifying that the size.
	 */
	@Test
	public void removeNodeTest() {
		setUp1();
		Client c = new Client("Andrea", 200, true, 322, 0, "29/09/2020", 0);
		myBst.addNode(c);
		assertEquals(1, myBst.size);
		myBst.removeNode(c);
		assertEquals(0, myBst.size);

	}

	/**
	 * Test the searchNode method verifying in a empty tree, it should return null
	 */
	@Test
	public void searchNodeTest() {
		setUp1();
		Client c = new Client("Andrea", 200, true, 322, 0, "29/09/2020", 0);

		assertNull(myBst.searchNode(c));
	}

	/**
	 * Test the searchNode method verifying in a non-empty tree, so it should return
	 * the element
	 */

	@Test
	public void searchNodeTest1() {
		setUp1();
		Client c = new Client("Andrea", 200, true, 322, 0, "29/09/2020", 0);
		myBst.addNode(c);

		assertEquals(c, myBst.searchNode(c).getData());
	}

	
	@Test
	public void isEmptyTest() {
		setUp1();

		assertTrue(myBst.isEmpty());
	}

	@Test
	public void isEmptyTest1() {
		setUp2();
		assertFalse(myBst.isEmpty());
	}
}

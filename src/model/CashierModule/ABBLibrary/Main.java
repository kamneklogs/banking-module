package model.CashierModule.ABBLibrary;

import java.util.Date;

import model.Client;

public class Main {

	public static void main(String[] args) {

		MyBST<Client> c = new MyBST<Client>();

		c.addNode(new Client("Andrea", 1010, 999, 999, new Date(), new Date(), 0));

		System.out.println(c.root);
		c.addNode(new Client("Danna", 1, 999, 000, new Date(), new Date(), 0));
		System.out.println(c.root.getLeft().getData().getName());
		System.out.println(c.root.getRight());

		c.addNode(new Client("Camilo", 1200, 000, 000, new Date(), new Date(), 0));

		System.out.println(c.root.getRight().getData().getName());

		System.out.println(c.generateArrayList().get(2).getName());

		NodeBST a = c.searchNode(c.getRoot().getData());
		System.out.println(a.getData());
	}

}

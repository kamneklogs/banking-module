package model.CashierModule.LinkedListLibrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import model.Client;

public class Main {

	public static void main(String[] args) {

		MyDoublyLinkedList<Client> c = new MyDoublyLinkedList<Client>();

		c.add(new Client("Andrea", 1010, 999, 999, new Date(), new Date(), 0));
		c.add(new Client("Danna", 1, 999, 000, new Date(), new Date(), 0));
		c.add(new Client("Camilo", 1200, 000, 000, new Date(), new Date(), 0));

		ArrayList<Client> ac = new ArrayList<Client>();

		ac = c.generateArrayList();

		Collections.sort(ac);

		System.out.println(ac.get(2).getName());
	}

}

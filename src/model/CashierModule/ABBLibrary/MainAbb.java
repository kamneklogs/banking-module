package model.CashierModule.ABBLibrary;

import model.Client;

public class MainAbb {

	public static void main(String[] args) {

		MyBST<Client> b = new  MyBST<Client>();
		
		Client andrea = new Client("Andrea", 11, false, 0, 0, " hoy" , 0);
		b.addNode(andrea);
		
		b.addNode(new Client("Danna", 10, false, 0, 0, " hoy" , 0));
		
		b.addNode(new Client("Camilo", 9, false, 0, 0, " hoy" , 0));

		
		System.out.println(b.root.data.getName());
		b.removeNode(andrea);
		System.out.println(b.root.data.getName());
	}

}

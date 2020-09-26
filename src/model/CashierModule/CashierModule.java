package model.CashierModule;

import java.util.ArrayList;
import java.util.Date;

import model.Client;
import model.User;
import model.CashierModule.ABBLibrary.IMyBST;
import model.CashierModule.HashTableLibrary.IMyHashtable;
import model.CashierModule.HashTableLibrary.MyHashtable;
import model.CashierModule.HeapSortLibrary.HeapSort;
import model.CashierModule.HeapSortLibrary.GenericArray.GenericArray;
import model.CashierModule.LinkedListLibrary.IMyDoublyLinkedList;
import model.CashierModule.LinkedListLibrary.MyDoublyLinkedList;

public class CashierModule {

	private User current, next;

	private IMyHashtable<Integer, Client> dataBasePartitionA;
	private IMyBST<Client> dataBasePartitionB;
	private IMyDoublyLinkedList<Client> dataBasePartitionC;
	private ArrayList<Client> dataBasePartitionD;

	public CashierModule() {
		dataBasePartitionA = new MyHashtable<Integer, Client>();

		dataBasePartitionC = new MyDoublyLinkedList<Client>();
		dataBasePartitionD = new ArrayList<Client>();
	}

	public User getCurrent() {
		return current;
	}

	public void setCurrent(User current) {
		this.current = current;
	}

	public User getNext() {
		return next;
	}

	public void setNext(User next) {
		this.next = next;
	}

	public void signUpClient(User theNew, double balance, double creditQuota, Date datePayC, Date registrationDate,
			int specialCondition) {

		// Partition A: Hash Table
		if (theNew.getId() >= 0 && theNew.getId() < 250) {
			addClientToPartitionA(new Client(theNew.getName(), theNew.getId(), theNew.isGender(), balance, creditQuota, datePayC,
					registrationDate, specialCondition));

			// Partition B: ABB
		} else if (theNew.getId() >= 250 && theNew.getId() < 500) {

			addClientToPartitionB(new Client(theNew.getName(), theNew.getId(), theNew.isGender(), balance, creditQuota, datePayC,
					registrationDate, specialCondition));
			// Partition C: LinkedList
		} else if (theNew.getId() >= 500 && theNew.getId() < 750) {
			addClientToPartitionC(new Client(theNew.getName(), theNew.getId(), theNew.isGender(), balance, creditQuota, datePayC,
					registrationDate, specialCondition));

			// Partition D: Heaps
		} else {
			addClientToPartitionD(new Client(theNew.getName(), theNew.getId(), theNew.isGender(), balance, creditQuota, datePayC,
					registrationDate, specialCondition));
		}

	}

	private void addClientToPartitionA(Client theNewClient) {

		dataBasePartitionA.add(theNewClient.getId(), theNewClient);

	}

	private void addClientToPartitionB(Client theNewClient) {

		dataBasePartitionB.addNode(theNewClient);
	}

	private void addClientToPartitionC(Client theNewClient) {
		dataBasePartitionC.add(theNewClient);
	}

	private void addClientToPartitionD(Client theNewClient) {
		dataBasePartitionD.add(theNewClient);
	}

	public ArrayList<Client> unifyClients() {
		ArrayList<Client> allClients = new ArrayList<Client>();

		allClients.addAll(dataBasePartitionA.generateArrayList());

		allClients.addAll(dataBasePartitionB.generateArrayList());

		// linked list

		HeapSort<Client> hS = new HeapSort<Client>();

		GenericArray<Client> clients = new GenericArray<Client>(dataBasePartitionD.size());

		for (int i = 0; i < dataBasePartitionD.size(); i++) {
			clients.set(i, dataBasePartitionD.get(i));
		}

		clients = hS.sortArray(clients);

		dataBasePartitionD.clear();
		for (int i = 0; i < clients.length; i++) {
			dataBasePartitionD.add(clients.get(i));
		}

		allClients.addAll(dataBasePartitionD);

		return allClients;
	}

	public Client searchClient(int id) {
		return dataBasePartitionA.get(id);

	}

	public boolean deleteClientAccount(int id) {

		if (dataBasePartitionA.remove(id) == null) {
			return false;
		} else {
			return true;
		}
	}

	public void doPay(int idUser, double amount) {

		Client c = searchClient(idUser);
		c.setBalance(c.getBalance() + amount);
	}

}
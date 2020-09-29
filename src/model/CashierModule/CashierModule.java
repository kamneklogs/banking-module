package model.CashierModule;

import java.util.ArrayList;
import java.util.Date;

import model.Client;
import model.User;
import model.CashierModule.ABBLibrary.IMyBST;
import model.CashierModule.ABBLibrary.MyBST;
import model.CashierModule.HashTableLibrary.IMyHashtable;
import model.CashierModule.HashTableLibrary.MyHashtable;
import model.CashierModule.HeapSortLibrary.HeapSort;
import model.CashierModule.HeapSortLibrary.GenericArray.GenericArray;
import model.CashierModule.LinkedListLibrary.IMyDoublyLinkedList;
import model.CashierModule.LinkedListLibrary.MyDoublyLinkedList;

public class CashierModule {

	private User current;

	private IMyHashtable<Integer, Client> dataBasePartitionA;
	private IMyBST<Client> dataBasePartitionB;
	private IMyDoublyLinkedList<Client> dataBasePartitionC;
	private ArrayList<Client> dataBasePartitionD;
	private ArrayList<Client> desertersClients;
	ArrayList<Client> allClients;

	public CashierModule() {
		dataBasePartitionA = new MyHashtable<Integer, Client>();
		dataBasePartitionB = new MyBST<Client>();
		dataBasePartitionC = new MyDoublyLinkedList<Client>();
		dataBasePartitionD = new ArrayList<Client>();
		allClients = new ArrayList<Client>();
		desertersClients = new ArrayList<Client>();
	}

	public User getCurrent() {

		return current;

	}

	public void setCurrent(User current) {

		this.current = current;

	}

	public void signUpClient(User theNew, double balance, double creditQuota, String today, int specialCondition) {

		Client tN = new Client(theNew.getName(), theNew.getId(), theNew.isGender(), balance, creditQuota, today,
				specialCondition);

		// Partition A: Hash Table
		if (theNew.getId() >= 0 && theNew.getId() < 250) {
			addClientToPartitionA(tN);

			// Partition B: ABB
		} else if (theNew.getId() >= 250 && theNew.getId() < 500) {

			addClientToPartitionB(tN);
			// Partition C: LinkedList
		} else if (theNew.getId() >= 500 && theNew.getId() < 750) {
			addClientToPartitionC(tN);

			// Partition D: ArrayList
		} else {
			addClientToPartitionD(tN);
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

		allClients.clear();

		allClients.addAll(dataBasePartitionA.generateArrayList());

		allClients.addAll(dataBasePartitionB.generateArrayList());

		// linked list
		allClients.addAll(dataBasePartitionC.generateArrayList());

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

		unifyClients();

		for (int i = 0; i < allClients.size(); i++) {
			if (allClients.get(i).getId() == id) {
				return allClients.get(i);
			}
		}

		return null;

	}

	public boolean deleteClientAccount(int id) {

		desertersClients.add(searchClient(id));

		// Partition A: Hash Table
		if (id >= 0 && id < 250) {

			dataBasePartitionA.remove(id);

			// Partition B: ABB
		} else if (id >= 250 && id < 500) {

			dataBasePartitionB.removeNode(searchClient(id));
			// Partition C: LinkedList
		} else if (id >= 500 && id < 750) {

			dataBasePartitionC.remove(id);

		} else {

			for (int i = 0; i < dataBasePartitionD.size(); i++) {
				if (dataBasePartitionD.get(i).getId() == id) {
					dataBasePartitionD.remove(i);
					i = dataBasePartitionD.size();

				}
			}

		}

		for (int i = 0; i < allClients.size(); i++) {
			if (allClients.get(i).getId() == id) {
				allClients.remove(i);
			}
		}

		return true;

	}

	public void doPay(int idUser, double amount) {

		Client c = searchClient(idUser);
		c.setBalance(c.getBalance() + amount);
	}

	public ArrayList<Client> getDesertersClients() {
		return desertersClients;
	}

	public void setDesertersClients(ArrayList<Client> desertersClients) {
		this.desertersClients = desertersClients;
	}

}
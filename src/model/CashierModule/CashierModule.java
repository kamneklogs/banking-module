package model.CashierModule;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import model.Client;
import model.User;
import model.CashierModule.HashTableLibrary.IMyHashtable;
import model.CashierModule.HashTableLibrary.MyHashtable;

public class CashierModule {

	private User current, next;
	private ArrayList<Client> allClients;

	private IMyHashtable<Integer, Client> dataBasePartitionA;

	public CashierModule() {
		allClients = new ArrayList<Client>();
		dataBasePartitionA = new MyHashtable<Integer, Client>();
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
			addClientToPartitionA(new Client(theNew.getName(), theNew.getId(), balance, creditQuota, datePayC,
					registrationDate, specialCondition));

			// Partition B: ABB
		} else if (theNew.getId() >= 250 && theNew.getId() < 500) {

			// Partition C: LinkedList
		} else if (theNew.getId() >= 500 && theNew.getId() < 750) {

			// Partition D: Heaps
		} else {

		}

	}

	private void addClientToPartitionA(Client theNewClient) {

		dataBasePartitionA.add(theNewClient.getId(), theNewClient);

	}

	public ArrayList<Client> unifyClients() {
		ArrayList<Client> allClients = new ArrayList<Client>();

		allClients.addAll(dataBasePartitionA.generateArrayList());
		

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

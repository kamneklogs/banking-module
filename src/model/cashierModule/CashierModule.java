package model.cashierModule;

import java.util.Date;

import model.Client;
import model.User;
import model.cashierModule.HashTableLibrary.IMyHashtable;
import model.cashierModule.HashTableLibrary.MyHashtable;

public class CashierModule {

	private User current, next;
	
	private IMyHashtable<String, Client> dataBasePartitionA; 

	public CashierModule() {
		dataBasePartitionA= new MyHashtable<String, Client>();
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
		
			//Partition A: Hash Table
			if(Integer.parseInt(theNew.getId()) >= 0 && Integer.parseInt(theNew.getId()) < 250){
				dataBasePartitionA.add(theNew.getId(), 
				new Client(theNew.getName(),theNew.getId(),balance, creditQuota, datePayC,registrationDate,specialCondition));
			//Partition B: ABB
			} else if (Integer.parseInt(theNew.getId())>= 250 && Integer.parseInt(theNew.getId()) < 500){

			//Partition C: LinkedList
			} else if (Integer.parseInt(theNew.getId()) >= 500 && Integer.parseInt(theNew.getId()) < 750){

			//Partition D: Heaps
			} else{

			}

		
		
		
	
	}
	public Client searchClient(String id) {
	return	dataBasePartitionA.get(id);
		
	}
	public boolean deleteClientAccount(String id) {
		
		if(dataBasePartitionA.remove(id)==null) {
			return false;
		}else {
			return true;
		}
	}
	
	public void doPay(String idUser, double amount) {
		
		Client c= searchClient(idUser);
		c.setBalance(c.getBalance()+amount);
	}
	
	
	
}

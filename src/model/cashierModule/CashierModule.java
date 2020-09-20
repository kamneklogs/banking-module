package model.cashierModule;

import java.util.Date;

import model.Client;
import model.User;
import model.cashierModule.HashTableLibrary.IMyHashtable;
import model.cashierModule.HashTableLibrary.MyHashtable;

public class CashierModule {

	private User current, next;
	
	private IMyHashtable<String, Client> dataBaseClients;

	public CashierModule() {
		dataBaseClients= new MyHashtable<String, Client>();
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
            boolean specialCondition) {
		dataBaseClients.add(theNew.getId(), 
				new Client(theNew.getName(),theNew.getId(),balance, creditQuota, datePayC,registrationDate,specialCondition));
		
		
	
	}
	public Client searchClient(String id) {
	return	dataBaseClients.get(id);
		
	}
	public boolean deleteClientAccount(String id) {
		
		if(dataBaseClients.remove(id)==null) {
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

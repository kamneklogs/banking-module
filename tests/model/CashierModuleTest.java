package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.CashierModule.CashierModule;

class CashierModuleTest {

	private CashierModule cashierModule;
	
	
	public void setUp1() {
		cashierModule= new CashierModule();
		
	}
	
	public void setUp2() {
		cashierModule = new CashierModule();
		cashierModule.signUpClient(new User("Andrea", 001, true, 0), 322, 0, "29/09/2020", 0);
		cashierModule.signUpClient(new User("Danna", 257, true, 2), 2, 3, "29/07/2020", 2);
		cashierModule.signUpClient(new User("Camilo", 999, false, 0), 10000, 0, "29/09/2020", 0);
		cashierModule.signUpClient(new User("Aristizabal", 666, true, 0), 0, 0, "29/09/2020", 0);
		
		cashierModule.unifyClients();
	}

	@Test
	public void signUpClientTest() {
		setUp1();
		
		cashierModule.signUpClient(new User("Andrea", 001, true, 0), 322, 0, "29/09/2020", 0);
		cashierModule.signUpClient(new User("Danna", 257, true, 2), 2, 3, "29/07/2020", 2);
		cashierModule.signUpClient(new User("Camilo", 999, false, 0), 10000, 0, "29/09/2020", 0);
		cashierModule.signUpClient(new User("Aristizabal", 666, true, 0), 0, 0, "29/09/2020", 0);
		
		assertEquals("Danna", cashierModule.searchClient(257).getName());
		assertEquals("Andrea", cashierModule.searchClient(001).getName());
		assertEquals("Camilo", cashierModule.searchClient(999).getName());
		assertEquals("Aristizabal", cashierModule.searchClient(666).getName());


	}
	
	@Test
	public void unifyClientTest() {
		setUp2();
		
		ArrayList<Client> c = new ArrayList<Client>();
		c.add(new Client("Andrea", 001, true, 0, 322, "29/09/2020", 0));
		c.add(new Client("Danna", 257, true, 2, 3, "29/07/2020", 2));
		c.add(new Client("Aristizabal", 666, true, 0, 0, "29/09/2020", 0));
		c.add(new Client("Camilo", 999, false, 10000, 0, "29/09/2020", 0));
		
		
		boolean equals=true;
		
		for(int i=0; i<c.size();i++) {
			if(c.get(i).getName().equalsIgnoreCase(cashierModule.getAllClients().get(i).getName())) {
				equals=true;
			}else {
				equals=false;
			}
		}
		assertEquals(true, equals);
	}
	
	@Test
	public void searchTest() {
		setUp2();
		
		Client searched= cashierModule.searchClient(666);
		
		assertEquals("Aristizabal", searched.getName());
	}
	
	@Test
	public void deleteClientAccountTest() {
		setUp2();

		boolean removed= cashierModule.deleteClientAccount(999);
		assertEquals(true, removed);
	}

}





























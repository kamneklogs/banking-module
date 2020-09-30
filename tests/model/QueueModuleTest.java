package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.QueueModule.QueueModule;

class QueueModuleTest {


	private QueueModule qm;
	
	public void setUp1() {
		qm= new QueueModule();
	}

	public void setUp2() {
		qm= new QueueModule();

		qm.receivePerson(new User("Andrea", 001, true, 0));
		qm.receivePerson(new User("Danna", 005, true, 0));
		qm.receivePerson(new User("Camilo", 888, true, 2));


	}
	@Test
	public void receivePersonTest() {
		setUp1();
		qm.receivePerson(new User("Andrea", 001, true, 0));
		
		assertEquals("Andrea", qm.getCurrenWithoutPriority().getName());
		
		qm.receivePerson(new User("Danna", 999, true, 3));
		
		assertEquals("Danna", qm.getCurrentWithPriority().getName());
	}
	
}

package model.CashierModule.HeapSortLibrary;

import model.User;

public class Main {

	public static void main(String[] args) {

		MyHeap mh = new MyHeap();
		
		mh.insert(new User("Andrea", 1010, 0));	
		mh.insert(new User("Dana", 1010, 1));
		mh.insert(new User("Camilo", 1010, 2));
		mh.insert(new User("Nunez", 1010, 5));
//		mh.insert(new User("Garcia",1010, 0));
//		mh.insert(new User("Gutierrez", 1010, 3));
		
		
		System.out.println(mh.getElements().get(0).getName());
		System.out.println(mh.getElements().get(1).getName());
		System.out.println(mh.getElements().get(2).getName());
		System.out.println(mh.getElements().get(3).getName());
//		System.out.println(mh.getElements().get(4).getName());
//		System.out.println(mh.getElements().get(5).getName());



	}

}

package model.CashierModule.HeapSortLibrary;
import model.*;
import java.util.ArrayList;

public class MyHeap {

	private ArrayList<User> elements;
	
	public MyHeap() {
		elements= new ArrayList<User>();
	}
	
	
	public ArrayList<User> getElements() {
		return elements;
	}


	public void setElements(ArrayList<User> elements) {
		this.elements = elements;
	}


	private void goUp() {
		int k = elements.size()-1;
		while(k>0) {
			int p=(k-1)/2;
			User element = elements.get(k);
			
			User parent= elements.get(p);
			if(element.getSpecialCondition()>parent.getSpecialCondition()) { //si el elemento es mayor al padre
				//swap
				elements.set(k,parent);
				elements.set(p, element);
				
				//nos movemos un nivel hacia arriba
				k= p;
			}else {
				break;
			}
		}
	}
	
	public void insert(User element) {
		elements.add(element);
		goUp();
	}
	
	private void goDown() {
		int k=0;
		int l=2*k+1; //hijo izquierdo
		
		while(l<elements.size()) {
			int max=l;
			int r=l+1;
			if(r<elements.size()) { //hay un hijo drecho
				if(elements.get(r).compareTo2(elements.get(l))>0) {
					//switch
					User temp = elements.get(k);
					elements.set(k, elements.get(max));
					elements.set(max, temp);
					k=max;
					l=2*k+1;
				}
			}else {
				break;
			}
		}
	}
	public User delete() {
		if(elements.size()==0) {
			throw new NullPointerException();
		}
		if(elements.size()==1) {
			return elements.remove(0);
		}
		User hold= elements.get(0);
		elements.set(0, elements.remove(elements.size()-1));
		goDown();
		return hold;
	}
	
	public int size() {
		return elements.size();
	}
	
	public String toString() {
		return elements.toString();
	}
}

package model.QueueModule;

import model.User;
import model.CashierModule.HeapSortLibrary.MyHeap;
import model.QueueModule.QueueLibrary.*;

public class QueueModule {

    public IQueue<User> simpleQueue;
    private MyHeap priorityQueue;
    private User current, next;

    public QueueModule() {
        simpleQueue = new Queue<User>();
        priorityQueue= new MyHeap();
    }

    public boolean receivePerson(User u) {

        if (u.getSpecialCondition() != 0) {
            priorityQueue.insert(u);
        } else {

            simpleQueue.enqueue(u);

            if (simpleQueue.getLast().getV() == u) {
                return true;
            } else {
                return false;
            }

        }

        return true;
    }

    public String[] returnQueue(){
        String msgSimpleQueue = "";
        String msgPriorityQueue = "";
        for(int i = 0; i < simpleQueue.getSize(); i++){
            int chose = (int) (Math.random() * (3 - 1) + 1);
            if(chose == 1){
                // Hombre
                msgSimpleQueue = "\uD83D\uDC71\u200D\u2642\uFE0F";
                
            } else{
                // Mujer
                msgSimpleQueue = "\uD83D\uDEB6\u200D\u2640\uFE0F";
            }
        }
        for(int i = 0; i < priorityQueue.getElements().size(); i++){
            switch(priorityQueue.getElements().get(i).getSpecialCondition()){
                case 1:
                    msgPriorityQueue += "\uD83D\uDC68\u200D\uD83E\uDDAF";
                    break;
                case 2:
                    msgPriorityQueue += "\uD83D\uDC68\u200D\uD83E\uDDBD";
                    break;
                case 3:
                    msgPriorityQueue += "\uD83E\uDD30";
                    break;
            }
        }
        String[] arreglo = new String[2];
        arreglo[0] = msgSimpleQueue;
        arreglo[1] = msgPriorityQueue;
        return arreglo;
    }

    public IQueue<User> getSimpleQueue() {
        return simpleQueue;
    }

    public void setSimpleQueue(IQueue<User> simpleQueue) {
        this.simpleQueue = simpleQueue;
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

}
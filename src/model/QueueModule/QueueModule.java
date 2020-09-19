package model.QueueModule;

import model.User;
import model.QueueModule.QueueLibrary.*;

public class QueueModule {

    private IQueue<User> simpleQueue;
    private Object priorityQueue;
    private User current, next;

    public QueueModule() {
        simpleQueue = new Queue<User>();
    }

    public boolean receivePerson(User u) {

        if (u.isSpecialCondition()) {
            priorityQueue = null;
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
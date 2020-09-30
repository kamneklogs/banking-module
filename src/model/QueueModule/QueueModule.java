package model.QueueModule;

import model.User;
import model.QueueModule.PriorityQueue.PriorityQueueHeap;
import model.QueueModule.QueueLibrary.*;

public class QueueModule {

    public IQueue<User> simpleQueue;
    public PriorityQueueHeap priorityQueue;
    public int countSimpleQueue, countPriorityQueue;

    public QueueModule() {
        simpleQueue = new Queue<User>();
        priorityQueue = new PriorityQueueHeap(100);
    }

    public boolean receivePerson(User u) {

        if (u.getSpecialCondition() != 0) {
            priorityQueue.enqueue(u);
            countPriorityQueue++;

        } else {

            simpleQueue.enqueue(u);
            countSimpleQueue++;

            if (simpleQueue.getLast().getV() == u) {
                return true;
            } else {
                return false;
            }

        }

        return true;
    }

    public String[] getCurrentState() {
        String[] msgs = new String[2];
        msgs[0] = "";
        msgs[1] = "";
        Element temp = simpleQueue.front();
        for (int i = 0; i < simpleQueue.getSize(); i++) {
        
            if (((User) temp.getV()).isGender()) {
                // Mujer
                msgs[0] += "\uD83D\uDC69\u200D\uD83E\uDDB1";

            } else {
                // Hombre
                msgs[0] += "\uD83D\uDC71\u200D\u2642\uFE0F";
            }
            temp = temp.getNextElement();
        }
        for (int i = 1; i <= priorityQueue.lastIndex; i++) {
            switch (priorityQueue.getHeap()[i].getSpecialCondition()) {

                case 1:
                    msgs[1] += "\uD83D\uDC68\u200D\uD83E\uDDAF";
                    break;
                case 2:
                    msgs[1] += "\uD83D\uDC68\u200D\uD83E\uDDBD";
                    break;
                case 3:
                    msgs[1] += "\uD83D\uDC69\u200D\uD83C\uDF7C";
                    break;

            }
        }
        return msgs;
    }

    public String returnQueue(int opcion) {
        String msgReturn = "";
        if (opcion == 0) {
            for (int i = 0; i < simpleQueue.getSize(); i++) {
                if (simpleQueue.getLast().getV().isGender()) {
                    // Mujer
                    msgReturn = "\uD83D\uDC69\u200D\uD83E\uDDB1";

                } else {
                    // Hombre
                    msgReturn = "\uD83D\uDC71\u200D\u2642\uFE0F";
                }
            }
        } else {
            for (int i = 1; i <= priorityQueue.lastIndex; i++) {

                switch (priorityQueue.getHeap()[i].getSpecialCondition()) {

                    case 1:
                        msgReturn += "\uD83D\uDC68\u200D\uD83E\uDDAF";
                        break;
                    case 2:
                        msgReturn += "\uD83D\uDC68\u200D\uD83E\uDDBD";
                        break;
                    case 3:
                        msgReturn += "\uD83D\uDC69\u200D\uD83C\uDF7C";
                        break;

                }

            }

        }
        return msgReturn;
    }

    public IQueue<User> getSimpleQueue() {
        return simpleQueue;
    }

    public void setSimpleQueue(IQueue<User> simpleQueue) {
        this.simpleQueue = simpleQueue;
    }

    public User getCurrentWithPriority() {
        User temp = priorityQueue.getHeap()[1];

        dequeueCurrentWithPriority();
        countPriorityQueue--;
        return temp;
    }

    public User getCurrentWithPriority2() {
        User temp = priorityQueue.getHeap()[1];
        return temp;
    }

    public User getCurrenWithoutPriority() {

        User temp = simpleQueue.front().getV();

        dequeueCurrentWithoutPriority();
        countSimpleQueue--;
        return temp;
    }

    public User getCurrenWithoutPriority2() {
        if (simpleQueue.front() != null) {
            User temp = simpleQueue.front().getV();
            return temp;
        } else {
            return null;
        }
    }

    private void dequeueCurrentWithoutPriority() {

        simpleQueue.dequeue();

    }

    private void dequeueCurrentWithPriority() {

        priorityQueue.dequeue();

    }

}
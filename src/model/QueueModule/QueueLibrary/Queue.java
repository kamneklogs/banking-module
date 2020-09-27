package model.QueueModule.QueueLibrary;

public class Queue<V> implements IQueue<V> {

    private Element<V> first, last;
    public int size;

    public Queue() {
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return first == null;
    }

    @Override
    public void enqueue(V item) {
        // TODO Auto-generated method stub
        Element<V> theE = new Element<V>();
        theE.setV(item);

        if (isEmpty()) {
            first = theE;
            last = theE;
        } else {
            last.setNextElement(theE);
            last = theE;
        }
        size = size + 1;
    }

    @Override
    public Element<V> front() {
        // TODO Auto-grated method stub
        return first;
    }

    @Override
    public Element<V> dequeue() {
        Element<V> theE = first;
        first = first.getNextElement();
        size = size - 1;
        return theE;
    }

    @Override
    public Element<V> getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

}

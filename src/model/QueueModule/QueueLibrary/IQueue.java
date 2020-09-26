package model.QueueModule.QueueLibrary;

public interface IQueue<V> {

    public int getSize();

    public boolean isEmpty();

    public void enqueue(V item);

    public Element<V> front();

    public Element<V> dequeue();

    public Element<V> getLast();
}
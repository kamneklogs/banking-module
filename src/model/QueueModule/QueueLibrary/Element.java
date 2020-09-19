package model.QueueModule.QueueLibrary;

public class Element<V> {
    
    private V v;
    private Element<V> nextElement;

    public Element() {
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public Element<V> getNextElement() {
        return nextElement;
    }

    public void setNextElement(Element<V> nextElement) {
        this.nextElement = nextElement;
    }

}
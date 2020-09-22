package model.CashierModule.HashTableLibrary;

public class Element<K, V> {
    private K key;
    private V value;
    private Element<K, V> next;

    public Element(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Element<K, V> getNext() {
        return next;
    }

    public void setNext(Element<K, V> next) {
        this.next = next;
    }

}
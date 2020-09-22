package model.CashierModule.HashTableLibrary;

import java.util.ArrayList;

import model.Client;

public class MyHashtable<K, V> implements IMyHashtable<K, V> {

    Element<K, V>[] slots;
    int maxs;
    int size;

    public MyHashtable() {
        maxs = 249;
        slots = new Element[maxs];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // funcion h
    public int getSlotIndex(K key) {

        return (Integer) key;
    }

    public V get(K key) throws ClassCastException {

        int index = getSlotIndex(key);

        Element<K, V> f = slots[index];
        while (f != null) {
            if (f.getKey().equals(key)) {
                return f.getValue();
            }
            f = f.getNext();
        }
        return null;
    }

    public V remove(K key) throws ClassCastException {
        int index = getSlotIndex(key);
        Element<K, V> f = slots[index];
        if (f == null) {
            return null;
        }
        if (f.getKey().equals(key)) {
            V val = f.getValue();
            f = f.getNext();
            slots[index] = f;
            size--;
            return val;
        } else {
            Element<K, V> prev = null;
            while (f != null) {

                if (f.getKey().equals(key)) {
                    prev.setNext(f.getNext());
                    size--;
                    return f.getValue();
                }
                prev = f;
                f = f.getNext();
            }
            size--;
            return null;
        }
    }

    public void add(K key, V value) throws ClassCastException {

        int index = getSlotIndex(key);

        Element<K, V> f = slots[index];
        Element<K, V> toAdd = new Element<K, V>(key, value);
        if (f == null) {
            slots[index] = toAdd;
            size++;

        } else {
            while (f != null) {
                if (f.getKey().equals(key)) {
                    f.setValue(value);
                    size++;
                    break;
                }
                f = f.getNext();
            }
            if (f == null) {
                f = slots[index];
                toAdd.setNext(f);
                slots[index] = toAdd;
                size++;
            }
        }
        if ((1.0 * size) / maxs > 0.7) {
            // do something
            Element<K, V>[] tmp = slots;
            slots = new Element[maxs];
            maxs = 2 * maxs;

            for (Element<K, V> theE : tmp) {
                while (theE != null) {
                    add(theE.getKey(), theE.getValue());
                    theE.setNext(theE.getNext());
                }
            }

        }

    }

    @Override
    public ArrayList<Client> generateArrayList() {

        ArrayList<Client> theaL = new ArrayList<Client>();

        for (int i = 0; i < slots.length; i++) {

            if(slots[i]!=null)
            theaL.add((Client)slots[i].getValue());

        }

        return theaL;
    }

}
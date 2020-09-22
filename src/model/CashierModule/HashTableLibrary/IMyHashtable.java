package model.CashierModule.HashTableLibrary;

import java.util.ArrayList;

import model.Client;

public interface IMyHashtable<K, V> {

    public int getSize();

    public boolean isEmpty();

    public int getSlotIndex(K key);

    public V get(K key);

    public V remove(K key);

    public void add(K key, V value);

    public ArrayList<Client> generateArrayList();

}
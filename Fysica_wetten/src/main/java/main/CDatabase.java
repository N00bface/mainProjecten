package main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jari Van Melckebeke
 * @version 0.1
 */
public class CDatabase<K, V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();
    K key;
    V value;

    public CDatabase() {
    }

    public void set(K key, V value) {
        try {
            keys.set(getIndexOfKey(key), key);
            values.set(getIndexOfKey(key), value);
        } catch (IndexOutOfBoundsException e) {
            keys.add(key);
            values.add(value);
        }
    }

    public String[] getkeys() {
        return keys.toArray(new String[keys.size()]);
    }

    public int size() {
        return keys.size();
    }

    public String toString() {
        String out = "";
        for (int i = 0; i < keys.size(); i++) {
            out += keys.get(i) + " = " + values.get(i) + ", ";
        }
        return out;
    }

    public int getIndexOfKey(K key) {
        //System.out.println("key = " + key);
        for (int i = 0; i < keys.size(); i++) {
            //System.out.println(getkeys()[i] +" =?= "+key);
            if (getkeys()[i].equals(key.toString())) {
                return i;
            }
        }
        //System.out.println("overloop");
        return keys.size() + 1;
    }

    public V get(K key) {
        //System.out.println("getIndexOfKey(key) = " + getIndexOfKey(key));
        return values.get(getIndexOfKey(key));
    }

    public boolean containsKey(K key) {
        for (K Key : keys) {
            if (key == Key) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (V val : values) {
            if (val == value) {
                return true;
            }
        }
        return false;
    }
}
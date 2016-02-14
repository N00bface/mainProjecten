package objects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jari Van Melckebeke
 * @version 0.1
 */
public class CDatabase<K, V> {
    private List<K> Keys = new ArrayList<>();
    private List<V> Values = new ArrayList<>();
    private K key;
    private K value;

    public CDatabase() {
    }

    public void set(K key, V value) {
        try {
            Keys.set(getIndexOfKey(key), key);
            Values.set(getIndexOfKey(key), value);
        } catch (IndexOutOfBoundsException e) {
            Keys.add(key);
            Values.add(value);
        }
    }

    public String[] getKeys() {
        return Keys.toArray(new String[Keys.size()]);
    }

    public int size() {
        return Keys.size();
    }

    public String toString() {
        String out = "";
        for (int i = 0; i < Keys.size(); i++) {
            out += Keys.get(i) + " = " + Values.get(i) + ", ";
        }
        return out;
    }

    public int getIndexOfKey(K key) {
        //System.out.println("key = " + key);
        for (int i = 0; i < Keys.size(); i++) {
            //System.out.println(getKeys()[i] +" =?= "+key);
            if (getKeys()[i].equals(key.toString())) {
                return i;
            }
        }
        //System.out.println("overloop");
        return Keys.size() + 1;
    }

    public V get(K key) {
        //System.out.println("getIndexOfKey(key) = " + getIndexOfKey(key));
        return Values.get(getIndexOfKey(key));
    }

    public boolean containsKey(K key) {
        for (K Key : Keys) {
            if (key == Key) {
                return true;
            }
        }
        return false;
    }
}

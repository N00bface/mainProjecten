package objects;

/**
 * Created by jari on 10.02.16.
 */
public class Tuple<K, V> {
    private K Key;
    private V Value;

    public Tuple (K key , V value){
        set(key,value);
    }
    @Override
    public String toString() {
        return String.valueOf(Key) + " = " + String.valueOf(Value);
    }

    public void set(K key, V value) {
        Key = key;
        Value = value;
    }

    public void setKey(K key) {
        Key = key;
    }

    public void setValue(V value) {
        Value = value;
    }

    public K getKey() {
        return Key;
    }

    public V getValue() {
        return Value;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

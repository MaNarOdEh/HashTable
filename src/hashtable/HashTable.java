package hashtable;

/**
 *
 * @author pc corner
 */
public class HashTable<K, V> {
    /*
     * HashTable generic Class 
     * K=>key,V =>Value
     * we used Fast,Uniform,Deterministic hash Function to determine the index for each entry
     */

    private int tableCapacity;//represent the size of array 
    private double loadFactor; //represent the threshold to resize our array size
    private int size; //represent the number of values in our table
    private LinkedList<K, V> array[]; //holding keys,values

    //default constructor
    public HashTable() {
        this.tableCapacity = 7;
        this.loadFactor = .75;
        this.array = new LinkedList[tableCapacity];
    }

    public HashTable(int intitalCapicity) {
        this.tableCapacity = intitalCapicity;
        this.loadFactor = .75;
    }

    public HashTable(int intitalCapicity, double loadFactor) {
        this.tableCapacity = intitalCapicity;
        this.loadFactor = loadFactor;
        this.array = new LinkedList[tableCapacity];
    }

    /*
     * put function takes key,value
     * Returns Nothing
     * first we calculate the CurrentloadFactor and rehash all the entries when (currentLoad>=loadFacotr)
     * we will found the proper position by using the hashFunction
     * then if there is an element in that position we will add the new value 
     * at the head of our linked list in case the head 
     * in case the key is already found we just update the value
     * other wise we will declare new linkedlist and adding store 
     * the key and value in the first node
     *
     */
    public void put(K key, V value) {
        double currentLoadFactor = (size * 1.0) / tableCapacity;
        if (currentLoadFactor >= loadFactor) {
            rehashAll();
        }
        put(array, key, value);
    }

    /*
     * [Note] splitting put methods into two methods to simply resize array method!..
     */
    private void put(LinkedList<K, V> array[], K key, V value) {
        int position = hashFunction(key);
        if (array[position] == null) {
            LinkedList<K, V> link = new LinkedList<>(key, value);
            array[position] = link;
            size++;
            return;
        }
        if (array[position].changeValueIfContainKey(key, value)) {
            return;
        }

        array[position].addFirst(key, value);
        size++;

    }

    /*
     *check if the key is found in our arrays
     *return true if the given key found,else false
     *Run Time Complexity in Amortized is O(1)
     */
    public boolean contains(K key) {
        int position = hashFunction(key);
        if (array[position] == null) {
            return false;
        }
        return array[position].getValue(key) != null;
    }

    /*
     * return the value for given key 
     * in case the key is not found it will return null
     * Runtime compleixty in amortized is O(1)
     */
    public V get(K Key) {
        int position = hashFunction(Key);
        if (array[position] == null) {
            return null;
        }
        return array[position].getValue(Key);
    }

    /*
     * containsValue methods take a specific value 
     * returns true if this table maps one or more keys to the specified value
     * Run Time Complexity O(n) where n is the size of hashTable
     *
     */
    public boolean contiansValue(V value) {
        for (LinkedList link : array) {
            if (link != null) {
                if (link.containsValue(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * remove methods take a specific value 
     * Take Key as Parameter
     * returns the value if the key excited and remove the entry,Null otherwise
     * Run Time Complexity in amortized case is O(1) ,Space Complexity is O(1)
     *
     */
    public V remove(K key) {
        int position = hashFunction(key);
        if (array[position] != null) {
            return array[position].removeByKey(key);
        }
        return null;
    }

    /*
     * getSize method
     * Returns number of stored keys in table
     */
    public int getSize() {
        return size;
    }

    /*
     * isEmpty method
     * Returns true if the table is empty,otherwise False
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * hashfunction methods
     * take an obj as parameter
     * return the hashFunction of the value
     * if the value is Integer it will return the value mod table size
     * Note [untill now it's for integer value only]
     */
    private int hashFunction(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj % tableCapacity;
        }
        throw new UnsupportedOperationException("My HashFunction is support Integer Key hashing untill now,sorry ^-^");

    }
    /*
     * rehashAll methods
     * Return Nothing
     * resize the linked array into bigger one!
     * then rehash all the keys into new table 
     * 
     */

    private void rehashAll() {
        int oldSize = size;
        LinkedList<K, V> table[] = new LinkedList[2 * tableCapacity];;
        for (LinkedList link : array) {
            if (link != null) {
                while (link.size() > 0) {
                    K key = (K) link.getFirstKey();
                    V value = (V) link.getFirstValue();
                    link.removeFirst();
                    int hash = hashFunction(key);
                    put(table, key, value);
                }
            }
        }
        this.tableCapacity = 2 * tableCapacity;
        this.size = oldSize + 1;
        this.array = table;
    }

    /*
     * clear method 
     * Return Nothing
     * clear all the key from the hashTable so the table containd nothing.
     */
    public void clear() {
        this.tableCapacity = 7;
        this.array = new LinkedList[tableCapacity];
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append("{");
        for (LinkedList<K, V> array1 : array) {
            if (array1 != null) {
                str.append(array1.toString()+",");
            }
        }
        str.append("}");
        return str.toString();
    }
    

}

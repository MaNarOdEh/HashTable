/*
 * Build LinkeList generic class.
 * each node store both the key&value
 * 
 */
package hashtable;

public class LinkedList<K, V> {

    private Node head; //pointer to first node in our linkedlist
    private Node tail; //pointer to last node in our linkedlist
    private int size; //represent the size of node in out linkedlist

    class Node<K, V> {

        private Node next;
        private V value;
        private K key;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(V value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public Node getNext() {
            return next;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "[" + key + "," + value + "]";
        }
    }

    public LinkedList(K key, V value) {
        addFirst(key, value);
    }

    /*
     * addFirst method
     * Take Key,Value as Parameter
     * Returns Nothing
     * add at the begining of the linkedList
     * RunTime Complexity is O(1),Space Complexity O(1)
     */
    public void addFirst(K key, V value) {
        size++;
        if (head == null) {
            head = new Node(key, value);
            tail = head;
            return;
        }
        Node node = new Node(key, value);
        node.setNext(head);
        head = node;
    }

    /*
     * removeFirst method
     * Returns Nothing
     * Throw EmptyException,in case the linked is empty
     * remove First Node
     * RunTime Complexity is O(1),Space Complexity O(1)
     */
    public void removeFirst() {
        if (head == null) {
            throw new IllegalStateException("EmptyException");
        }

        head = head.next;
        size--;
        //set the tail into null if the linked become empty
        if (size == 0) {
            tail = null;
        }
    }

    /*
     * getFirstKey method
     * Returns Key
     * Throw EmptyException,in case the linked is empty
     * RunTime Complexity is O(1),Space Complexity O(1)
     */
    public K getFirstKey() {
        if (head == null) {
            throw new IllegalStateException("EmptyException");
        }
        return (K) head.getKey();
    }

    /*
     * getFirstValue method
     * Returns Value
     * Throw EmptyException,in case the linked is empty
     * RunTime Complexity is O(1),Space Complexity O(1)
     */
    public V getFirstValue() {
        if (head == null) {
            throw new IllegalStateException("EmptyException");
        }
        return (V) head.getValue();
    }

    /*
     * changeValueIfContainKey method
     * Take Key,Value as Parameter
     * Returns boolean
     * search if any node in our linkedList have the given key
     * set new value if the key is found and return true
     * otherwise it will return false
     */
    public boolean changeValueIfContainKey(K key, V v) {
        Node current = head;
        while (current != null && current.getKey() != key) {
            current = current.getNext();
        }
        if (current != null) {
            current.setValue(v);
        }
        return current != null;
    }

    /*
     * containsValue method
     * Take Value as Parameter
     * Returns boolean
     * return true if any node in our linkedList have the given value
     * otherwise it will return false
     *
     */
    public boolean containsValue(V value) {
        Node current = head;
        while (current != null && current.getValue() != value) {
            current = current.getNext();
        }
        return current != null;

    }
    /*
     * addLast method
     * Take Key,Value as Parameter
     * Returns Nothing
     * add at the tail of the linkedList
     * RunTime Complexity is O(1),Space Complexity O(1)
     */

    public void addLast(K key, V value) {
        if (head == null) {
            addFirst(key, value);
            return;
        }
        Node node = new Node(key, value);
        node.setNext(tail);
        tail = node;
        size++;
    }
    /*
     * getValue method
     * Take Key as Parameter
     * Returns V
     * search if any node in our linkedList have the given key
     * return the value of that key.
     * otherwise it will return null
     */

    public V getValue(K Key) {
        if (head == null) {
            return null;

        }
        Node current = head;
        while (current != null && (K) current.getKey() != Key) {
            current = current.getNext();
        }
        return current == null ? null : (V) current.getValue();
    }
    /*
     * removeByKey method
     * Take Key as Parameter
     * Returns V
     * search if any node in our linkedList have the given key
     * return the value of that key.
     * otherwise it will return null
     */

    public V removeByKey(K key) {
        if (head == null) {
            throw new IllegalStateException("Empty LinkedList");
        }
        if (head.getKey() == key) {
            V value = (V) head.value;
            removeFirst();
            return value;
        }
        Node current = head;
        while (current.getNext() != null && current.getNext().getKey() != key) {
            current = current.getNext();
        }//check if the last element is have the key and represent the tail anouther time..
        if (current.getNext() == tail) {
            tail = current;
        }
        V value = (current.getNext() != null) ? (V) current.getNext().getValue() : null;
        current.setNext((current.getNext() != null) ? current.getNext().getNext() : null); //remove the next node by exchange the pointer 
        size--;
        return value;
    }

    public V getFirst() {
        if (head == null) {
            throw new IllegalStateException("Empty LinkedList");
        }
        return (V) head.getValue();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "{}";
        }
        StringBuilder builder = new StringBuilder();
        Node cNode = head;
        while (cNode != null) {
            builder.append(cNode.toString() + ",");
            cNode = cNode.getNext();
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

}

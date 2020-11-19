import java.util.*;

public class STsequentialsearch<Key, Value> {
    //Declaration
    private int size;
    private Node head;

    //constructor for initilization
    public STsequentialsearch() {
        size=0;
        head=null;
    }

    //class Node for node declaration
    private class Node {
        private Key key;
        private Value value;
        private Node next;
        //constructor for initilization
        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next; 
        }
    }
    
    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size;
    }
    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        if(size() == 0){
            return true;
        }
        return false;
    }
    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key){
        if(key == null){
            throw new IllegalArgumentException("false, the key is absent");
        } 
        else if(key == key){
            throw new IllegalArgumentException("True but existing key, a key has to be unique");
        }  
        else{
            return get(key) != null;
        }
    }
    /**
     * Returns the value associated with the given key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *     and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if(key == null) {
            throw new IllegalArgumentException("The key is absent");
        }
        else{
            for(Node i = head; i != null; i = i.next){
                if (key == i.key) {
                    return i.value;
                }
            }
            return null;
        }
    }
    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value value) {
        Node newest = new Node( key, value, null );
 
        for(Node i = head; i != null; i = i.next){
            if (key == i.key) {
                i.value = value;
                return;
            }
        }
        newest.next = head;
        head = newest;
        size++;            
    }

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null){
            throw new IllegalArgumentException("The key is absent");
        } 
        head = delete(head, key);
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete (Node i, Key key) {
        if (i == null) 
            return null; 

        if (key == i.key) {
            size--;
            return i.next;
        }

        i.next = delete(i.next, key);
        return i;
    }
    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table
     */
    public Iterable<Key> keys() {

        ArrayList<Key> arr = new ArrayList<Key>();//arraylist for storing the vlaues and keys
        for (Node i = head; i != null; i = i.next) {
            arr.add(i.key); 
        }
        return arr;
    }
    
}
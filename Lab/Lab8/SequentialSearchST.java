import java.util.*;
public class SequentialSearchST<Key, Value> {
    //number of key val pairs
    private int n;

    //The key-val pairs 
    private Node first;
    /**
     * Initializes an empty symbol table.
     */

    public SequentialSearchST(){
        first = null;
        n = 0;
    }

    private class Node{
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;

        }
    }


    /**
     * Returns the number of key-val pairs in this symbol table.
     *
     * @return the number of key-val pairs in this symbol table
     */
    public int size() {
        return n;
    
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        if (n==0)
            return true;  
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
    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException ("The key is absent/null");
        }
        return get(key) != null;
    
    }

    /**
     * Returns the val associated with the given key in this symbol table.
     *
     * @param  key the key
     * @return the val associated with the given key if the key is in the symbol table
     *     and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException(""); 
        }
        for (Node x = first; x != null; x = x.next) {
            if (key == x.key) 
                return x.val;
        }
        return null;
    
    }

    /**
     * Inserts the specified key-val pair into the symbol table, overwriting the old 
     * val with the new val if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated val) from this symbol table
     * if the specified val is {@code null}.
     *
     * @param  key the key
     * @param  val the val
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("The key is absent/null");
        }
        Node newest = new Node(key, val, null);

        for (Node x = first; x != null; x = x.next){
            if (key==x.key) 
            { 
                x.val = val; 
                return;
            }

        }
        newest.next = first;
        first = newest;
        n++;
        
    
    }

    /**
     * Removes the specified key and its associated val from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("TThe key is absent/null");
        }
        first = delete(first, key);
    
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, Key key) {
        if (x == null) 
            return null;
        if (key==x.key) { 
            n--; 
            return x.next; 
        }
        x.next = delete(x.next, key);
        return x;
    
    }

    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table
     */
    public Iterable<Key> keys()  {
        ArrayList<Key> arr = new ArrayList<Key>();
        for (Node x = first; x!= null; x = x.next) {
            arr.add(x.key);     
        }
        return arr;

   }
    /**
         main method
     */
    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
            
        System.out.println(st.isEmpty());
        System.out.println("Size : "+st.size());

        st.put("sonam",1);
        st.put("Choki",2);
        st.put("Elle",3);
        st.put("Henna",4);
        st.put("Lhamo",5);

        System.out.println(st.isEmpty());
        System.out.println("Size : "+st.size());
        
        st.delete("Elle");

        System.out.println("Value of the given key : "+st.get("sonam"));
        System.out.println("Value of the given key : "+st.get("Lhamo"));
        
        System.out.println(st.size());
        System.out.println(st.isEmpty());

        System.out.println(st.contains("Henna"));

        assert(st.isEmpty() == false);
        assert(st.size() == 4);
        System.out.println("All Test Cases Passed.");

        }
    
}



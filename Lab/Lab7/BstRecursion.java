import java.util.*;

public class BstRecursion<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree
       

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public BstRecursion() {
        root = null;
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if(size() == 0){
            return true;
        }
        else{
            return false;
        }
       
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
      return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if(x == null){
            return 0;
        }    
        else{
            return x.size;
        }
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
     public boolean contains(Key key) {
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
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if(key == null){
            throw new IllegalArgumentException("The key is absent");
        }
        else{
            return get(root, key);
        }
    }

    private Value get(Node x, Key key) {
       if(x == null){
            return null;
       }
       int compare = key.compareTo(x.key);
       if (compare < 0){
            return get(x.left, key); 
       }
       else if(compare > 0){
            return get(x.right, key);
       }
       else{
            return x.val;
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
    public void put(Key key, Value val) {
     root = put(root, key, val);   
       
    }

    private Node put(Node x, Key key, Value val) {
       if (x == null){
        return new Node(key, val, 1);
        }

       int compare = key.compareTo(x.key);
       if (compare < 0){
            x.left = put(x.left, key, val);
       } 
       else if (compare > 0){
            x.right = put(x.right, key, val);
       }
       else{
            x.val = val;
       }
       x.size = 1 + size(x.left) + size(x.right);
       return x;
     }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        if(size() == 0){
            throw new NoSuchElementException ("The symbol table is empty");
        }
       return min(root).key;
    } 

    private Node min(Node x) { 
       if (x.left == null) 
            return x;
       return min(x.left);  
    } 

   

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        Node x = floor(root, key);
        return x.key;
    } 

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int compare =  key.compareTo(x.key);
        if(compare == 0) return x;
        if(compare < 0) return floor(x.left, key);
        Node y = floor(x.right, key);
        if (y != null) return y;
        else {
            return x;
        }       
     } 

    
    

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */

    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("The rank is too high or low");
        }
        return select(root, k);
    }

    // Return key in BST rooted at x of given rank.
    // Precondition: rank is in legal range.
    private Key select(Node x, int k) {
        if (x == null){
        	return null;
        }

        int left = size(x.left);
        if (left > k){
        	return select(x.left,  k);
        }
        else if (left < k){
        	return select(x.right, k - left - 1);
        	} 
        else{
		    return x.key;
		}
    }

    

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        ArrayList<Key> arr = new ArrayList<Key>();
        keys(root, arr, lo, hi);
        return arr;
    } 

    private void keys(Node x,ArrayList<Key> arr, Key lo, Key hi) { 
        if (x == null) return;
        int comparelo = lo.compareTo(x.key);
        int comparehi = hi.compareTo(x.key);
        if (comparelo < 0) keys(x.left, arr, lo, hi);
        if (comparelo <= 0 && comparehi >= 0) arr.add(x.key);
        if(comparehi > 0) keys(x.right, arr, lo, hi);
    } 
}
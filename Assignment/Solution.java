import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST
    private int size;

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
    public Solution() {
        root = null;
        size = 0;
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if (size() == 0){
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
      return size; 
    }

    //return number of key-value pairs in BST rooted at x
    private int size(Node x) {//node x is the root which is initilized as null
       if (x == null){
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
    // public boolean contains(Key key) {
       
    // }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key){
        if(key == null){
            throw new IllegalArgumentException("The key is absent");
        }
        else{
            return get(root, key);
        }   
    }

    private Value get(Node x, Key key){
        while(x != null){
            int compare = key.compareTo(x.key);
            if(compare < 0){
                x = x.left;
            }
            else if(compare > 0){
                x = x.right;
            }
            else{//when key == x.key
                 return x.val;
            }
        }
        return null;//returns null when empty      
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
        if(val == null){
           throw new IllegalArgumentException("The value of the given key is null"); 
        }
        Node newest = new Node(key, val, 1);
        if (root == null){
            root = newest;
        }

        Node subroot = null;
        Node temp = root;
        while(temp != null){
            int compare = key.compareTo(temp.key);
            subroot = temp;
            if(compare < 0){
                temp = temp.left;
            }
            else if (compare > 0){
                temp = temp.right;
            }
            else{
                temp.key = key;
                return; 
            }
        } 
        int compare1 = key.compareTo(subroot.key);
        if (compare1 < 0){
            subroot.left = newest;
        }
        subroot.right = newest;
        size = size+1;     
    }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
      if(size() == 0){
            throw new NoSuchElementException ("The symbol table is Empty");
        }
       return min(root).key; 
    } 

    private Node min(Node x) { 
            while(x.left != null){
                x = x.left;
            }
            return x; 
    } 
    // /**
    //  * Returns the largest key in the symbol table less than or equal to {@code key}.
    //  *
    //  * @param  key the key
    //  * @return the largest key in the symbol table less than or equal to {@code key}
    //  * @throws NoSuchElementException if there is no such key
    //  * @throws IllegalArgumentException if {@code key} is {@code null}
    //  */
    public Key floor(Key key) {
       Node x = floor(root, key);
        return x.key; 
    } 

    private Node floor(Node x, Key key) {
        Node temp = null;
        while(x != null){
            int compare = key.compareTo(x.key);
            if(compare < 0){
                x = x.left;
            }
            else if (compare > 0){
                temp = x;
                x = x.right;
            }
            else{
                return x; 
            }
        } 
        return temp;    
    } 

    // /**
    //  * Return the key in the symbol table whose rank is {@code k}.
    //  * This is the (k+1)st smallest key in the symbol table.
    //  *
    //  * @param  k the order statistic
    //  * @return the key in the symbol table of rank {@code k}
    //  * @throws IllegalArgumentException unless {@code k} is between 0 and
    //  *        <em>n</em>–1
    //  */

    // public Key select(int k) {
    //   if (k < 0 || k >= size()) {
    //         throw new IllegalArgumentException("The rank is too high or low");
    //     }
    //     return select(root, k);  
    // }

    // // Return key of rank k. 
    // private Node select(Node x, int k) {
    //     if (x == null){
    //         return null;
    //     }

    //     int left = size(x.left);
    //     if (left > k){
    //         x = x.left;
    //     }
    //     else if (left < k){
    //         x = x.right;
    //     } 
    //     else{
    //         return x.key;
    //     }
    // } 

    // private Key select(Node x, int k) {
    //     if (x == null){
    //         return null;
    //     }

    //     int left = size(x.left);
    //     if (left > k){
    //         return select(x.left,  k);
    //     }
    //     else if (left < k){
    //         return select(x.right, k - left - 1);
    //         } 
    //     else{
    //         return x.key;
    //     }
    // }


    // /**
    //  * Returns all keys in the symbol table in the given range,
    //  * as an {@code Iterable}.
    //  *
    //  * @param  lo minimum endpoint
    //  * @param  hi maximum endpoint
    //  * @return all keys in the symbol table between {@code lo} 
    //  *         (inclusive) and {@code hi} (inclusive)
    //  * @throws IllegalArgumentException if either {@code lo} or {@code hi}
    //  *         is {@code null}
    //  */

    public Iterable<Key> keys(Key lo, Key hi) {
    Queue<Key> queue = new LinkedList<Key>();
    keys(root, queue, lo, hi);
    return queue;
    } 

    private void keys(Node x,Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return;

        Node temp;
        while(x != null){
            temp = x;
            if(x.key == null){
                throw new IllegalArgumentException("The key is absent");
            }
            int comparelo = lo.compareTo(temp.key);
            int comparehi = hi.compareTo(temp.key);
            if (comparelo < 0){
                queue.add(x.key);
                x = temp.left;
            }
            else if (comparelo <= 0 && comparehi >= 0){ 
                queue.add(x.key);
            }
            if(comparehi > 0){  
              x = temp.right;
            }
        }
    }
   
    /* Run the program by giving the approriate command obtained from
    input files through input.txt files. The output should be displayed
    exactly like the file output.txt shows it to be.*/
  
    public static void main(String[] args) { 
        Solution<String, Integer> obj = new Solution<String, Integer>();
        
        obj.put("ABDUL",1);
        System.out.println("Get : "+obj.get("ABDUL"));
        obj.put("HRITHIK",2);
        obj.put("SAI",3);
        obj.put("SAMAL",6);
        System.out.println("Get : "+obj.get("SAI"));
        obj.put("TASHI",4);
        System.out.println("Size : "+obj.size());
        System.out.println("Min : "+obj.min());
        System.out.println("Floor : "+obj.floor("HRITHIK"));
        System.out.println("Floor : "+obj.floor("HAHA"));
        //System.out.println("Select : "+obj.select(2));
        System.out.println("Keys : "+obj.keys("ABDUL","TASHI"));
        obj.put("CHIMI",5);
        obj.put("SAMAL",4);
        System.out.println("Get : "+obj.get("SAMAL"));
        obj.put("NIMA",7);
        System.out.println("Size : "+obj.size());
        System.out.println("Get : "+obj.get("CHIMI"));
        System.out.println("Floor : "+obj.floor("CHIMA"));
        obj.put("SONAM",8);
        System.out.println("Keys : "+obj.keys("ABDUL","TASHI"));
       
    }
}
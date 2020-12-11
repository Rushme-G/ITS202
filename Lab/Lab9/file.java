import java.util.Iterator;
import java.util.NoSuchElementException;

public class file<Item> implements Iterable<Item> {
    private Node<Item> first;   
    private int size;              

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    public file() {
        first = null;
        size = 0;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return size;
    }
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);  
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> cur;

        public LinkedIterator(Node<Item> first) {
            cur = first;
        }

        public boolean hasNext()  { return cur != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = cur.item;
            cur = cur.next; 
            return item;
        }
    }
}
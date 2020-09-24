public class LinkedList{//main class named Linkedlist
	Node head;
	Node tail;
	int size;

	//constructor for initialization
	public LinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	//returns the number of elements in the list
	public int size(){
		return size;
	}
	//returns true if the list is empty and false otherwise
	public boolean isEmpty(){
		if (size == 0) {
			return true;
		}
		return false;
	}
	//returns the first element from the list
	public int first(){
		return head.getElement();
	}
	//returns the last element from the list
	public int last(){
		return tail.getElement();
	}

	//to add a new element in a list as the head
	public void addFirst(int n){
		Node newest = new Node(n, null);

		if (size == 0) {
			 head = newest;
			 tail = newest;
		}

		else{
			newest.setNext(head);
			head = newest;
		}
		size = size + 1;
	}

	//to add a new element to a list as the tail
	public void addLast(int n){
		Node newest = new Node(n, null);
		if (size == 0) {
			head = newest;
			tail = newest;
		}
		else{
			tail.setNext(newest);
			tail =newest;
		}
		size += 1;
	}

	//removing the head/first element from the list
	public int removeFirst(){
		int deletedElement = head.getElement();
		if (size == 0) {
			return 0;
		}
		else{
			head = head.getNext();
			size = size -1;
		}
		return deletedElement;
	}



}
//subclass named Node
class Node{
	private int element;
	private Node next;
	// constructor
	public Node(int element, Node next ){
	    this.element = element;
		this.next = next;
	}

	// getElement
	public int getElement(){
		return element;
	}

	// getNext
	public Node getNext(){
		return next;
	}

	//setElement
	public void setElement(int n){
		element = n;
	}

	//setNext
	public void setNext(Node n){
		next = n;
	}
}
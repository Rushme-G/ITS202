/* Implement the following method using Linked List on asking the user to enqueue and dequeue the integers and to display the elements in the Queue.
enqueue(e): Add element e to the back of the Queue Q.
dequeue(): Remove and return the first element from queue Q.
first(): Return a reference to the front of the queue Q, without removing it; an
error occurs if the queue is empty
is_empty(): Returns true if queue Q does not contain any elements.
len(Q): Return the number of elements in queue Q; */


//declearing variables
class StackMdLList{
	Node front;
	Node tail;
	int size;
	//constructor for initalization
	public StackMdLList(){
		front = null;
		tail = null;
		size = 0;
	}

	//len(): Returns the number of elements in the Queue
	public int len(){
		return size;
	}

	//is_empty(): Returns a boolean indicating whether the queue is empty
	public boolean is_empty(){
		if(size == 0){
			return true;
		}
		else{
			return false;
		}
	}

	//enqueue(e): Adds element e to the top of the queue
	public void enqueue(int element){
			Node newest = new Node(element, null);
			if(is_empty()){
				front = newest;
				tail = newest;
				System.out.println(element);
			}
			else{
				tail.setNext(newest);
				tail = newest;
				System.out.println(element);
			}
			size += 1;
	}

	//first(): Returns the top element of the queue, without removing it (or null if the queue is empty)
	public int first(){
		int f_element = front.getElement();
		if(is_empty()){
			System.out.println("Empty Queue");
		}
		return f_element;
	}

	//dequeue(): Removes and returns the top element from the queue(or null if the queue is empty)
	public int dequeue(){
		int dequeued_element = front.getElement();
		if(is_empty()){
			System.out.println("Empty Queue");
		}
		else{
			front = front.getNext();
			size -= 1;
		}
		return dequeued_element;
	}
}

//main class
public class QueueMdLList{

	//main method 
  public static void main(String[] args) {

    
    //creating an object
    QueueMdArray x=new QueueMdArray();

    //calling the functions
    System.out.println("The first element is(Before enqueue) : "+ x.first());
    System.out.println("The array is Empty(Before enqueue) : "+ x.is_empty());
    System.out.println("The len before enqueue : "+ x.len());
    x.enqueue(2);
    x.enqueue(4);
    x.enqueue(6);
    x.enqueue(8);
    x.enqueue(1);
    System.out.println("The first element is(After enqueue) : "+ x.first());
    System.out.println("The array is Empty(After enqueue) : "+ x.is_empty());
    System.out.println("The len after enqueue : "+ x.len());
    System.out.println("The dequeued value : "+ x.dequeue());
    System.out.println("The first element is(After dequeue) : "+ x.first());
    System.out.println("The len after a dequeue : "+ x.len());
  }

}

//A sub class named Node
class Node{
	private int element;
	private Node next;

	//constructor for initalization
	public Node(int element, Node next){
		this.element = element;
		this.next = next;
	}
	 //getElement
	public int getElement(){
		return element;
	}
	//getNext
	public Node getNext(){
		return next;
	}
	//setElement
	public void setElement(int n) {
		element = n;
	}
	//setNext
	public void setNext(Node n) {
		next = n;
	}

}


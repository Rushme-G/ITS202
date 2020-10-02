/* Implement the following method using Linked list on asking user to push and pop the integers and get the size of the stack.

push(e):     Adds element e to the top of the stack.
pop():       Removes and returns the top element from the stack(or null if the stack is empty).
top():       Returns the top element of the stack, without removing it (or null if the stack is empty).
size():      Returns the number of elements in the stack.
isEmpty():   Returns a boolean indicating whether the stack is empty*/


//main class(declearing)
public class StackMdLList{
	Node head;
	int size;
	//constructor for initalization
	public StackMdLList(){
		head = null;
		size = 0;
	}

	//size(): Returns the number of elements in the stack
	public int size(){
		return size;
	}

	//isEmpty(): Returns a boolean indicating whether the stack is empty
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		else{
			return false;
		}
	}

	//push(e): Adds element e to the top of the stack
	public void push(int element){
			Node newest = new Node(element);
			newest.next = head;
			head = newest;
			System.out.println(element);
			size += 1;
	}

	//top(): Returns the top element of the stack, without removing it (or null if the stack is empty)
	public int top(){
		if(isEmpty()){
			System.out.println("Empty Stack");
		}
		return head.element;
	}

	//pop(): Removes and returns the top element from the stack(or null if the stack is empty)
	public int pop(){
		int popped_element = head.element;
		if(isEmpty()){
			System.out.println("Stack Underflow");
		}
		else{
			head = head.next;
			size -= 1;
		}
		return popped_element;
	}

	//main method 
  public static void main(String[] args) {

    //creating an object
    StackMdLList x=new StackMdLList();

    //calling the functions
    System.out.println("The array is Empty(Before push) : "+ x.isEmpty());
    System.out.println("The size before push : "+ x.size());
    x.push(2);
    x.push(4);
    x.push(6);
    x.push(8);
    x.push(1);
    System.out.println("The top element is(After push) : "+ x.top());
    System.out.println("The array is Empty(After push) : "+ x.isEmpty());
    System.out.println("The size after push : "+ x.size());
    System.out.println("The popped value : "+ x.pop());
    System.out.println("The top element is(After pop) : "+ x.top());
    System.out.println("The size after a pop : "+ x.size());
  }
}

//A sub class named Node
class Node{
	int element;
	Node next;

	//constructor for initalization
	public Node(int element){
		this.element = element;
		this.next = next;
	}
}


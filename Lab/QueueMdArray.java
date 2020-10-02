/* Implement the following method using array on asking the user to enqueue and dequeue the integers and to display the elements in the Queue.
enqueue(e): Add element e to the back of the Queue Q.
dequeue(): Remove and return the first element from queue Q.
first(): Return a reference to the front of the queue Q, without removing it; an
error occurs if the queue is empty
is_empty(): Returns true if queue Q does not contain any elements.
len(Q): Return the number of elements in queue Q; */

public class QueueMdArray{ 
  //delearing variables
  int list[], front, max, len, rear; 
 
  public QueueMdArray(){
    //use constructor for initialization
    front=0;
    rear=-1;
    len=0;
    max=10;
    list=new int[max];
  }
  //is_empty(): Returns a boolean indicating whether the queue is empty
  public boolean is_empty(){
    if (len == 0){
      return true;
    }
    else{
      return false;
    }
  }
  //len(): Returns the number of elements in the queue
  public int len(){
    return len;
  }
  //first(): Returns the first element of the queue, without removing it (or null if the queue is empty)
  public int first(){
    if(is_empty()){
      System.out.println("Empty Queue");
    }
    return list[front];
  }

  //enqueue(e): Adds element e to the top of the queue
  public void enqueue(int n){
    if(rear > max){
      System.out.print("The queue is already full");
    }
    else{
      rear++;
      list[rear]=n;
      System.out.println(n);
    }
    len += 1;  
  }

  //dequeue(): Removes and returns the first element from the queue(or null if the queue is empty)
  public int dequeue(){
    if(is_empty()){
      System.out.print("Empty Queue");
    }
    else{
      front=front+1;
      len -= 1;
    }
    return list[front-1];
  }
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
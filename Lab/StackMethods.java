/* Implement the following method using array on asking user to push and pop the integers and get the size of the stack.

push(e):     Adds element e to the top of the stack.
pop():       Removes and returns the top element from the stack(or null if the stack is empty).
top():       Returns the top element of the stack, without removing it (or null if the stack is empty).
size():      Returns the number of elements in the stack.
isEmpty():   Returns a boolean indicating whether the stack is empty*/

public class StackMethods{ 
  //delearing variables
  int list[], top, size, max; 
  
  public StackMethods(){
    //use constructor for initialization
    max=10;
    top=-1;
    list=new int[max];
    size=0;
  }
  //isEmpty(): Returns a boolean indicating whether the stack is empty
  public boolean isEmpty(){
    if (size == 0){
      return true;
    }
    else{
      return false;
    }
  }
  //size(): Returns the number of elements in the stack
  public int size(){
    return size;
  }
  //top(): Returns the top element of the stack, without removing it (or null if the stack is empty)
  public int top(){
    if(isEmpty()){
      System.out.println("Empty Stack");
    }
    return list[top];
  }

  //push(e): Adds element e to the top of the stack
  public void push(int n){
    if(top > max){
      System.out.print("Stack Overflow");
    }
    else{
      top++;
      list[top]=n;
      System.out.println(n);
    }
    size += 1;  
  }

  //pop(): Removes and returns the top element from the stack(or null if the stack is empty)
  public int pop(){
    if(isEmpty()){
      System.out.print("Stack Underflow");
    }
    else{
      top=top-1;
    }
    size -= 1;
    return list[top+1];
  }
  //main method 
  public static void main(String[] args) {

    //creating an object
    StackMethods x=new StackMethods();

    //calling the functions
    x.pop();
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
import java.util.*;
//main class
public class ArrayList{//Declearation
	int array[], size, first_ele, max, len;
	double  onefourth, threefourth, length;
	//constructor for initalization
	public ArrayList(){
		max = 4;
		array = new int[max];
		size = 0;
		onefourth = 0.25;
		threefourth = 0.75;
		first_ele = -1;
	}

	//add(): add element in array
	public void add(int e){
		if(first_ele > max){
      	System.out.println("Reached the Limit!");
   		 }
	    else{
	      first_ele = first_ele +1;
	      array[first_ele]=e;
	      System.out.println(e);
	    }
	}

	//pop(): remove an element 
	public void pop(){
      	first_ele = first_ele;
		array[first_ele] = 0;
		int count = 0;
		for(int i = 0; i < array[i]; i++) {
			count++;
		}
		len = count;
		length = (double)len/max;
	}
	//resize() 
	public void resize(){

		if(length == onefourth ) {
			int newest[] = new int[(max/2)*2];
			for(int i = 0; i < array.length; i++) {
				newest[i] = array[i];
			}
			array = newest;
			max = max/2;
			for(int j : newest) {
				System.out.print(j + " ");
				}	
		}
		else if(length == threefourth) {
			int newest[] = new int[max*2];
			for(int i = 0; i < array.length; i++) {
				newest[i] = array[i];
			}
			max = max * 2;
			array = newest;
			for(int k : newest) {
			System.out.print(k + " ");
			}
			System.out.println();
		}
		else {
			System.out.println(" Error!!");
		}
	}

	//size(): no of elements in the array
	public int size(){
		return size;
	}

	//toString(): string representation of the dynamic array
	public String toString(){
		String arr = Arrays.toString(array);
		return arr;
	}
	//main method
	public static void main(String[] args) {
		ArrayList x = new ArrayList();
		x.add(1);
		x.add(2);
		x.add(3);
		x.add(4);
		x.pop();
		x.resize();
		assert(x.size() == 3);
		System.out.println("All Test Cases Passed");
		x.size();
		System.out.println("The string representation : " +x.toString());
	}
}

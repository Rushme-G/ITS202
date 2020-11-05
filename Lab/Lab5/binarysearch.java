public class binarysearch{

	//first sorting the array to perform binary search 
	public void sort(int array[]){
		//initiliztion the size to the length of the array
		int len = array.length;

		System.out.print("The sorted array : ");

		for (int i=0; i< len; i++) {
			int smallest = i;//taking index i as the smallest element
			for (int j=i+1; j < len ; j++) {
				if (array[j] < array[smallest]) {
					smallest = j;
					
				}	
			}
			int Smallest = array[smallest];
			array[smallest] = array[i];//swapping 
			array[i] = Smallest;
			System.out.print(array[i]+" ");		
			}
			System.out.println();
	} 
	//peroforming the binary search to the above sorted array
	public int search(int array[], int key, int lo, int hi){

	 	if (hi >= lo){
		 	int mid = (lo + hi)/2;//finding the mid
		 	if(array[mid] == key){//if the mid value is equal to the key value
				System.out.println("Search successful! key : "+ array[mid]);
				return mid;
			}
			else if(array[mid] > key){//if the mid value is smaller than the key value
				return search(array, key, lo, mid-1);
			}
			else{//if the mid value is more than the key value
				return search(array, key, mid+1, hi);
			}
		}
		return -1;//if the key value is not there in the array
	}

	public static void main(String[] args){

		binarysearch x = new binarysearch();
		int array[] = {6,5,4,3,2,1};

		x.sort(array);
		int temp = x.search(array,6, 0, 5);

		if(temp == -1){
			System.out.println("Sorry, the key value is not in the list");
		}
		System.out.println("And the index of the key is : "+temp);

	}
}	

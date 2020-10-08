//performing selection sort 

public class selectionsort{
	public static void main(String[] args){
		//list of array named list
		int[] list = {2, 3, 1, 6, 8, 4};
		int len = list.length;//initilizating the array to its length

		//printing the unsorted array
		System.out.print("Unsorted : ");
		for (int k = 0; k <= len-1 ; k++ ) {
			System.out.print(list[k]+ " ");
		}
		System.out.print("\nSorted : ");
		//two for loops used for comparing and swapping ;(sorting)
		for (int i = 0 ; i <= len-1; i++) {
			int smallest = i;//taking the index 0 as the smallest number

			for (int j = i+1 ; j <= len-1; j++) {
				if (list[j] < list[smallest]) {
					smallest = j;//assigning j as smallest  
				}
			}
			//swapping
			int Smallest = list[smallest];
			list[smallest] = list[i];
			list[i] = Smallest;
			//printing the selection sorted array
			System.out.print(list[i] + " ");
		}
	}	
}

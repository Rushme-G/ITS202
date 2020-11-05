public class keyindx{

	public void keyindxsort(int[] array){

		int N = array.length;
		int R = 9;//should be more than the largest no from the array
		int[] aux = new int[N];
		int[] count = new int[R+1];

		// Compute frequency counts.
		for (int i = 0; i < N; i++)
		count[array[i] + 1]++;

		// Transform counts to indices.
		for (int r = 0; r < R; r++)
		count[r+1] += count[r];

		// Distribute the records.
		for (int i = 0; i < N; i++)
		aux[count[array[i]]++] = array[i];

		// Copy back.
		for (int i = 0; i < N; i++)
		array[i] = aux[i];

		//printing the sorted list
		for (int i = 0; i < N; i++ ) {
			System.out.print(array[i]+" ");
		}
	}
	
	public static void main(String[] args) {
	
	keyindx x = new keyindx();
	int array[] = {4,3,2,1,0,8,6};
	x.keyindxsort(array);

	}
}
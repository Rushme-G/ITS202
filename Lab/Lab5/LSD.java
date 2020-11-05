public class LSD{
	
	public static void lsdsort(String[] names, int W){
	//Sort a[] on leading W characters.
		int N = names.length;
		int R = 256;
		String[] aux = new String[N];
		
		for (int d = W-1; d >= 0; d--){
		 // Sort by key-indexed counting on dth char.
			int[] count = new int[R+1];
			// Compute frequency counts.

			for (int i = 0; i < N; i++)
			count[names[i].charAt(d) + 1]++;

			for (int r = 0; r < R; r++)
			// Transform counts to indices.
			count[r+1] += count[r];

			for (int i = 0; i < N; i++)
			// Distribute.
			aux[count[names[i].charAt(d)]++] = names[i];

			for (int i = 0; i < N; i++)
			// Copy back.
			names[i] = aux[i];
		}
		//printing the sorted list
		for (int i = 0; i < N ; i++ ) {
			System.out.println(names[i]+" ");
		}
	}

	public static void main(String[] args){
		LSD x = new LSD();
		String names[] = {"sonam","karma","dorji","choki"};
		int W = 5;//length of the string(should be all equal)
		x.lsdsort(names,W);

	}
}
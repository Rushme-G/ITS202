public class linearsearch{

	public void search(int array[], int key){

		//initiliztion the size to the length of the array
		int len = array.length;

		for (int i = 0; i < len; i++) {
			if (array[i] == key) {
					System.out.println("Search successful! The key is : "+array[i]);
					return;
			}	
		}
		System.out.println("Sorry, the key is not on the list");
	}	

	public static void main(String[] args){
		linearsearch x = new linearsearch();
		int array[] = {3,2,5,1,7,8};
		int key = 1;
		x.search(array, key);	
	}
}
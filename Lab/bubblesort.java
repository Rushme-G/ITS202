//performing bubble sort

public class bubblesort{
   
    public static void bubble(int[] list){
        int len = list.length;//initilizing array to its length

        //using two for loops
        for (int i = 0; i <= len-1 ; i++ ) {

            for (int j = 0; j< len-1; j++ ) {
                
                if (list[j] > list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
                
            }
            
        }
    }
    public static void main(String[] args) {
        
        int[] list1 = {7, 6, 5, 4, 3, 2, 1};
        int len = list1.length;//initilizing array to its length

        //printing the unsorted array
        System.out.print("Unsorted : ");
        for (int k = 0; k <= len-1; k++ ) {
            System.out.print(list1[k]+" ");
        } 

        //printing the bubble sorted array
        bubble(list1);    
        System.out.print("\nSorted : ");
        for (int l = 0; l <= len-1; l++ ) {
            System.out.print(list1[l]+" ");
        }   
    }
}
//performing insertion sort

public class insertionsort {  

    public static void insertion(int list[]) {    
        int len = list.length;//initilizing array to its length
        //using two for loop
        for (int i = 0; i < len-1; i++) {  

            for (int j = i + 1; j > 0 && check(j-1, j, list) ;j-- ) {
                int temp = list[j-1];
                list[j-1] = list[j];
                list[j] = temp;
                }
                
            }
        } 
        public static boolean check(int k, int l, int[] list1){
            //comparing
            if (list1[k] > list1[l]) {
                return true;  
            }
            return false;   
        }  
       
    public static void main(String[] args) {    
        
        int[] list2 = {6, 5, 4, 3, 2, 1}; 
        int len = list2.length;//initilizing array to its length

        insertionsort x = new insertionsort();
        //printing unsorted array
        System.out.print("Unsorted : ");
        for(int i = 0; i <= len-1 ; i++){    
            System.out.print(list2[i]+" ");    
        } 
        //printing the insertion sorted list
        x.insertion(list2);
        System.out.print("\nSorted : "); 
        for(int j = 0; j <= len-1; j++){    
            System.out.print(list2[j]+" ");    
        }   
    }
}


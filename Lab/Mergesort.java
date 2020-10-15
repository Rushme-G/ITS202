/* Precondition: Array a[] has at least mid + hi components starting at a[lo]. The first
lo (Lowest) elements (from a[lo] to data[lo+mid-1]) are sorted from smallest to
largest, and the last hi (last)elements (from a[lo + mid] to a[lo+mid+hi-1]) are also
sorted from smallest to largest.
Post condition: Starting at a[lo, mid + hi] elements of the array a[] have been
rearranged to be sorted from smallest to largest. */

public class Merge {

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if(i > mid){
                a[k] = aux[j++];
            }              
            else if(j > hi) {
                a[k] = aux[i++];
            }                
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = (lo + hi) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);

    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @/param a the array to be sorted
     */
    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        int lo = 0;
        int hi = a.length - 1;

        sort(a,aux,lo,hi);
    }


   /***************************************************************************
    *  Helper sorting function.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
        
   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) {
                return false;
            }
        return true;
    }

    // print array to standard output
    private static void show(int[] a) {
        System.out.print("\nSorted : ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.print("\n\n");
    }

    /**
     * Reads in a sequence of strings from standard input; mergesorts them; 
     * and prints them to standard output in ascending order. 
     *
     * /@param args the command-line arguments
     */
    public static void main(String[] args) {
        int[] a = {  6, 5, 4, 3, 2, 1 };

        System.out.print("\nUnsorted : ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

        Merge.sort(a);
        show(a);
    }
}
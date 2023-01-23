import java.util.Comparator;

public class Insertion { // slide3
   //This Class should not be intantiated.
   private Insertion() {
   }

   //is  V < W ?
   private static boolean less(Comparable v, Comparable w) { //slide4
       return v.compareTo(w) < 0;
   }

   //is  V < W ?
   private static boolean less(Object v, Object w, Comparator comparator) {
       return comparator.compare(v, w) < 0;
   }

   // exchange a[i] and a[j]
   private static void exch(Object[] a, int i, int j) {
       Object swap = a[i];
       a[i] = a[j];
       a[j] = swap;
   }

   public static void sort(Comparable[] a) { //slide5
       int N = a.length;
       for (int i = 0; i < N; i++) {
           for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
               exch(a, j, j-1);
           }
           assert isSorted(a, 0, i);
       }
       assert isSorted(a);
   }

   public static void sort(Comparable[] a, int lo, int hi) { //slide6
       for (int i = lo; i <= hi; i++) {
           for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
               exch(a, j, j-1);
           }
       }
       assert isSorted(a, lo, hi);
   }

   public static void sort(Object[] a, Comparator comparator) { //slide7
       int N = a.length;
       for (int i = 0; i < N; i++) {
           for (int j = i; j > 0 && less(a[j], a[j-1], comparator); j--) {
               exch(a, j, j-1);
           }
           assert isSorted(a, 0, i, comparator);
       }
       assert isSorted(a, comparator);
   }

   public static void sort(Object[] a, int lo, int hi, Comparator comparator) { //slide8
       for (int i = lo; i <= hi; i++) {
           for (int j = i; j > lo && less(a[j], a[j-1], comparator); j--) {
               exch(a, j, j-1);
           }
       }
       assert isSorted(a, lo, hi, comparator);
   }

   public static int[] indexSort(Comparable[] a) { //slide9
       int N = a.length;
       int[] index = new int[N];
       for (int i = 0; i < N; i++)
           index[i] = i;

       for (int i = 0; i < N; i++)
           for (int j = i; j > 0 && less(a[index[j]], a[index[j - 1]]); j--)
               exch(index, j, j-1);

       return index;
   }

   //exchange a[i] and a[j] (for indirect sort)
   private static void exch(int[] a, int i, int j) { //slide10
       int swap = a[i];
       a[i] = a[j];
       a[j] = swap;
   }
   private static boolean isSorted(Comparable[] a) {
       return isSorted(a, 0, a.length - 1);
   }

   //is the array sorted from a[lo] to a[hi]
   private static boolean isSorted(Comparable[] a, int lo, int hi) {
       for (int i = lo + 1; i <= hi; i++)
           if (less(a[i], a[i-1])) return false;
       return true;
   }
   private static boolean isSorted(Object[] a, Comparator comparator) { //slide11
       return isSorted(a, 0, a.length - 1, comparator);
   }

   //is the array sorted from a[lo] to a[hi]
   private static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
       for (int i = lo + 1; i <= hi; i++)
           if (less(a[i], a[i-1], comparator)) return false;
       return true;
   }

   //print array to standard output
   private static void show(Comparable[] a) {
       for (int i = 0; i < a.length; i++) {
           StdOut.println(a[i]);
       }
   }

   public static void main (String[] args) { //slide12
       String[] a = StdIn.readAllStrings();
       Insertion.sort(a);
       show(a);
   }
}
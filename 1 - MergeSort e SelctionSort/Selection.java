import java.util.Comparator;

public class Selection { // Slide15

   //this class should not be instantiated
   private Selection(){ }

   public static void sort(Comparable[] a) {
      int N = a.length;
      for (int i = 0; 0 < N; i++) {
          int min = i;
          for (int j = i+1; j < N; j++) {
              if (less(a[j], a[min])) min = j;
          }
          exch(a, i, min);
          assert isSorted(a, 0, i);
      }
      assert isSorted(a);
   }
   public static void sort(Object[] a, Comparator c) { // Slide16
       int N = a.length;
       for (int i = 0; i < N; i++) {
           int min = i;
           for (int j = i+1; j < N; j++) {
               if (less(c, a[j], a[min])) min = j;
           }
           exch(a, i, min);
           assert isSorted(a, c, 0, i);
       }
       assert isSorted(a, c, 0, a.length - 1);
       //assert isSorted(a, c);
   }
   //is v < w ?
   private static boolean less(Comparable v, Comparable w) { // Slide17
       return v.compareTo(w) < 0;
   }

   //is v < w ?
   private static boolean less(Comparator c, Object v, Object w) {
       return c.compare(v, w) < 0;
   }
   // exchange a[i] and a[j]
   private static void exch(Object[] a, int i, int j) {
       Object swap = a[i];
       a[i] = a[j];
       a[j] = swap;
   }
   //is the array a[] sorted?
   private static boolean isSorted(Comparable [] a) { // Slide18
       return isSorted(a, 0, a.length - 1);
   }
   // is the array sorted from a[lo] to a[hi]
   private static boolean isSorted(Comparable[] a, int lo, int hi) {
       for (int i = lo + 1; i <= hi; i++)
           if (less(a[i], a[i-1])) return false;
       return true;
   }
   //is the array a[] sorted?
   private static boolean isSorted(Object[] a, Comparator c)
   {
       return isSorted(a, c, 0, a.length - 1);
   }
   // is the array sorted from a[lo] to a[hi]
   private static boolean isSorted(Object[] a, Comparator c,  int lo, int hi) {
       for (int i = lo + 1; i <= hi; i++)
           if (less(c, a[i], a[i-1])) return false;
       return true;
   }
   //print array to standard output
   private static void show(Comparable[] a) { // Slide19
       for (int i = 0; i < a.length; i++) {
           StdOut.println(a[i]);
       }
   }
   public static void main(String[] args) {
       String[] a = StdIn.readAllStrings();
       Selection.sort(a);
       show(a);
   }
}
public class Merge {

    //this class should not be instantiated
    private Merge() { }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        //precondition: a[lo....] and a[min+1....hi] are sorted subarrays
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        //copy to aux[]    observe que é necessário copiar
        for  (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        //merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                a[k] = aux[j++];
            else if (j > hi)                 a[k] = aux[i++];
            else if (less(aux[j], aux[i]))   a[k] = aux[j++];
            else                             a[k] = aux[i++];
        }

        // postoondition: a[lo...hi] is sorted
        assert isSorted(a, lo, hi);
    }

    //mersort a[lo....hi] using auxiliary array aux[lo...hi]
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi ) {
        if (hi <= lo) return;
        int  mid = lo + (hi -lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+ 1, hi);
        merge(a, aux, lo, mid, hi);
    }
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
        assert isSorted(a);
    }
    private static boolean less(Comparable v, Comparable w) {
        return  v.compareTo(w) < 0;
    }
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[j];
        a[i] = a[j];
        a[j] = swap;
    }
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Merge.sort(a);
        show(a);
    }
    private static boolean isSorted(Comparable [] a) { // Slide18
        return isSorted(a, 0, a.length - 1);
    }
    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
}
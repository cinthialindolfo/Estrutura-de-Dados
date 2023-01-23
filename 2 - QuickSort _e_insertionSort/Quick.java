public class Quick {

    //this class should not be instantiated
    private Quick(){ }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }
    //quicksort the subarray from a[lo] to a[hi]
    private static void sort(Comparable[] a , int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1,hi);
        assert isSorted(a, lo, hi);
    }
    private static int partition(Comparable [] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {

            //finf item on lo to swap
            while (less(a[++i], v))
                if (i == hi) break;

            //find item on hi to swap
            while (less(v, a[--j]))
                if (j == lo) break; //reduntant since a[lo]

            //check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        //put partitioning item v at a[j]
        exch(a, lo, j);

        //now, a[lo... j-1] <= a[j] <= a[j+1....hi]
        return j;
    }
    //funçoes do sorting
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    //check if array is sorted - useful for debugginig
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    //print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
    public static void main( String[] args) {
        String[] a = StdIn.readAllStrings();
        Quick.sort(a);
        show(a);

        //shuffle
        StdRandom.shuffle(a);

        //display results again using select
        StdOut.println();

    }
}

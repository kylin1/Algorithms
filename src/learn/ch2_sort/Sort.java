package learn.ch2_sort;

/**
 * Created by kylin on 27/05/2017.
 * All rights reserved.
 */
public abstract class Sort {

    public abstract void sort(Comparable[] a);

    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

}

package learn.ch2_sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by kylin on 27/05/2017.
 * All rights reserved.
 */
public class QuickSort extends Sort {

    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (low >= high)
            return;
        // 先把数组分成大小两部分,以middle间隔
        int middle = partition(a, low, high);
        // 左侧排序
        sort(a, low, middle);
        // 右侧排序
        sort(a, middle + 1, high);
    }

    private int partition(Comparable[] a, int low, int high) {

    }

}

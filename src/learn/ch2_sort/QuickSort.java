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

    public void sort3Way(Comparable[] a) {
        StdRandom.shuffle(a);
        sort3Way(a, 0, a.length - 1);
    }

    private void sort3Way(Comparable[] a, int low, int high) {
        if (low >= high) return;
        int lessThan = low, i = low + 1, greatThan = high;
        Comparable middle = a[low];
        // less than middle     equals middle      great than middle
        //   i=low+1                                          gt=high
        // [low, lessThan-1] [lessThan,greatThan] [greatThan+1,high]

        while (i <= greatThan) {
            int cmp = a[i].compareTo(middle);
            // a[i] < middle, change lessThan and i, increase two
            if (cmp < 0) exch(a, lessThan++, i++);
                // a[i] > middle, change greatThan and i, decrease greatThan
            else if (cmp > 0) exch(a, i, greatThan--);
            // a[i] == middle, increase i
            else i++;
        }
        //[lessThan,greatThan] == middle, not need to sort
        sort3Way(a,low,lessThan-1);
        sort3Way(a,greatThan+1,high);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (low >= high)
            return;
        // 可以改成 if(low + M >= high) 调用插入排序,处理小数组 M:5-15

        // 先把数组分成大小两部分,以middle间隔
        int middle = partition(a, low, high);
        // 左侧排序
        sort(a, low, middle - 1);
        // 右侧排序
        sort(a, middle + 1, high);
    }

    /**
     * 将一个数组[low,high]划分为大小两部分,返回中间位置的下标
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    private int partition(Comparable[] a, int low, int high) {
        if (low >= high)
            return high;
        Comparable middleOne = a[low];

        int i = low;
        int j = high + 1;

        while (true) {
            // 一直移动左侧指针到 a[i] >= middleOne 为止
            while (less(a[++i], middleOne)) if (i == high) break;
            // 一直移动右侧指针到 middleOne >= a[j] 为止
            while (less(middleOne, a[--j])) if (j == low) break;
            // 如果数组遍历完毕
            if (i >= j) break;
            // 此时 a[i] >= middleOne >= a[j], 目标是翻过来的
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }

}

package learn.ch2_sort;

/**
 * Created by kylin on 27/05/2017.
 * All rights reserved.
 * <p>
 * 需要的时间是 N logN
 * 空间与N大小成正比
 */
public class MergeSort extends Sort {

    //并归排序需要一个辅助数组进行合并操作
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        sort(a, 0, N - 1);
    }

    /**
     * 自底向上的并归排序
     *
     * @param a
     */
    public void sortBottomUp(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        // size = 1,2,4,8,16... 从size小的开始排序,先排大小是2的数组...并归,再排大小是4的
        for (int size = 1; size < N; size += size) {
            // size = 1,low = 0,2,4,6,8,...
            // size = 2,low = 0,4,8,12...
            // size = 4,low = 0,8,16...
            for (int low = 0; low < N - size; low += size + size) {
                // 每次对[low,low+size + size-1]归并
                // size = 2,low = 0,4,8,12...
                // 每次归并[0,3] [4,7] [8,11]
                int high = Math.min(low + size + size - 1, N - 1);
                merge(a, low, low + size - 1, high);
            }
        }
    }

    /**
     * 内部实现排序操作
     *
     * @param a    数组
     * @param low  排序下界
     * @param high 排序上界
     */
    private void sort(Comparable[] a, int low, int high) {
        if (low >= high)
            return;
        int middle = (low + high) >> 1;

        // sort left and right part
        sort(a, low, middle);
        sort(a, middle + 1, high);

        // then merge them
        merge(a, low, middle, high);
    }

    /**
     * 原地归并,将一个数组的两部分[low,mid],[mid+1,high]
     * 按顺序合并到一个数字[low,high]中
     *
     * @param a
     * @param low
     * @param middle
     * @param high
     */
    private void merge(Comparable[] a, int low, int middle, int high) {
        // copy from a to aux
        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }

        // merge aux into a
        int index1 = low;
        int index2 = middle + 1;
        int next;
        // TODO 下面的并归代码自己没写出来!!! 考虑左右都用完的情况!!!
        for (int i = low; i <= high; i++) {
            // left part is empty, next is right !!!
            if (index1 > middle)
                next = index2++;
                // right part is empty, next is left !!!
            else if (index2 > high)
                next = index1++;
                // both part is not empty, compare: left < right, use index1
            else if (less(aux[index1], aux[index2]))
                next = index1++;
                // left >= right, use index2
            else
                next = index2++;
            // set a[i] = next element
            a[i] = aux[next];
        }
    }

}

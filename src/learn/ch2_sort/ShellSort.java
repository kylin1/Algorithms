package learn.ch2_sort;

/**
 * Created by kylin on 27/05/2017.
 * All rights reserved.
 * <p>
 * 任意间隔为h的元素都是有序的:h有序数组
 * 对于每一个h,将子数组独立地使用插入排序
 * <p>
 * 排序开始的时候,每个子数组都很短
 * 排序结束的时候,每个子数组都部分排序
 * 这两点都适合插入排序
 * <p>
 * 数组越大,希尔排序比插入和选择排序的优势越大
 * 还不需要额外的内存空间
 * 需要的平均比较次数不是N的平方,次方比平方小,数学证明困难
 */
public class ShellSort extends Sort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        // generate increase sequence h
        int h = 1;
        // h = 1, 4, 13, 40, 121 ...
        while (h < N / 3)
            h = 3 * h + 1;
        // start shell sort, h decrease from one num to 1
        while (h >= 1) {
            // sort array to h-sorted
            for (int i = h; i < N; i++) {
                // 将a[i]插入到a[i-h],a[i-2h],a[i-3h],...,中
                // 也就是一个小数组的排序,总共有 h-->N-1多个小数组
                // 例如,h=4,N=10,
                // i = 4,5,6,7,8,9
                // i = 4, 插入 a[0] a[-4]
                // i = 5, 插入 a[1] a[-3]
                // i = 8, j = 8,4,0
                // i = 9, 插入 a[5] a[1] a[-3] j=9,5,1,-3
                // 插入a[i]到前面所有间隔h的范围
                for (int j = i; j >= h && less(a[j],a[j-h]); j -= h) {
                    exch(a,j,j-h);
                }
            }
            // change h to smaller one until it is 1
            h = h / 3;
        }
    }
}
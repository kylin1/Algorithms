package learn.ch2_sort;

/**
 * Created by kylin on 27/05/2017.
 * All rights reserved.
 * <p>
 * 整理扑克牌,每次插入一个元素到前面的适当位置
 * <p>
 * 一般的情况下, 0.25 N^2 比较 和 移动(不会比较比插入元素更小的元素)
 * 比如,前面是1 2 3 4 5 6,现在插入3.5, 则只会移动 4 5 6, 1 2 3 并不动
 * 而选择排序每次都比较所有的
 *
 * 最坏的情况下, 倒序, 0.5 N^2 比较 和 移动
 * 最好的情况下, 正序, N-1 比较, 0次移动(交换)
 *
 * 对于部分有序的数组很高效/小规模数组
 *
 * 交换的次数和数组中倒置的数目相同,倒置为0,排序结束
 * 一次交换,一次比较
 */
public class InsertSort extends Sort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        // insert a[i] to [0,i-1]
        for (int i = 1; i < N; i++) {
            // if a[j] < a[j-1], exchange them
            // i = 1, j = 1, less(a[1],a[0]) : change them so a[0]<a[1]
            // i = 2, j = 2, a[2]<a[1], j=1, a[1]<a[0]
            // i = 3, j = 3, 3<2, 2<1, 1<0
            // 插入a[i] 至  i 到 1 的范围
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}

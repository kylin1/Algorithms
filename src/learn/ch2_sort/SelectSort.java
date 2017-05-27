package learn.ch2_sort;

/**
 * Created by kylin on 27/05/2017.
 * All rights reserved.
 * <p>
 * 外层循环选择最小的数据放到第一个/第二个
 * 内层循环比较找出最小的数据
 * <p>
 * 比较的次数是 1+2+3+...+n-1
 * 交换的次数是 n,交换次数(移动次数)是最少的,其他任何算法都不具备这个特点!
 * <p>
 * 运行时间和输入无关,每一次扫描找最小的,与下一次扫描无关
 * 输入数据是有序的/无序的,都需要扫描全部
 */
public class SelectSort extends Sort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        // exchange N-1 times
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            // find the smallest one in [i+1,n-1]
            for (int j = i + 1; j < N; j++) {
                // a[j] < a[i], change smallest
                if (less(a[j], a[minIndex]))
                    minIndex = j;
            }
            // change a[i] with a[smallest]
            exch(a, i, minIndex);
        }
    }
}

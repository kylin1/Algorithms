package learn.ch2_sort;

/**
 * Created by kylin on 28/05/2017.
 * All rights reserved.
 */
public class Heap<Key extends Comparable> extends PriorityQueue {

    private Key[] pq;

    private int N = 0;

    public Heap(int max) {
        super(max);
        pq = (Key[]) new Comparable[max + 1];
    }

    @Override
    public void insert(Comparable a) {
        Key newOne = (Key) a;
        pq[++N] = newOne;       //直接插入到末尾
        swim(N);                //调整顺序
    }


    @Override
    public Comparable delete() {
        Key Max = pq[1];       //返回最大元素
        exch(pq, 1, N);     //交换最大元素和最后一个
        pq[N] = null;          //删除最后一个元素
        sink(1);            //恢复堆的顺序
        N--;                   //大小-1
        return Max;            //返回结果
    }


    @Override
    public Comparable peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void sort(Comparable[] a) {

    }

    private void swim(int n) {

    }

    private void sink(int i) {

    }


}

package learn.ch2_sort;

/**
 * Created by kylin on 28/05/2017.
 * All rights reserved.
 * <p>
 * 删除最大/最小元素 并增加新的元素->优先队列数据结构
 */
public abstract class PriorityQueue<Key extends Comparable> extends Sort{

    public PriorityQueue() {

    }

    public PriorityQueue(int max) {

    }

    public PriorityQueue(Key[] a) {

    }

    public abstract void insert(Key a);

    // 删除最大元素并返回
    public abstract Key delete();

    // 只返回最大元素
    public abstract Key peek();

    public abstract boolean isEmpty();

    public abstract int size();
}

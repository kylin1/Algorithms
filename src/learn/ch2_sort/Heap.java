package learn.ch2_sort;

/**
 * Created by kylin on 28/05/2017.
 * All rights reserved.
 */
public class Heap extends PriorityQueue {

    private Comparable[] pq;

    private int N = 0;

    public Heap(int max) {
        pq = new Comparable[max + 1];
    }

    public Heap(Comparable[] a) {
        int size = a.length;
        pq = new Comparable[size + 1];
        for (Comparable one : a)
            pq[++N] = one;
    }

    @Override
    public void insert(Comparable a) {
        Comparable newOne = a;
        pq[++N] = newOne;             //直接插入到末尾
        swim(N, 1);              //调整顺序
    }


    @Override
    public Comparable delete() {
        Comparable Max = pq[1];       //返回最大元素
        exch(pq, 1, N);            //交换最大元素和最后一个
        pq[N] = null;                 //删除最后一个元素
        N--;                          //大小-1
        sink(1, N);            //恢复堆的顺序
        return Max;                   //返回结果
    }


    @Override
    public Comparable peek() {
        return pq[1];
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
        // 首先按输入顺序放入数组
        int size = a.length;
        pq = new Comparable[size + 1];
        for (int i = 1; i <= size; i++) {
            pq[i] = a[i - 1];
        }

        // 对数组进行建立堆的操作
        int start = size >> 1;
        for (int i = start; i >= 1; i--) {
            sink(i, size);
        }

        // 按照顺序从大到小输出
        int index = 0;
        while (N > 0){
            a[index++] = delete();
        }
    }

    /**
     * 把一个元素向上浮动
     * 用于插入一个新的元素
     */
    private void swim(int newNode, int end) {
        // 一直上浮到root
        int father = newNode >> 1;
        // newNode > 1 && father < newNode
        while (newNode > end && less(pq[father], pq[newNode])) {
            exch(pq, father, newNode);
            newNode = father;
            father = father >> 1;
        }
        // newNode = 1
    }

    /**
     * 把一个元素向下放置
     * 用于删除最大元素重新调整堆
     */
    private void sink(int target, int end) {
        // 一直下沉到叶子节点, 也就是target一直不是叶子,至少有左后代
        while ((target << 1) <= end) {
            // find the bigger son
            int leftSon = target << 1;
            int rightSon = leftSon + 1;
            int biggerSon = leftSon;
            // 如果有右后代 且 left son < right son
            if (rightSon <= N && less(pq[leftSon], pq[rightSon])) {
                biggerSon = rightSon;
            }

            // if target >= biggerSon, no need to sink more
            if (!less(pq[target], pq[biggerSon])) break;

            // target < biggerSon, switch
            exch(pq, target, biggerSon);

            // sink to next level
            target = biggerSon;
        }
        // target * 2 > end, target已经是叶子节点
    }

    public static void main(String[] args) {
        Integer input[] = {0, 3, 6, 1, 2, 4, 3};
        Heap heap = new Heap(input);
        heap.sink(1, input.length);

        input = new Integer[]{10, 9, 8, 7, 6, 5, 20};
        heap = new Heap(input);
        heap.swim(input.length, 1);
    }

}

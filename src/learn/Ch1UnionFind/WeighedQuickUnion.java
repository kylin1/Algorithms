package learn.Ch1UnionFind;

/**
 * Created by kylin on 25/05/2017.
 * All rights reserved.
 * <p>
 * 加权的quick union
 * 解决问题:树变成直的
 * 解决方法:总是把较小的深度小的树,链接到深度大的树,
 * 减少数深度的增加
 * 对数级别性能
 *
 * N个节点,深林任意节点深度最大为logN
 */
public class WeighedQuickUnion extends UnionFind {

    // each root node size
    private int[] size;

    public WeighedQuickUnion(int N) {
        super(N);
        size = new int[N];
        for (int i = 0; i < N; i++) {
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }

        if(size[i] < size[j]){
            id[i] = j;
            size[j] += size[i];
        }else {
            id[j] = i;
            size[i] += size[j];
        }
        count--;
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public int count() {
        return count;
    }
}

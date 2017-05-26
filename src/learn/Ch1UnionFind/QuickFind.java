package learn.Ch1UnionFind;

/**
 * Created by kylin on 25/05/2017.
 * All rights reserved.
 *
 * 使用数组表示各个节点,
 * 数组里面存的值代表一个联通分类的ID
 * 处在一个联通分量的各个节点,对应的值,是相同的
 *
 * find直接返回节点的数组值
 * union修改所有这些节点的值为一个值
 */
public class QuickFind extends UnionFind {

    public QuickFind(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        // 找到p q对应的联通分量的ID
        int pid = find(p);
        int qid = find(q);

        // 如果两个点已经联通
        if(pid == qid){
            return;
        }

        // 看做q是后来的
        // 将原来所有p的值，全部变成q的值
        for (int i = 0; i < id.length; i++) {
            // 原来和p相连接的i下表
            if(id[i] == pid){
                // 全部变成qid
                id[i] = qid;
            }
        }

        count--;
    }



}

package learn.Ch1UnionFind;

/**
 * Created by kylin on 25/05/2017.
 * All rights reserved.
 *
 * 使用树状结构代表
 * find返回的是一个节点的根节点,
 *
 * 两个节点根节点相同,说明两者在一个树上,也就是联通
 *
 * union把一个节点的根节点连接到另外一个根节点
 * 也就是两个树的根合并
 *
 * 仍然是平方级别的N次union(一颗直直的树)
 */
public class QuickUnion extends UnionFind {

    public QuickUnion(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        // 这里的ID就相当于root
        while (id[p] != p)
            p = id[p];
        return p;
    }

    @Override
    public void union(int p, int q) {
        int proot = find(p);
        int qroot = find(q);

        if (proot == qroot) {
            return;
        }

        // 将qroot赋值给id[proot],也就是p跟节点指向了q的根节点

        id[proot] = qroot;
        count--;
    }

}

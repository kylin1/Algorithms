package LeetCode.tag.unionFind;

/**
 * 加权UF的实现
 * 数组记录父亲节点
 * find返回根节点
 * <p>
 * union把小树的 根节点 连接到 大树 上面
 */
class UF {

    private int[] id, size;
    private int count;

    public UF(int count) {
        this.count = count;
        id = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }

        int bigger = size[i] > size[j] ? i : j;
        int smaller = i + j - bigger;

        id[smaller] = bigger;
        size[bigger] += size[smaller];

        count--;
    }

    public int find(int p) {
        // find the root node of p
        int pParent = p;
        while(id[pParent]!=pParent){
            pParent=id[pParent];
        }

        // link all node in the path directly to the root
        while(id[p]!= p){
            p=id[p];
            id[p]=pParent;
        }

        return pParent;
    }

    public int count() {
        return count;
    }

}

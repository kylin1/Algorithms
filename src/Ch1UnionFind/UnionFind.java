package Ch1UnionFind;

/**
 * Created by kylin on 25/05/2017.
 * All rights reserved.
 */
// 抽象类是不能存在实例对象的，换句话说就是抽象类就是为了被继承而存在的。
public abstract class UnionFind {

    // 各个触点，下表0-N
    protected int[] id;

    // 联通分量的数量,刚开始无联通，是N
    protected int count;

    public UnionFind(int N) {
        this.id = new int[N];
        this.count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // 一个类中如果有抽象方法，则这个类必须是抽象类
    // 两个子类都分别实现了抽象方法study(),不实现就会报错。
    public abstract int find(int p);

    public abstract void union(int p, int q);

    protected boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    protected int getCount() {
        return this.count;
    }
}

package learn.ch1_union_find;

import org.junit.Test;

/**
 * Created by kylin on 25/05/2017.
 * All rights reserved.
 */
public class UnionFindTest {

    @Test
    public void test(){
        UnionFind unionFind = new WeighedQuickUnion(10);
        unionFind.union(4,3);
        unionFind.union(3,8);
        unionFind.union(6,5);
        unionFind.union(9,4);
        unionFind.union(2,1);
        unionFind.union(8,9);
        unionFind.union(5,0);
        unionFind.union(7,2);
        unionFind.union(6,1);
        unionFind.union(1,0);

    }

}

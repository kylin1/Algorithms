package Ch1UnionFind;

import org.junit.Test;

/**
 * Created by kylin on 25/05/2017.
 * All rights reserved.
 */
public class UnionFindTest {

    @Test
    public void test(){
        UnionFind unionFind = new WeighedQuickUnion(10);
        unionFind.union(1,3);
        unionFind.union(1,3);
        unionFind.union(1,3);
    }

}

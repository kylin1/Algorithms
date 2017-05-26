package LeetCode.tag.unionFind;

/**
 * Created by kylin on 26/05/2017.
 * All rights reserved.
 * <p>
 * There are N students in a class. Some of them are friends, while some are not.
 * Their friendship is transitive in nature.
 * For example, if A is a direct friend of B, and B is a direct friend of C,
 * then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 * <p>
 * output the total number of friend circles among all the students.
 */
public class No547 {
    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1},
        };
        No547 solution = new No547();
        System.out.println(solution.findCircleNum(input));
    }


    public int findCircleNum(int[][] M) {
        int n = M.length;
        if (n == 0) {
            return 0;
        }
        UF uf = new UF(n);
        int notFriend = 0;
        // n friend
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                // union two friends
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.count() - notFriend;
    }
}



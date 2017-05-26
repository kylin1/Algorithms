package LeetCode.tag.unionFind;

import MyUtil.MyPrint;

/**
 * Created by kylin on 26/05/2017.
 * All rights reserved.
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands.
 * <p>
 * An island is surrounded by water and is formed by
 * connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class No200 {

    public static void main(String[] args) {
        No130 regions = new No130();
        char[][] board = {
                {'1', '1', '1', '1', '0',},
                {'1', '1', '0', '1', '0',},
                {'1', '1', '0', '0', '0',},
                {'0', '0', '0', '0', '0',},
        };
        MyPrint.print(board);
        No200 solution = new No200();
        int result = solution.numIslands(board);
        System.out.println(result);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        int numOfSea = 0;
        UF uf = new UF(n * m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // connect all land together
                if (grid[i][j] == '1') {
                    int thisNode = i * m + j;
                    // i+1,j
                    if (i + 1 < n && grid[i + 1][j] == '1')
                        uf.union((i + 1) * m + j, thisNode);
                    // i,j+1
                    if (j + 1 < m && grid[i][j + 1] == '1')
                        uf.union(i * m + j + 1, thisNode);
                    // one grid of sea
                } else {
                    numOfSea++;
                }
            }
        }
        return uf.count() - numOfSea;
    }
}

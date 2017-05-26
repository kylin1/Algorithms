package LeetCode.tag.unionFind;

import MyUtil.MyPrint;

/**
 * Created by kylin on 25/05/2017.
 * All rights reserved.
 * <p>
 * capture all regions surrounded by 'X'.
 * <p>
 * if a region is NOT captured, it is connected to the boundry.
 */
public class No130 {

    public static void main(String[] args) {
        No130 regions = new No130();
        char[][] board = {
                {'O', 'X', 'X', 'O', 'X',},
                {'X', 'O', 'O', 'X', 'O',},
                {'X', 'O', 'X', 'O', 'X',},
                {'O', 'X', 'O', 'O', 'O',},
                {'X', 'X', 'O', 'X', 'O',},
        };
        MyPrint.print(board);
        regions.solve(board);
        System.out.println("result");
        MyPrint.print(board);
    }

    public void solve(char[][] board) {
        // 获得board的场合宽,构造m*n+1大小的UF
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        UF uf = new UF(m * n + 1);

        // 最后一个节点代表边界
        int dummyNode = n * m;

        // 遍历棋盘
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }
                int thisNode = i * m + j;

                // 如果是边界上的'O',则将它连接到伪造的一个点上,代表与边界相连
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    uf.union(dummyNode, thisNode);

                    // 如果是棋盘里面的0,将它连接到自己上下左右四个0上
                } else {
                    int iVariance[] = {-1, 1, 0, 0};
                    int jVariance[] = {0, 0, -1, 1};
                    // 4 adjacent node index
                    for (int k = 0; k < 4; k++) {
                        int iIndex = i + iVariance[k];
                        int jIndex = j + jVariance[k];
                        int adjacentNode = iIndex * m + jIndex;
                        // if in map and is 'O', union this node and its adjacent node
                        if (isInMap(iIndex, jIndex, n, m) && board[iIndex][jIndex] == 'O') {
                            uf.union(adjacentNode, thisNode);
                        }
                    }
                }

            }
        }

        // 遍历UF的结果,如果0不能够和边界相连,则再见,变成X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int thisPoint = i * m + j;
                if (board[i][j] == 'O' && !uf.connected(thisPoint, dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean isInMap(int i, int j, int n, int m) {
        return (i >= 0 && i <= n - 1 && j >= 0 && j <= m - 1);
    }
}


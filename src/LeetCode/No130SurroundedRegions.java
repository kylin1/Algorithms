package LeetCode;

import MyUtil.MyPrint;

/**
 * Created by kylin on 25/05/2017.
 * All rights reserved.
 * <p>
 * capture all regions surrounded by 'X'.
 * <p>
 * if a region is NOT captured, it is connected to the boundry.
 */
public class No130SurroundedRegions {

    public static void main(String[] args) {
        No130SurroundedRegions regions = new No130SurroundedRegions();
        char[][] board = {
                {'X', 'O', 'X', 'O', 'X', 'O',},
                {'O', 'X', 'O', 'X', 'O', 'X',},
                {'X', 'O', 'X', 'O', 'X', 'O',},
                {'O', 'X', 'O', 'X', 'O', 'X',},
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
            if (i == n - 1) {
                int x = 3;
            }

            for (int j = 0; j < m; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }
                int thisNode = i * m + j;

                // 如果是边界上的'O',则将它连接到伪造的一个点上,代表与边界相连
                if (isOnBoundary(i, j, n, m)) {
                    uf.union(thisNode, dummyNode);

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
                            uf.union(thisNode, adjacentNode);
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


    /**
     * is[i,j] on the boundary of [n * m]
     *
     * @param i
     * @param j
     * @param n
     * @param m
     */
    private boolean isOnBoundary(int i, int j, int n, int m) {
        return (i == 0 || i == n - 1 || j == 0 || j == m - 1);
    }

    private boolean isInMap(int i, int j, int n, int m) {
        return (i >= 0 && i <= n - 1 && j >= 0 && j <= m - 1);
    }
}

/**
 * 加权UF的实现
 * 数组记录父亲节点
 * find返回根节点
 * <p>
 * union把小树的 根节点 连接到 大树 上面
 */
class UF {

    private int[] id;
    private int[] size;
    private int count;

    public UF(int count) {
        this.count = count;

        id = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int proot = find(p);
        int qroot = find(q);

        if (proot == qroot) {
            return;
        }

        int psize = size[proot];
        int qsize = size[qroot];

        if (qsize > psize) {
            // q is bigger
            id[p] = qroot;
            size[q] += psize;
        } else {
            id[q] = proot;
            size[p] += qsize;
        }

        count--;
    }

    public int find(int p) {
        while (id[p] != p) {
            p = id[p];
        }
        return p;
    }

    public int count() {
        return count;
    }

}
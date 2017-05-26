package MyUtil;

/**
 * Created by kylin on 26/05/2017.
 * All rights reserved.
 */
public class MyPrint {

    public static void print(char[][] board){
        int n = board.length;
        if(n == 0){
            return;
        }
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

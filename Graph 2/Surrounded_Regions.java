import java.util.*;
public class Surrounded_Regions {
    int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    class pair {
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    void bfs(char[][] grid, int x, int y, boolean[][] visited) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            pair p = q.remove();
            for (int ar[] : directions) {
                int newx = p.x + ar[0];
                int newy = p.y + ar[1];
                if (newx >= 0 && newx < grid.length && newy >= 0 && newy < grid[0].length && grid[newx][newy] == 'O'
                        && visited[newx][newy] == false) {
                    q.add(new pair(newx, newy));
                    visited[newx][newy] = true;
                }
            }
        }
    }

    public void solve(char[][] board) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O' && !visited[i][0])
                bfs(board, i, 0, visited);
            if (board[i][board[0].length - 1] == 'O' && !visited[i][board[0].length - 1])
                bfs(board, i, board[0].length - 1, visited);
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O' && !visited[0][i])
                bfs(board, 0, i, visited);
            if (board[board.length - 1][i] == 'O' && !visited[board.length - 1][i])
                bfs(board, board.length - 1, i, visited);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && visited[i][j] == false)
                    board[i][j] = 'X';
            }
        }
    }
}


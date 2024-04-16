import java.util.*;
class Rotting_Oranges
{//https://leetcode.com/problems/rotting-oranges/description/
    int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    class pair {
        int x;
        int y;
        int t;

        pair(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    int bfs(Queue<pair> q, int[][] grid, int fresh) {
        int check = 0, max = 0;
        while (!q.isEmpty()) {
            pair p = q.remove();
            int x = p.x;
            int y = p.y;
            int t = p.t;
            for (int ar[] : directions) {
                int newx = x + ar[0];
                int newy = y + ar[1];
                if (newx >= 0 && newx < grid.length && newy >= 0 && newy < grid[0].length &&
                        grid[newx][newy] == 1) {
                    check++;
                    grid[newx][newy] = 2;
                    q.add(new pair(newx, newy, t + 1));
                }
            }
            max = Math.max(max, t);
        }
        if (fresh != check)
            return -1;
        return max;
    }

    public int orangesRotting(int[][] grid) {
        Queue<pair> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    q.add(new pair(i, j, 0));
                if (grid[i][j] == 1)
                    fresh++;
            }
        }
        return bfs(q, grid, fresh);
    }
}

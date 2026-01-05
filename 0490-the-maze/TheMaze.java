import java.util.*;

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        visited[start[0]][start[1]] = true;

        int[][] directions = {
            {1, 0},   // down
            {-1, 0},  // up
            {0, 1},   // right
            {0, -1}   // left
        };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            // If destination reached
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }

            for (int[] dir : directions) {
                int x = curr[0];
                int y = curr[1];

                // Roll the ball until it hits a wall
                while (x + dir[0] >= 0 && x + dir[0] < m &&
                       y + dir[1] >= 0 && y + dir[1] < n &&
                       maze[x + dir[0]][y + dir[1]] == 0) {
                    x += dir[0];
                    y += dir[1];
                }

                // If this stopping point is not visited
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return false;
    }
}

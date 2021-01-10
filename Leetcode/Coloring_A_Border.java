class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> qu = new LinkedList();
        int[] start = new int[] {r0,c0};
        qu.add (start);
        visited[r0][c0] = true;
        int colr =grid[r0][c0];
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while (!qu.isEmpty())
        {
            int[] curr = qu.poll();
            if (curr[0]==0 || curr[0] == m-1 || curr[1] == 0 || curr[1] == n-1)
                grid[curr[0]][curr[1]] = color;
            for (int j =0 ;j< 4;j+=1)
            {
                int r = curr[0] + dr[j];
                int c = curr[1] + dc[j];
                if (r>=0 && r < m && c>=0 && c< n && !visited[r][c])
                {
                    // inner boundary
                    if (grid[r][c] != colr)
                        grid[curr[0]] [curr[1]] = color;                    
                    
                    else
                    {
                        int[] child = new int[] {r,c};
                        qu.add (child);
                        visited[r][c] = true;
                    }
                }
            }
        }
        return grid;
    }
}

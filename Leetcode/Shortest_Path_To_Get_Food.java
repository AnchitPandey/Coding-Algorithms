class Solution {
    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] start = new int[2];
        Queue<int[]> qu = new LinkedList();
        for (int i= 0; i< m;i+=1)
        {
            for (int j= 0; j< n;j+=1)
            {
                if (grid[i][j] =='*')
                {
                    start[0] = i;
                    start[1] = j;
                    visited[i][j] = true;
                    qu.add (start);
                    break;
                }
            }
        }
        int[][] ans = new int[m][n];
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while (!qu.isEmpty())
        {
            int[] curr = qu.poll();
            if (grid[curr[0]][curr[1]] =='#')
                return ans[curr[0]][curr[1]];
            for (int j =0; j< 4;j+=1)
            {
                int r = curr[0] + dr[j];
                int c = curr[1] + dc[j];
                if (r>=0 && r < m && c>=0 && c<n && !visited[r][c] && grid[r][c] !='X')
                {
                    int[] child = new int[] {r,c};
                    visited[r][c] = true;
                    ans[r][c] = ans[curr[0]][curr[1]] +1;
                    qu.add (child);
                }
            }
        }        
        return -1;
    }
}

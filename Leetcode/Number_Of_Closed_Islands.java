class Solution {
    
    boolean surr = true;
    
    public void bfs (int x, int y, int[][] grid, boolean[][] visited)
    {
        Queue<int[]> qu = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        int[] root = new int[] {x,y};
        int[] dr ={-1,1,0,0};
        int[] dc = {0,0,-1,1};
        qu.add (root);
        while (!qu.isEmpty()) {
            int[] curr = qu.poll();
            if (curr[0] == 0 || curr[0] == m-1 || curr[1] == 0 || curr[1] == n-1)
               surr = false;
            for (int j =0; j< 4;j+=1)
            {
                int r = curr[0] + dr[j];
                int c = curr[1] + dc[j];
                if (r >=0 && r < m && c>=0 && c< n && !visited[r][c] && grid[r][c] ==0)
                {
                    visited[r][c] = true;
                    int[] child = new int[] {r,c};
                    qu.add (child);
                }
            }
        }
        return;
    }
    
    public int closedIsland(int[][] grid) {
        surr = true;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans =0;
        for (int i =0; i< m;i+=1)
        {
            for (int j =0;j < n;j+=1){
                
                if (!visited[i][j] && grid[i][j] ==0 ) {
                    visited[i][j] = true;
                    surr = true;
                    bfs (i,j,grid, visited);
                    if (surr)
                    {
                        //System.out.println("row , col is "+ i+","+ j);
                        ans+=1;
                    }
                }
            }        
        }
        return ans;
    }
}

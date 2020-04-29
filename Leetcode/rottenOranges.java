class rottenOranges {
    public int orangesRotting(int[][] grid) {
            
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost= new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> qu= new LinkedList<int[]>();
        int max = 0;
        int fresh = 0;
        for (int i =0 ; i< m;i+=1)
        {
            for (int j =0; j< n;j+=1)
            {
                if(grid[i][j] ==1)
                    fresh+=1;
                else if (grid[i][j] ==2)
                {
                    int[] temp = new int[] {i,j};
                    qu.add (temp);
                }
            }
        }
        if (fresh ==0 && qu.size() ==0)
            return 0;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        while (!qu.isEmpty())
        {
            if (fresh ==0)
                return max;
            int[] curr = qu.poll();
            for (int j =0; j< 4;j++)
            {
                int r = curr[0]+ dr[j];
                int c = curr[1] + dc[j];
                if (r >=0 && r <m && c>=0 && c<n && !visited[r][c] && grid[r][c] ==1)
                {
                    visited[r][c] = true;
                    cost[r][c] = 1 + cost [curr[0]][curr[1]];
                    fresh --;
                    max = cost[r][c];
                    int[] tt = new int[] {r,c};
                    qu.add (tt);
                }
            }            
        }
        return -1;
    }
}

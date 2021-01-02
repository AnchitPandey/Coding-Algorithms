class Solution {
    int ans =0;
    
    public void backTrack (int row, int col, int[][] grid, int rem)
    {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[row][col] == 2 && rem ==1)
        {
            ans+=1;
            return;
        }
        int[] dr= {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        int temp = grid[row][col];
        grid[row][col] = -4;
        for (int  i =0 ; i< 4;i++)
        {
            int r = row +dr[i];
            int c = col + dc[i];
            if (r>=0 && r < m && c>=0 && c<n && grid[r][c] >=0)
            {
                backTrack (r,c,grid,rem-1);   
            }
        }
        grid[row][col] = temp;
    }
    
    
    public int uniquePathsIII(int[][] grid) {
        
        ans  =0;
        int startRow = 0, startCol =0, total = 0;
        int m = grid.length;
        int n=  grid[0].length;
        for (int i=0; i< m; i+=1)
        {
            for (int j =0  ; j< n;j+=1)
            {
                if (grid[i][j] ==1)
                {
                    startRow = i;
                    startCol = j;
                }
                if (grid[i][j] >=0)
                    total+=1;
            }
        }
       // System.out.println(total);
        backTrack (startRow, startCol, grid, total);
        return ans;
    }
}

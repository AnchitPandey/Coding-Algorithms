class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] row  = new int[m];
        int[] col  = new int[n];
        for(int i = 0 ;i< m;i+=1)
        {
            int max = grid[i][0];
            for (int j =1 ; j < n;j+=1)
            {
                max = Integer.max (max, grid[i][j]);   
            }
            row[i] = max;
        }
        for(int i = 0 ;i< n;i+=1)
        {
            int max = grid[0][i];
            for (int j =1 ; j < m;j+=1)
            {
                max = Integer.max (max, grid[j][i]);   
            }
            col[i] = max;
        }
        int total =0;
        for (int i =0; i< m;i+=1)
        {
            for (int  j= 0 ; j< n;j++)
            {
                int min = Integer.min (row[i], col[j]);
                total += min - grid[i][j];
            }            
        }
        return total;
    }
}

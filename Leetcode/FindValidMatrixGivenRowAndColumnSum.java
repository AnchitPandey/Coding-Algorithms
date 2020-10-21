class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
     
        int m = rowSum.length;
        int n = colSum.length;
        int[][] fa = new int[m][n];
        
        int row = 0, col = 0;
        while (row < m && col < n)
        {
            int min = Integer.min (rowSum[row],colSum[col]);
            rowSum[row] -= min;
            colSum[col] -=min;
            fa[row][col] = min;
            if (rowSum[row] ==0)
                row+=1;
            if (colSum[col] ==0)
                col+=1;
        }        
        return fa;
    }
}

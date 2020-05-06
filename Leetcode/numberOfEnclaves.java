class numberOfEnclaves {
    public int numEnclaves(int[][] A) {
    
      int m = A.length;
      int n = A[0].length;
      boolean[][] visited = new boolean   [m][n];
      int[] dr = {-1,1,0,0};
      int[] dc = {0,0,-1,1};
      Queue<int[]> qu = new LinkedList<int[]>();
      
     // 1st and last row
      for (int i =0 ;i<n;i+=1)
      {
        if (A[0][i] == 1)
        {
            visited[0][i] = true;
             int[] temp = new int[]{0,i};
             qu.add (temp);
        }
        if (A[m-1][i] == 1)
        {
            visited[m-1][i] = true;
             int[] temp = new int[]{m-1,i};
             qu.add (temp);
        }      
      }
        
        // 1st and last column
            // 1st row
      for (int i =0 ;i<m;i+=1)
      {
        if (A[i][0] == 1)
        {
            visited[i][0] = true;
             int[] temp = new int[]{i,0};
             qu.add (temp);
        }
        if (A[i][n-1] == 1)
        {
            visited[i][n-1] = true;
             int[] temp = new int[]{i,n-1};
             qu.add (temp);
        }      
      }
    while (!qu.isEmpty())
    {
        int[] curr = qu.poll();
        for (int  i=0; i< 4; i+=1)
        {
            int r = curr[0]+ dr[i];
            int c = curr[1] + dc[i];
            if (r >=0 && r<m && c>=0 && c < n && !visited[r][c] && A[r][c] ==1)
            {
                visited[r][c] = true;
                qu.add (new int[]{r,c});
            }
        }
    }
        int counter =0;
        for(int i =0; i< m;i+=1)
        {
            for (int j =0; j< n;j+=1)
            {
                if (A[i][j] ==1 && !visited[i][j])
                    counter+=1;
                
            }            
        }
            return counter;        
    }
}

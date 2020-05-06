class matrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        
        ArrayList<int[]> pts = new ArrayList<int[]>();
        int[] dr  ={-1,1,0,0};
        int[] dc = {0,0,-1,1};
        Queue<int[]> qu = new LinkedList<int[]>();
      //  int index = 0 ;
        int[] tt = new int []{r0,c0};
        qu.add (tt);
        boolean[][] visited = new boolean[R][C];
        visited[r0][c0] = true;
        while (!qu.isEmpty())
        {
            int[] curr = qu.poll();         
                pts.add (curr);
            for (int i =0; i< 4;i+=1)
            {
                int r = curr[0] + dr[i];
                int c = curr [1] + dc[i];
                
                if (r>=0 && r<R && c>=0 && c< C && !visited[r][c])
                {
                  
                    visited[r][c] = true;
                    qu.add (new int[]{r,c});
                }
            }
        }
        
     
        int[][] fa = new int[pts.size()][2];
       //int indi =0 ;
        for (int i =0; i<pts.size();i+=1)
        {
            int[] get = pts.get(i);
            fa[i][0] = get[0];
            fa[i][1] = get[1];      
        }
        return fa;
    }
}

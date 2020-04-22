class shortestBridge {
    public int shortestBridge(int[][] A) {
        Queue<int[]> qu = new LinkedList<int[]>();
        int n = A.length;
        
        if (n <=1)
            return 0;
        
        int[][] marked = new int[n][n];
       outer: for (int i =0; i<n;i+=1)
        {
            for (int j =0; j< n;j+=1)
            {
                if (A[i][j] == 1)
                {
                    int[] temp = new int[]{i,j};
                    qu.add (temp);
                    break outer;
                }  
            }
        }
        
        Queue<int[]> qu1 = new LinkedList<int[]>();
        qu1.add (qu.peek());
        marked[qu.peek()[0]][qu.peek()[1]] = 2;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        while (!qu.isEmpty())
        {
            int[] curr = qu.poll();
            for (int j =0; j< 4;j+=1)
            {
                int r = curr[0] +dr[j];
                int c= curr[1] + dc[j];
                
                if (r < n && r >=0 && c < n && c>=0 && marked[r][c] !=2 && A[r][c] ==1)
                {
                    marked[r][c] =2;
                    int[] adder = new int[] {r,c};
                    qu1.add (adder);
                    qu.add (adder);
                }               
            }            
        }
        
      
        
        
        int[][] cost = new int[n][n];
        boolean[][] visited = new boolean [n][n];
        visited[qu1.peek()[0]][qu1.peek()[1]] = true;
        
      //  System.out.println("visited matrix is ...");
        // for (int i= 0 ;i <n;i+=1)
        // {
        //     for (int j =0; j< n;j+=1)
        //     System.out.print(visited[i][j] +" ");
        //     System.out.println();
        // }
        
        while (!qu1.isEmpty())
        {
            int[] tt = qu1.poll();
          //  System.out.println("parent coords = "+tt[0]+", "+tt[1]);
            for (int j =0; j< 4;j+=1)
            {
                int r = tt[0] + dr[j];
                int c = tt[1] + dc[j];
                if (r >= 0 && r < n && c >=0 && c <n && !visited[r][c] && marked[r][c] !=2)
                {
               //     System.out.println("child coords = "+r+", "+c);
                    if (A[r][c] == 1)
                    {
                      //  System.out.println("reached here");
                        return cost[tt[0]][tt[1]];
                    }
                        else
                    {
                        cost[r][c] = cost[tt[0]][tt[1]] + 1;
                        visited[r][c]  = true;
                        int[] tempi = new int[] {r,c};
                        qu1.add (tempi);
                    }
                }
            }
        }
        
          // Printing marked 
        for (int i= 0 ; i< n;i+=1)
        {
            for (int j =0 ; j< n;j+=1)
                System.out.print(cost[i][j]+" ");
            System.out.println();
        }
    
        return -1;
    }
}

class isGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        
       int n = graph.length;
       ArrayList<Integer>[] vert = new ArrayList[n];
        HashMap<Integer, HashMap<Integer, Integer>> mapper = new HashMap<Integer, HashMap<Integer, Integer>>();
        
       for (int i =0 ; i< n;i+=1)
          vert[i] = new ArrayList<Integer>();
    
        int[] cost=  new int [n];
        Arrays.fill (cost,-1);
        int[] parent =new int[n];
        for (int i =0 ;i< n;i+=1)
            parent[i] = i;
        
        for (int i =0;  i< n; i+=1)
            for (int j =0 ; j < graph[i].length;j+=1)
                vert[i].add (graph[i][j]);   
            
        
        for (int i =0  ;i< n;i+=1)
        {
            if (cost[i] != -1)
                continue;
            cost[i] = 0;
            Queue<Integer> qu = new LinkedList<Integer>();
            qu.add (i);
            while (!qu.isEmpty())
            {
              //  System.out.println("############################");
                int curr = qu.poll();
            //    System.out.println("current node is "+ curr);
                for (int child: vert[curr])
                {
                   
                    if (cost[child] !=-1 && parent[curr] != child)
                    {
              //           System.out.println("child node is "+ child);
                        if (Math.abs (cost[curr] - cost[child]) %2 ==0)
                            return false;
                    }
                    else if (cost[child] ==-1)
                    {
                        cost[child] = 1 + cost[curr];
                        parent[child]  = curr;
                        qu.add (child);
                    }
                }              
            }     
        }
        return true;
    }
}

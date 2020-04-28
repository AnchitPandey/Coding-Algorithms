class timeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        ArrayList<Integer>[] vert = new ArrayList[n];
        for (int i=0; i< n;i+=1)
            vert[i] = new ArrayList<Integer>();
        
        for (int i =0 ; i< manager.length;i+=1)
        {
            if (manager[i]!= -1)
            {
                vert[i].add (manager[i]);
                vert[manager[i]].add (i);
            }
        }
      
        
        int[] visited = new int[n];
        for (int i = 0 ; i< n;i+=1)
            visited[i] = -1;
        
        visited[headID] = 0 ;
        Queue<Integer> qu = new LinkedList<Integer>();
        qu.add (headID);
        while (!qu.isEmpty())
        {
            int curr = qu.poll();
            ArrayList<Integer> children = vert[curr];
            for (int child : children)
            {
                if (visited[child] ==-1)
                {
                    visited [child] = visited[curr] + informTime[curr]; 
                    qu.add (child);
                }                
            }
        }
        
        int max= -1;
        for (int i =0; i< n;i+=1)
        {
          //  System.out.print(visited[i]+" ");
            max = Integer.max (visited[i],max);
        }
            return max;
    }
}

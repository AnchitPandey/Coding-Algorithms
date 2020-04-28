class possibleBiPartition {
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
     
    ArrayList<Integer>[] vert = new ArrayList[n];    
    for (int i =0; i< n;i+=1)
        vert[i] = new ArrayList<Integer>();
        
    int[] visited = new int[n];
    for (int i =0; i< n;i+=1)
        visited[i] = -1;
        
    for (int i =0; i< dislikes.length;i+=1)
    {
       int u = dislikes[i][0] -1;
       int v = dislikes[i][1] -1;
       vert[u].add (v);
       vert[v].add (u);
    }
        
        
     for (int i =0; i< n;i+=1)
     {
         if (visited[i] !=-1)
             continue;
         visited[i] =0;
        Queue<Integer> qu = new LinkedList<Integer>();
        qu.add (i);
         while (!qu.isEmpty())
         {
             int curr =qu.poll();
            ArrayList<Integer> children = vert[curr];
             for (int child: children)
             {
                 if (visited[child]!=-1)
                 {
                     if (Math.abs (visited[child] - visited[curr]) %2 ==0)
                         return false;
                 }
                 else
                 {
                     visited[child] = visited[curr]+1;
                     qu.add (child);
                 }
             }
         }
     
     }
        return true;
    }
}

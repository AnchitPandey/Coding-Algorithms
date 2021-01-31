class Solution {
    
    public int[] gardenNoAdj(int n, int[][] paths) {
  
        int[] ans = new int[] {1,2,3,4};
        ArrayList<Integer>[] ls = new ArrayList[n];
        for (int i =0 ;i< n;i+=1)
            ls[i] = new ArrayList();
        for (int i= 0 ; i< paths.length;i+=1)
        {
            int u = paths[i][0] -1;
            int v = paths[i][1] -1;
            ls[u].add (v);
            ls[v].add (u);
        }
        Queue<Integer> qu = new LinkedList();
        //qu.add (0);
        int[] type = new int[n];
        for (int node = 0; node< n;node+=1)
        {
            if (type[node] !=0)
                continue;
            qu.add (node);
            while (!qu.isEmpty())
            {
                int curr = qu.poll();
                Set<Integer> cannotUse = new HashSet();
                ArrayList<Integer> children = ls[curr];
                for (int child: children)
                    if (type[child] !=0)
                        cannotUse.add (type[child]); 
                for (int i= 0; i< 4;i+=1)
                {
                    if (!cannotUse.contains(ans[i]))
                    {
                        type[curr] = ans[i];
                        break;
                    }
                }
                for (int child: children)
                {
                    if (type[child] ==0)
                        qu.add (child);   
                }            
            }
        }
        return type;
    }
}

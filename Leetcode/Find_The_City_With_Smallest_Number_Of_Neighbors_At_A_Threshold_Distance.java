class custom implements Comparator<int[]> {
    
    public int compare (int[] o1, int[] o2)
    {
        return o1[1] - o2[1];
    }
}
class Solution {
    
    public int customDijkstra (int curr, ArrayList<int[]>[] ls, int dt)
    {
        int ans =0;
        PriorityQueue<int[]> pq = new PriorityQueue(new custom());
        Set<Integer> visited = new HashSet();
        visited.add (curr);
        ArrayList<int[]> chil = ls[curr];
        
        for (int[] child: chil)
        {
            pq.add (child);
        }
        while (!pq.isEmpty())
        {   
            int[] tt = pq.poll();
            if (visited.contains(tt[0]))
                continue;
            if (tt[1] > dt)
                break;
       
            ans +=1;
            visited.add (tt[0]);
            ArrayList<int[]> children = ls[tt[0]];
            for (int[] child: children)
            {
                if (!visited.contains(child[0]))
                {
                    int[] ttnew = new int[] {child[0], tt[1] + child[1]};
                    pq.add (ttnew);
                }
            }            
        }
        return ans;
    }
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dt = distanceThreshold;
        ArrayList<int[]>[] ls = new ArrayList[n];
        for (int i =0 ; i < n;i+=1)
            ls[i] = new ArrayList();
        for (int i=0 ;  i< edges.length;i+=1)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int dist = edges[i][2];
            int[] tt = new int[] {v,dist};
            ls[u].add (tt);
            tt = new int[] {u,dist};
            ls[v].add (tt);
        }
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i= 0; i < n;i+=1)
        {
            int numCities =  customDijkstra (i, ls, dt);
         //   System.out.println("##################");
           // System.out.println("current city number is "+ i);
           // System.out.println(numCities);
            if (numCities <= min)
            {
                min = numCities;
                ans = Integer.max (ans, i);
            }
        }    
        return ans;
    }
}

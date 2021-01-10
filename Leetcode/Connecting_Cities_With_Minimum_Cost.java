class custom implements Comparator<int[]> {
    // [node, val]
    public int compare (int[] o1, int[] o2)
    {
        return o1[1] - o2[1];
    }
}

class Solution {
    public int minimumCost(int N, int[][] connections) {
        
        ArrayList<int[]>[] ls = new ArrayList[N];
        
        for (int i =0 ; i< N;i+=1)
            ls[i] = new ArrayList();
        
        // adj list
        for (int i= 0 ;i< connections.length;i+=1)
        {
            int u = connections[i][0] -1;
            int v = connections[i][1] -1;
            int[] tt1 = new int[] {v, connections[i][2]};
            ls[u].add (tt1);
            int[] tt2 = new int[] {u, connections[i][2]};
            ls[v].add (tt2);
        }
        
        int ans = 0;
        // prims algo
        Set<Integer> visited = new HashSet();
        visited.add (0);
        PriorityQueue<int[]> pq = new PriorityQueue(new custom());
        // initialize pq
        for (int i =0 ; i< ls[0].size();i+=1)
        {
            int[] gets = ls[0].get(i);
            pq.add (gets);
        }
        while (!pq.isEmpty())
        {
            int[] curr = pq.poll();
            if (visited.contains(curr[0]))
                continue;
            visited.add (curr[0]);
            ans += curr[1];
            ArrayList<int[]> children = ls[curr[0]];
            for (int[] child: children)
            {
                if (!visited.contains(child[0]))
                    pq.add (child);
            }
        }
        if (visited.size() != N)
            return -1;            
        return ans;
    }
}

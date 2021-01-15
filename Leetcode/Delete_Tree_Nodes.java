class Solution {
    
    public void dfs (int curr, int[] sum, int[] value, HashMap<Integer, ArrayList<Integer>> mapper) {
        if (!mapper.containsKey (curr))
        {
            sum[curr] = value[curr];
            return;
        }
        int num =0;
        ArrayList<Integer> children = mapper.get(curr);
        for (int child: children) {
            if (sum[child] == Integer.MIN_VALUE)
                dfs (child, sum, value, mapper);
            num += sum[child];
        }
        sum[curr] = num + value[curr];
    }
    
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int[] sum = new int[nodes];
        Arrays.fill (sum , Integer.MIN_VALUE);
        HashMap<Integer, ArrayList<Integer>> mapper = new HashMap();
        for (int i =1 ; i< nodes;i+=1)
        {
            if (!mapper.containsKey (parent[i])) {
                
                ArrayList<Integer> children = new ArrayList();
                mapper.put (parent[i], children);
            }   
            ArrayList<Integer> children = mapper.get(parent[i]);
            children.add (i);
        }
     //  System.out.println(mapper); 
        // dfs
        dfs (0, sum, value, mapper);
        int fa =0;
        
        // bfs
        Queue<Integer> qu = new LinkedList();
        qu.add (0);
        while (!qu.isEmpty()) {
            int curr = qu.poll();
            if (sum[curr] ==0)
                continue;
            fa+=1;
            ArrayList<Integer> children = mapper.get(curr);
            if (children == null)
                continue;
            for (int child: children)
                qu.add (child);
        }
        return fa;
    }
}

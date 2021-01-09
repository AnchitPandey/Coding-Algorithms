class Solution {
    List<List<Integer>> ans;
    
    public List<Integer> clone (List<Integer> temp) {
        
        List<Integer> cloned = new ArrayList();
        for (int num: temp)
            cloned.add (num);        
        return cloned;
    }
    public void dfs (int start, int[][] graph, int end, List<Integer> temp)
    {
        temp.add (start);
        if (start == end)
        {
            List<Integer> cloned = clone (temp);
            ans.add (cloned);
            temp.remove (temp.size()-1);
            return;
        }
        for (int i =0 ;i< graph[start].length;i+=1)
        {
            int child = graph[start][i];
            dfs (child, graph, end,temp);
        }        
        temp.remove(temp.size()-1);
        return;
    }
        
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    
        ans = new ArrayList();
        int n = graph.length;
        List<Integer> temp = new ArrayList();
        dfs (0, graph, n-1, temp);
        return ans;
    }
}

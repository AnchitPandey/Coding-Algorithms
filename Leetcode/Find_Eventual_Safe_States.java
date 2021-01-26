class Solution {

   
    public void dfs (int currNode, Set<Integer> currStack, HashMap<Integer, Boolean> visited,
                    int[][] graph)
    {        
         boolean cycle = false;
         for (int i = 0; i< graph[currNode].length;i+=1)
         {
             int child = graph[currNode][i];
             if (currStack.contains(child) || (visited.containsKey(child) && visited.get(child)))
             {
                 cycle = true;
                 break;
             }
             if (!visited.containsKey (child))
             {
                 currStack.add (child);
                 dfs (child,currStack,visited,graph);
                 currStack.remove (child);
                 if (visited.get(child))
                 {
                    cycle = true;
                     break;
                 }
             }      
         }
        visited.put (currNode, cycle);
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
         List<Integer> ans = new ArrayList();
         HashMap<Integer, Boolean> visited = new HashMap();
         Set<Integer> currStack = new HashSet();
         int n = graph.length;
         for (int i =0 ; i< n;i+=1)
         {
            if (!visited.containsKey(i))
            {
                currStack.add (i);
                dfs (i,currStack,visited, graph);
                currStack.remove (i);
            }             
         }
        for (int i =0 ; i< n;i+=1)
        {
            if (!visited.containsKey(i) || !visited.get(i))
                ans.add (i);
        }
        Collections.sort (ans);
        return ans;
    }
}

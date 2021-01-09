class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet();
        for (int i =0; i < edges.size();i+=1)
        {
            List<Integer> edg = edges.get(i);
            set.add (edg.get(1));
        }
        List<Integer> ans = new ArrayList();
        for(int i =0; i<= n-1;i+=1)
        {
            if (!set.contains(i))
                ans.add (i);
        }
        return ans;
    }
}

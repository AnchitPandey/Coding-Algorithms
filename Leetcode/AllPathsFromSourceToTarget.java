class Solution {
   
    
     List<List<Integer>> fa;
    public void callme (int curr, List<Integer> temp, int last, int[][] graph) 
    {
        if (curr == last)
        {
            List<Integer> putter = new ArrayList<Integer>();
            for (int i =0 ; i< temp.size();i+=1)
                putter.add (temp.get(i));
            
            fa.add (putter);
            return;
        }
        for (int j =0;  j< graph[curr].length;j+=1)
        {
            int child = graph[curr][j];
            temp.add (child);
            callme (child,temp, last, graph);
            temp.remove (temp.size()-1);
        }
        return;
    }
    
   public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n =graph.length -1;
       fa = new ArrayList<List<Integer>>();
       List<Integer> temp =new ArrayList<Integer>();
       temp.add (0);
       callme (0, temp, n, graph);
       return fa;
   }
}

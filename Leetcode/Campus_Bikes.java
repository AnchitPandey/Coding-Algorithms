class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        
        // bucket for storing distances and  {worker_index, bike_index} 
         ArrayList<int[]>[] ls = new ArrayList[2001];
        // add all pairs to the buckets 
        for (int i = 0; i < workers.length;i +=1)
         {
             for (int j =0; j < bikes.length; j+=1)
             {
                int dist = Math.abs (workers[i][0] - bikes[j][0]) + Math.abs (workers[i][1] - bikes[j][1]);
                if (ls[dist] == null)
                {
                    ls[dist] = new ArrayList();
                }
                int[] tt = new int[] {i,j};
                ls[dist].add (tt);
             }
         }
        
            
            int[] ans = new int[workers.length];
            Set<Integer> set = new HashSet();
            Arrays.fill (ans,-1);
        // travel from smallest to largest distance and pair workers & bikes that are not yet paired 
        for (int i = 0; i<2001;i+=1)
            {
                if (ls[i] == null)
                    continue;
                for(int j =0; j < ls[i].size();j+=1)
                {
                    int[] tt = ls[i].get(j);
                    if (set.contains(tt[1]) || ans[tt[0]] !=-1)
                        continue;
                    ans[tt[0]] = tt[1];
                    set.add (tt[1]);
                }                
            }
        return ans;
    }
}

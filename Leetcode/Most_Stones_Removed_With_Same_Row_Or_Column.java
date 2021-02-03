class Solution {
    public int removeStones(int[][] stones) {
        HashMap<Integer,ArrayList<Integer>> xmapper = new HashMap();
        HashMap<Integer, ArrayList<Integer>> ymapper =new HashMap();
        int m = stones.length;
        for (int i =0 ; i< m;i+=1)
        {
            if (!xmapper.containsKey (stones[i][0]))
            {
                ArrayList<Integer> ls = new ArrayList<Integer>();
                xmapper.put (stones[i][0],ls);
            }
            if (!ymapper.containsKey (stones[i][1]))
            {
                ArrayList<Integer> ls = new ArrayList<Integer>();
                ymapper.put (stones[i][1], ls);
            }
            ArrayList<Integer> ls = xmapper.get(stones[i][0]);
            ls.add (i);
            ls = ymapper.get(stones[i][1]);
            ls.add (i);
        }
        Queue<Integer> qu = new LinkedList();
        
        int ans= 0;
        Set<Integer> visited = new HashSet();
        for (int i =0; i < m;i+=1)
        {
            if (visited.contains(i))
                continue;
            visited.add (i);
            int current= 0;
            qu.add (i);
            while (!qu.isEmpty())
            {
                int curr = qu.poll();
                current+=1;
                ArrayList<Integer> ls = xmapper.get(stones[curr][0]);
                for (int child:ls)
                {
                    if (visited.contains (child))
                        continue;
                    qu.add (child);
                    visited.add (child);
                }
                ls = ymapper.get(stones[curr][1]);
                for (int child:ls)
                {
                    if (visited.contains (child))
                        continue;
                    qu.add (child);
                    visited.add (child);
                } 
            }
            ans += current-1;
        }
        return ans;
    }
}

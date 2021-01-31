class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        ArrayList<Integer> temp = new ArrayList();
        HashMap<Integer, ArrayList<Integer>> mapper = new HashMap();
        int m = adjacentPairs.length;
        for (int i =0;  i< m;i+=1)
        {
            int u = adjacentPairs[i][0];
            int v = adjacentPairs[i][1];
            if(!mapper.containsKey(u))
            {
                ArrayList<Integer> ls = new ArrayList();
                mapper.put(u, ls);
            }

            if(!mapper.containsKey(v))
            {
                ArrayList<Integer> ls = new ArrayList();
                mapper.put(v, ls);
            }
            ArrayList<Integer> ls = mapper.get(u);
            ls.add (v);
            ls = mapper.get(v);
            ls.add (u);            
        }
        int startNode =-1;
        for (Map.Entry<Integer, ArrayList<Integer>> me: mapper.entrySet())
        {
            if (me.getValue().size() ==1)
            {
                startNode = me.getKey();
                break;
            }            
        }
        
        Set<Integer> set = new HashSet();
        set.add (startNode);
        Queue<Integer> qu = new LinkedList();
        qu.add (startNode);
        while (!qu.isEmpty())
        {
            int curr = qu.poll();
            temp.add(curr);
            ArrayList<Integer> children = mapper.get(curr);
            for(int child: children)
            {
                if (!set.contains(child))
                {
                    set.add (child);
                    qu.add (child);
                }    
            }
        }
        int[] ans = new int[temp.size()];
        for (int i =0; i< temp.size();i+=1)
            ans[i] = temp.get(i);
        return ans;
    }
}

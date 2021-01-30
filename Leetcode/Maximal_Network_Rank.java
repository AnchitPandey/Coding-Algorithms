class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, Set<Integer>> mapper = new HashMap();
        int m = roads.length;
        for (int i =0 ; i < n;i++)
        {
            Set<Integer> visited = new HashSet();
            mapper.put (i, visited);
        }
        for (int i =0 ;i< m;i+=1)
        {
            int u = roads[i][0];
            int v = roads[i][1];
            Set<Integer> set1 = mapper.get(u);
            Set<Integer> set2 = mapper.get(v);
            set1.add (v);
            set2.add (u);
        }
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int i = 0 ;i< n;i+=1)
        {
            Set<Integer> getter = mapper.get(i);
            max1 = Integer.max (max1, getter.size());
        }
        for (int i =0 ; i< n;i+=1)
        {
            Set<Integer> getter = mapper.get(i);
            if ( getter.size() > max2 && getter.size() < max1)
                max2 = getter.size(); 
        }
        ArrayList<Integer> ls1 = new ArrayList(), ls2 = new ArrayList();
        for (int i =0 ; i< n;i+=1)
        {
            Set<Integer> getter =  mapper.get(i);
            if (getter.size() == max1)
                ls1.add (i);            
            else if (getter.size() == max2)
                ls2.add (i);
        }
        
      // System.out.println (mapper);
       // System.out.println(ls2);
      //  System.out.println (ls1);
        int ans = -1;
        // checking between similar size
        for (int i =0; i< ls1.size();i+=1)
        {
            for (int j = i+1; j< ls1.size();j+=1)
            {
                Set<Integer> getter = mapper.get(ls1.get(i));
                if (getter.contains(ls1.get(j)))
                {
                    ans = Integer.max(ans, 2*getter.size() -1);
                }
                else
                    ans = Integer.max(ans, 2* getter.size());              
            }            
        }
        // checking between different sizes
        for (int  i= 0; i< ls1.size();i+=1)
        {
            Set<Integer> getter = mapper.get(ls1.get(i));
        //    System.out.println("getter is "+ getter);
            for (int j =0  ;j< ls2.size();j+=1)
            {
                if (getter.contains(ls2.get(j)))
                    ans = Integer.max (ans, getter.size() + mapper.get(ls2.get(j)).size()-1);
                else
                    ans = Integer.max (ans, getter.size() + mapper.get(ls2.get(j)).size());
            }
        }
        return ans;
    }
}

class numberWithSameConsecutiveDifferences {
 
    public static void callme(int curr, int k, ArrayList<Integer> ls, int n)
    {

  //      System.out.println("current element is "+ curr);
    //     System.out.println("List size is "+ ls.size());
        if (ls.size() == n)
        {
            StringBuilder sb = new StringBuilder();
            for (int i =0 ;i<n;i+=1)
                sb.append (ls.get(i));
            int num = Integer.parseInt(sb.toString());
            mapper.put (num,1);
            return;
        }
        if (curr-k>=0)
        {
    //       System.out.println("adding "+ (curr-k) +" to the list");
            ls.add (curr-k);
            callme (curr-k,k,ls,n);
            ls.remove (ls.size()-1);
        }
        if (curr +k <=9)
        {
            
       //  System.out.println("adding "+ (curr+k) +" to the list");
            ls.add (curr+k);
            callme(curr+k,k,ls,n);
            ls.remove (ls.size()-1);
        }
    }
    
    
    static HashMap<Integer, Integer> mapper;
    public int[] numsSameConsecDiff(int n, int k) {
    
        mapper = new HashMap<Integer, Integer>();
        for (int i =1; i<=9;i+=1)
        {
    //        System.out.println("############################");
             ArrayList<Integer> ls = new ArrayList<Integer>();
             ls.add (i);
            callme (i, k,ls,n);
        }
        ArrayList<Integer> lister = new ArrayList<Integer>(mapper.keySet());
        if (n ==1)
            lister.add(0);
        int[] fa= new int[lister.size()];
        for (int i =0; i<lister.size();i+=1)
            fa[i] = lister.get(i);
        return fa;
    }
}

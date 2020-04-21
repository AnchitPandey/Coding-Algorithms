class smallestStringWithSwaps {   
    
    public int findParent(int id, int[] parent)
    {
        if (id != parent[id])
            parent[id] = findParent(parent[id], parent);
        return parent[id];
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int n = s.length();
        int[] parent = new int[n];
        
        for (int i =0 ; i< s.length();i+=1)
            parent[i] = i;
        
        for (int i =0;i< pairs.size();i+=1)
        {
            //ystem.out.println();
            List<Integer> gets = pairs.get(i);           
            int u = gets.get(0);
            int v = gets.get(1);
//             System.out.println("char1 is: "+ s.charAt(u));
//             System.out.println("char2 is: "+ s.charAt(v));
            
            int par1 = findParent (u, parent);
            int par2 = findParent(v,parent);
            
//             System.out.println("parent of char1 is: "+ s.charAt(par1));
//             System.out.println("parent of char2 is: "+ s.charAt(par2));
            
            if (s.charAt(par1) < s.charAt(par2))
            {
   //             System.out.println("inside if");
                 parent[par2] = par1;
            }
                else
                {
            //         System.out.println("inside else");
                     parent[par1] = par2;                   
                }
                
                }
        
        
        for (int i = 0 ; i< n;i+=1)
            findParent(i, parent);
        
        // for (int i =0 ; i<n;i+=1)
        //     System.out.print(parent[i]+" ");
        
        HashMap<Integer, PriorityQueue<Character>> mapper = new HashMap<Integer,PriorityQueue<Character>>();
        
        for (int i =0; i< n;i+=1)
        {
            if (!mapper.containsKey(parent[i]))
            {
                PriorityQueue<Character> pq = new PriorityQueue<Character>();
                pq.add (s.charAt(i));
                mapper.put (parent[i], pq);
            }
            
            else
            {
                 PriorityQueue<Character> pq = mapper.get(parent[i]);
                 pq.add (s.charAt(i));       
            }           
        }
          StringBuilder sb = new StringBuilder();
        for (int i =0  ;i<n; i+=1)
        {
            sb.append (mapper.get(parent[i]).poll());          
        } 
        return sb.toString();
    }
}

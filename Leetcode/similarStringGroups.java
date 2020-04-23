class similarStringGroups {
   
    public int findParent (int id,int[] parent)
    {
         if (id != parent[id])
             //return findParent(parent[id], parent);
             parent[id] = findParent(parent[id], parent);
        return parent[id];
    }
    
    
    public boolean compareStrings(String a, String b)
    {
        int maxDiff = 0;
        if (a.equals (b))
            return true;
        for (int i =0;  i<a.length();i+=1)
        {
            if (a.charAt(i) != b.charAt(i))
                maxDiff +=1;
        }
        
        return maxDiff ==2;
    }
    
    
    public int numSimilarGroups(String[] A) {
   
      int n = A.length;
      int[] parent = new int[A.length];
      for (int i =0 ; i<A.length;i+=1)
        parent[i] = i;   
      for (int i = 0;i< n;i+=1)
      {
          for (int j =i+1;j< n;j+=1)
          {
            int parent1 = findParent(i, parent);
            int parent2 = findParent (j, parent);
            if (parent1 != parent2)
            {
               boolean yesOrNo = compareStrings(A[i], A[j]);  
                if (yesOrNo)
                    parent[parent2] = parent1;
            }
          }
      }
        int counter =0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i =0; i< n;i+=1)
         set.add (findParent(i, parent));
            
        
        
        return set.size();
    }   
}

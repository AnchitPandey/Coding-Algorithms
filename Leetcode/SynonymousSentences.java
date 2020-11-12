class Solution {
    
    
    HashMap<String, Integer> fa;
    public void backTrack (String[] splitter, HashMap<String, Integer> mapper,  int index, HashMap<Integer, ArrayList<String>> refer, int[] parent)
    
    {
        if(index >= splitter.length)
        {
            String tp = "";
            for (int i =0 ; i< splitter.length;i++)
            {
                tp += splitter[i];                 
                if (i!= splitter.length-1)
                    tp += " "; 
            }
            fa.put (tp,1);
            return;
        }
        
        String curr = splitter[index];
        if (!mapper.containsKey(curr))
            backTrack (splitter,mapper, index+1,refer, parent);    
        
        else
        {
            int indi = mapper.get(splitter[index]);   
            int par = parent[indi];
            ArrayList<String> children = refer.get(par);
            for (int j =0 ; j< children.size();j+=1)
            {
                String ch = children.get(j);
                splitter[index] =  ch;
                backTrack (splitter, mapper, index+1,refer,parent);
            }
        }               
    }
    
    public int findParent (int id, int[] parent)
    {
            if (id == parent[id])
                return parent[id];
            
            return findParent(parent[id], parent);
        
    }
    
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        
      fa = new HashMap<String, Integer>();
      HashMap<String, Integer> mapper = new HashMap<String, Integer>();
      HashMap<Integer, String> reverser = new HashMap<Integer, String>();
        
      int counter =0;
        
      for (int i =0 ;i< synonyms.size();i+=1)
      {
          List<String> getter =  synonyms.get(i);
          for (int j=0; j< getter.size();j+=1)
          {
            String gets = getter.get(j);
             if (!mapper.containsKey (gets))
             {
                 reverser.put (counter, gets);
                 mapper.put (gets, counter);
                 counter+=1;
             }
          }          
      }
        int[] parent = new int[counter];
        for (int i =0; i< counter;i +=1)
            parent[i] = i;
        
        /// creating relationship
        for (int i =0; i< synonyms.size();i+=1){
            List<String> getter = synonyms.get(i);
            int par1 = findParent (mapper.get(getter.get(0)), parent);
            int par2 = findParent (mapper.get(getter.get(1)), parent);
            if (par1 != par2)
            {
                if (par1 < par2)
                    parent[par2] = par1;
                else
                    parent[par1] = par2;
            }
        }
        
        HashMap<Integer, ArrayList<String>> refer = new HashMap<Integer,ArrayList<String>>();
        
        for (int i = 0; i< counter;i+=1)
            parent[i] = findParent (i, parent);
        
        for (int i =0 ; i < counter;i+=1)
        {
            String str = reverser.get (i);
            if (!refer.containsKey (parent[i]))
            {
                ArrayList<String> putter = new ArrayList<String>();
                putter.add (str);
                refer.put (parent[i], putter);                  
            }
            else
            {
                ArrayList<String> getter = refer.get (parent[i]);
                getter.add (str);
            }                
        }
                            
        String[] splitter = text.split("\\s+");
        backTrack (splitter, mapper,  0, refer, parent);
        
        List<String> ans = new ArrayList<String>(fa.keySet());
        Collections.sort (ans);
        //for (int i =0 ; i< ans.size();i+=1)
        //System.out.println(ans.get(i));
        return ans;
        
    }
}

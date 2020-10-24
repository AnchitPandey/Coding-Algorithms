class Solution {

    HashMap<String, Integer> coster;
    
    public void dfs (String curr, HashMap<String, Integer> mapper)
    {
        int max = 0;
        int temp =0;
        if (coster.containsKey (curr))
            return ;
        for (int i =0 ; i < curr.length();i+=1)
        {
            String start = curr.substring (0,i);
            String end = curr.substring (i+1,curr.length());
            String child = start+ end;
            if(mapper.containsKey (child))
            {
                if (coster.containsKey (child))
                    max  = Integer.max (max, coster.get(child)+1);
                
                else
                {
                    dfs (child, mapper);
                    temp = coster.get(child);
                    max = Integer.max (max, temp+1);
                }
            }
        }   
        coster.put (curr, max);
    }
    
    public int longestStrChain(String[] words) {
        
        coster = new HashMap<String, Integer>();
        HashMap<String, Integer> mapper = new HashMap<String, Integer>();
        for (int i =0 ;i< words.length;i+=1)
            mapper.put(words[i],1);
   
        int len = words.length; 
        for (int j =0; j< len;j+=1)
            dfs(words[j], mapper); 
        
       // System.out.println (coster);
        ArrayList<Integer> vals = new ArrayList<Integer>(coster.values());
        int max =-1;
        for (int i =0 ; i< vals.size();i+=1)
             max = Integer.max (max, vals.get(i));
         
            return max+1;
    }
}

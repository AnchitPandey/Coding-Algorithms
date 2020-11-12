class Solution {
    
    public int findDifference (HashMap<Character, Integer> leftMap, HashMap<Character, Integer> rightMap)
    {
        ArrayList<Character> ls;
        
      
        if (leftMap != null)
        {
         ls =  new ArrayList<Character> (leftMap.keySet());
         for (int i =0 ; i < ls.size();i+=1)
            rightMap.put(ls.get(i), rightMap.get(ls.get(i))- leftMap.get(ls.get(i)));
        }
        
        int counter =0;       
        ls = new ArrayList<Character>(rightMap.keySet());
        
        for (int i =0 ; i< ls.size();i+=1)
        {
            if (rightMap.get(ls.get(i)) % 2!=0)
                counter+=1;
        }
        counter /=2;
        return counter;
    }
    
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
 
      int n = s.length();
    List<Boolean> ls =new ArrayList<Boolean>();
      HashMap<Character, Integer>[] mapper = new HashMap[n];
      for (int i =0; i< n;i+=1)
          mapper[i] = new HashMap<Character,Integer>();
      
        mapper[0].put(s.charAt(0),1);    
        for (int i =1; i < s.length();i+=1)
        {
            char ch = s.charAt(i);
            mapper[i] = (HashMap<Character, Integer>)mapper[i-1].clone();
            mapper[i].put (ch, mapper[i].getOrDefault(ch,0)+1);
        }
        for (int i =0; i< queries.length;i+=1)
        {
            int k = queries[i][2];
            HashMap<Character, Integer> right = (HashMap<Character, Integer>)mapper[queries[i][1]].clone(); 
            HashMap<Character, Integer> left = null;

            if (queries[i][0] != 0)
                left = (HashMap<Character, Integer>)mapper[queries[i][0]-1].clone();
            
            int counter = findDifference(left,right);
            if (k >= counter)
                    ls.add (true);
                else
                    ls.add (false);   
        }
        return ls;
    }
}

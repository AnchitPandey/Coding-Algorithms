class groupsOfSpecialEquivalentStrings {
    
    public HashMap<Character, Integer> findEven (String str)
    {
        int len = str.length();
        HashMap<Character, Integer> ret =  new HashMap<Character, Integer>();
        for (int i = 0;  i< len;i+=2)
            ret.put(str.charAt(i), ret.getOrDefault(str.charAt(i),0)+1);
        return ret;
    }
    
    public HashMap<Character, Integer> findOdd (String str)
    {
        int len = str.length();
        HashMap<Character, Integer> ret =  new HashMap<Character, Integer>();
        for (int i = 1;  i< len;i+=2)
            ret.put(str.charAt(i), ret.getOrDefault(str.charAt(i),0)+1);
        return ret;
    }
    public int numSpecialEquivGroups(String[] A) {
        
    HashMap<HashMap<Character,Integer>, HashMap<HashMap<Character, Integer>, Integer>>
        mapper = new  HashMap<HashMap<Character,Integer>, HashMap<HashMap<Character, Integer>, Integer>>();
        
        for (int i =0 ; i< A.length;i+=1)
        {
    
       HashMap<Character, Integer> key =   findEven(A[i]);
       HashMap<Character, Integer> val =   findOdd(A[i]);    
       if (mapper.containsKey(key))
       {
          HashMap<HashMap<Character,Integer>, Integer>  getter = mapper.get(key);  
           getter.put (val,1);  
       }
        else
            {
                HashMap<HashMap<Character,Integer>, Integer>  putter = new HashMap<HashMap<Character,Integer>, Integer>();
                putter.put (val,1);
                mapper.put (key, putter);
            }
        }
        
        ArrayList<HashMap<Character, Integer>> keys = new ArrayList<HashMap<Character,Integer>>(mapper.keySet());
        int counter  =0; 
        for (int i=0; i< keys.size();i+=1)
        {
            HashMap<Character, Integer> gets = keys.get(i);
            counter += mapper.get(gets).size();
        }  
        return counter;
    }
}

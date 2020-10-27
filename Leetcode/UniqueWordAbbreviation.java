class ValidWordAbbr {

    HashMap<String , HashMap<String, Integer>> mapper;
  HashMap<String, Boolean> map;
  // HashMap<String , Boolean> map;
  public ValidWordAbbr(String[] dictionary) {
    
     mapper = new HashMap<String , HashMap<String, Integer>>();
      map = new HashMap<String, Boolean>();
     for (int i =0; i< dictionary.length;i+=1)
     {
         String inp = dictionary[i];
         if (inp.length() <=2)
            map.put(inp, true);   
         else
         {
            String num = String.valueOf(inp.length() -2);
            String str = String.valueOf(inp.charAt(0))+num + String.valueOf(inp.charAt(inp.length()-1));
            if (!mapper.containsKey (str))
            {
                HashMap<String, Integer> m =new HashMap<String, Integer>();
            m.put (inp,1);
                mapper.put(str, m);   
            }
             else
             {
                HashMap<String, Integer> m = mapper.get(str);
                m.put (inp,1);
             }             
         }     
     }
      ArrayList<String> k = new ArrayList<String>(mapper.keySet());
      for (int i =0 ; i< k.size();i+=1)
      {
          String key = k.get(i);
          if (mapper.get(key).size() >1)
              map.put (key, false);
          else
              map.put (key, true);    
      }
            }        
      
       
    public boolean isUnique(String word) {  
            if (word.length () ==0)
                return true; 
        
            String num = String.valueOf(word.length() -2);
            String str = String.valueOf(word.charAt(0))+num + String.valueOf(word.charAt(word.length()-1));
        
        if (!map.containsKey (str))
            return true;
        else if (map.get(str)) 
        {
            HashMap<String, Integer> m  = mapper.get(str);
            if (!m.containsKey (word))
                return false;
            else
                return true;
        }
        else
            return false;        
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */

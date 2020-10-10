class Solution {
    public int minSteps(String s, String t) {
        
      HashMap<Character, Integer> mapper1 = new HashMap<Character, Integer>();
        
HashMap<Character, Integer> mapper2 = new HashMap<Character, Integer>();
        
    for (int i =0 ; i< s.length();i+=1)
    {
        char c = s.charAt(i);
        mapper1.put (c, mapper1.getOrDefault(c, 0)+1);
    }
        
    for(int i =0 ;i< t.length();i++)
    {
            char c = t.charAt(i);
            mapper2.put (c, mapper2.getOrDefault(c, 0)+1);
    }

    int counter =0;
    ArrayList<Character> keys2 = new ArrayList<Character>(mapper2.keySet());
    for (int i =0 ; i< keys2.size();i+=1)
    {
        char ch =  keys2.get(i);
        if (mapper1.containsKey (ch))
        {
            if (mapper1.get(ch) - mapper2.get(ch) >0)
                counter+=  mapper1.get(ch) - mapper2.get(ch);
        }
    }
  ArrayList<Character> keys1 = new ArrayList<Character>(mapper1.keySet());
  for (int i =0; i< keys1.size();i+=1)
  {
      if (!mapper2.containsKey (keys1.get(i)))
        counter+= mapper1.get(keys1.get(i));      
  }
    
        return counter;
    }
}

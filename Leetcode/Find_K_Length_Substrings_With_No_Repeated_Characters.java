class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
     
      if (K > S.length())
          return 0;
        
      HashMap<Character, Integer> mapper = new HashMap<Character, Integer>();
      for (int i= 0; i< K;i+=1)
      {
            char ch = S.charAt(i);
            mapper.put(ch, mapper.getOrDefault(ch, 0)+1);
      }
     int counter=0;
     if (mapper.size() == K)
         counter+=1;
     for (int i =K; i< S.length();i+=1)
     {
         char ch = S.charAt(i -K);
         
         mapper.put (ch, mapper.get(ch) -1);
         if (mapper.get(ch) ==0)
             mapper.remove (ch);
         ch = S.charAt(i);
         mapper.put(ch, mapper.getOrDefault(ch, 0)+1);
         if (mapper.size() == K)
             counter+=1;
     }
    return counter;
    }
}

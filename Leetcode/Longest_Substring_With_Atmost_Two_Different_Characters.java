class Solution {
   
    public int lengthOfLongestSubstringTwoDistinct(String s) {
   
        HashMap<Character,Integer> mapper = new HashMap<Character, Integer>();       
        int i = 0, j =0;
        int max =0;
        while (i < s.length ())
        { 
            char ch = s.charAt(i);
            mapper.put (ch, mapper.getOrDefault(ch,0)+1);
            while (mapper.size() >2)
                {
                    char ch2 = s.charAt(j);
                    mapper.put(ch2, mapper.get(ch2)-1);
                    if (mapper.get(ch2) ==0)
                        mapper.remove (ch2);
                    j+=1;
                }                
            i+=1;
            max = Integer.max (max, i -j);
        }
        return max;   
        }
}

class Solution {
    
    public int minSteps(String s, String t) {
        
        HashMap<Character, Integer> mapper1 = new HashMap();
        HashMap<Character, Integer> mapper2 = new HashMap();
        for (int i =0 ; i< s.length();i+=1)
        {
            char ch = s.charAt(i);
            mapper1.put (ch, mapper1.getOrDefault(ch,0)+1);
        }
        
        for (int i =0 ; i< t.length();i+=1)
        {
            char ch = t.charAt(i);
            mapper2.put (ch, mapper2.getOrDefault(ch,0)+1);
        }
        int sum = 0;
        for (Map.Entry<Character,Integer> me: mapper1.entrySet())
        {
            if (mapper2.containsKey (me.getKey()))
            {
                if (mapper2.get(me.getKey()) < me.getValue())
                    sum += me.getValue() - mapper2.get(me.getKey());
            }
            else
                sum += me.getValue();
        }
        
        return sum;
    }
}

class Solution {
    
    public boolean closeStrings(String word1, String word2) {
    
        if (word1.length() != word2.length())
            return false;
        HashMap<Character,Integer> mapper1 = new HashMap();
        HashMap<Character,Integer> mapper2 = new HashMap();
        for (int i =0  ;i< word1.length();i+=1)
        {
            char ch = word1.charAt(i);
            mapper1.put (ch, mapper1.getOrDefault(ch, 0)+1);
        }
        for (int i =0  ;i< word2.length();i+=1)
        {
            char ch = word2.charAt(i);
            mapper2.put (ch, mapper2.getOrDefault(ch, 0)+1);
        }
        //Set<Integer> set = new HashSet();
        HashMap<Integer, Integer> mp  =new HashMap();
        for (Map.Entry<Character, Integer> me: mapper1.entrySet())
        {
            mp.put(me.getValue(), mp.getOrDefault(me.getValue(),0)+1);
        }       
        //System.out.println(mp);
        for (Map.Entry<Character, Integer> me: mapper2.entrySet())
        {
            int fre = me.getValue();
            if (!mp.containsKey(fre) || !mapper1.containsKey (me.getKey()))
                return false;
            mp.put (fre, mp.get(fre)-1);
            if (mp.get(fre) ==0)
                mp.remove(fre);
        }
        return true;      
    }
}

class Solution {
    public boolean canConstruct(String s, int k) {
     
        if (s.length() < k)
            return false;
        int count =0; 
        HashMap<Character, Integer> mapper = new HashMap();
        for (int i =0; i< s.length();i+=1)
        {
            char ch = s.charAt(i);
            mapper.put (ch, mapper.getOrDefault(ch,0)+1);
        }
        for (Map.Entry <Character, Integer> me: mapper.entrySet())
        {
            if (me.getValue() % 2  !=0)
                count+=1;
        }
        return count <= k;
    }
}

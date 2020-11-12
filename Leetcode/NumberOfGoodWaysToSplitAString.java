class Solution {
    public int numSplits(String s) {
 
        HashMap<Character,Integer> right = new HashMap<Character, Integer>();
        
    HashMap<Character,Integer> left = new HashMap<Character, Integer>();
        
        // initializing right 
        for (int i =1 ; i <s.length();i+=1)
        {
            char ch = s.charAt (i);
            right.put (ch, right.getOrDefault(ch,0)+1);
        }    
        left.put (s.charAt(0),1);
        int ans =0;
        for (int i =1; i< s.length();i+=1)
        {
            if (left.size() == right.size())
                ans+=1;
        
            char ch = s.charAt(i);
            left.put (ch, left.getOrDefault(ch,0)+1);
            right.put (ch, right.get(ch)-1);
            if (right.get(ch) ==0)
                right.remove (ch);
        }
        return ans;
    }
}

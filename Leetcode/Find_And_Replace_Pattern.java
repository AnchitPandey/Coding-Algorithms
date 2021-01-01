class Solution {
    
    public boolean matches (String word, String pattern)
    {
        HashMap<Character,Character> mapper = new HashMap<Character, Character>();
        for (int i =0 ; i< word.length();i+=1)
        {
            if (!mapper.containsKey (word.charAt(i)))
                mapper.put (word.charAt(i), pattern.charAt(i));
            if (mapper.get(word.charAt(i))!= pattern.charAt(i))
                return false;
        }
        Set<Character> set = new HashSet();
        for (char ch: mapper.values())
        {
           if (set.contains(ch))
               return false;
            set.add (ch);
        }
        return true;
    }
    
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        for (String word: words)
        {
            if (matches(word,pattern))   
                ans.add (word);
        }
        return ans;
    }
}

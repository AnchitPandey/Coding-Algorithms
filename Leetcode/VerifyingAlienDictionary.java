class Solution {
    
    public boolean compareWords (String word1, String word2, HashMap<Character, Integer> mapper)
    {
        int ind1 =0 , ind2 = 0;
        int flag =0 ;
        while (ind1 != word1.length() && ind2 != word2.length())
        {
            char ch2 = word2.charAt(ind2);
            char ch1 = word1.charAt(ind1);
            int num2 = mapper.get (ch2);
            int num1 = mapper.get(ch1);
            if (num1 > num2)
                return false;
            
            if (num2 > num1)
                return true;      
            
            ind1 +=1;
            ind2 +=1;
        }
        if (ind2 == word2.length() && word1.length() != word2.length())  
            return false;
    
        return true;
    }
   
    public boolean isAlienSorted(String[] words, String order) {
        
         HashMap<Character, Integer> mapper = new HashMap<Character, Integer>();
        for (int i =0 ; i< order.length();i+=1)
            mapper.put (order.charAt(i), i);
        
        int len = words.length;
        for (int i =1;  i< len;i+=1)
        {
            boolean ans = compareWords(words[i-1], words[i], mapper);
            if (!ans)
                return false;
        }
        return true;          
    }
}

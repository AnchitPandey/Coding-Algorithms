class Solution {
    
    public boolean vowel (char ch)
    {
        return ch =='a' || ch=='e' || ch =='i' || ch =='o' || ch == 'u'; 
    }
    
    public String removeVowels(String s) {  
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < s.length();i+=1)
            if (!vowel (s.charAt(i)))
            sb.append (s.charAt(i));
        return sb.toString();
    }
}

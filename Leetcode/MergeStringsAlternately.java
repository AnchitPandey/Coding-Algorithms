class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int count =0;
        int min = Integer.min (word1.length(), word2.length());
        int count1 =0 , count2  =0;
        while (count1 < word1.length() && count2 < word2.length())
        {
            if ( (count1 + count2 ) %2 ==0)
            {
                sb.append (word1.charAt(count1));
                count1+=1;
            }
            else
            {
                sb.append (word2.charAt(count2));
                count2+=1;
            }                
        }
        while (count1 < word1.lenagth())
        {
            sb.append (word1.charAt(count1));
            count1+=1;
        }
        while (count2 < word2.length())
        {
            sb.append (word2.charAt(count2));
            count2+=1;
        }
        return sb.toString();
    }
}

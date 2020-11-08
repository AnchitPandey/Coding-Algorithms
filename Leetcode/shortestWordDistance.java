class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
   int first = -1;  
    int second  =-1;
    int n = words.length;
    int min = Integer.MAX_VALUE;
    for (int i =0; i < n;i+=1)
    {
        if (words[i].equals(word1))
        {
            if (second !=-1)           
                min = Integer.min(min, i - second);
            first = i;
        }
        
        else if( words[i].equals(word2))
        {
            if (first !=-1)           
                min = Integer.min(min, i - first);
            second = i;
        }
    }
        return min;
    }
}

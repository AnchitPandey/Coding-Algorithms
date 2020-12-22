class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
            
        int min = Integer.MAX_VALUE;
        
             
        
        
        ArrayList<Integer> index1 = new ArrayList<Integer>();
        ArrayList<Integer> index2 = new ArrayList<Integer>();
        for (int i=0; i < words.length;i+=1)
        {
            if (words[i].equals (word1))
                index1.add (i);
            if (words[i].equals (word2))
                index2.add (i);
        }
        if (word1.equals(word2))
        {
            for (int i =0 ; i< index1.size()-1;i+=1)
            {
                min = Integer.min (min, index1.get(i+1) - index1.get(i));
            }
            return min;
        }
   
        
        
        
        int curr1 =0 , curr2 =0;
        while (curr1 < index1.size() && curr2 < index2.size())
        {
            int pos1 = index1.get(curr1);
            int pos2  = index2.get(curr2);
            min = Integer.min (min, Math.abs (pos1 - pos2));
            if (pos1 > pos2)
                curr2+=1;
            else
                curr1+=1;
        }
        if (curr1 == index1.size())
        {
            int pos1 = index1.get(curr1-1);
            while (curr2 < index2.size())
            {
                int pos2 = index2.get(curr2);
                min = Integer.min (min, Math.abs (pos2 - pos1));
                curr2+=1;
            }
        }
       else if (curr2 == index2.size())
        {
            int pos2 = index2.get(curr2-1);
            while (curr1 < index1.size())
            {
                int pos1 = index1.get(curr1);
                min = Integer.min (min, Math.abs (pos2 - pos1));
                curr1+=1;
            }
        }
        return min;    
    }
}

class WordDistance {

    HashMap<String, ArrayList<Integer>> mapper;
    public WordDistance(String[] words) {
  
        mapper = new HashMap<String, ArrayList<Integer>>();
        for (int i =0 ; i< words.length;i+=1){
            
            if (!mapper.containsKey(words[i]))
            {
                ArrayList<Integer> keys = new ArrayList<Integer>();
                keys.add (i);
                mapper.put (words[i], keys);
            }
            else
            {
                ArrayList<Integer> keys = mapper.get (words[i]);
                keys.add (i);
            } 
        }    
    }
    
    public int shortest(String word1, String word2) {
     
      ArrayList<Integer> index1 = mapper.get(word1);
      ArrayList<Integer> index2 = mapper.get(word2);
      int min = Integer.MAX_VALUE;
      int curr1 =0, curr2 =0;
        while (curr1 < index1.size() && curr2 < index2.size())
        {
            int pos1 = index1.get(curr1);
            int pos2 = index2.get(curr2);
            min = Integer.min (min, Math.abs (pos2 - pos1));
            if (pos1 > pos2)
                curr2+=1;
            else
                curr1+=1;
        }
        if (curr2 == index2.size())
        {
            int pos2 = index2.get(curr2-1);
            while (curr1 < index1.size())
            {
                int pos1 = index1.get(curr1);
                min = Integer.min (min, Math.abs (pos2 - pos1));
                curr1+=1;
            }
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
       return min; 
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */

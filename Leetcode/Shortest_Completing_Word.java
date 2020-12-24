class Solution {
    
    public boolean contains (HashMap<Character, Integer> mapA, HashMap<Character,Integer> mapB)
    {
        if  (mapA.size() < mapB.size())
            return false;
        for (Map.Entry<Character,Integer> me : mapB.entrySet())
        {
            if (!mapA.containsKey(me.getKey()))
                return false;
            if (mapA.get(me.getKey()) < me.getValue())
                return false;
        }        
        return true;
    }
    
    
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        HashMap<Character, Integer> mapper = new HashMap<Character, Integer>();
        for (int i =0  ;i< licensePlate.length();i+=1)
        {
            char ch = licensePlate.charAt(i);
            if (ch >='A' && ch <='Z')
                ch = (char) ((int) ch + 32);
            if (ch >='a' && ch <='z')
                mapper.put (ch, mapper.getOrDefault(ch,0)+1); 
        }  
        
        int min = 1001;
        String fa = "";
        for (int j =0; j< words.length ;j+=1)
        {
            HashMap<Character, Integer> mp = new HashMap<>();
            for (int  i= 0; i< words[j].length();i+=1){
                mp.put (words[j].charAt(i), mp.getOrDefault(words[j].charAt(i),0)+1);                
        }
            boolean ct = contains (mp, mapper);
            
            if (ct)
            {              
                if (words[j].length() < min)
                {
                    min = words[j].length();
                    fa = words[j];
                } 
            }            
        }
        return fa;
    }
}

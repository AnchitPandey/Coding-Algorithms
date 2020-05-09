class maximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
     
        int min  = Integer.MAX_VALUE;
        HashMap<Character,Integer> mapper = new HashMap<Character, Integer>();
        for (int i =0; i< text.length();i+=1)
        {
            char ch = text.charAt(i);
            mapper.put (ch, mapper.getOrDefault(ch,0)+1);
        }
        String str = "balon";
        for (int i =0; i< str.length();i+=1){
            char ch = str.charAt(i);
             if (!mapper.containsKey(ch))
                {
                    min = 0; 
                    return min;
                }
            if (ch =='l' || ch =='o')
            {
                int getter =  mapper.get(ch);
                getter /= 2;
                if (getter < min)
                    min = getter;
            }
            else
            {
                if (mapper.get(ch) < min)
                    min = mapper.get(ch);
            }
        }
        return min;
    }
}

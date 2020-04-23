class bullsAndCows {
    public String getHint(String secret, String guess) {
      
        int bull =0, cow =0;
        HashMap<Character,Integer> gmap = new HashMap<Character, Integer>();
        HashMap<Character,Integer> smap = new HashMap<Character, Integer>();
      
        for (int i= 0 ; i< secret.length();i+=1)
        {
            if (secret.charAt(i) ==guess.charAt(i))
                bull+=1;
            
            if (gmap.containsKey(guess.charAt(i)))
                gmap.put (guess.charAt(i), gmap.get(guess.charAt(i))+1);
            else
                gmap.put (guess.charAt(i),1);

            if (smap.containsKey(secret.charAt(i)))
                smap.put (secret.charAt(i), smap.get(secret.charAt(i))+1);
            else
                smap.put (secret.charAt(i),1);
        }
        
        ArrayList<Character> keys = new ArrayList<Character>(gmap.keySet());
        int total =0;
        for (int i =0 ;i< keys.size();i++)
        {
            if (smap.containsKey(keys.get(i)))
                total += Integer.min(smap.get(keys.get(i)), gmap.get(keys.get(i)));
            
        }
        int cows = total - bull;
        return bull +"A"+cows+"B";
    }
}

class findTheDifference {
    public char findTheDifference(String s, String t) {

        
        if (s.length() ==0)
            return t.charAt(0);
        HashMap<Character, Integer> mapper = new HashMap<Character,Integer>();
        for (int i =0 ;  i< s.length();i+=1)
        {
            if (!mapper.containsKey(s.charAt(i)))
                mapper.put (s.charAt(i),1);
            else
                mapper.put (s.charAt(i), mapper.get(s.charAt(i))+1);
        }
        HashMap<Character, Integer> m2 =new HashMap<Character, Integer>();
        for(int i =0 ;i< t.length();i++)
        {
            if (!m2.containsKey(t.charAt(i)))
                m2.put (t.charAt(i),1);
            else
                m2.put (t.charAt(i), m2.get(t.charAt(i))+1);
        }      
        ArrayList<Character> t1 = new ArrayList<Character>(m2.keySet());
        for (char ch: t1)
        {
            if (m2.get(ch) != mapper.get(ch))
                return ch;
        }
        return 'a';
    }
}

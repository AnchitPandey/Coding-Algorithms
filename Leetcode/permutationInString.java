class permutationInString {
    public boolean checkInclusion(String p, String s) {
        
       HashMap<Character,Integer> pat = new HashMap<Character, Integer>();
        for (int i =0; i< p.length();i+=1)
        {
            if (!pat.containsKey(p.charAt(i)))
                pat.put (p.charAt(i),1);
            else
                pat.put (p.charAt(i), pat.get(p.charAt(i))+1); 
        }

        if (p.length() > s.length() || p.length() ==0)
            return false;
      
       HashMap<Character,Integer> mapper = new HashMap<Character, Integer>();
        for (int i =0 ; i< p.length();i+=1)
        {
            char ch = s.charAt(i);
            if (!mapper.containsKey(ch))
                mapper.put (ch,1);
            else
                mapper.put (ch, mapper.get(ch)+1);
        }
        // System.out.println("mapper is "+mapper);
        for (int i  =p.length();i< s.length();i+=1)
        {
            if (mapper.equals(pat))
                return true;
          //      arr.add (i-p.length());
            
      //      System.out.println("mapper is "+ mapper);
            char ch = s.charAt(i-p.length());
         //   System.out.println("i value is "+i);
          //  System.out.println("outgoing char is "+ ch);
            mapper.put(ch, mapper.get(ch)-1);
            if (mapper.get(ch) ==0)
                mapper.remove (ch);
            
           
             ///   System.out.println("incoming char is "+s.charAt(i));
                if (mapper.containsKey(s.charAt(i))) 
                    mapper.put (s.charAt(i), mapper.get(s.charAt(i))+1);
                else
                    mapper.put (s.charAt(i),1);                
        }
        if (mapper.equals (pat))
            return true;
         //   arr.add (s.length()-p.length());
       // return arr;
        return false;
       }       
}

class mostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
    
       ArrayList<String> ls = new ArrayList<String>();
        HashMap<String, Integer> lisa = new HashMap<String, Integer>();
       HashMap<String, Integer> mapper = new HashMap<String, Integer>();
        for (int i =0; i< banned.length;i+=1)
            mapper.put (banned[i],1);
        
       StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i< paragraph.length();i+=1)
        {
            char ch = paragraph.charAt(i);
            if ((ch >='a' && ch <='z') || (ch >='A' && ch <='Z'))  
                sb.append (ch);
            else
            {
                String str = sb.toString().toLowerCase();
                if (str.length() !=0 && !mapper.containsKey(str))
                    lisa.put (str, lisa.getOrDefault(str,0)+1);
                sb = new StringBuilder();
            }         
        }
      String str = sb.toString().toLowerCase();
                if (str.length() !=0 && !mapper.containsKey(str))
                    lisa.put (str, lisa.getOrDefault(str,0)+1);
         ArrayList<String> keys = new ArrayList<String>(lisa.keySet());
            String fa = "";
            int max  =0 ;
          for (int i =0 ; i< keys.size();i+=1)
          {
              if (lisa.get(keys.get(i)) > max)
              {
                  max = lisa.get(keys.get(i));
                  fa = keys.get(i);
              }
          }
        return fa;
    }
}

class searchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    
        int n = products.length;
        HashMap<String, ArrayList<String>> mapper = new HashMap<String, ArrayList<String>>();
   
        for (int i =0; i< n;i+=1)
        {
            StringBuilder sb = new StringBuilder();
            for (int j =0; j<products[i].length();j+=1)
            {
                sb.append (products[i].charAt(j));
                String str = sb.toString();
                if (!mapper.containsKey(str))
                {
                    ArrayList<String> putter = new ArrayList<String>();
                    putter.add (products[i]);
                    mapper.put (str, putter);
                }
                else
                {
                   ArrayList<String> getter = mapper.get(str);
                   getter.add (products[i]);
                }
            }            
        }
        List<List<String>> fa = new ArrayList<List<String>>();
        ArrayList<String> keys = new ArrayList<String>(mapper.keySet());
        for (int i = 0 ;i< keys.size();i+=1)
        {
            ArrayList<String> gets = mapper.get(keys.get(i));
            Collections.sort (gets);
            mapper.put (keys.get(i), gets);
        }
        
        StringBuilder sb =new StringBuilder();
        for (int i =0; i< searchWord.length();i+=1)
        {
            sb.append (searchWord.charAt(i));
            String temp = sb.toString();
            List<String> tempa = new ArrayList<String>();
            if (mapper.containsKey(temp))
            {
                ArrayList<String> gets = mapper.get(temp);
                int min = Integer.min(gets.size(),3);
                for (int j =0; j< min;j+=1)
                    tempa.add (gets.get(j));
            }
            fa.add (tempa);
        }
        return fa;
    }
}

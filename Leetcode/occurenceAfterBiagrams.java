class occurenceAfterBiagrams {
    public String[] findOcurrences(String text, String first, String second) {
        
        
        ArrayList<String> ls = new ArrayList<String>();

        String[] splitter = text.split("\\s+");
        for (int i =0;i< splitter.length-1;i+=1)
        {
            if (splitter[i].equals(first) && splitter[i+1].equals(second) ) 
            {
                if (i+2 < splitter.length)
                    ls.add (splitter[i+2]);  
            }
        }
        String[] fa = new String[ls.size()];
        for (int i =0; i< ls.size();i+=1)
            fa[i] = ls.get(i);
        return fa;
    }
}

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
    
        List<String> fa = new ArrayList<String>();
        HashMap<String, Integer> mapper = new HashMap<String, Integer>();
        int n = cpdomains.length;
        for (int i =0; i< n;i+=1)
        {
            String[] splitter = cpdomains[i].split("\\s+");
            int fre = Integer.parseInt (splitter[0]);
            //System.out.println(splitter[1]);
            String[] domains = splitter[1].split ("\\.");
            String curr ="";
            for (int j = domains.length-1; j>=0; j--)
            {
                   curr = domains[j] + curr;
                mapper.put (curr, mapper.getOrDefault(curr,0)+ fre);     
                curr = "." + curr;
             //   System.out.println(curr);
            }                      
        }
        for (Map.Entry<String,Integer> me : mapper.entrySet())
        {
            String str = me.getValue() + " "+ me.getKey();
            fa.add (str);
        }
        return fa;
    }
}

class minimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        HashMap<String,Integer> m1 = new HashMap<String,Integer>();
        for (int i =0 ; i< list1.length;i+=1)   
            m1.put  (list1[i],i); 
       
        TreeMap<Integer,ArrayList<String>> map = new TreeMap<Integer, ArrayList<String>>();
    
        for (int j = 0;j< list2.length;j+=1)
        {
            if (m1.containsKey(list2[j]))
            {
                int sum = j + m1.get(list2[j]);
                if (map.containsKey(sum))
                {
                    ArrayList<String> tt = map.get(sum);
                    tt.add (list2[j]);
                }
                else
                {
                    ArrayList<String> naya = new ArrayList<String>();
                    naya.add (list2[j]);
                    map.put (sum, naya);
                }
            }
        }
        
        ArrayList<ArrayList<String>> gg = new ArrayList<ArrayList<String>>(map.values());
        String[] fa  = new String[gg.get(0).size()];
        for (int i =0; i< gg.get(0).size();i+=1)
            fa[i] = gg.get(0).get(i);
        return fa;
    }
}

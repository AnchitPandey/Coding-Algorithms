class displayTableOfFoodOrdersInARestaurant {
    public List<List<String>> displayTable(List<List<String>> orders) {
    
    List<List<String>> fa = new ArrayList<List<String>>();
    TreeMap<String, Integer>  map = new TreeMap<String, Integer>();
    TreeMap<Integer,Integer> ids =new TreeMap<Integer, Integer>();
        
    for (int i =0; i< orders.size();i+=1)
    {
            ids.put (Integer.parseInt(orders.get(i).get(1)),1);
            map.put (orders.get(i).get(2),1);
         
    }
        //contains dish names
    List<String> initial = new ArrayList<String>(map.keySet());
    initial.add (0,"Table");
    fa.add (initial);
        ArrayList<Integer> allId = new ArrayList<Integer>(ids.keySet());
    
    TreeMap<Integer, TreeMap<String, Integer>> mapper = new TreeMap<Integer, TreeMap<String, Integer>>();
      
        for (int i =0 ; i< allId.size();i+=1)
        {
    
            TreeMap<String, Integer> m = new TreeMap<String,Integer>();
            for (int j =1; j< initial.size();j+=1)
            {
                String gets=  initial.get(j);
                m.put (gets, 0);
            }
            mapper.put (allId.get(i),m);           
        }
        
        // counting part of it is 
        for (int i =0; i< orders.size();i+=1)
        {
             int id =Integer.parseInt(orders.get(i).get(1));
             String item = orders.get(i).get(2);
             TreeMap<String,Integer> getter = mapper.get(id);
             getter.put (item, getter.get(item)+1);
        }
        // printing part ..
        for (int i= 0 ;i< allId.size();i+=1)
        {
            List<String> putter = new ArrayList<String>();
            int id =allId.get(i);
            putter.add (String.valueOf(id));
            TreeMap <String, Integer> getter = mapper.get(id);
            List<Integer> values =  new ArrayList<Integer>(getter.values());
            for (int j =0; j< values.size();j+=1)
            {
                putter.add (String.valueOf(values.get(j)));    
            }
            fa.add (putter);
        }
        return fa;
     }
}

class Solution {
    public String destCity(List<List<String>> paths) {
        
        HashMap<String, Integer> mapper= new HashMap<String, Integer>(); 
        
        for (int i =0; i< paths.size(); i++)    
          mapper.put (paths.get(i).get(0),1);
        
        String fa = "";
          for (int i =0; i< paths.size();i++)    
          {
              if (!mapper.containsKey(paths.get(i).get(1)))
              {
                  fa = paths.get(i).get(1);
                  break;
              }
          }
         return fa;
        
    }
}

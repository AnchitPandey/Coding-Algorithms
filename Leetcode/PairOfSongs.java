class Solution {
    public int numPairsDivisibleBy60(int[] time) {
    
    int n = time.length;
    //    HashMap<Integer, Integer>[] mapper = new HashMap[n];
     //   for (int i =0  ;i< n;i+=1)
      //      mapper[i] = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        ArrayList<Integer> powers  = new ArrayList<Integer>();
          int total =0 ;  
        for (int i =0 ; i<=16;i+=1)
        {
            powers.add (60 *i);   
        }
     
        for (int i = n-2;i>=0;i--)
        {
         
         //   mapper[i] = (HashMap<Integer, Integer>)mapper[i+1].clone();
            mapper.put (time[i+1],mapper.getOrDefault(time[i+1],0)+1);
            
            for (int j =0; j< powers.size();j+=1)
            {
                if (mapper.containsKey(powers.get(j) - time[i]))
                    total += mapper.get(powers.get(j) - time[i]);       
            }           
        }
       
        return total;
    }
}

class kDiffPairs {
    public int findPairs(int[] nums, int k) {
        
        
        if (nums.length ==0 || k <0)
            return 0;
        Arrays.sort (nums);
        HashMap<HashMap<Integer,Integer>, Integer> mapper = new  HashMap<HashMap<Integer,Integer>, Integer>();
        HashMap<Integer, Integer> mapper2 = new HashMap<Integer, Integer>();
        for (int i =0; i< nums.length; i+=1)
        {
            if (mapper2.containsKey(nums[i]))
                mapper2.put(nums[i], mapper2.get(nums[i])+1);
           else 
            mapper2.put (nums[i],1);
        }
        
        for (int i =0; i< nums.length; i+=1)
        {
            
           if ( (k ==0 && mapper2.get(nums[i])>1) || (k!=0 && mapper2.containsKey(nums[i]+k)))
           {
               HashMap<Integer, Integer> temp2 = new HashMap<Integer, Integer>();
               temp2.put (nums[i],1);
               temp2.put (nums[i]+k,1);
               mapper.put (temp2,1);
           }
               
            if ( (k==0 && mapper2.get(nums[i]) > 1)|| ( k!=0 && mapper2.containsKey(nums[i] - k)))
           {
               HashMap<Integer, Integer> temp2 = new HashMap<Integer, Integer>();
               temp2.put (nums[i],1);
               temp2.put (nums[i]-k,1);
               mapper.put (temp2,1);
           }     
        }
        return mapper.size();
    }
}

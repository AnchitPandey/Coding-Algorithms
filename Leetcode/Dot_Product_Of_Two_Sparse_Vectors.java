class SparseVector {

    HashMap<Integer,Integer> mapper;         
    SparseVector(int[] nums) {
               mapper = new HashMap<Integer, Integer>();
                for(int i= 0; i< nums.length;i+=1)
                {
                    if (nums[i] !=0)
                       mapper.put (i,nums[i]);
                }  
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int answer =0;
        HashMap<Integer, Integer> first, second;
       
        
        HashMap<Integer, Integer> mapper2 = vec.mapper;
         if (mapper.size() < mapper2.size())
         {
             first = mapper;
             second = mapper2;
         }
         else
         {
             first = mapper2;
             second = mapper;
         }
        for(Map.Entry<Integer,Integer> me: first.entrySet())
        {
            if (second.containsKey(me.getKey()))
                answer += second.get(me.getKey()) * me.getValue();
        }        
        return answer;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);

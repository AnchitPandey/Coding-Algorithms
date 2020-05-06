class singleNumberII {
    public int singleNumber(int[] nums) {
        
        HashMap<Integer,Integer> mapper = new HashMap<Integer, Integer>();
        for (int i =0;i< nums.length;i+=1)
            mapper.put (nums[i], mapper.getOrDefault(nums[i],0)+1);
        ArrayList<Integer> keys = new ArrayList<Integer>(mapper.keySet());
        int num= -1;
        for (int i =0;i < keys.size();i+=1)
        {
            if (mapper.get(keys.get(i))==1) 
            {
                num = keys.get(i);
                break;
            }
        }
            
        return num;
    }
}

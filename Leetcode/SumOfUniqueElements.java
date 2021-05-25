class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> mapper = new HashMap();
        for(int i=0 ; i< nums.length;i+=1)
        {
            mapper.put (nums[i], mapper.getOrDefault(nums[i],0)+1);
        }
        int sum =0 ;
        for (Map.Entry<Integer,Integer> me: mapper.entrySet())
        {
            if (me.getValue() ==1)
                sum += me.getKey(); 
        }
        return sum;
    }
}

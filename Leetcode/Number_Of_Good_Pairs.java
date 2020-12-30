class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> mapper = new HashMap();
        for (int i =0 ; i< nums.length;i+=1)
            mapper.put (nums[i], mapper.getOrDefault(nums[i],0) +1);
        int total =0;
        for (Map.Entry<Integer,Integer> me : mapper.entrySet())
            total += me.getValue() * (me.getValue() -1)/2;       
        return total;
    }
}

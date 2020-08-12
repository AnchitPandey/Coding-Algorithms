class Solution {
    
    
    public int factorial (int num)
    {
        int prod = 1;
        for (int i= num;i>=1;i--)
        {
            prod *= i;
        }
        return prod;
    }
    
    public int numIdenticalPairs(int[] nums) {
        
        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        for (int i =0; i< nums.length;i+=1)
        {
            if (!mapper.containsKey(nums[i]))
                mapper.put (nums[i],1);
            else
                mapper.put (nums[i], mapper.get(nums[i])+1);
        }
        int total =0 ;
        ArrayList<Integer> values = new ArrayList<Integer>(mapper.values());
        for (int  i =0; i< values.size();i++)
        {
            int curr = values.get(i);
            total += curr * (curr -1)/2;
        }
        return total;
    }
}

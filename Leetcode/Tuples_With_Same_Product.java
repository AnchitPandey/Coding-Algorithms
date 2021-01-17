class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> mapper = new HashMap();
        int n = nums.length;
        for (int i =0 ; i< n;i+=1)
        {
            for (int j =0  ;j< n;j+=1) 
            {
                if (i == j)
                    continue;
                int prod = nums[i] * nums[j];
                mapper.put (prod, mapper.getOrDefault(prod,0)+1);
            }
        }
        int ans= 0;
        for (int i =0 ; i< n;i+=1)
        {
            for (int j =0  ;j< n;j+=1) 
            {
                if (i == j)
                    continue;
                int prod = nums[i] * nums[j];
                ans += mapper.get(prod) -2;
            }
        }
        return ans;
    }
}

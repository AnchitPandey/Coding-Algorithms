class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int left =0 ;
        int prod = 1;
        int fa =0;
        if (k<=1)
            return 0;
        int n = nums.length;
        for (int right = 0; right < n;right+=1)
        {                
            prod = prod * nums[right];
            while (prod >= k)
            {
                prod = prod/nums[left];
                left+=1;
            }
            fa += right - left + 1;
        }
        return fa;
    }
}

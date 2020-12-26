class Solution {
    
    public int maxValue (int[] nums)
    {
        int n = nums.length;
        // corner cases
        if (n ==1)
            return nums[0];
        if (n == 2)
            return Integer.max (nums[0], nums[1]);
        
        int[] opt = new int[nums.length];
        opt[0] = nums[0];
        opt[1] = Integer.max (nums[1], nums[0]);
        for(int i=2; i< n;i+=1){
            opt[i] = Integer.max (nums[i]+ opt[i-2], opt[i-1]);     
        }
        return opt[n-1];       
    }
    
    public int rob(int[] nums) {
        
        int n = nums.length;
        if (n ==1)
            return nums[0]; 
        
        int[] nums1 = new int[n-1];
        int[] nums2 = new int[n-1];
        for (int i =0 ; i< n-1;i+=1)
            nums1[i] = nums[i];
        for (int i =1 ; i< n;i+=1)
            nums2[i-1] = nums[i];
        return Integer.max (maxValue(nums1), maxValue(nums2));
    }
}

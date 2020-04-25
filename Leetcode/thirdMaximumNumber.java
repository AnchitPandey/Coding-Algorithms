class thirdMaximumNumber {
    
    
    public int thirdMax(int[] nums) {
    
        int max1 = Integer.MIN_VALUE;
        for (int i= 0; i< nums.length;i+=1)
            max1 = Integer.max (max1, nums[i]);
        int max2 = Integer.MIN_VALUE;
        int flag =0;
        for (int i =0;i< nums.length;i+=1)
        {
            if (nums[i] > max2 && nums[i]!=max1) 
                max2 = nums[i];
        }
        int max3 = Integer.MIN_VALUE;
        for (int i =0;i< nums.length;i+=1)
        {
            if (nums[i] >= max3 && nums[i] != max2 && nums[i]!=max1) 
            {
                max3 = nums[i];
                flag  =1;
            }
        }
        if (max3 == Integer.MIN_VALUE && flag ==0) 
           return max1;
        
        return max3;
    }
}

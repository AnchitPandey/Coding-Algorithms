class Solution {
    public int maxProduct(int[] nums) {
        int max1 = -1, max2 = -1;
        int index = -1;
        for (int i =0; i< nums.length;i+=1)
        {
            if (nums[i] > max1)
            {
                max1 = nums[i];
                index = i;
            }
        }
        
        for (int i =0; i< nums.length;i+=1)
        {
            if (nums[i] > max2 && i != index)
            {
                max2 = nums[i];
            }
        }
   
        return (max1 - 1) * (max2 - 1);
    }
}

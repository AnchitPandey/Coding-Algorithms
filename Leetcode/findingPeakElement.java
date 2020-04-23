class Solution {
    
    public int bs (int[] nums, int lower, int upper)
    {
        if (lower > upper)
            return -1;
        int mid = (lower + upper)/2 ;
       
         if (nums[mid] < nums[mid+1])
        {
        
            return bs (nums,mid+1, upper);
        }
            else if (nums[mid] < nums[mid-1])
            {
       
                return bs(nums, lower, mid-1);
            }
        else
        {
        
            return mid;        
        }
        }
    
    public int findPeakElement(int[] nums) {
        
        if(nums.length <=1)
            return 0;
        
        
        if (nums[0] > nums [1] )
            return 0;
        if (nums[nums.length-1] > nums[nums.length-2])
            return nums.length-1;
        
        int index  =  bs (nums, 0, nums.length-1);  
        return index;
    }
}

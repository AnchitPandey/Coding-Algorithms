class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length ==0)
            return 0;
        int max =0;
        int curr =0 ;
        for (int i =0; i< nums.length;i+=1)
        {
            if (nums[i] ==0)
            {
                if (curr > max)
                    max = curr;
                curr= 0;
            }
            else
                curr+=1;
        }
               if (curr > max)
                    max = curr;
        return max;
    }
}

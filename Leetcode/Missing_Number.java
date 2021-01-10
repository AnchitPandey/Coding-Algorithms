class Solution {
    public int missingNumber(int[] nums) {
        int sum =0;
        for (int i =0  ;i< nums.length;i+=1)
            sum += nums[i];
        int tot = nums.length * (nums.length +1) /2;
        return tot - sum;
    }
}

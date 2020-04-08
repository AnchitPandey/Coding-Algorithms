class Solution {
    public void wiggleSort(int[] nums) {

        
        Arrays.sort(nums);
        for (int i =1; i< nums.length;i+=2)
        {
            if (i == nums.length -1)
                break;
            int t = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = t;
        }
    }
}

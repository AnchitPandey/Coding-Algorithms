class Solution {
    public List<Integer> minSubsequence(int[] nums) {
     
        List<Integer> ls = new ArrayList<Integer>();
        Arrays.sort (nums);
        for (int i = 0 ;i< nums.length/2 ;i+=1)
        {
            int temp = nums[i];
            nums[i] = nums[nums.length -i - 1];
            nums[nums.length - i -1 ] = temp;
        }
        int sum =0 ;
        for (int i =0  ;i< nums.length;i+=1)
            sum += nums[i];    
        int curr =0;
        for (int i =0; i< nums.length;i+=1)
        {
                curr +=nums[i];
                sum -= nums[i];
                ls.add (nums[i]);
                if (curr > sum)
                    break;
        }      
        return ls;
    }
}

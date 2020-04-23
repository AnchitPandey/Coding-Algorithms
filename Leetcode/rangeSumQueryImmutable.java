class rangeSumQueryImmutable {

    int[] prefix;
    public NumArray(int[] nums) {
        
        prefix = new int [nums.length];
        if (prefix.length >0)
        {
            prefix[0] = nums[0];
            for (int i=1; i< nums.length;i+=1)
            {
                prefix[i] = prefix[i-1] + nums[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {
 
        if (prefix.length ==0)
            return 0;
        if (i ==0)
            return prefix[j];
        else
            return prefix[j] - prefix[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * rangeSumQueryImmutable obj = new rangeSumQueryImmutable(nums);
 * int param_1 = obj.sumRange(i,j);
 */

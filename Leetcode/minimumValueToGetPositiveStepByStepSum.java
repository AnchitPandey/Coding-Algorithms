class minimumValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
    int n = nums.length;       
    int min = nums[0];
    int sum = nums[0];
        for (int i= 1;  i< n;i+=1)
        {
            sum += nums[i];
            if (sum < min)
                min = sum;
        }
        if (min >= 1)
            return 1;
        else
            return 1 - min;
    }
}

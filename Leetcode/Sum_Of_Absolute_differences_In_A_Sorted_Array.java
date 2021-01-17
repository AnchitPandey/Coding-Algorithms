class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i =1; i< n;i+=1)
        {
            prefix[i] = prefix[i-1]+ nums[i];
        }
        int[] result = new int[n];
        result[0] = prefix[n-1] - prefix[0] - (n-1) * nums[0];
        result[n-1] = (n-1) * nums[n-1] - prefix[n-2];
        for (int i =1; i< n-1;i+=1)
        {
            result[i] = prefix[n-1] - prefix[i] - prefix[i-1] - (n - 2*i -1)* nums[i]; 
        }
        return result;
        
        // [1,2,3,4,5,6]
        // 2  = (3 + 4 + 5 + 6) - 4 * 2 + 2 - (1) 
        //  prefix[n-1] - prefix[i]  - (n - i -1) * arr[i]  - prefix[i-1] + i * arr[i]
        // result[i]  = prefix[n-1] - prefix[i] - prefix[i-1]  - (n - 2*i - 1) * arr[i]; 
        
        // if i ==0 - >    prefix[n-1] - prefix[0] - (n-1)* arr[i]
        // if i == n-1 ->  (n-1)* arr[i]  - prefix[i-1]
        
        // return result
    }
}

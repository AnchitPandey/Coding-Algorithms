class Solution {
    public int[] nextGreaterElements(int[] nums) {
    
        int n = nums.length;
        if (n ==0)
            return nums;
        int[] arr = new  int[2 *n];
        
        for (int i =0 ; i< n;i+=1)
            arr[i] = nums[i];
        
        for (int i =n ; i< 2*n;i+=1)
            arr[i] = nums[i-n];
        
        int[] ulta =new int [2*n];
        Stack<Integer> stacker = new Stack<Integer>();
        stacker.push (0);
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for (int i =1 ;i< 2*n;i+=1)
        {
            while (!stacker.isEmpty() && arr[stacker.peek()] < arr[i])
            {
                ulta [stacker.pop()] = arr[i];
                 
            }
            stacker.push (i);
        }
        while (!stacker.isEmpty()){
      ulta[stacker.pop()] = -1;
        //      ls.add (-1);
          //  stacker.pop();
        }
        int[] ans = new int[n];
        for (int i =0 ;i<n;i+=1)
            ans[i] = ulta[i];
        return ans;
    }
}

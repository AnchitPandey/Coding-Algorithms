class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n ==0)
            return n;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push (0);
        for (int i =0; i< n;i+=1)
        {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()])
            {
                int nu = stack.pop();
                right[nu] = i - nu;
            }
            stack.push (i);
        }
        while (!stack.isEmpty())
        {
            int nu = stack.pop();
            right[nu] = n - nu;
        }
        stack.push (n-1);
        
        for (int i =n-2; i>= 0;i-=1)
        {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()])
            {
                int nu = stack.pop();
                left[nu] =  nu - i;
            }
            stack.push (i);
        }
        while (!stack.isEmpty())
        {
            int nu = stack.pop();
            left[nu] = nu+1;
        }
        
       int max =0;
        for (int i =0 ;i< n;i+=1)
        {
            max = Integer.max(max, (right[i]+left[i] -1)* heights[i]);
        }
        return max;
    }
}

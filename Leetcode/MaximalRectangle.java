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

    public int maximalRectangle(char[][] M) {

        int m = M.length;
        if (m ==0)
            return 0;
        int n = M[0].length;
        int[][] newMat = new int[m][n];
        for (int j = 0; j< n;j+=1)
        {
            int num = Integer.parseInt (String.valueOf(M[0][j]));
            newMat[0][j] = num;
        }
            for (int i =1 ;i<m;i+=1)
        {
            for(int j =0; j< n;j++)
            {
                if (M[i][j] =='0')
                newMat[i][j]=0;
                else
                newMat[i][j] = 1 + newMat[i-1][j];
            }
        }
        int max =0;
        for (int i =0; i< m;i+=1)
        {
            max = Integer.max (max,largestRectangleArea(newMat[i]));
        }
        return max;
        
     
    }
}

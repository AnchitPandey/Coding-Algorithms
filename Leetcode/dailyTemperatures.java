class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int len= T.length;
        int[] fa = new int[len];
        if (len == 0)
            return fa;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push (0);
        for (int i =1; i< T.length;i+=1)
        {
            while(!stack.isEmpty() && T[i] > T[stack.peek()]) 
            {
                int top = stack.pop();
                fa[top] = i - top;
            }
            stack.push (i);
        }
        while (!stack.isEmpty())
        {
            int top = stack.pop();
            fa[top] = 0;
        }
        return fa;
    }
}

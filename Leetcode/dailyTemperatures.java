class dailyTemperatures {
    
    public int[] dailyTemperatures(int[] T) {
        
    Stack<Integer> stack = new Stack<Integer>();
    int[] opt = new int [T.length];
        if (T.length ==0)
            return opt;
    HashMap<Integer,Integer> mapper = new HashMap<Integer,Integer>();
    stack.push (0);
    for (int i= 0; i<T.length;i+=1)
    {
        while (!stack.isEmpty())
        {
            if (T[stack.peek()] < T[i])
            {
                int q = stack.pop();
                opt[q] = i-q;
            }
            else
                break;
        }
        stack.push (i);
    }
    return opt;
    }
}

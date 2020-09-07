class GfG
{
    int minEle;
    Stack<int[]> s;
    
    public GfG()
    {
        s =new Stack<int[]>();
    }
    
    /*returns min element from stack*/
    int getMin()
    {
                if (s.isEmpty())
        return -1;
    int[] tt = s.peek();
    return tt[1];
    
	// Your code here
    }
    
    /*returns poped element from stack*/
    int pop()
    {
        if (s.isEmpty())
        return -1;
        int[] tt = s.pop();
        return tt[0];
    
	// Your code here	
    }

    /*push element x into the stack*/
    void push(int x)
    {
        int[] tt = new int [2];
        tt[0] =x;
        if (s.isEmpty())
            tt[1] = x;
        else
        {
            int[] kt = s.peek();
            if(kt[1] < x)
                tt[1] = kt[1];
            else tt[1] = x;
        }
        s.push (tt);
    }	
}

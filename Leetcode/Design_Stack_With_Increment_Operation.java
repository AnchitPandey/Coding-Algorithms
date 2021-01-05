class CustomStack {
    int top, sz;
    int[] st;
    public CustomStack(int maxSize) {
        st = new int[maxSize];
        sz = maxSize;
        top =-1;
    }
    
    public void push(int x) {
        if (top >= sz -1)
            return;
        
        top+=1;
        st[top] = x;
    }
    
    public int pop() {
        if (top <=-1)
            return -1;
        int temp = top;
        top-=1;
        return st[temp];
    }
    
    public void increment(int k, int val) {
        int min = Integer.min (k-1, top);
        for (int i= 0 ;i<= min;i+=1)
            st[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

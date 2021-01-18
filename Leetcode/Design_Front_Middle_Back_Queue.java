class FrontMiddleBackQueue {
    
    Deque<Integer> deq;
    public FrontMiddleBackQueue() {
        deq = new LinkedList();
    }
    
    public void pushFront(int val) {
        deq.addFirst (val);
    }
    
    public void pushMiddle(int val) {
        int index = deq.size()/2;
        Stack<Integer> st = new Stack();
        for (int i =0 ; i< index;i+=1)
            st.push (deq.removeFirst());
        deq.addFirst(val);
        while (!st.isEmpty())
            deq.addFirst(st.pop());
    }
    
    public void pushBack(int val) {
        deq.addLast(val);              
    }
    
    public int popFront() {
        if (deq.size() ==0)
            return -1;
        return deq.removeFirst();
    }
    
    public int popMiddle() {       
        if (deq.size() ==0)
            return -1;
        int index = deq.size() /2;
        if (deq.size() % 2 !=0)
            index +=1;
        Stack<Integer> st = new Stack();
        for (int i =0 ; i<index;i+=1)
        {
            st.push (deq.removeFirst());
        }
        int val = st.pop();
        while (!st.isEmpty()) {
            deq.addFirst(st.pop());
        }
        return val;
    }
    
    public int popBack() {
        if (deq.size() ==0)
            return -1;
        return deq.removeLast();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */

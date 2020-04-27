class designCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    ArrayList<Integer> ls;
    int cap;
    int index;
    public MyCircularQueue(int k) {
        ls = new ArrayList<Integer>();
        cap = k; 
        index =0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (ls.size() -index <cap)
        {
            ls.add(value);
            return true;
        }
        return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
    if (ls.size() -index >0)
    {
        index+=1;
        return true;
    }
    return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
     if (ls.size() -index ==0)
         return -1;
        return ls.get(index);
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
           if (ls.size() -index ==0)
         return -1;
        return ls.get(ls.size()-1);
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {   
        return ls.size() -index == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return ls.size() -index == cap;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

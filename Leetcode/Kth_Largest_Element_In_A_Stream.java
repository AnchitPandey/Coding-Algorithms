class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>();
        this.k = k;
        for (int i = 0 ;i < nums.length;i+=1)
        {
            if(pq.size() == k)
            {
                int top = pq.peek();
                if (nums[i] > top)
                {
                    pq.poll();
                    pq.add (nums[i]);
                }
            }
            else
                pq.add(nums[i]);
        }        
    }
    
    public int add(int val) {
   
        if(pq.size() == k)
            {
            int top = pq.peek();
                if (val > top)
                {
                    pq.poll();
                    pq.add (val);
                }
            }
            else
                pq.add(val);
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

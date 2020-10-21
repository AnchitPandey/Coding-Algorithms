class Solution {
    public int connectSticks(int[] sticks) {
    
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n= sticks.length;
        for (int i = 0; i < n;i++)
            pq.add (sticks[i])  ;
        
        int total = 0;
        while (pq.size () >=2)
        {
            int num1 = pq.poll();
            int num2 = pq.poll();
            total += num1 + num2;
            pq.add (num1+ num2);
        }
            return total;
    }
}

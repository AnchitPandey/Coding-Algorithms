class custom implements Comparator<int[]> {
    
    public int compare (int[] o1, int[] o2)
    {
        return o1[1] - o2[1];
    }    
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length;i+=1)
            mapper.put (nums[i], mapper.getOrDefault(nums[i],0)+1); 
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new custom());
        for (Map.Entry<Integer,Integer> me: mapper.entrySet())
        {
            int[] tt =new int[] {me.getKey(),me.getValue()};
            if (pq.size() ==k)
            {
               int[] top = pq.peek();
               if (top[1] < tt[1])
               {
                   pq.poll();
                   pq.add (tt);
               }
            }
            else            
                pq.add (tt);
        }
        int[] ans = new int[k];
        int curr =0;
        while (!pq.isEmpty())
        {
            int[] tt = pq.poll();
            ans[curr] = tt[0];
            curr+=1;
        }
        return ans;
    }
}

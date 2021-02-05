class custom implements Comparator<int[]> {
    public int compare (int[] o1, int[] o2)
    {
        return o1[1] - o2[1];
    }
}

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
     
        if (k == arr.length)
            return 0;
        PriorityQueue<int[]> pq = new PriorityQueue(new custom());
        HashMap<Integer, Integer> mapper = new HashMap();
        for (int i=0  ; i< arr.length;i+=1)
            mapper.put (arr[i],mapper.getOrDefault(arr[i],0)+1);           
        for (Map.Entry<Integer, Integer> me: mapper.entrySet())
        {
            int[] tt = new int[] {me.getKey(), me.getValue()};
            pq.add (tt);
        }
        while (!pq.isEmpty() && k >0)
        {
            int[] top = pq.poll();
            int min = Integer.min (k, top[1]);
            k -= min;
            top[1] -=min;
            if(top[1] !=0)
                pq.add (top);
        }
        return pq.size();    
    }
}

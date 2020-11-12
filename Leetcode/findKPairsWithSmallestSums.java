class custom implements Comparator<int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        return -(o1[0] + o1[1] - o2[0] -o2[1]);
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new custom());
        int m = nums1.length;
        int n = nums2.length;
        if (k ==0)
        {
            List<List<Integer>> putter = new ArrayList<List<Integer>>();
            return putter;
        }
        
        for (int i =0; i< m;i+=1)
        {
            for(int j= 0; j< n;j+=1)
            {
                int[] tt = new int[]{nums1[i], nums2[j]};
                if (pq.size() ==k)
                {
                    int[] opt = pq.peek();
                    if (nums1[i] + nums2[j] < opt[0]+ opt[1])
                    {
                        opt = pq.poll();
                        pq.add (tt);
                    }
                }
                else
                    pq.add (tt);
            }        
        }
        List<List<Integer>> fa = new ArrayList<List<Integer>>();
        while (!pq.isEmpty())
        {
            int[] tt = pq.poll();
            List<Integer> ls1 = new ArrayList<Integer>();
            ls1.add (tt[0]);
            ls1.add (tt[1]);
            fa.add (ls1);        
        }
        return fa;
    }
}

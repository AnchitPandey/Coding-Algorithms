class custom implements Comparator<float[]> {
    
    public int compare (float[] o1, float[] o2)
    {
        if (o2[2] > o1[2])
            return 1;
        else
            return -1;
    }
}
class Solution {
    
    public int[][] kClosest(int[][] points, int K) {
        
        PriorityQueue<float[]> pq = new PriorityQueue<float[]>(new custom());
        int len = points.length;
        for (int  i =0; i< len;i+=1)
        {
            float dist = (float) Math.sqrt (Math.pow (points[i][0],2) +Math.pow (points[i][1],2));
            float[] tt = new float[] {points[i][0], points[i][1], dist};
            if (pq.size () ==K)
            {
                float[] top= pq.peek();
                if (dist < top[2])
                {
                    pq.poll();
                    pq.add(tt);
                }
            }
            else
                pq.add (tt);
        }
        int[][] ans = new int[K][2];
        int curr =0;
        while(!pq.isEmpty())
        {
            float[] tt = pq.poll();
            ans[curr][0] = (int)tt[0];
            ans[curr][1] = (int)tt[1];
            curr+=1;
        }
        return ans;
    }
}

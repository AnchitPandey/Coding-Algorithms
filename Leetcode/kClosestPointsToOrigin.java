class pointClass implements Comparator <int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        return -(o1[0]*o1[0] + o1[1]*o1[1] -  o2[0]*o2[0] - o2[1]*o2[1]);

    }

}

class kClosestPointsToOrigin {
    
    public int dist (int[] o1)
    {
        return o1[0]*o1[0]  + o1[1]* o1[1];
    }
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new pointClass());
        for(int i =0;i<points.length;i+=1)
        {
            if (pq.size() == k)
            {
                int[] get = pq.peek();
                if (dist(get) > dist(points[i]))
                {
                    pq.poll();
                    pq.add (points[i]);
                }         
            }    
            else
                pq.add (points[i]);
        }
        int[][] fa = new int [k][2];
        int index =0;
       // System.out.println("pq size is "+ pq.size());
        while (!pq.isEmpty())
        {
        int[] getter = pq.poll();
        fa[index][0] = getter[0];
        fa[index][1] = getter[1];
        index+=1;        
        }
        return fa;
    }
}

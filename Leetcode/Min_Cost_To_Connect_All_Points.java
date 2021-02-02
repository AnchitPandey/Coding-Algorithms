class custom implements Comparator<int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        return o1[2] - o2[2];
    }
}
class Solution {

    public int findParent (int id, int[] parent)
    {
        if (id == parent[id])
            return parent[id];
        return findParent (parent[id], parent);
    }

    public int minCostConnectPoints(int[][] points) {
        int min = 0;
        int n = points.length;
        int[] parents = new int[n];
        for (int i =0 ;i< n;i+=1)
            parents[i]  = i;
        PriorityQueue<int[]> pq = new PriorityQueue(new custom());
        for(int i =0 ; i < n;i+=1)
        {
            for (int j = i+1; j< n;j++)
            {
                int manhattanD = Math.abs (points[i][0] - points[j][0]) + Math.abs (points[i][1] - points[j][1]);
                int[] tt = new int[] {i,j,manhattanD};
                pq.add (tt);
            }        
        }
        while (!pq.isEmpty())
        {
            int[] tt = pq.poll();
            int par1 = findParent(tt[0], parents);
            int par2 = findParent(tt[1], parents);
            if (par1 < par2)
            {
                parents[par2] = par1;
                min += tt[2];
            }
            else if (par2 < par1)
            {
                parents[par1] = par2;
                min += tt[2];
            } 
        }
        return min;
    }
}

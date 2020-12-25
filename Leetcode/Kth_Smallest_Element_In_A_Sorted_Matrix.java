class custom implements Comparator<int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        return o1[0] - o2[0];
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean [m][n];
        visited[0][0] =  true;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]> (new custom());
        int[] start = new int[3];
        start[0] = matrix[0][0];
        start[1] = 0;
        start[2] = 0;
        pq.add(start);
        while (k >0)
        {
            k-=1;
            int[] getter = pq.poll();
            if(getter[1] +1< m && !visited[getter[1]+1][getter[2]])
            {
                int[] putter = new int[] {matrix[getter[1]+1][getter[2]], getter[1]+1,  getter[2]};
                pq.add (putter);
                visited[getter[1]+ 1][getter[2]] = true;
            }
            
            if(getter[2] +1< n && !visited[getter[1]][getter[2]+1])
            {
                int[] putter = new int[] {matrix[getter[1]][getter[2]+1], getter[1],  getter[2]+1};
                pq.add (putter);
                visited[getter[1]][getter[2]+1] = true;
            }
            if (k ==0)
                return getter[0];
        }
        return -1;
    }
}

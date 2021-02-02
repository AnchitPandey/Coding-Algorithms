class custom implements Comparator<int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        return - o1[2] + o2[2];
    }
}

class Solution {
    public int maximumMinimumPath(int[][] A) {
        PriorityQueue<int[]> pq = new PriorityQueue(new custom());
        //int min = A[0][0];
        int m = A.length;
        int n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        //visited[0][0] = true;
        int[] tt = new int[]{0,0, A[0][0]};
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        pq.add (tt);
        while (!pq.isEmpty())
        {
            int[] curr = pq.poll();
            if (curr[0] == m-1 && curr[1] == n-1)
                return curr[2];
            if (visited[curr[0]][curr[1]])
                continue;
            visited[curr[0]][curr[1]] = true;
            for (int i= 0 ; i< 4;i+=1)
            {
                int r = curr[0] + dr[i];
                int c = curr[1] + dc[i];
                if (r >=0 && r< m && c>=0 && c< n && !visited[r][c])
                {
                    //visited[r][c] = true;
                   int min = Integer.min (curr[2], A[r][c]);
                    int[] newone = new int[] {r,c, min};
                    pq.add (newone);
                }                
            }            
        }
        return -1;
    }
}

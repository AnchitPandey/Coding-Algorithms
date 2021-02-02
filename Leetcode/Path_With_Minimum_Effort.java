class custom implements Comparator<int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        return o1[2] - o2[2];
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue(new custom());
        boolean[][] visited = new boolean[m][n];
        int[] tt = new int[] {0,0,0};
        pq.add (tt);
        int[] dr = new int[] {-1,1,0,0};
        int[] dc = new int[] {0,0,-1,1};
        while (!pq.isEmpty())
        {
            int[] curr =  pq.poll();
            if (curr[0] == m-1 && curr[1] == n-1)
                return curr[2];
            if (visited[curr[0]][curr[1]])
                continue;
            visited[curr[0]][curr[1]] = true;
            for (int i =0 ;i< 4;i+=1)
            {
                int r = curr[0] + dr[i];
                int c = curr[1] + dc[i];
                if (r>=0 && r< m && c>=0 && c< n && !visited[r][c])
                {
                    int comp = Math.abs (heights[r][c] - heights[curr[0]][curr[1]]);
                    int max = Integer.max (curr[2], comp);
                    int[] newone = new int[] {r,c,max};
                    pq.add (newone);
                }
            }    
        }
        return -1;
    }
}

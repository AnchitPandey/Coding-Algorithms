class Solution {
    
    public Set<ArrayList<Integer>> bfs (int x, int y, boolean[][] visited, int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> qu = new LinkedList();
        Set<ArrayList<Integer>> ans =new HashSet();
        int[] start = new int[] {x,y};
        qu.add (start);
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while (!qu.isEmpty())
        {
            int[] curr = qu.poll();
            int xRel = curr[0] -x;
            int yRel = curr[1] -y;
            ArrayList<Integer> adder = new ArrayList();
            adder.add (xRel);
            adder.add (yRel);
            ans.add (adder);
            for (int j =0 ; j< 4;j+=1)
            {
                int r = curr[0] + dr[j];
                int c = curr[1] + dc[j];
                if (r>=0 && r< m && c>=0 && c< n && !visited[r][c] && grid[r][c] ==1)
                {
                    int[] child = new int[] {r,c};
                    visited[r][c] = true;
                    qu.add (child);
                }     
            }
        }
        return ans;
    }
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<Set<ArrayList<Integer>>> set = new HashSet();
        for (int i =0 ; i< m;i+=1)
        {
            for (int j =0 ; j< n;j+=1)
            {
                if (!visited[i][j] && grid[i][j] ==1)
                {
                    visited[i][j] = true ;
                    Set<ArrayList<Integer>> gets = bfs (i,j,visited, grid);
                    set.add (gets);
                }
            }
        }
        return set.size();
    }
}

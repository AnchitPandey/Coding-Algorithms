class Solution {
    public int findParent(int id, int[] parent) {
        if (parent[id] == id)
            return parent[id];
        return findParent (parent[id], parent);
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ls = new ArrayList();
        int k = positions.length;
        int[] parent = new int[k];
        for (int i =0 ; i< k;i+=1)
            parent[i] = i;
        int[][] grid = new int[m][n];
        for (int i =0 ; i< m;i+=1)
            for (int j =0 ; j< n;j+=1)
                grid[i][j] = -1;
        int[] dr = new int[] {-1,1,0,0};
        int[] dc = new int[] {0,0,-1,1};
        Set<Integer> visited = new HashSet();
        for (int i =0 ; i< k;i+=1) {
            if (grid[positions[i][0]][positions[i][1]] !=-1)
            {
                ls.add (visited.size());
                continue;
            }
            grid[positions[i][0]][positions[i][1]] = i;
            visited.add (i);
            int par2 = i;
            for (int j =0 ;  j< 4;j+=1)
            {
                int r = positions[i][0] + dr[j];
                int c = positions[i][1] + dc[j];
                par2 = grid[positions[i][0]][positions[i][1]];
               // par2 = findParent (grid[positions[i][0]][positions[i][1]], parent);
                if (r >=0 && r < m && c >=0 && c< n && grid[r][c] != -1) {
                    int par1 = findParent (grid[r][c], parent);
                    if (par2 < par1) {
                        visited.remove (par1);
                        visited.add (par2);
                        parent[par1] = par2;
                    //    grid[positions[i][0]][positions[i][1]] = par2;
                    }
                    else if (par1 < par2)
                    {
                        visited.remove (grid[positions[i][0]][positions[i][1]]);
                        grid[positions[i][0]][positions[i][1]] = par1;
                        parent[par2] = par1;
                }   
            }
            }
            ls.add (visited.size());
        }
        return ls;
    }
}

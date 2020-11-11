class custom implements Comparator<int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        return o1[0] - o2[0];
    }
}

class Solution {
    
    public int findParent (int id, int[] parent)
    {
        if (id == parent[id])
            return parent[id];
        return findParent (parent[id], parent);
    }
    
    
    public int earliestAcq(int[][] logs, int N) {
    
        ArrayList<int[]> ls = new ArrayList<int[]>();
        int n = N;
        int[] parent = new int[n];
        for (int i =0 ; i< n;i+=1)
            parent[i] = i;
        for (int i =0 ; i< logs.length; i+=1)
            ls.add (logs[i]);
            
        Collections.sort (ls, new custom());
        int ans =-1;
        for (int i=0 ; i< ls.size();i+=1)
        {
                int[] edge = ls.get(i);
                int par1 = findParent(edge[1], parent);
                int par2 = findParent (edge[2], parent);
                if (par1 != par2)
                {
                ans = edge[0];
                    if (par1 < par2)
                        parent[par2] = par1;
                    else
                    parent[par1] = par2;   
                }       
        }
        for (int i =0; i< n;i+=1)
            parent[i] = findParent(i, parent);
        for (int i =1 ;i< n;i+=1)
        {
            if (parent[i] != parent[i-1])
                return -1;
        }
        return ans;
    }
}

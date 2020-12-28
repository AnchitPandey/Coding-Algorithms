class custom  implements Comparator<int[]> {    
    public int compare (int[] o1, int[] o2)
    {
        return o1[0] - o2[0];
    } 
}

class Solution {
    
    public int findParent (int id, int[] parent)
    {
        if(id == parent[id])
            return parent[id];
        return findParent(parent[id],parent);
    }
    
    public int earliestAcq(int[][] logs, int N) {
        
        ArrayList<int[]> ls = new ArrayList<int[]>();
        for (int i= 0 ;i < logs.length;i+=1)
            ls.add (logs[i]);
        
        int[] parent= new int[N];
        int[] size = new int[N];
        for (int i =0 ; i< N;i+=1)
            parent[i] = i;
        Arrays.fill (size,1);
        //Arrays.sort(logs);
        Collections.sort (ls, new custom());
        int min = Integer.MAX_VALUE;
        for (int i =0; i<  ls.size();i+=1)
        {
            int[] logg = ls.get(i);
            int par1 =  findParent(logg[1], parent);
            int par2 = findParent(logg[2], parent);
            if (par1 < par2)
            {   
                size[par1] += size[par2];       
                parent[par2] = par1;
            }
            else if (par2 < par1)
            {
                size[par2] += size[par1];       
                parent[par1] = par2;                
            }
            if (size[par1] == N || size[par2] == N)
                return logg[0];        
        }
        return -1;
    }
}

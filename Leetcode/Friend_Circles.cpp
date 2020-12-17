class Solution {
    
    
  public:
    int findParent (int id, int parents[])
    {
        if (id != parents[id])
            return findParent(parents[id], parents);
        return parents[id];
    }
    
public:
    int findCircleNum(vector<vector<int>>& M) {
   
            set<int> setter;
            int n= M.size();
            int parents[M.size()];
            for (int i =0; i< M.size();i+=1)
                parents[i] = i;
            for (int i =0; i< M.size();i+=1)
            {
                for (int j =i+1; j< M.size();j+=1)
                {
                    if (M[i][j] ==1)
                    {
                        int par1 = findParent (i, parents);
                        int par2 = findParent (j, parents);
                        if (par1 < par2)
                            parents[par2] =par1;
                        else if (par2< par1)
                            parents[par1] = par2;
                    }
                }                
            }
            for (int i= 0; i< M.size();i+=1)
                parents[i] = findParent (i, parents);                
            
        for (int i =0 ; i< M.size();i+=1)      
            setter.insert (parents[i]); 
        return setter.size();
    }
};

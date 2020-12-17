class Solution {
    
    public: 
        int findParent (int parent[], int id)
        {
            if (parent[id] != id)
                return findParent (parent, parent[id]);
            return parent[id];
        }
    
public:
    string smallestEquivalentString(string A, string B, string S) {
        
        int parent[26];
        for (int i = 0;i < 26;i+=1)
            parent[i] = i;
        
        for (int i =0; i< A.length();i+=1)
        {
            int par1 = findParent(parent,(int)A[i] - 97 );
            int par2 = findParent(parent,(int)B[i] - 97 );
            if (par1 < par2)
                parent [par2] = par1;
            else if (par2 < par1)
                parent[par1] = par2;  
        }
        for (int i =0 ; i < 26;i+=1)
            parent[i] = findParent (parent, i);             
        
        string finalans = "";
        for (int i =0 ; i< S.length();i+=1){
            
            int id = parent [(int)S[i] - 97];
            id += 97;
            finalans += (char)id;
        }
          return finalans;         
    }
};

class Solution {
    
    public int findParent (int id, int[] parent)
    {
        if (id != parent[id])
            return findParent (parent[id], parent);
        return parent[id];
        
    }
    
    
    public String smallestEquivalentString(String A, String B, String S) {

        int[] parent = new int[26];
        for (int i =0; i< 26;i+=1)
            parent[i] = i;
        
        int n = A.length();
        for (int i= 0; i< n;i+=1 )
        {
            int par1 = findParent ((int)A.charAt(i) -97, parent);
            int par2 = findParent ((int)B.charAt(i) -97, parent);
            if (par1 != par2)
            {
                if (par1 < par2)
                    parent[par2] =par1;
                
                else if (par2 < par1)
                    parent[par1] = par2;
            }
        }
        for (int i= 0; i< 26;i+=1)
            parent[i] = findParent(i, parent);
            
        
        StringBuilder sb = new StringBuilder();
        for (int i =0; i< S.length();i+=1)
        {
            int par  = 97 + parent[(int)S.charAt(i) - 97];
            char t = (char)par;
            sb.append (t);
        }
        return sb.toString();
    }
}

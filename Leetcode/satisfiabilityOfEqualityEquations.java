class satisfiabilityOfEqualityEquations {
    
    public int findParent (int id, int[] parent)
    {
        if (id != parent[id])
            parent[id] = findParent(parent[id], parent);
        return parent[id];
    }
    
    public boolean equationsPossible(String[] equations) {
        
        int[] parent = new int[26];
        for (int i= 0 ; i< 26; i+=1)
            parent[i] = i;
        
        for (int i =0 ; i< equations.length;i+=1)
        {
            String equ = equations[i];
            if (equ.charAt(1) == '=')             
            {
                
                char ch1 = equ.charAt(0);

                char ch2 = equ.charAt(3);
                int par1 = findParent(ch1 -'a',parent);
                int par2 = findParent(ch2 -'a',parent);
                if (ch1 < ch2)
                    parent [par2] = par1;
                else
                    parent[par1] = par2;
            } 
        }
        for (int i =0;  i< equations.length;i+=1)
        {
            String equ = equations[i];
            if (equ.charAt(1) =='!')
            {
                char ch1 = equ.charAt(0);
                char ch2 = equ.charAt(3);
                
                int par1 = findParent(ch1 -'a',parent);
                int par2 = findParent(ch2 -'a',parent);
                if (par1 == par2)
                    return false;     
            }
        }
        return true;
    }
}

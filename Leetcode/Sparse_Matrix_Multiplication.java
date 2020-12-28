class Solution {
    
    public int multiply (HashMap<Integer, Integer> m1, HashMap<Integer, Integer> m2)
    {
        int total =0;
        HashMap<Integer, Integer> first, second;
        if (m1.size() <0)
        {
            first = m1;
            second = m2;
        }        
        else
        {
            second = m1;
            first = m2;
        }
        for (Map.Entry<Integer,Integer> me: first.entrySet())
        {
            if (second.containsKey(me.getKey())) 
                total += second.get(me.getKey()) * me.getValue();
        }
        return total;
    }
    
    public int[][] multiply(int[][] A, int[][] B) {
   
        int rowA = A.length, colA = A[0].length, rowB = colA, colB = B[0].length;
    
        HashMap<Integer, Integer>[] mA = new HashMap[rowA], 
        mB = new HashMap[colB];
        for (int i =0  ;i< rowA;i+=1)
        {
            mA[i] = new HashMap<Integer, Integer>();
            for (int j=0 ; j< colA; j+=1)
            {
                if (A[i][j] != 0)
                    mA[i].put (j, A[i][j]);    
            }           
        }
        for (int i =0  ;i< colB;i+=1)
        {
            mB[i] = new HashMap<Integer, Integer>();
            for (int j=0 ; j< rowB; j+=1)
            {
                if (B[j][i] != 0)
                mB[i].put (j, B[j][i]);    
            }           
        }
        int[][] fa = new int[rowA][colB];
        for (int i = 0 ;i < mA.length;i+=1)
        {
          
            for (int j =0  ;j< mB.length;j+=1)
            {
               fa[i][j] = multiply(mA[i],mB[j]);
            }                   
        }
        return fa;
    }
}

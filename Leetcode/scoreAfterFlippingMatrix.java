class Solution {
      
    public int matrixScore(int[][] A) {
    
     int m = A.length;
    int n = A[0].length;
        int[][] fa = new int[m][n];
        for (int i= 0 ; i < m;i+=1)
        {
            int flag = 0;
            if (A[i][0] == 0)
                flag =1;
            A[i][0] = 1;
            for (int j = 1; j< n;j+=1)
            {
                if (flag ==1)
                    A[i][j] = (A[i][j] == 0) ? 1 : 0;     
            }
        }
        
        for (int i=1; i< n;i+=1)
        {
            HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
            for (int j =0 ;j < m;j+=1)
            {
                if (A[j][i] ==1)
                    mapper.put (1, mapper.getOrDefault (1,0)+1);
                else
                    mapper.put (0, mapper.getOrDefault (0,0)+1);
            }
            if (!mapper.containsKey(1))
                mapper.put (1,0);
            if (!mapper.containsKey(0))
                mapper.put (0,0);
            
            
            if (mapper.get(0) > mapper.get(1))
            {
                for (int j =0 ;j < m;j+=1)
                    A[j][i] = (A[j][i] == 0) ? 1 : 0;                
            }
        }
        
        int total =0;
        for (int i =0; i< m;i+=1)
        {
         StringBuilder sb = new StringBuilder ();
            for (int j =0; j< n;j++)
                sb.append (A[i][j]);
                total+= Integer.parseInt(sb.toString(),2);
        }
        return total;
    }
}

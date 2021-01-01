class Solution {
    public int matrixScore(int[][] A) {
        
        int m = A.length;
        int n = A[0].length;
        for (int i =0; i< m;i++)
        {
            boolean flag = false;
            if (A[i][0] == 0)
            {
                A[i][0] = 1;
                flag = true;
            }
            for (int j = 1; j< n; j+=1)
            {
                if (flag)
                    A[i][j] = A[i][j] ==1 ? 0: 1;
            }           
        }
        int total = m* (int)Math.pow (2, n-1);
        for (int j =1 ;j< n;j+=1)
        {
            int ones = 0;
            for (int i = 0; i< m;i++)
            {
                if (A[i][j] == 1)
                    ones+=1;
            }
            ones = Integer.max (ones, m- ones);
            total += ones* (int)Math.pow (2, n - j-1);
        }
        return total;
    }
}

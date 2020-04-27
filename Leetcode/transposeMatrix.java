class transposeMatrix {
    public int[][] transpose(int[][] A) {
        
        if (A.length ==0)
            return new int[0][0];
        int m = A.length;
        int n = A[0].length;
       int[][] mat = new int[n][m];
       for (int i =0; i< m;i+=1)
       {
            for (int j =0 ;j< n;j+=1)
            {
            mat[j][i] = A[i][j];
            }
       }
    return mat;
    }
}

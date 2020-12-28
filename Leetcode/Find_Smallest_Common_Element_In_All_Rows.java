class Solution {
    public int smallestCommonElement(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer, Integer> mapper = new HashMap<Integer,Integer>();    
        for (int i =0; i < n;i+=1)
        {
            for (int j =0; j < m;j+=1)
            {
                mapper.put (mat[j][i], mapper.getOrDefault(mat[j][i],0) +1);     
                if (mapper.get(mat[j][i] ) == m)
                    return mat[j][i];
            }
        }
        return -1;
    }
}

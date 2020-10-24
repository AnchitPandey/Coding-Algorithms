class Solution {
    public int smallestCommonElement(int[][] mat) {
     
        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0 ; i< m;i+=1)
            for (int j= 0; j< n;j+=1)
                mapper.put (mat[i][j], mapper.getOrDefault(mat[i][j],0)+1);
        
        ArrayList<Integer> keys =new ArrayList<Integer>(mapper.keySet());
        int min = Integer.MAX_VALUE;
        for (int i =0 ; i< keys.size();i+=1)
            if (mapper.get(keys.get(i)) == m)
                min = Integer.min (min, keys.get(i));
            
            if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }
}

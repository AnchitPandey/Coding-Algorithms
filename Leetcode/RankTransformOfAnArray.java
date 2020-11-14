class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        TreeMap<Integer,Integer> mapper = new TreeMap<Integer, Integer>();
        for (int i =0 ;i< arr.length;i+=1)
            mapper.put (arr[i],1);
        
        ArrayList<Integer> keys = new ArrayList<Integer>(mapper.keySet());
        int[] fa=  new int[arr.length];
        for (int i= 0; i< arr.length;i++)
        {
            int rank = Collections.binarySearch (keys, arr[i])+1;
            fa[i] = rank;
        }   
        return fa;
    }
}

class heightChecker {
    public int heightChecker(int[] heights) {
        
        int n = heights.length;
        int[] hts = heights.clone();
        Arrays.sort (hts);
        int counter =0;
        for (int i =0 ; i< n;i+=1)
        {
         if (heights[i] != hts[i])
             counter+=1;
        }
        return counter;
    }
}

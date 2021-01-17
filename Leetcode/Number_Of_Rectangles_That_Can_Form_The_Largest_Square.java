class Solution {
    public int countGoodRectangles(int[][] rect) {
        
        HashMap<Integer,Integer> mapper = new HashMap();
        for (int i =0  ; i< rect.length;i+=1)
        {
            int min = Integer.min (rect[i][0], rect[i][1]);
            mapper.put (min, mapper.getOrDefault(min,0)+1);
        }
        int max = -1;
        int ans =0;
        for (Map.Entry <Integer, Integer> me: mapper.entrySet()) {
            if (me.getKey() > max )
            {
                max = me.getKey();
                ans = me.getValue();
            }
        }
        return ans;
    }
}

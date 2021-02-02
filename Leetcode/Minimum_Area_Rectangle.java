class Solution {
    
    public ArrayList<Integer> findCommon (TreeMap<Integer,Integer> firstX, TreeMap<Integer, Integer> secondX)
    {
        ArrayList<Integer> ans = new ArrayList();     
        for (Map.Entry <Integer, Integer> me: firstX.entrySet())
        {
            int key = me.getKey();
            if (secondX.containsKey(key))
            {
                ans.add (key);
            }
        }
        return ans;
    }
    
    public int minAreaRect(int[][] points) {
        int min = Integer.MAX_VALUE;
        TreeMap<Integer, TreeMap<Integer, Integer>> ys = new TreeMap();
        for (int i =0 ; i< points.length;i++)
        {
            int x = points[i][0];
            int y = points[i][1];
            if (!ys.containsKey(y))
            {
                TreeMap<Integer, Integer> mapper = new TreeMap();
                ys.put (y, mapper);
            }
            TreeMap<Integer, Integer> mapper = ys.get(y);
            mapper.put (x,1);
        }
        ArrayList<Integer> yValues = new ArrayList<Integer>(ys.keySet());
        for (int i =0 ; i< yValues.size();i+=1)
        {
            int yFirst = yValues.get(i);
            TreeMap<Integer, Integer> firstX = ys.get(yFirst);
            for (int j = i+1; j< yValues.size();j++)
            {
                int ySecond = yValues.get(j);
                int yDiff = ySecond - yFirst;
                TreeMap<Integer, Integer> secondX = ys.get(ySecond);                
                ArrayList<Integer> commonXs = findCommon (firstX, secondX);
                for (int k=1; k< commonXs.size();k+=1)
                {
                    int xDiff = commonXs.get(k) - commonXs.get(k-1);
                    min = Integer.min (min, xDiff * yDiff);                    
                }
            }            
        }
        return min == Integer.MAX_VALUE ? 0: min;
    }
}

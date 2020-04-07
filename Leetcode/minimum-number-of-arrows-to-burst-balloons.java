class Solution {
    public int findMinArrowShots(int[][] intervals) {
        
          
        if (intervals.length ==0)
            return 0;
        
       TreeMap<Integer, Integer> mapper = new TreeMap<Integer, Integer>();
        for (int i =0; i < intervals.length;i+=1)
        {
            if (mapper.containsKey(intervals[i][1]))
            {
                if (mapper.get(intervals[i][1]) < intervals[i][0])
                    mapper.put (intervals[i][1], intervals [i][0]);
            }
            
            else 
                mapper.put (intervals[i][1], intervals [i][0]);
        }
        
        ArrayList<Integer> startTimes = new ArrayList<Integer>(mapper.values());
        ArrayList<Integer> endTimes = new ArrayList<Integer>(mapper.keySet());
        int total =1;
        int index =0;
        
        for (int i = 1; i< startTimes.size();i+=1)
        {
            if (startTimes.get(i)> endTimes.get(index))
            {
                total+=1;
                index = i;
            }
        }
        return  total;   
        
    }
}

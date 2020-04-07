class test implements Comparator <custom>
{
public int compare (custom o1,  custom o2)
{
    if (o1.start <= o2.start)
    return -1;
    else
    return 1;
}

}



class custom
{
    int start, end,  index;
    custom (int start, int end, int index)
    {
        this.start = start;
        this.end  = end;
        this.index = index;
    }
}


class Solution {
    
    
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n ==0)
            return 0;
        
        TreeMap<Integer, Integer> eMap = new TreeMap<Integer, Integer>();
        custom[] objs = new custom[n];
        for (int i =0; i < n;i+=1)
            objs[i] = new custom(intervals[i][0], intervals[i][1], i);
        
        Arrays.sort (objs, new test());
        ArrayList<Integer> ets = new ArrayList<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add (objs[0].end);
        //for (int i =0;  i< n;i+=1)
          //  pq.add (objs[i].end);
        int max =1;
        for (int i =1; i<n;i+=1)
        {
            if (objs[i].start < pq.peek()) 
                max+=1;
            else
                pq.poll();
            pq.add (objs[i].end);
        } 
        return max;
    }
}

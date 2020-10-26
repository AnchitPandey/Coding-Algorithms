class custom implements Comparator <int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        if (o1[0] < o2[0])
            return -1;
        else if  (o1[0] > o2[0])
            return 1;
        else
            return o2[1] - o1[1];
    }    
}

class Solution {

    public int removeCoveredIntervals(int[][] intervals) {    
    
        HashMap<int[], Integer> mapper = new HashMap<int[], Integer>();
        ArrayList<int[]> ls = new ArrayList<int[]>();
        for (int i=0;i< intervals.length; i+=1)
            ls.add (intervals[i]);     
        Collections.sort (ls, new custom());        
        int[] start = ls.get(0);
        for (int i= 1; i<ls.size();i+=1)
        {
            int[] curr = ls.get(i);
            if (curr[0] < start[1] && curr[1] <= start[1])
                mapper.put (curr,1);
            else
                start[1] = curr[1];
        }
        return intervals.length - mapper.size();    
    }
}

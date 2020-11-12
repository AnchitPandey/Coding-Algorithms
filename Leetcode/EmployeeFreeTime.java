/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class custom implements Comparator <int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        return o1[0] -o2[0];
    }
}

class Solution {
public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {   
        ArrayList<int[]> ls = new ArrayList<int[]>();
        for (int i= 0 ; i< schedule.size();i+=1)
        {
            for (int j=0; j< schedule.get(i).size();j+=1)
            {       
                Interval it = schedule.get(i).get(j);
                int[] tt  = new int[2];
                tt[0] = it.start;
                tt[1] =  it.end;
                ls.add (tt);
            }
        }
        Collections.sort (ls, new custom());
        int start = ls.get(0)[0];
        int end = ls.get(0)[1];
        ArrayList<int[]> fa = new ArrayList<int[]>();
        for (int i =1 ; i< ls.size();i+=1)
        {
            int[] curr = ls.get(i);
            if (curr[0] <= end)
                end = Integer.max (curr[1], end);
            else 
            {
                int[] tt= new int[2];
                tt[0] = start;
                tt[1] = end;
                start = curr[0];
                end = curr[1];
                fa.add (tt);           
            }
        }  
        int[] ta = new int[] {start,end};
        fa.add (ta);
        List<Interval> ans  = new ArrayList<Interval>();
        for (int i=1; i< fa.size();i+=1)
        {
            int[] prev = fa.get(i-1);
            int[] curr = fa.get(i);
            
            Interval it = new Interval (prev[1], curr[0]);            
            ans.add (it);
        }
        return ans;
}
}

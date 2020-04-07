class test implements Comparator <int[]>
{
    public int compare (int[] o1, int[] o2)
    {
      if(o1[0] <= o2[0])
      return -1;
      else if (o1[0] > o2[0])
      return 1;
      else
      {
        if (o1[1] < o2[1])
        return -1;
    
    else if (o1[1] > o2 [1])
    return 1;
    
    else
    return -1;
      
      }  
    }
}

class custom
{
    int start, end;
    custom (int start, int end){
        this.start =start;
        this.end = end;
    }
}
    
    

class Solution {
    public int[][] merge(int[][] intervals) {
    
        int n = intervals.length;
        if (n == 0)
        {
            int[][] arr = new int[0][0];
            return arr;
        }
  //      ArrayList<int[]> lister = new ArrayList<int[]>();
   //    for (int i =0; i< intervals.length;i++)
    //       lister.add (intervals[i]);
           
    // ArrayList<custom> objs = new ArrayList<custom>();
    custom[] objs = new custom [n];
    for (int i =0 ;i< n;i+=1)
        objs[i] = new custom (intervals[i][0], intervals[i][1]);        
        
    Arrays.sort (objs, (a,b) -> a.start -b.start);
   //Collections.sort(lister, new test());
  
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        ArrayList<ArrayList<Integer>> lister = new ArrayList<ArrayList<Integer>>();
       // pq.add (intervals[0][1]);
        pq.add (objs[0].end);
        int curr = objs[0].start;
       // int curr = intervals[0][0];
        for (int i=1; i< n;i+=1)
        {
  //          if (intervals[i][0] <= pq.peek())
            if (objs[i].start <= pq.peek())
            {
               // if (intervals[i][1] > pq.peek())
                if (objs[i].end > pq.peek ())
                {
                    pq.poll();
    //                pq.add (intervals[i][1]);
                    pq.add (objs[i].end);
                }                
            }
            
            else
            {
                ArrayList<Integer> adder = new ArrayList<Integer>();
                adder.add (curr);
                adder.add(pq.poll());
                lister.add (adder);
             //   pq.add (intervals[i][1]);
               pq.add (objs[i].end);
           //     curr = intervals[i][0];
               curr = objs[i].start;       
            }
        }
       
        if (!pq.isEmpty())
        {
            ArrayList<Integer> adder = new ArrayList<Integer>();
            adder.add (curr);
            adder.add (pq.poll());
            lister.add (adder);
        }
        int[][] fa = new int[lister.size()][2];
        for (int i = 0 ; i< lister.size();i+=1)
        {
            fa[i][0] = lister.get(i).get(0);
            fa[i][1] = lister.get(i).get(1);
        }
        return fa;
    }
}

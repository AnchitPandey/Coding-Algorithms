class custom implements Comparator<ArrayList<Integer>>
{
    public int compare (ArrayList<Integer> l1, ArrayList<Integer> l2)
    {
        return l2.get(0) -l1.get(0); 
    }
}

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
    
        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<ArrayList<Integer>>(new custom());
        
        int n = values.length;
        for (int i =0 ; i< n;i+=1)
        {
            ArrayList<Integer> val = new ArrayList<Integer>();
            val.add (values[i]);
            val.add (labels[i]);
            pq.add (val);
            mapper.put (labels[i],0);
        }
        
        int total =0; 
        while (num_wanted >0 && pq.size () >0)
        {
            ArrayList<Integer> getter = pq.poll();
          //  System.out.println(getter);
            if (!mapper.containsKey (getter.get(1)))
                continue;
            //System.out.println("I got in");       
            total += getter.get(0);
        //    System.out.println("total value is "+ total); 
            //System.out.println("mapper is "+ mapper);
            mapper.put (getter.get(1), mapper.get(getter.get(1)) +1);
            if (mapper.get(getter.get(1)) == use_limit)
                mapper.remove (getter.get(1));
            
          //  System.out.println("mapper value is " +mapper);
            num_wanted -=1;
        }
    return total;        
    } 
}

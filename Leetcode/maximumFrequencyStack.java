class test implements Comparator <int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        if (o1[1] > o2[1])
            return -1;
        else if (o1[1] < o2[1])
            return 1;
        
        return o2[2]-  o1[2];
    }

}

class maximumFrequencyStack {
    
    PriorityQueue<int[]> pq;
    HashMap<Integer, Integer> mapper;
    int counter; 
    public FreqStack() {
        
        pq = new PriorityQueue<int[]>(new test());
        mapper = new HashMap<Integer, Integer>();
        counter = 0;
    }
    
    public void push(int x) {
        if (!mapper.containsKey (x))
        {
            mapper.put (x,1);
            int[] temp = new int[] {x, 1, counter};
            pq.add (temp);
        }
        else
        {
            mapper.put (x,mapper.get(x)+1);
            int[] temp = new int []{x, mapper.get(x), counter};
            pq.add (temp);
        }
        counter+=1;
      }
    
    public int pop() {
       
        int[] rm = pq.poll();
        mapper.put (rm[0], mapper.get(rm[0]) -1);
        if (mapper.get(rm[0]) ==0)
            mapper.remove (rm[0]);
        return rm[0];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */

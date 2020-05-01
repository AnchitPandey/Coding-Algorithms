class test implements Comparator <int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        if (o1[1] < o2[1])
            return -1;
        else if (o1[1] > o2[1])
            return 1;
        
        return o1[2] - o2[2];  
    }
}

class LFUCache {
    
    HashMap<Integer,int[]> m1;
    HashMap<Integer, Integer> m2;
    PriorityQueue<int[]> pq;
    int cap;
    int recent;
      public LFUCache(int capacity) {
        
        m1 = new HashMap<Integer, int[]>();
        m2 = new HashMap<Integer, Integer>();
        pq = new PriorityQueue<int[]>(new test());
        cap = capacity;
          recent =0;

    }
    
    public int get(int key) {
      
        recent+=1;
        if (m2.containsKey (key))
        {
            int[] tt  = m1.get(key);
            pq.remove (tt);
            tt[1] +=1 ;
            tt[2] = recent;
            pq.add (tt);
            return m2.get(key);
        }
        else
            return -1;  
    }
    
    public void put(int key, int value) {
    
        if(cap ==0)
        return;
        
        
        recent +=1;
        if (!m2.containsKey(key) && m2.size() == cap)
        {
            int[] tt = pq.poll();
            m1.remove (tt[0]);
            m2.remove (tt[0]);
            int[] tr = new int[] {key, 1,recent};
            m2.put (key, value);
            m1.put (tr[0], tr);
            pq.add (tr);
        }
        else 
        {
            
            if (!m2.containsKey(key))
            {
                int[] tt = new int[] {key, 1, recent};
                m2.put (key, value);
                m1.put (key,tt);
                pq.add (tt);
            }
            else
            {
                m2.put (key,value);
                int[] tt = m1.get(key);
                pq.remove (tt);
                tt[1] +=1;
                tt[2] = recent;
                pq.add(tt);
                
            }
        }
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

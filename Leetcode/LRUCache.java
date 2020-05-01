class yoMomma implements Comparator <int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        return o1[1] - o2[1];
    }
}
class LRUCache {

    HashMap<Integer, Integer> global;
    HashMap<Integer, int[]> keyToArray;
    PriorityQueue<int[]> pq;
    int recent = 0;
   // static ArrayList<Integer> lister;
    static int cap =0;
    public LRUCache(int capacity) {
    
        keyToArray = new HashMap<Integer, int[]> ();
        global = new HashMap<Integer, Integer>();
        pq = new PriorityQueue<int[]>(new yoMomma());
        cap = capacity;        
        recent = 0;
    }
    
    public int get(int key) {
    
        if(!global.containsKey(key))
            return -1;
            
        recent+=1;
        int[] tt=  keyToArray.get(key);
        pq.remove (tt);
        tt[1] = recent;
        pq.add (tt);
        return global.get(key);
    }
    
    public void put(int key, int value) {
    recent+=1;
    if (global.containsKey(key))
    {
        int[] tt = keyToArray.get(key);
        pq.remove (tt);
        tt[1] = recent;
        global.put (key,value);
        pq.add (tt);
    }
    
    else
    {
        if (cap == pq.size())
        {
           int[] tt =  pq.poll();
           global.remove (tt[0]);
           keyToArray.remove (tt);
        }
        int[] tt = new int[2];
        tt[0] = key;
        tt[1] = recent;
        pq.add (tt);
        keyToArray.put (key,tt);
        global.put (key, value);
    }
}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

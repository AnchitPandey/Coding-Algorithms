class custom implements Comparator<int[]> {
    
    public int compare (int[] o1, int[] o2) {
        return -o1[1] + o2[1];
    } 
}

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        // [barcode[i], fre(barcode[i])] min heap / max heap
        HashMap<Integer, Integer> mapper = new HashMap();
        for (int i =0; i< barcodes.length;i+=1)
            mapper.put(barcodes[i], mapper.getOrDefault(barcodes[i],0)+1);
        PriorityQueue<int[]> pq = new PriorityQueue(new custom());
        for (Map.Entry<Integer,Integer> me: mapper.entrySet())
        {
            int[] arr = new int[] {me.getKey(), me.getValue()};
            pq.add (arr);
        }
        int[] fa = new int[n];
        int curr =0;
        int prev= -1;
        while (!pq.isEmpty()) {
            
            // first time
            if (prev == -1)
            {
                int[] get = pq.poll();
                prev = get[0];
                fa[curr] = get[0];
                curr+=1;
                get[1] -=1;
                if (get[1] !=0)
                {
                    pq.add (get);
                }
            }
            else
            {
                int[] top = pq.poll();
                if (top[0] == prev) {
                    
                    int[] tt = pq.poll();
                    fa[curr] = tt[0];
                    curr+=1;
                    tt[1] -=1;
                    if (tt[1] !=0)
                        pq.add (tt);
                    prev = tt[0];
                    pq.add (top);   
                }
                
                else
                {
                    fa[curr] = top[0];
                    prev = top[0];
                    top[1] -=1;
                    if (top[1] !=0)
                        pq.add (top);
                    curr+=1;
                    
                }   
            }
        }
        return fa;
    }
}

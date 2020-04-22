class test implements Comparator<int[]>
{
    public int compare (int[] a, int[] b)
    {
        return a[1] - b[1];
    }
}

class networkDelayTime {
    public int networkDelayTime(int[][] flights, int n, int src) {
     
    int[] parent = new int[n];
    for (int i =0 ; i<n;i+=1)
        parent[i] = -1;
    
        ArrayList<int[]>[] vert = new ArrayList[n];
        for (int i =0 ; i< n;i+=1)
        {
            vert[i] = new ArrayList<int[]>();
        }
        
        // making adj. list
        for (int i =0; i< flights.length;i+=1)
        {
            int[] adder = new int[] {flights[i][1]-1,flights[i][2]};
            vert[flights[i][0]-1].add (adder);
        }
        
        HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new test());
        int[] starter = new int[] {src-1,0};
        pq.add (starter);
        //int finalCost = -1;
        while(!pq.isEmpty())
        {
            int[] curr = pq.poll();
            
            if (visited.containsKey(curr[0]))
                continue;
          
            parent[curr[0]] = curr[1];
            visited.put (curr[0],1);
            ArrayList<int[]> children = vert[curr[0]];
            for (int j =0; j< children.size();j+=1)
            {
                int[] child = children.get(j);
                child[1] += curr[1];
                pq.add (child);
               // parent[child[0]] = curr[0];
            }            
        }
        
        
        for(int i =0 ; i< n;i+=1)
        {
                if (!visited.containsKey(i))
                     return -1;
                
       }
        //System.out.println("so its working basically");
        int max =-1;
        for (int i =0 ; i< n;i+=1)
        {
            if (parent[i] > max)
            max = parent[i];        
        }

        return max;
    }
}

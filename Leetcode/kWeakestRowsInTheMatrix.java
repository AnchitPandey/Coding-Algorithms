class test implements Comparator <int[]>
{
    public int compare (int[] o1, int[] o2)
    {
        if (o1[0] > o2[0])
        return -1;
        
        else if (o1[0] < o2[0])
        return 1;
        
        if (o1[1] > o2[1])
        return -1;
        
        return 1;    
    }
}
kWeakestRowsInTheMatrixSolution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new test());
        for (int i =0; i< mat.length;i+=1)
        {
            int counter =0;
            for (int j =0 ; j< mat[0].length;j+=1)
            {
                if (mat[i][j] ==0)
                break;
                
                counter+=1;
            }
            
            int[] temp = new int[] {counter, i};
            if (pq.size() ==k)
            {
                if (temp[0] <pq.peek()[0] || (temp[0] ==pq.peek()[0] && temp[1] < pq.peek()[1]) )
                {
                    pq.poll();
                    pq.add (temp);
                }
            }
            else
            pq.add (temp);
        }
        ArrayList<Integer> te = new ArrayList<Integer>();
        while (!pq.isEmpty())
        {
            int[] temp = pq.poll();
            te.add (temp[1]);
        }
        int[] fa = new int[k];
        
        for (int i =0; i< k;i+=1)
        fa[i] = te.get(k-i-1);
        return fa;
        
     }
}

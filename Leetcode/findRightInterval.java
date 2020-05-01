class findRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int n= intervals.length;
        if (n ==0)
        {
            int[] fa = new int[0];
            return fa;
        }
        if (n ==1)
        {
            int[] fa = new int[]{-1};
            return fa;
        }
        HashMap<Integer,Integer> mapper = new HashMap<Integer, Integer>();
        ArrayList<Integer> lister = new ArrayList<Integer>();
        for (int i =0; i<intervals.length;i++)
        {
            mapper.put(intervals[i][0],i);   
            lister.add (intervals[i][0]);
        }
       
        Collections.sort (lister);
       // System.out.println(lister);
        int[] fa = new int[n];
        for (int i =0 ; i< n;i+=1)
        {
            int index = Collections.binarySearch (lister, intervals[i][1]);
            if (index < 0)
                index = -index-1;
        //  System.out.println(index);
            if (index ==n)
                fa[i]= -1;
            else
                fa[i] = mapper.get(lister.get(index));
        }
        return fa;
    }
}

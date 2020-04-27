class countLargestGroup {
    public int findSum (int n)
    {
        int sum =0;
        while (n >0)
        {
            sum += n% 10;
            n/=10;
        }
        return sum;
    }
    
    public int countLargestGroup(int n) {
      
        HashMap<Integer, Integer> mapper = new HashMap<Integer, Integer>();
        int max =0;
        for (int i=1; i<=n;i+=1)
        {
            int sum = findSum(i);
            // System.out.println("n is "+ n);
            // System.out.println("sum is "+ sum);
            
            if (mapper.containsKey(sum))
                mapper.put (sum, mapper.get (sum)+1);
            else
                mapper.put (sum,1);
        
            if (mapper.get(sum) > max)
                max = mapper.get(sum);
        }
        ArrayList<Integer> values = new ArrayList<Integer>(mapper.values());
        int counter =0;
        for (int i =0; i< values.size();i+=1)
        {
            if (values.get(i) == max)
                counter+=1;
        }
        return counter;
    }
}

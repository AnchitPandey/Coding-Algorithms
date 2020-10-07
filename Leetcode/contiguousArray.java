class Solution {
    
    public int findMaxLength(int[] nums) {
       
        int n = nums.length;
        if (n ==0)
            return n;
        int[] prefix = new int[n];
       
        for (int i =0; i< n;i+=1)
        {
            if (nums[i] ==0)
                nums[i] = -1;
        }
         prefix[0] = nums[0];
        for (int i =1; i<n;i+=1)
            prefix[i] = prefix[i-1] + nums[i];
        int max =0;
        for (int i =0; i< n;i+=1)
        {
            if (prefix[i] ==0)
                max = i+1;
        }
        HashMap<Integer, ArrayList<Integer>> mapper = new HashMap<Integer, ArrayList<Integer>>();
        for (int i =0; i< prefix.length;i+=1)
        {
            if (prefix[i] != 0)
            {
                if (!mapper.containsKey(prefix[i]))
                {
                    ArrayList<Integer> putter = new ArrayList<Integer>();
                    putter.add (i);
                    mapper.put (prefix[i], putter);
                }
                else
                {
                    ArrayList<Integer> getter = mapper.get(prefix[i]);
                    getter.add (i);
                }
            }
        }
        ArrayList<ArrayList<Integer>> values =new ArrayList<ArrayList<Integer>>(mapper.values());
        
        for (int i =0 ;i< values.size();i+=1)
        {
            ArrayList<Integer> val = values.get(i);
            if (val.size() >1)
                max = Integer.max (max, val.get(val.size()-1) - val.get(0));
            
        }
    return max;        
    }
}

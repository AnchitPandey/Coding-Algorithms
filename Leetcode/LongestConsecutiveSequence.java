class Solution {
    public int longestConsecutive(int[] nums) {
        
        if (nums.length ==0)
            return 0;
        
        HashMap<Integer, Integer> visited =new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> mapper =new HashMap<Integer, Integer>();
        for (int i= 0; i< nums.length;i+=1)
        {
            mapper.put (nums[i],1);
        }
    
        int max=1;
        for (int i =0; i< nums.length;i+=1)
        {
            if (!visited.containsKey (nums[i]))
            {
                visited.put (nums[i],1);
                int counter =0;
                Queue<Integer> qu = new LinkedList<Integer>();
                qu.add (nums[i]);
                while (!qu.isEmpty())
                {
                    int number = qu.poll();
                    counter+=1;
                    if (mapper.containsKey(number+1) && !visited.containsKey (number+1))
                    {
                        visited.put (number+1, 1);
                        qu.add (number+1);
                    }
                 if (mapper.containsKey(number-1) && !visited.containsKey (number-1))
                    {
                       visited.put (number-1, 1);
                        qu.add (number-1);
                    }                   
                }
                max = Integer.max (max, counter);
            }
            
        }
        return max;
}
    
}

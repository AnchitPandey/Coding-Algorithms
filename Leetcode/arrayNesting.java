class arrayNesting {
    
    
    public void dfs (int curr, int[] cost,  ArrayList<Integer>[] vert, HashMap<Integer, Integer> stacker)
    {
        // add the current node to stack
        stacker.put (curr,1);
        
        // if this is leaf node OR this node is already on this current stack
        if (vert[curr].size() ==0 || stacker.containsKey(vert[curr].get(0)))
        {
            // set this nodes cost to 0
            cost[curr]  =0;
            return;
        }
        
        // get the child of this node
        int child = vert[curr].get(0);
        
        // if this child has been visited before, then just increment cost
        if (cost[child] !=-1)
        {
            cost[curr] = 1+ cost[child];
            return;
        }
        
        // otherwise recursively call dfs on the child node
        dfs (child, cost,vert, stacker);
        
        // after rec, increment cost of child node by 1
        cost[curr] = 1 + cost[child];
        
        // remove node from current stack after processing is over
        stacker.remove (child,1);
        return;
    }
    
    public int arrayNesting(int[] nums) {
        
        int n = nums.length; 
        if (n ==0)
            return 0;
        ArrayList<Integer>[] vert = new ArrayList[n];
        for (int i =0; i< n;i+=1)
            vert[i] = new ArrayList<Integer>();        
        
        
        for (int i = 0; i< nums.length;i++)
        {
            // To avoid self loops
            if (i != nums[i])
            vert[i].add (nums[i]);          
        }
        
        // stores cost
        int[] cost = new int[n];
        // initializing any random value
        Arrays.fill(cost,-1);
        
        for (int i =0 ;i< n;i+=1)
        {
            // current node
            int curr = i;
            
            // if node has not been processed before
            if (cost[curr] !=-1)
                continue;
            
            // keeping track of current nodes in the stack during DFS
            HashMap<Integer, Integer> stacker = new  HashMap<Integer, Integer>();
            
            // performing dfs
            dfs (curr,cost, vert, stacker);
        }
        
        int max = Integer.MIN_VALUE;
        // find max value in cost array
        for (int i=0 ; i< n;i+=1)
            max =Integer.max (max, cost[i]);
        
        // max +1 because length of |S| is always 1 more than max(cost)
        return max+1;
    }
}

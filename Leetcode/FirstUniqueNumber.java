class FirstUnique {

    ArrayList<Integer> ls;
    HashMap<Integer, Integer> mapper;
    
    int currIndex = -1;   
    
    public FirstUnique(int[] nums) {
        
        ls = new ArrayList<Integer>();
        mapper = new HashMap<Integer, Integer>();
        for (int i =0; i < nums.length;i+=1)
        {
            if (!mapper.containsKey(nums[i]))
            {
                ls.add (nums[i]);
                mapper.put (nums[i],1);
            }
            else
                mapper.put (nums[i], mapper.get(nums[i])+1);
        }
        // adjusting index
    currIndex=0;
        while (currIndex < ls.size() && mapper.get(ls.get(currIndex))> 1)
            currIndex+=1;
        
    }
    
    public int showFirstUnique() {
    if (currIndex == ls.size())
        return -1;        
    return ls.get(currIndex);    
    }
    
    public void add(int value) {
        if (!mapper.containsKey (value))
        {
            ls.add (value);
            mapper.put (value,1);
        }
        else
            mapper.put (value, mapper.get(value)+1);         
       
        // adjusting index
        while (currIndex < ls.size() && mapper.get(ls.get(currIndex)) >1)
            currIndex+=1;
        
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */

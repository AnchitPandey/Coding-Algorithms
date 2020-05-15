class relativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        
        int[] sorted = nums.clone ();
        String[] fa = new String[nums.length];
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for(int i =0 ; i< nums.length;i+=1)
            ls.add (nums[i]);
        
        Collections.sort(ls);
        
        for (int i=0 ; i< nums.length;i+=1)
        {
            int index = Collections.binarySearch (ls, nums [i]);
            if (index == ls.size()-1)
            {
                fa[i] = "Gold Medal";
            }
            else if (index == ls.size()-2)
            {
                fa[i] = "Silver Medal";
            }
            else if (index ==  ls.size()-3)
            {
                fa[i] = "Bronze Medal";
            }
            else
                fa[i] = String.valueOf(ls.size() - index);
        }
        return fa;
    }
}

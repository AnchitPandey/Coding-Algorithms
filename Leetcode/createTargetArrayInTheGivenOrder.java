class createTargetArrayInTheGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        
      int n = nums.length;
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for (int i =0; i<n;i+=1)
            ls.add (index[i], nums[i]);
        int[] target = new int[n];
        for (int i =0 ;i< n;i+=1)
            target[i] = ls.get(i);
        
        return target;
    }
}

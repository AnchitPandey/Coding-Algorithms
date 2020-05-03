class findAllNumbersDisappearedInAnArray {
   
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> mapper=  new HashMap<Integer,Integer>();
        for (int i =0; i< nums.length;i++)
        {
            mapper.put(nums [i],1);
        }
        List<Integer> fa = new ArrayList<Integer>();
        for(int i =1;i<=n;i++)
        {
            if (!mapper.containsKey(i))
                fa.add (i);
        }
    return fa;
            
    }
}

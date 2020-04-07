class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length ==0)
            return 0;
        
        ArrayList<Integer> lister = new ArrayList<Integer>();
        for (int i =0 ;i< nums.length;i+=1)
        {
            if (nums[i] ==0)
                lister.add (i);        
        }
        if (lister.size () <=1)
               return nums.length;
        
        int max =0;
        //System.out.println(lister);
        
        for (int  i =0 ; i< lister.size();i+=1)
        {
            if (i == lister.size()-1)
                max = Integer.max (max, nums.length - lister.get(i-1)-1);    
            
            else if (i ==0)
                max = Integer.max (max, lister.get(i+1));
            
            else
                max = Integer.max(max, lister.get(i+1) - lister.get(i-1)-1);    
            
         //   System.out.println("max is "+ max);
        
        }
        return max;
    }
}

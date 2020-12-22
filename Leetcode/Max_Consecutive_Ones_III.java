class Solution {
    public int longestOnes(int[] nums, int k) {
 

        if (k >= nums.length)
            return nums.length;
        ArrayList<Integer> ls =new ArrayList<Integer>();
        for (int i =0 ; i< nums.length;i+=1)
        {
            if (nums[i] ==0)
                ls.add (i);
        }
        if (ls.size() ==0 || k>= ls.size())
            return nums.length;
        
        if (k ==0)
        {
            int max = ls.get(0);
            for (int i =0; i<ls.size()-1;i+=1)
              max = Integer.max (max, ls.get(i+1)-ls.get(i) -1);   
            
            max = Integer.max (max, nums.length - ls.get(ls.size()-1)-1);
            return max;
        }
        
        int max = 0;
        for (int i =0 ; i< ls.size();i+=1)
        {
            int upper =-1, lower =-1;
            if (i+k < ls.size())
                upper = ls.get(i+k); 
            else
                upper = nums.length;
            

            if (i ==0)
                lower =0;
            else               
                lower = ls.get(i-1) +1;   
            if (ls.get(i) == 9)
            {
             //   System.out.println(i);
              //  System.out.println(upper);
               // System.out.println(lower);
            }
            
            max = Integer.max (max, upper - lower);
        }
        return max;
    }
}

class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        if (nums.length < 3)
            return false;
        
        int num1 = nums[0], num2=-1, num3=-1, flag = 0, cand = -1;
        boolean isNum2 = false, isCand = false;        
        for (int i =1; i< nums.length;i+=1)
        {
            // if num2 is not yet initialized
            if (!isNum2)
            {
                if (nums[i] > num1)
                {
                    num2 = nums[i];
                    isNum2 = true;
                }
                else if (nums [i] < num1)
                    num1 = nums[i];                
            }
            
            else
            {
                // if candidate key is not set
                if (!isCand)
                {

                    if (nums[i] < num2 && nums[i] > num1)
                        num2 = nums[i];

             
                    else if (nums[i] > num2)
                        return true;

                    // if nums[i] < num1 then assign candidate key
                    else if (nums [i] < num1)
                    {
                        cand = nums[i];
                        isCand = true;
                    }           
                }
                
                // if candidate key is set
                else
                {
                    // if current element is smaller than candidate key then assign current element to candidate key
                    if (nums[i] < cand)
                        cand = nums[i];

                    // if current number is greater than num2 , then we found a triplet
                    else if (nums[i] > nums[2] )
                        return true;
                    
                    // re-assign num1 & num2 if below condition meets
                    else if (nums[i] > num1 && nums[i] < num2)
                    {
                        num2 = nums[i];
                        num1 = cand;
                        isCand = false;
                    }
                }
            }
        }
        return false;
    }
}

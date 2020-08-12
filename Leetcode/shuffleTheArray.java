class Solution {
    public int[] shuffle(int[] nums, int n) {
        
       int[] answer = new int[2*n];
        int index1 = 0, index2 = n;
        for (int i =0;i< nums.length;i+=1)
        {
            if (i %2 ==0)
            {
                answer[i] = nums[index1];
                index1+=1;
            }
            else
              {
                    answer[i] = nums[index2];
                    index2+=1;
               }
        }
        return answer;
    }
}

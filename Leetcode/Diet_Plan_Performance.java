class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
       
            int tot =0 , curr =0;
            for (int i=0; i< k;i+=1)
            {
                curr += calories[i];
            }
            if (curr > upper)
                tot +=1;
            else if (curr < lower)
                tot-=1;
        
            for (int i = k; i < calories.length;i+=1)
            {
                curr -= calories[i-k];
                curr += calories[i];
                if (curr > upper)
                    tot +=1;
                else if (curr < lower)
                    tot-=1;                
            }
        return tot;
    }
}

class Solution {
    public int minCost(String s, int[] cost) {
 
        int curr= 0;
        int max = 0;
        int total =0;
        int n = cost.length;
        for (int i =1; i<n;i+=1)
        {
            if (s.charAt(i) ==s.charAt(i-1))
            {
                if ( i==1 || (s.charAt(i-2) != s.charAt(i-1) ))
                {
                    curr = cost[i] + cost[i-1];
                    max = Integer.max (cost[i], cost[i-1]);
                }
                else
                {
                    curr += cost[i];            
                    max = Integer.max (max, cost[i]);
               
                }
            }
            else
            {
            
                total += curr - max;
                curr = 0;
                max =0;               
            }            
        }
        total += curr- max;
        return total;
    }
}

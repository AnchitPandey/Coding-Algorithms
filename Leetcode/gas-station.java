class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
    
        
        
        int currIndex =0;
        int n = gas.length; 
        if (n ==0)
            return -1;
        
        int prev =0;
        for(int i= 0; i< n;i+=1)
        {
            if (gas[i] - cost[i]  + prev >=0)
                prev +=gas[i] - cost[i];   
            else
            {
                if (i+1 < n)
                {
                    currIndex = i+1;
                    prev = 0;
                }
                    else
                    currIndex = -1;
            }          
        }
        if (currIndex ==-1)
            return -1;
        
        for (int i =0 ; i < currIndex;i+=1)
        {
            if (gas[i] - cost [i]+ prev >=0)
            {
                prev += gas[i] - cost[i];
            }
            else
                return -1;
        }  
        return currIndex;
    }
}

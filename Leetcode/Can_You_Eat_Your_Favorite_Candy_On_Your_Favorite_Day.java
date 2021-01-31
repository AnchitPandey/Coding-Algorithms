class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {

        long[] prefix = new long[candiesCount.length];
        prefix[0] = candiesCount[0];
        int n = candiesCount.length;
        for (int i =1; i< n;i+=1)
            prefix[i] = prefix[i-1] + candiesCount[i];   
        boolean[] ans = new boolean[queries.length];
        for (int i= 0;i<queries.length;i+=1)
        {
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];          
            if (type == 0)
            {
                if (day <= prefix[0]-1)
                ans[i] = true;
                else
                    ans[i] = false;
                continue;
            }
            long div = 0L;
            if (prefix[type-1] % cap ==0)
                div = (long)prefix[type-1]/cap;
            else 
            {
                div = (long)Math.ceil ((float) prefix[type-1] / cap);
                div -=1;
            }
            long upperlimit = prefix[type]-1;
            if (day >=  div && day <= upperlimit)
                ans[i] =true;
            else
                ans[i] = false;
        }
        return ans;
    }
}

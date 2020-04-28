class grumpyBookStoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
     
        int n  =customers.length;
  
        int[] prefix = new int[n];
        
        for (int i =0 ; i< n;i+=1)
        {
            if (grumpy[i] ==0)
                grumpy[i]  =1;
            else
                grumpy[i] = 0;
        }
        prefix[0] = grumpy[0] * customers[0];
        
        for (int i=1; i< n;i+=1)
            prefix[i] = prefix[i-1] + grumpy[i] * customers[i];
        
        int sum = 0;
        for (int i =0; i< X;i+=1)
            sum += customers[i];

        int up = prefix[n -1] - prefix[X-1];
        int max = sum + up;
        for (int i = X;i < n;i+=1)
        {
            int lower = prefix[i-X];
            sum = sum - customers[i-X] + customers[i];
            max = Integer.max (max , sum + lower + prefix[n-1] - prefix[i]);
        }
        return max;
    }
}

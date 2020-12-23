class Solution {
    public int minSwaps(int[] data) {
        
    int counter =0, min = Integer.MAX_VALUE;
    int k =0;
    
    for (int i =0  ; i< data.length;i+=1)
    {
        if (data[i] ==1)
            k+=1;
    }            
    for (int i = 0 ; i<k;i+=1)
    {
        if (data[i] == 0)
            counter+=1;
    }
    min = Integer.min (counter, min);
    for (int i =k; i<data.length;i+=1)
    {
        if (data[i-k] == 0)
            counter-=1;
        if (data[i] ==0)
            counter+=1;
        min = Integer.min (counter, min);
    }
    return min;
    }
}

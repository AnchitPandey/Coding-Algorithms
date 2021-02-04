class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3)
            return false;
        boolean incr = false;
        boolean decr = false;
        for (int i =1; i<arr.length;i+=1)
        {
             if (arr[i] > arr[i-1])
             {
                 incr = true;
                 if (decr)
                 {
                   //  System.out.println("over here");
                     return false;
                 } 
            }
             if (arr[i] < arr[i-1])
                 decr = true;            
            if (arr[i] == arr[i-1])
                return false;
        }
       // System.out.println(decr +" "+ incr);
        if (decr && incr)
            return true;
        return false;
    }
}

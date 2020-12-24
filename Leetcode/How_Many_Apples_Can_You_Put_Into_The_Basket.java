class Solution {
    public int maxNumberOfApples(int[] arr) {

        int rem = 5000;
        int counter =0;
        Arrays.sort (arr);
        for (int i =0 ; i< arr.length;i+=1)
        {
            if ( rem - arr[i] >0)
            {
                counter+=1;
                rem -= arr[i];
            }
        }
        return counter;
    }
}

class Solution {
    public int findKthPositive(int[] arr, int k) {

        Set<Integer> set = new HashSet<Integer>();
        int counter =0;
        for (int i =0 ;i< arr.length;i+=1)
            set.add (arr[i]);
        int missing = -1;
        for (int i =1; i<= 2001;i+=1) {
            
            if (!set.contains (i))
            {
                counter+=1;
                missing = i;
                if (counter == k)
                    break;
            }
        }
        return missing;
    }
}

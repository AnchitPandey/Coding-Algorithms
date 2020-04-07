class test implements Comparator <int[]>
{

    public int compare (int[] a1, int[] a2)
    {
        if (a1[0] < a2[0])
        return -1;
        
        else if (a1[0] > a2[0])
        return 0;
        
        else
        {
            if (a1[1] <= a2[1])
            return -1;
            
            else
            return 1;
        }
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    
            if (nums.length ==0)
            return false;
    
            ArrayList<int[]> l = new ArrayList();
            for (int i= 0; i< nums.length;i+=1)
            {
                int[] arr = new int[]{nums[i],i};
                l.add (arr);
            }
            Collections.sort (l, new test());
            int[] prev = l.get(0);
            for (int i =1 ; i< l.size();i+=1)
            {              
                int[] arr = l.get(i);
                if (prev[0] == arr[0])
                {
                    if (arr[1] - prev[1] <= k)           
                        return true ;               
                }
                prev = arr;
            }
            return false;
    }
}

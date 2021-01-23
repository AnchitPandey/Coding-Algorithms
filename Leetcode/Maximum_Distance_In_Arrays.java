class Solution {
    public int maxDistance(List<List<Integer>> arrays) {  
        int minIndex1 =0, minIndex2 = 0, maxIndex1 = 0, maxIndex2 =0;
        int m = arrays.size();
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE; 
        for (int i =0 ; i< m;i++)
        {
           List<Integer> ls = arrays.get(i);
            if (ls.get(0) <= minValue)
            {
                minValue = ls.get(0);
                minIndex1 = i;
            }
            if (ls.get(ls.size()-1) >= maxValue)
            {
                maxValue = ls.get(ls.size()-1);
                maxIndex1 = i;
            }            
        }
        
        if (minIndex1 != maxIndex1)
            return Math.abs(maxValue - minValue);   
        minValue = Integer.MAX_VALUE; maxValue = Integer.MIN_VALUE;
        for (int i =0 ; i < m;i+=1)
        {
            List<Integer> ls = arrays.get(i);
            if (ls.get(0) <= minValue && i != minIndex1)
            {
                minValue = ls.get(0);
                minIndex2 = i;
            }
            if (ls.get(ls.size()-1) >= maxValue && i!= maxIndex1)
            {
                maxValue = ls.get(ls.size()-1);
                maxIndex2 = i;
            }    
        }
        
        int diff1 =0, diff2 =0, diff3 =0;
        List<Integer> ls1 = arrays.get(maxIndex1);
        List<Integer> ls2 = arrays.get(maxIndex2);
        List<Integer> ls3 = arrays.get(minIndex2);
        diff1 = Math.abs (ls1.get(ls1.size()-1) - ls3.get(0));
        diff2 = Math.abs (ls2.get(ls2.size()-1) - ls1.get(0));
        if (minIndex2 != maxIndex2)
            diff3 = Math.abs (ls2.get(ls2.size()-1) - ls3.get(0));
        return Integer.max (diff1, Integer.max (diff2, diff3));  
    }
}

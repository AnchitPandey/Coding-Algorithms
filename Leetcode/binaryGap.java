class Solution {
    public int binaryGap(int N) {
       
        String str = Integer.toBinaryString (N);
        int max = 0;
        int prev = -1;
        for (int i =0; i< str.length();i+=1)
        {
            if (str.charAt(i) =='1')
            {
                if (prev ==-1)
                    prev = i;
                else
                {
                    max = Integer.max (max, i - prev);
                    prev = i;
                }
            }
        }
        return max;
    }
}

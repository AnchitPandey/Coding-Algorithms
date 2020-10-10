class Solution {
    public int minFlips(String target) {
        int sum = 0;
        int n = target.length();
        char curr = '0';
        for (int i =0 ; i< n;i+=1)
        {
            if (target.charAt(i) != curr)
            {
                sum +=1;
                if (curr == '0')
                    curr = '1';
                else
                    curr = '0';
            }
        }
        return sum;
    }
}

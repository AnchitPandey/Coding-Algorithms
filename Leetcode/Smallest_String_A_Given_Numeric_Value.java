class Solution {
    public String getSmallestString(int n, int k) {
        
        StringBuilder sb = new StringBuilder();
        for (int i =0; i< n; i+=1)
        {
            int rem = 26 *(n-i-1);
            for (int j=0; j< 26;j+=1)
            {
                int k_star = k- j - 1;
                if (rem - k_star >=0)
                {
                    k = k_star;
                    sb.append ((char)(97 + j));
                    break;
                }
            } 
        }
        return sb.toString();
    }
}

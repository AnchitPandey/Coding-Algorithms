class Solution {
    public boolean hasAlternatingBits(int n) {
     
        
        String input = Integer.toBinaryString(n);
        for (int i =1; i< input.length();i++)
        {
            if (input.charAt(i) == input.charAt(i-1))
                return false;
        }       
        return true;
    }
}

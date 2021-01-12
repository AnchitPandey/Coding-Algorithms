class Solution {
    public String shiftingLetters(String S, int[] shifts) {   
        long prev = 0L;
        char[] arr = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = S.length ()-1 ;i>=0;i-=1)
        {
            char ch = S.charAt(i);
            prev  += shifts[i];
            prev %= 26;
            int curr = (int)ch - (int)'a';
            curr+= prev;
            curr %= 26;
            ch = (char)((int)curr + (int)'a');
            sb.append(ch);
        }
        sb = sb.reverse();
        return sb.toString();
     }
}

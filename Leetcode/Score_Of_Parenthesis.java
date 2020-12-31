class Solution {

    public int scoreOfParentheses(String S) {
        int sum =0, depth =1;
        char prev= '-';
        for (int i =0 ; i< S.length();i+=1)
        {
            char ch = S.charAt(i);
            if (ch == '(')
            {
                depth*=2;
          //      prev = ch;
            }
            else
            {
                if (prev =='(')
                    sum += depth/2;
                depth/=2;
            }
            prev = ch;            
        }
        return sum;
    }
}

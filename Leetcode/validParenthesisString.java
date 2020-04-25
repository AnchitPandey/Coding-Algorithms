class validParenthesisString {
    public boolean checkValidString(String s) {
    
        // travel first from left to right and then from right to left 
        // keep count of * ("rem" variable) , if there is a inconsistency in brackets then decrement rem
        // if there is inconsistency && rem == 0 return false
        // rem  =  number of * left
        
        Stack<Character> st = new Stack<Character>();
        int rem =0; 
        
        // traverse from left to right to check 
        
        
        for (int i =0; i< s.length();i+=1)
        {
            if (s.charAt(i) =='(')
                st.push ('(');
            else if (s.charAt(i) =='*')
                rem+=1;      
            else
            {
                if (st.size() ==0)
                {
                    if (rem ==0)
                        return false;
                    else
                    rem -=1;
                }
                else
                    st.pop();
            }
        }
        if (!st.isEmpty() && st.size() > rem)
            return false; 
        
        // traverse from right to left 
        Stack<Character> st1 = new Stack<Character>();
        rem =0;
        for (int i =s.length()-1; i >=0;i--)
        {
            if (s.charAt(i) ==')')
                st1.push (')');
            
            else if (s.charAt(i) == '*')
                rem +=1;
            else 
            {
                if (st1.size() ==0)
                {
                    if (rem ==0)
                        return false;
                    else
                        rem -=1;
                }
                else
                    st1.pop();
            }   
        }    
          if (!st1.isEmpty() && st1.size() > rem)
            return false; 
    return true;
    }
}

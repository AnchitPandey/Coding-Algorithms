class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        int ind1= 0, ind2 =0;
        Stack<Integer> st = new Stack<Integer>();
        int len1 = pushed.length;
        int len2  = popped.length;
        
        while (ind1 < len1 && ind2 < len2)
        {   
            if (pushed[ind1] != popped[ind2])
            {
                st.push (pushed[ind1]);
                ind1+=1;
            }
            else
            {           
                    ind2+=1;
                    ind1 +=1;
                    while (!st.isEmpty() && st.peek() == popped[ind2] && ind2 < len2)
                    {
                        st.pop();
                        ind2 +=1;
                    }
            }
        }
        if (ind2 < len2)
            return false;
        
        if (ind1 >= len1)
        {
            while (!st.isEmpty() && ind2 < len2 )
            {
                int popper = st.pop();
                if(popper != popped[ind2])
                    return false;
                ind2 +=1;
            }
            if (ind2 < len2 )
                return false;
        }
        return true;
    }
}

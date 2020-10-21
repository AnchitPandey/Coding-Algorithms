class Solution {
    public int[] findPermutation(String s) {
        
        int[] fa = new int[s.length() +1];
        Stack<Integer> st = new Stack<Integer>();
        int j = 0;
        for (int i =0 ; i< s.length();i+=1)
        {
            if (s.charAt(i) =='D')
                st.push (i+1);
            else
            {
                st.push (i+1);
                while (!st.isEmpty())
                    fa[j++] = st.pop();
            }
        }
        st.push (s.length()+1);
        while (!st.isEmpty())
            fa[j++] = st.pop();
        
        return fa;

    }
}

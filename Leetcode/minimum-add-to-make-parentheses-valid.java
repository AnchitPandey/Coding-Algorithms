class Solution {
    public int minAddToMakeValid(String s) {

        int total =0; 
        Stack<Character> st = new Stack<Character> ();
        for (int i =0 ; i< s.length();i+=1)
        {
            if (s.charAt(i) ==')')
            {
                if (st.isEmpty())
                    total+=1;
                else
                    st.pop();
            }
            else 
                st.push ('(');
        }
        
        while (!st.isEmpty())
        {
            total +=1;
            st.pop();
        }
        return total;        
    }
}

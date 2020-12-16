class Solution {
public:
    string removeOuterParentheses(string s) {
        
        vector <int> vec;
        stack<int>  st;
        set <int> setter;
        
        for (int i =0; i< s.length();i+=1)
        {
            if (s[i] == '(')
            {
                if (st.empty())
                {
                    //vec.push_back(i);
                    setter.insert(i);
                }
                else
                    vec.push_back(i);
                st.push(i);
            }
            else
            {
                int indi = st.top();
                st.pop();
                //int indi = st.pop();
                if (setter.find (indi) == setter.end())
                {
                    vec.push_back(i);                   
                }              
            }
        }
        string finalans = "";
        for (int i =0; i <vec.size();i+=1)
            finalans += s[vec[i]];
        return finalans;
    }
};

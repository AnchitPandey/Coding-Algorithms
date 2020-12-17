class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {

        stack<int> st;
        int finalans[T.size()];
        st.push (0);
        for (int i =1 ; i< T.size();i+=1)
        {
            while  (st.size() > 0 && T[i] > T[st.top()])
            {
                int curr = st.top();
                st.pop();
                finalans [curr] = i -curr;                
            }
            st.push(i);
        }
        while (!st.empty())
        {
            int curr = st.top();
            st.pop();
            finalans[curr] = 0;
        }
    vector<int> f;
        for  (int i =0 ; i< T.size();i+=1)
            f.push_back(finalans[i]);
        return f;
    }
};

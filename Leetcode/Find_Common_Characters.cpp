class Solution {
public:
    vector<string> commonChars(vector<string>& A) {
    
        int n = A.size();
        int mat[n][26];
        for (int i =0 ; i< n;i+=1)
        {
            for (int  j =0; j< 26;j++)
                mat[i][j] = 0;
            
        }
        for (int i= 0; i < A.size();i+=1)
        {
            for (int j =0 ; j< A[i].length();j+=1)
            {
                int id = (int)A[i][j] -  97;
                mat[i][id]+=1;
            }           
        }
        vector<string> ans;
        for (int i =0; i< 26;i+=1)
        {
            int mini = INT_MAX;
            for (int j =0 ;j< n;j+=1)
            {
                mini = min (mini, mat[j][i]);
            }
            string putter = "";
            char ch = (char)(i + 97);
            putter += ch;
            while (mini >0)
            {
                ans.push_back(putter);
                mini-=1;
            }
        }
        return ans;
    }
};

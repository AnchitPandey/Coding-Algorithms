class Solution {
public:
    int largestUniqueNumber(vector<int>& A) {
 
        
    int maxi = -1;
    map<int, int> m;
        for (int i =0 ; i< A.size();i+=1)
        {
            m[A[i]]+=1;
        }
        for (const auto &p: m )
        {
            if (p.second == 1)
            {
                maxi = max (p.first, maxi);
            }
        }
        return maxi;
    }
};

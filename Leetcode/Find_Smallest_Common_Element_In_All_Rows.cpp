class Solution {
public:
    int smallestCommonElement(vector<vector<int>>& mat) {

        map<int, int> mapper;
        for (int i =0 ; i< mat.size();i+=1)
        {
            for (int j =0 ; j< mat[0].size();j+=1)
            {
                mapper[mat[i][j]]+=1;
            }
        }
        for (const auto &p: mapper)
        {
            if (p.second == mat.size())
                return p.first;
        }
        return -1;
    }
};

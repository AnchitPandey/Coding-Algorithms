class Solution {
public:
    vector<string> buildArray(vector<int>& target, int n) {

    int index1 =1 ;
        int index2 =0;
        vector <string> vec;
        while (index2 != target.size())
        {
            if (index1 == target[index2])
            {
                vec.push_back("Push");               
                index1+=1;
                index2+=1;
            }
            else
            {
                while (index1 != target[index2])
                {
                    vec.push_back("Push");
                    vec.push_back("Pop");
                    index1+=1;   
                }
            }
        }
        return vec;
    }
};

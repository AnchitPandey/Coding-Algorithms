class Solution {
public:
    int distributeCandies(vector<int>& candyType) {
 
        set<int> s;
        
        for (int i =0 ; i < candyType.size(); i+=1)
            s.insert (candyType[i]);
        int mini = min (s.size(), candyType.size()/2);
        return mini;
    }
};

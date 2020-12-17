class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        
        
    map<char, int> mapper1, mapper2 ;
        for (int i =0 ; i < p.length();i+=1)
            mapper1[p[i]] +=1;
    
    vector<int> ans;
    for (int  i= 0 ; i< p.length();i+=1)
    {
        mapper2[s[i]]+=1;
    }
        bool flag =false;
    if (mapper1.size() == mapper2.size())
    {
        flag= true;
        for (const auto &p: mapper1)
        {
            if (mapper2[p.first] != p.second)
            {
                flag = false;
                break;
            }            
        } 
    }
    if (flag)
        ans.push_back(0);
        
        for (int i =p.length();i < s.length();i+=1)
        {
            mapper2[s[i-p.length()]] -=1;
            if (mapper2[s[i-p.length()]] ==0)
                mapper2.erase (s[i -p.length()]);
            
            mapper2[s[i]]+=1;
            bool flaggi = false;
            
        if (mapper1.size() == mapper2.size())
        {
            flaggi = true;
        for (const auto &p: mapper1)
        {
            if (mapper2[p.first] != p.second)
            {
                flaggi = false;
                break;
            }            
        }
            if (flaggi)
                ans.push_back (i-p.length()+1 );
    }            
        }
        return ans;
    }
};

class Solution {
  
public: 
    bool isVowel (char ch) {
        
        return ch =='a' || ch =='e' || ch =='i' || ch =='o' || ch =='u';
    }
    
public:
    string removeVowels(string s) {
     
        string ans = "";
        for (int i =0; i< s.length();i+=1)
        {
            if (!isVowel (s[i]))
                ans += s[i];
        }
        return ans;
    }
};

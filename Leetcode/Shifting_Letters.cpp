class Solution {
public:
    string shiftingLetters(string S, vector<int>& shifts) {
        long sum =0L ;
        string fa = "";
        for (int i = S.length() -1; i>=0;i-=1)
        {
            char ch = S[i];
            sum += shifts[i];
            sum %= 26;
            int num = (int)ch - (int)'a';
            num += sum;
            num %=26;
            char newc = (char)(num + 'a');
            fa = newc + fa;
        }
        return fa;
    }
};

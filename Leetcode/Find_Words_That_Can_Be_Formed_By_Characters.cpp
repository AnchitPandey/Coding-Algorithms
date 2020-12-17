class Solution {
      
public:
    int countCharacters(vector<string>& words, string chars) {
     
        map<char, int> mapper1;
        for (int i= 0; i< chars.length();i+=1)
            mapper1[chars[i]] +=1;
        
        int total =0  ;
        
        for (int i =0 ; i< words.size();i+=1)
        {
            map<char, int> mapper2;
            bool flag=true;
            for (int j =0 ; j< words[i].length();j++)
            {
                mapper2[words[i][j]] +=1;
            }
            
            for ( const auto &p : mapper2 )
            {
                if (mapper1[p.first] < p.second)
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
            {
                total += words[i].length();
            } 
        }
        return total;
    }
};

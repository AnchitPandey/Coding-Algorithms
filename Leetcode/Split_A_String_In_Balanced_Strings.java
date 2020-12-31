class Solution {
    public int balancedStringSplit(String s) {
        
        int counter =0;
        int answer =0;
        for (int i = 0 ;i< s.length();i+=1)
        {
            if (s.charAt(i) == 'R')
                counter+=1;
            else
                counter -=1;
            if (counter ==0)
                answer+=1;
        }
        return answer;
    }
}

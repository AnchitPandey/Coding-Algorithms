class Solution {
    public int maxVowels(String s, int k) {
        
        int max =0;
        int curr =0;
     
        for (int i = 0 ; i< k;i+=1)
        {
             char ch =  s.charAt(i);
             if (ch =='a' || ch =='e' || ch=='i' || ch=='o' || ch =='u')
                     curr+=1;
     
        }
        max = Integer.max (curr, max);
        for (int i =k; i< s.length();i+=1)
        {
            char ch = s.charAt(i -k);
            if (ch == 'a' || ch =='e' || ch =='i' || ch =='o' || ch =='u')
                curr-=1;
              ch = s.charAt(i);
            if (ch == 'a' || ch =='e' || ch =='i' || ch =='o' || ch =='u')
                 curr+=1;
     
            max = Integer.max (curr, max);
            
        }
        return max;
    }
}

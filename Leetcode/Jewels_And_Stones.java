class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet();
        for (int i =0 ; i < J.length();i+=1)
            set.add (J.charAt(i));
        int total =0;
        for (int i = 0 ;i< S.length();i+=1)
            if (set.contains(S.charAt(i)))
                total+=1;
        return total;
    }
}

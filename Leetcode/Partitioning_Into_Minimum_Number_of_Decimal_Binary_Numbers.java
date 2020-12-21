class Solution {
    
    public int minPartitions(String n) {
        int max = 0;
        for (int i =0; i< n.length();i+=1)
            max = Integer.max (max, Integer.parseInt (String.valueOf(n.charAt(i))));
        return max;
    }
    
}

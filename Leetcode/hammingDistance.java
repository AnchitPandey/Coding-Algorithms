class hammingDistance {
    public int hammingDistance(int x, int y) {
    int t = x^y;
    String str = Integer.toBinaryString (t);
    int counter= 0;
    for (int i =0 ;i< str.length();i+=1)
        if (str.charAt(i) =='1')
            counter+=1;
    
        return counter;
    }
}

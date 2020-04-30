public class numberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int t = n ^ 0;
        int counter=0;
        String str= Integer.toBinaryString (t);
        for (int i =0; i< str.length();i+=1)
        {
            if (str.charAt(i) =='1')
                counter+=1;
        }
        return counter;
    }
}

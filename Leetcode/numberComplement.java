class numberComplement {
    public int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ;i< str.length();i+=1)
        {
            if (str.charAt(i) =='1')
                sb.append ('0');
            else
                sb.append ('1');
        }
        String fa = sb.toString();
        int x = Integer.parseInt(fa, 2);
        return x;
    }
}

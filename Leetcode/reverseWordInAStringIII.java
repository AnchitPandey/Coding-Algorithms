class reverseWordInAStringIII {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
       String[] splitter = s.split("\\s+");
        for (int i =0; i< splitter.length;i+=1)
        {
            for (int j = splitter[i].length()-1;j>=0;j--)
                sb.append (splitter[i].charAt(j));
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}

class Solution {
    public String restoreString(String s, int[] indices) {
     
     char[] array = new char[s.length()];
     for (int i =0 ;i< s.length();i++)
            array[indices[i]] =s.charAt(i);
        
        StringBuilder sb = new StringBuilder ();
        for (int i =0; i< s.length();i+=1)
            sb.append (array[i]);
        return sb.toString();
    } 
}

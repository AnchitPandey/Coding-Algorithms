class test implements Comparator <String>
{
    public int compare (String s1 , String s2)
    {
        String ss1 = s1+ s2;
        String ss2 = s2 +s1;
        if (ss1.compareTo(ss2) >=0)
        return -1;
        else
        return 1;
      }
}
class Solution {
    public String largestNumber(int[] nums) {
        
        if (nums.length ==0)
        return "";
        ArrayList<String> l1 = new ArrayList<String>();
        for (int i =0 ; i< nums.length;i+=1)
            l1.add (String.valueOf(nums[i]));
        Collections.sort (l1, new test());
        StringBuilder sb = new StringBuilder();
        for (int i= 0 ; i< l1.size();i+=1)
        {
            String getter = l1.get(i);
            for (int j =0 ;  j< getter.length();j+=1)
                sb.append (getter.charAt(j));
        } 
        String str =sb.toString();
        if(str.charAt(0) =='0')
        return "0"; 
    return str;
    }
}

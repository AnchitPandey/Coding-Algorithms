class Solution {
    
    public int monotoneIncreasingDigits(int N) {
    
        String input = String.valueOf(N);
        char[] arr = input.toCharArray();
        int index =-1;
        for (int i =0; i < arr.length-1;i+=1)
        {
            if (arr[i] > arr[i+1])
            {
                index = i;
                arr[i] =  (char)( (int)arr[i]-1);
                break;
            }
        }
        if (index !=-1)
        {
            while ( index >0 && arr[index-1] > arr[index])
            {
                arr[index-1] = (char) ((int) arr[index-1] -1);
                index-=1;
            }        
            for(int i = index+1;i< arr.length;i+=1)
                arr[i] = '9';
        }
        
        
        StringBuilder sb = new StringBuilder ();
        for(int i =0; i< arr.length; i+=1)
            sb.append (arr[i]);
        
        return Integer.parseInt (sb.toString());
    } 
}

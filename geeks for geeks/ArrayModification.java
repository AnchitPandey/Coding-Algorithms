import java.io.*;
import java.util.*;


class TestClass {

    public static void main(String args[] ) throws Exception { 

    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt (buff.readLine());
    int[] arr = new int[n];
    String[] input = buff.readLine().split("\\s+");
    for (int i =0;i< n;i+=1)
        arr[i] = Integer.parseInt(input[i]);
    
    long[] left = new long[n];
    long[] right = new long[n];
    left[0] = 0L;
    for (int i =1; i< n;i+=1)
    {
       long curr = left[i-1] + arr[i-1];
        curr /=2;
        left[i] = curr;
    }
    right[n-1] = 0L;
    for (int i=  n-2; i>=0; i-=1)
    {   
        long curr = right[i+1] + arr[i+1];
        curr /=2;
        right[i] = curr;  
    }
    long max = 0;
    for (int i= 0 ; i< n;i+=1)
        max = Long.max (left[i]+ arr[i]+ right[i], max);
    System.out.println(max);
     
    }
}

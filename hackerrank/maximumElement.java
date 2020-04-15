import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class maximumElement {

    public static void main(String[] args)throws Exception {
        
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buff.readLine());
        Stack<int[]> stack=  new Stack<int[]>();
        for (int i =0 ; i< n;i+=1)
        {
            String[] input = buff.readLine().split("\\s+");
            int n1 = Integer.parseInt(input[0]);
            if (n1 ==1)
            {
                int val = Integer.parseInt(input[1]);
                int[] temp = new int[2];
                temp [0] = val;
                if (!stack.isEmpty())
                {
                    int[] curr = stack.peek();
                    if (curr[1] >val)
                        temp [1] = curr[1];
                    else
                        temp[1] = val;
    
             //       temp[1] = Integer.max(curr[1], val);
                }
                else
                    temp[1] = val;
                stack.push (temp);
            }
            else if (n1 ==2)
            stack.pop();

            else
            {
                int[] temp = stack.peek();
                System.out.println(temp[1]);
            }
        }
    }
}

import java.io.*;
import java.util.*;


public class funGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         String[] arr_arr = br.readLine().split(" ");
         int[] arr = new int[n];
         for(int i_arr=0; i_arr<arr_arr.length; i_arr++)
         {
         	arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
         }

         int[] out_ = funGame(arr);
         System.out.print(out_[0]);
         for(int i_out_=1; i_out_<out_.length; i_out_++)
         {
         	System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
    static int[] funGame(int[] arr){
        // Write your code here
        Stack<Integer> sA = new Stack<Integer>();
        Stack<Integer> sB = new Stack<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i =0 ; i< arr.length;i+=1)
        {
            sB.push (arr[i]);
            sA.push (arr[arr.length -i -1]);
        }   
        while (!sA.isEmpty() && !sB.isEmpty())
        {
            if(sA.peek () > sB.peek())
            {
                ans.add (1);
                sB.pop();
            }
            else if (sA.peek () < sB.peek())
            {
                ans.add(2);
                sA.pop();
            }
            else
            {
                ans.add (0);
                sA.pop();
                sB.pop();
            }
        } 
         int[] returnArray = new int[ans.size()];
         for (int i=0 ; i< returnArray.length;i++)
            returnArray[i] = ans.get(i);
         return returnArray;
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class balancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String input){

Stack<Character> st = new Stack<Character>();
int flag = 0;
for (int i = 0; i< input.length();i+=1)
 {
     char str ='a';
     if (input.charAt(i) =='(' || input.charAt(i) =='{' || input.charAt(i) =='[')
     {
         str = input.charAt(i);
        // String str = String.valueOf(input.charAt(i))+" "+ String.valueOf(i);
         st.push(str);
     }
     else if (input.charAt(i) ==')' || input.charAt(i) =='}' || input.charAt(i) ==']')
     {
       
         if (!st.isEmpty())    
          str =  st.pop();
         else
         {
            flag =1;
            break;
         }
         
         if ((str =='[' && input.charAt(i)!=']' ) || (str =='(' && input.charAt(i)!=')' ) || (str =='{' && input.charAt(i)!='}' ))
         {
         
            flag = 1;
            break;
         }        
     }
 }
 if (!st.isEmpty() && flag ==0)
 {
            flag = 1;        
 }

    if (flag ==0)
        return "YES";
    else
       return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

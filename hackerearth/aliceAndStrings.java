import java.io.*;
import java.util.*;

class aliceAndStrings
{
    public static void main (String[] args) throws Exception
    {
        BufferedReader buff=  new BufferedReader(new InputStreamReader(System.in));
        String str1 = buff.readLine();
        String str2 = buff.readLine();

        if (str1.length() != str2.length())
        {
            System.out.println("NO");
            return;
        }

        int counter =0;
        int flag= 0;
        for (int i = str1.length()-1;i>=0;i--)
        {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if (ch1 + counter > ch2)
            {
                flag = 1;
                break;
            }
            counter += ch2 - ch1 - counter;
        }
        if (flag ==1)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}

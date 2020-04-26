import java.io.*;
import java.util.*;

class capicua 
{
    public static void main(String[] args)throws Exception
    {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(buff.readLine());
        for (int test =1; test<=t;test+=1)
        {
            String str = buff.readLine();
            int flag =0;
            for (int i =0;i< str.length()/2;i+=1)
            {
                if (str.charAt(i) != str.charAt(str.length()-i-1))
                    {
                        flag =1;
                        break;
                    }
            }
            if (flag ==1)
            {
                System.out.println("NO");
            }
            else
                System.out.println("YES");

        }

    }
}

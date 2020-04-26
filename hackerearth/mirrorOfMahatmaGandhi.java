import java.io.*;
import java.util.*;



class mirrorOfMahatmaGandhi
{
    public static void main(String[] args)throws Exception
    {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(buff.readLine());
        for (int t =1; t<=test;t+=1)
        {
          int flag = 0;
          String n = buff.readLine();
          for (int i =0 ; i< n.length();i+=1)
          { 
              if (n.charAt(i) !='1' && n.charAt(i) !='0' && n.charAt(i) !='8')
              {
                flag =1;
                break;
              }
          }
          if (flag ==1)
            System.out.println("NO");
          
          else
          {
            int bb = 0;
            for (int i = 0; i< n.length()/2;i+=1)
            {
                if (n.charAt(i) != n.charAt(n.length()-i-1))
                {
                    bb =1;
                    break;
                }
            }
            if (bb ==1)
              System.out.println("NO");
            else
            System.out.println("YES");
          }
        }
    }
}

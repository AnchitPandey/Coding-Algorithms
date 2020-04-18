import java.io.*;
import java.util.*;



class TestClass {

    public static int findParent(int id, int[] parent)
    {
        if (id != parent[id])
            id = findParent(parent[id], parent);
        return parent [id];
    }

    public static void main(String args[] ) throws Exception {
 
        //BufferedReader
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buff.readLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] parent = new int[n];
        for (int i =0  ;i< n;i+=1)
            parent[i] = i;
        
        for (int i =0; i< m;i+=1)
        {
            input= buff.readLine().split("\\s+");
            int u = Integer.parseInt(input[0]) -1;
            int v = Integer.parseInt(input[1]) -1;
            int par1 =findParent(u, parent);
            int par2 = findParent(v, parent);
            if (par1 > par2)
                parent[par2] = par1;
            else if (par1 < par2)
                parent[par1] = par2;
        }
        int q = Integer.parseInt(buff.readLine());
              
        for (int quer=1; quer<=q;quer+=1)
        {
            input = buff.readLine().split("\\s+");
            int u = Integer.parseInt(input[0])-1;
            int v = Integer.parseInt(input[1]) - 1;         
            int par1 =findParent(u, parent);
            int par2 = findParent(v, parent);   
            if (par1 > par2 )
                System.out.println(u+1);
            else if (par1 < par2)
                System.out.println(v+1);
            else
                System.out.println("TIE");
        }
    }
}

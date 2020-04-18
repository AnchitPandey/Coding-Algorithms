import java.io.*;
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
class TestClass {

    public static int findParent(int id , int[] parent)
    {
        if (id != parent[id])
            parent[id] = findParent(parent[id], parent);
        return parent[id];
    }
    
    public static void printParentList(int[] parent)
    {
        for (int i =0; i< parent.length;i+=1)
        System.out.print (parent[i]+" ");

    }

       public static void printRankList(int[] rank)
    {
        for (int i =0; i< rank.length;i+=1)
        System.out.print (rank[i]+" ");

    }

    public static void main(String args[] ) throws Exception {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buff.readLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] parent = new int[n];
        for (int i =0; i< n;i+=1)
            parent[i] = i; 
        int[] rank = new int [n];
        for (int i =0; i< n; i+=1)
            rank[i] = 1;

        for (int i =0 ;i< m;i+=1)
        {
            input =  buff.readLine().split("\\s+");
            int u  =Integer.parseInt(input[0]) -1;
            int v  = Integer.parseInt(input[1]) -1;
            // System.out.println("node a is "+ u);
            // System.out.println("node b is "+ v);
            
            int par1 = findParent(u, parent);
            int par2 = findParent(v,parent);

       //     System.out.println("parent of node a is "+ par1);
         //   System.out.println("parent of node b is "+ par2);
            
            if (par1 != par2)
            {
 //               System.out.println("parents are not the same");
                rank[par1] +=rank[par2]; 
                parent[par2] = par1;
    //            System.out.println("updated parent list is ");
      //          printParentList(parent);
            //     System.out.println();
            //     System.out.println("updated rank list is ");
            //     printRankList(rank);
            //     System.out.println();
             }
        }
// System.out.println("finally, ");
// printParentList(parent);
        for (int i =0; i< n;i+=1)
            System.out.print((rank[findParent(i,parent)]-1)+" ");
    }
}

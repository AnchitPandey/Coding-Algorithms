//Author: Anchit Pandey

import java.io.*;
import java.util.*;

class NewClass1
{
   
   /*
   
  The working is that items can be purchase until the amount which we have currently (denoted by s) is not less than the price of the item.
The cost of next item is decreased by d amount until the final price is m after which there is no change in price (or discount).
 
 Variable Map:
 
 1. p ->Initial price of the first item
 2. d -> Amount to be decreased by
 3. m -> Threshold amount after which there is no discount given
 4. s -> The initial amount that the user has
 5. current_cost -> The cost that holds the consecutive costs of the items after deducting multiples of d
 6. counter -> to count the number of items that can be bought
   
 */
   
   
    public static void main(String[] args)throws Exception {
        
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buff.readLine().split("\\s+");
        int p = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);
        int s = Integer.parseInt(input[3]);
        int counter =0;
        int current_cost = p;
        while (s >=current_cost)
        {
           counter++;
            s-=current_cost;
            if (current_cost -d> m)
            {
                current_cost-=d;
             }
            else
                current_cost = m;
 //s-=current_cost;           
            
        }
        System.out.println(counter);       
        
           }
   
}

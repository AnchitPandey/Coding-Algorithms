// Author : Anchit Pandey a.k.a AP

import java.io.*;
import java.util.*;

class NewClass1
{
    
    public static void main(String[] args)throws Exception {


/*
The problem can be solved in the following manner. An obstacle can lie in the queen's path in only the following ways:

1. The obstacle lies in the same horizontal line: In this case y_obstacle = y_queen and ((x_obstacle > x_queen) or (x_obstacle < x_queen))
(2 cases)

2. The obstacle lies in the same vertical line: In this case x_obstacle = x_queen and ((y_obstacle > y_queen ) or (y_obstacle < y_queen))  (2 cases)
(2 cases)

3. The obstacle lies in y = x line where (x_obstacle > x_queen or x_obstacle < x_queen)
(Again 2 cases)

4. The obstacle lies in y = -x line where (x_obstacle > x_queen or x_obstacle < x_queen)
(2 more cases)


Hence, there are 8 cases in total. For each case, I have found the minimum distance that the queen can move until it collides with the closest 
obstacle in that particular case. 

The sum of all such minimum distance for each of the 8 cases is our required answer.


Variable map:

1. n -> number of chess tiles
2. k -> number of obstacles
3. input -> a string array for input
4. x_queen -> x-coordinate of the queen
5. y_queen -> y-coordinate of the queen
6. x1 -> Variable for storing the x-coordinate of the nearest obstacle on y=x where x_obstacle > x_queen
7. x2 -> Variable for storing the x-coordinate of the nearest obstacle on y=x where x_obstacle < x_queen
8. x3 -> Variable for storing the x-coordinate of the nearest obstacle on y=-x where x_obstacle < x_queen
9. x4 -> Variable for storing the x-coordinate of the nearest obstacle on y=-x where x_obstacle > x_queen
10. x5 -> Variable for storing the x-coordinate of the nearest obstacle on y=y_queen where x_obstacle > x_queen
11. x6 -> Variable for storing the x-coordinate of the nearest obstacle on y=y_queen where x_obstacle < x_queen
12. x7 -> Variable for storing the y-coordinate of the nearest obstacle on x=x_queen  where y_obstacle > y_queen
13. x8 -> Variable for storing the y-coordinate of the nearest obstacle on x=x_queen  where y_obstacle < y_queen
14. pos_plus -> Variable for storing the minimum eucledian distance of the obstacle on y=x line where x_obstacle > x_queen
15. pos_neg   -> Variable for storing the minimum eucledian distance of the obstacle on y=x line where x_obstacle < x_queen
16. neg_plus  -> Variable for storing the minimum eucledian distance of the obstacle on y=-x line where x_obstacle < x_queen
17. neg_neg   -> Variable for storing the minimum eucledian distance of the obstacle on y=-x line where x_obstacle > x_queen
18. min1  -> Variable for storing the minimum eucledian distance of the obstacle on y=y_queen line where x_obstacle > x_queen
19. min2 -> Variable for storing the minimum eucledian distance of the obstacle on y=y_queen line where x_obstacle < x_queen
20. min3 -> Variable for storing the minimum eucledian distance of the obstacle on x=x_queen line where y_obstacle > y_queen
21. min4 -> Variable for storing the minimum eucledian distance of the obstacle on x=x_queen line where y_obstacle < y_queen
22. total -> For storing the total free spaces
*/


        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buff.readLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        input = buff.readLine().split("\\s+");
        int x_queen = Integer.parseInt(input[0]);   // x-coordinate of the queen
        int y_queen = Integer.parseInt(input[1]);   // y-coordinate of the queen
        int x1=0,x2=0,x3=0,x4=0,x5=0,x6=0,x7=0,x8=0,min1=1000000000,min2=1000000000,min3=1000000000,min4=1000000000;
        double  pos_plus=1000000000,pos_neg=1000000000, neg_plus=1000000000,neg_neg=1000000000;
 
 
 
 for (int i=0; i<k;i++)
 {
 input = buff.readLine().split("\\s+");
 int x = Integer.parseInt(input[0]);           // x-coordinate of ith obstacle
 int y = Integer.parseInt(input[1]);           // y-coordinate of ith obstacle
 if ((y - y_queen) == (x-x_queen))             //  checking if obstacle lies in y=x line
 {
 
     double dist =  Math.sqrt(Math.pow(x-x_queen,2) + Math.pow (y-y_queen,2));  // computing euclidean distance between the obstacle and the queen
     if (x > x_queen && dist < pos_plus)      // finding minimum distance where obstacle lies in y=x line and x_obstacle > x_queen 
     {
         pos_plus = dist;
         x1 = x;
     }
     
    if (x < x_queen && dist < pos_neg)      // finding minimum distance where obstacle lies in y=x line and x_obstacle < x_queen
    {
 pos_neg = dist;
 x2 = x;
         }
     
  }
 
else if ((y - y_queen)== (x_queen - x))  // checking if obstacle lies in y=-x line
 {
          double dist =  Math.sqrt(Math.pow(x-x_queen,2) + Math.pow (y-y_queen,2));
if (x < x_queen && dist < neg_plus)    // finding minimum distance where obstacle lies in y=-x line and x_obstacle < x_queen
{
   neg_plus=  dist;
   x3= x;
   }

if (x > x_queen && dist < neg_neg)  // finding minimum distance where obstacle lies in y=-x line and x_obstacle > x_queen
{
    neg_neg = dist;
    x4 =x;
   
}
    
     
 }
 
else if (y == y_queen && x > x_queen && x - x_queen < min1 ) // checking if obstacle lies in same horizintal line and x_obstacle > x_queen
{
    min1 = x-x_queen;
    x5 = x;
    
}
 
else if (y==y_queen && x< x_queen && x_queen - x< min2)  // cheking if obstacle lies in same horizontal line and x_obstacle < x_queen
{
    min2 = x_queen -x;
    x6 = x;
}    
 
else if (x==x_queen && y  > y_queen && y - y_queen < min3) // checking if obstacle lies in same vertical line and y_obstacle > y_queen
{
    min3 = y -y_queen;
x7 =y;
}
else if (x == x_queen && y< y_queen && y_queen-y < min4) // checking if obstacle lies in same vertical line and y_obstacle < y_queen
{
    min4  = y_queen - y;
 x8 =y;
}    
 }
  
  
 // computing free spaces/minimum distances from all 8 possiblities now..
 long total =0;
 if (pos_plus ==1000000000) // if there is no obstacle in y =x line where x > x_queen 
 {
   //  System.out.println("no obstacle on pos_plus");
    if (n -x_queen < n - y_queen)
    total+= n-x_queen;  
        
    
    else 
        total+= n - y_queen;
   }
 else 
 {
     // System.out.println("obstacle on pos_plus");
       
  total+= x1 -x_queen -1;

 }
 if (pos_neg ==1000000000)   // if there is no obstacle on y=x line where x < x_queen
 {
    //  System.out.println("no obstacle on pos_neg");
       
   if (x_queen-1 < y_queen-1)  // I am subtracting 1 because the queen's position has to be excluded from the free spaces counting.
     
       total+=x_queen-1; 
     
   else
       total+=y_queen-1;
   
 }
 else {
//      System.out.println("obstacle on pos_neg");
       
     total += x_queen -x2 -1;
 
 }
if (neg_plus == 1000000000)  // if there is no obstacle on y=-x line where x < x_queen
{
    // System.out.println("no obstacle on neg_plus");
       
    if (x_queen -1 <n - y_queen)
        total +=x_queen-1 ;
    else 
        total+= n -y_queen;
        
}
else
{
    // System.out.println("obstacle on neg_plus");
       
    total+= x_queen -x3 -1;
}
  if (neg_neg==1000000000)  // if there is no obstacle on y=-x line where x > x_queen
    {
      //   System.out.println("no obstacle on neg_neg");
       
     if (n-x_queen < y_queen -1)
         total+= n-x_queen;
     else
         total+= y_queen -1;
        
      }
  else
  {
//       System.out.println("obstacle on neg_neg");
       
      total+= x4 -x_queen -1;
  }
  if (min1 ==1000000000) // if there is no obstacle on y = y_queen line where x > x_queen
  {
   //    System.out.println("no obstacle on x_pos");
       
 total+= n - x_queen;
  } 
 else 
  { 
  //    System.out.println("obstacle on x_pos");
       
      total+= x5 - x_queen-1;
  }
      if (min2 ==1000000000)  // if there is no obstacle on y = y_queen line where x < x_queen
      {
//           System.out.println("no obstacle on x_neg");
       
           total+= x_queen -1;
      }
           else
      {
 //          System.out.println("obstacle on x_neg");
       
           total+= x_queen -x6-1;
       
      }
           if (min3 ==1000000000)  // if there is no obstacle on x = x_queen line where y > y_queen
           {
 //               System.out.println("no obstacle on y_pos");
       
                      total+= n- y_queen;
           }
                      else 
           {
              //  System.out.println("obstacle on y_pos");
       
                      total+= x7 - y_queen-1;
           }
                      if (min4==1000000000)   // if there is no obstacle on x = x_queen line where y < y_queen
                      {
                         //  System.out.println("no obstacle on y_neg");
       
                          total+=y_queen -1 ;
                      }
                          else 
                      {
                         //  System.out.println("obstacle on y_neg");
       
                      total+= y_queen -x8-1;
                      }
   System.out.println(total);
  
    }  
  }

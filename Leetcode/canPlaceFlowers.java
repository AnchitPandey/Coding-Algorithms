class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
       int counter = 0;
       for (int i =0; i< flowerbed.length;i++)
       {      
           int lok = 0;
           int rok  = 0;
           
           if (flowerbed[i] ==0)
           {
               if (i+1 <= flowerbed.length -1)
               {
                   if (flowerbed[i+1] ==0)       
                       rok=1;
                   else
                       rok=-1;
               }
               else
                   rok = 1;

            if (i-1 >=0)
               {
                   if (flowerbed[i-1] ==0)       
                       lok=1;
                   else
                       lok=-1;
               }
               else
                   lok = 1;

             if (lok ==1 && rok == 1)
             {
                i+=1;
                 counter++;
             }
       }
     }
   
        return counter >= n ;
    } 
}

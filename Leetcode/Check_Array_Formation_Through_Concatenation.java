class Solution {

    
    // O (N + m*n)
  public boolean canFormArray(int[] arr, int[][] pieces) {
      HashMap<Integer, Queue<Integer>> mapper =new HashMap<Integer, Queue<Integer>>();
      for (int i =0  ;i< pieces.length;i+=1)
      {
          Queue<Integer> qu = new LinkedList<Integer>();
          for (int j =1; j < pieces[i].length;j+=1)
          {
              qu.add (pieces[i][j]);
          }
          mapper.put (pieces[i][0], qu);
      }
      
      for (int i =0 ;i< arr.length;i+=1) {
            
          if (!mapper.containsKey (arr[i]))
          {
 
                return false;          
          } 
          Queue<Integer> qu = mapper.get(arr[i]); 
     
          mapper.remove (arr[i]);
          while (!qu.isEmpty())
          {
              int newNum = qu.poll();
              i+=1;
              if (arr[i] != newNum)
              {           
                  return false;          
              }
          }    
      }
      return true;
    }
}

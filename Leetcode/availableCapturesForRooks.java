class availableCapturesForRooks {
    public int numRookCaptures(char[][] board) {
     
        int r =-1,c =-1;
      outer:  for (int i=0 ; i< 8; i+=1)
        {
            for (int j =0; j< 8;j+=1)
            {
                if (board[i][j] == 'R')
                {
                    r = i;
                    c = j;
                    break outer;
                }       
            }   
        }
        // up
        int counter =0;
        for (int i = r-1;i>=0;i--)
        {
            if (board[i][c] == 'p')
            {
                counter+=1;
                break;
            }
            else if (board[i][c] != '.')
                break;
        }
        
        // down
        for (int i = r+1; i< 8; i+=1)
        {
            if (board[i][c] == 'p')
            {
                counter+=1;
                break;
            }
            else if (board[i][c] != '.')
                break;
        }
        
        // right
        for (int i = c+1; i< 8; i+=1)
        {
            if (board[r][i] == 'p')
            {
                counter+=1;
                break;
            }
            else if (board[r][i] != '.')
                break;
        }
        
        // left 
          // left
        for (int i = c-1; i>= 0; i-=1)
        {
            if (board[r][i] == 'p')
            {
                counter+=1;
                break;
            }
            else if (board[r][i] != '.')
                break;
        }
    
         return counter;     
    }
}

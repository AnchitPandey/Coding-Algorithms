class Solution {
    public void dfs (char[][] board, int currRow, int currCol, boolean[][] visited)
    {
        int m = board.length;
        int n = board[0].length;
        visited[currRow][currCol] = true;
        int[] dr = {-1,-1,-1,1,1,1,0,0};
        int[] dc = {-1,1,0,-1,1,0,-1,1};
        int counter = 0;
        for (int i = 0; i < 8;i+=1)
        {
            int r = currRow + dr[i];
            int c = currCol + dc[i];
            if (r >=0  && r < m && c>=0 && c< n && !visited[r][c])
            {
                if (board[r][c]  =='X' || board[r][c] =='M')
                    counter+=1;
            }            
        }
        if (counter !=0)
        {
            board[currRow][currCol] = (char)(counter+'0');
            return;
        }
        board[currRow][currCol] = 'B';
        for (int i =0 ; i< 8;i+=1)
        {
            int r = currRow + dr[i];
            int c = currCol + dc[i];
            if(r >=0 && r< m && c>=0 && c< n && !visited[r][c] && board[r][c] =='E') 
                dfs (board, r,c,visited);
        }
    }
    public char[][] updateBoard(char[][] board, int[] click) {
        
            if (board[click[0]][click[1]] == 'M' || board[click[0]][click[1]] =='X')
            {
                board[click[0]][click[1]] = 'X';
                return board;
            }
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            dfs (board, click[0], click[1], visited);
            return board;
        }
    }

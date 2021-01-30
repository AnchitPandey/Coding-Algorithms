class Solution {
    
    public ArrayList<Integer> getExternalCell (int dir, int currRow, int currCol, int m, int n)
    {
        ArrayList<Integer> ls = new ArrayList();
        if (dir ==0)
        {
            if (currRow ==0)
                return ls;
            ls.add (currRow -1); ls.add (currCol); ls.add (2);
            return ls;
        }
        if (dir ==1)
        {
            if (currCol == n-1)
                return ls;
            ls.add (currRow); ls.add (currCol+1); ls.add (3);
            return ls;
        }
        else if (dir ==2)
        {
            if (currRow == m-1)
                return ls;
            ls.add (currRow+1); ls.add (currCol); ls.add (0);
            return ls;
        }
        else
        {
            if (currCol ==0)
                return ls;
            ls.add (currRow); ls.add (currCol-1); ls.add (1);
            return ls;
        }
    }
    
    public ArrayList<Integer> getInternalCells (int dir, char cell)
    {
        ArrayList<Integer> ls = new ArrayList();
        if (cell == '/')
        {
            if (dir == 0)
            {
                ls.add (3);
                return ls;
            }
            else if (dir ==1)
            {
                ls.add (2);
                return ls;
            }
            else if (dir == 2)
            {
                ls.add (1);
                return ls;               
            }
            else 
            {
                ls.add (0);
                return ls;
            }      
        }
        else if (cell == '\\')
        {
            if (dir == 0)
            {
                ls.add (1);
                return ls;
            }
            else if (dir ==1)
            {
                ls.add (0);
                return ls;
            }
            else if (dir == 2)
            {
                ls.add (3);
                return ls;
            }
            else 
            {
                ls.add (2);
                return ls;
            }     
        }
        else 
        {
            for (int i =0; i< 4;i+=1)
            {
                if (i != dir)
                    ls.add (i);
            }
            return ls;
        }        
    }
    public int regionsBySlashes(String[] grid) {
        
        Set<ArrayList> visited = new HashSet();
        int m = grid.length;
        int n = grid[0].length();
        int ans= 0;
        for (int i= 0; i< m;i++)
        {
            for (int j =0; j< n;j+=1)
            {
                for (int dir =0; dir < 4;dir+=1)
                {
                    ArrayList<Integer> ls = new ArrayList();
                    ls.add (i); ls.add (j); ls.add (dir);
                    if (visited.contains(ls))
                        continue;
                    
                  //  System.out.println ("####################");
                  //  System.out.println ("current cell is "+ls);
                    visited.add (ls);
                    ans +=1;
                    Queue<ArrayList<Integer>> qu = new LinkedList();
                    qu.add (ls);
                    while (!qu.isEmpty())
                    {
                        ArrayList<Integer> curr = qu.poll();
                        char currCell = grid[curr.get(0)].charAt(curr.get(1));
                        ArrayList<Integer> internal = getInternalCells (curr.get(2),currCell);
                       // System.out.println("internal cells are "+internal);
                        // check for internal cells
                        for (int t =0; t< internal.size();t+=1)
                        {
                            ArrayList<Integer> childCell = new ArrayList();
                            childCell.add (curr.get(0));
                            childCell.add (curr.get(1));
                            childCell.add (internal.get(t));
                            if (!visited.contains(childCell))
                            {
                                visited.add (childCell);
                                qu.add (childCell);
                            }
                        }
                        ArrayList<Integer> ext = getExternalCell (curr.get(2),curr.get(0),curr.get(1), m, n);
                        //System.out.println("external cells are "+ ext);
                        if (ext.size() !=0 && !visited.contains(ext))
                        {
                            visited.add (ext);
                            qu.add (ext);
                        }
                    }
                }
            }            
        }
        return ans;
    }
}

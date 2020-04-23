class validateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
   
        // HashMap<Integer, Integer> m1 = new HashMap<Integer, Integer>();
        // HashMap<Integer, Integer> m2 = new HashMap<Integer, Integer>();
        HashMap<Integer, Character> m = new HashMap<Integer, Character>();
        for(int i= 0; i< leftChild.length;i+=1)
        {
            if (leftChild[i]!=-1)
            {
                if (!m.containsKey(leftChild[i]))
                     m.put (leftChild[i],'L');
                else
                    return false;
            }
        }
        
        for(int i= 0; i< rightChild.length;i+=1)        
        {
            if (rightChild[i] !=-1)
            {
                if (!m.containsKey(rightChild[i]))
                    m.put (rightChild[i],'R');
                else
                    return false;
            }
        }
        int counter = 0;
        int rootNode =-1;
        for (int  i =0; i<n;i++)
        {
            
        if (!m.containsKey(i))
            {    
                rootNode = i;
                counter+=1;
           //     break;
            }           
        }
        
        if (counter !=1)
            return false;
         
        
        // perform bfs
        Queue<Integer> qu = new LinkedList<Integer>();
        qu.add(rootNode);
        HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>();
        visited.put(rootNode,1);
        while(!qu.isEmpty())
        {
            int root =qu.poll();
            if (leftChild[root] != -1 && !visited.containsKey(leftChild[root]))
            {
                visited.put (leftChild[root],1);
                qu.add(leftChild[root]);
                
            }
            
            if (rightChild[root] != -1 && !visited.containsKey(rightChild[root]))
            {
                visited.put (rightChild[root],1);
                qu.add(rightChild[root]);    
            }
        }
        if (visited.size() != n)
            return false;
        return true;        
    }
}

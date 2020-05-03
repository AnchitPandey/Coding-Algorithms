/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class verticalOrderTraversalOfABinaryTree {

  
     static class ttt implements Comparator <TreeNode>{
         
        public int compare(TreeNode o1, TreeNode o2)
        {
            if (depthMapper.get(o1) < depthMapper.get(o2))
                return -1;
            else if (depthMapper.get(o1) > depthMapper.get(o2))
                return 1;
            
            return o1.val - o2.val;
        }       
    }
 
    static HashMap<TreeNode, Integer> depthMapper;
        
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
        {
            List<List<Integer>> ll = new ArrayList<List<Integer>>();
            return ll;
        }
        
        TreeMap<Integer, List<TreeNode>> mapper = new TreeMap<Integer, List<TreeNode>>();
        HashMap<TreeNode, Integer> nodeX  = new HashMap<TreeNode, Integer>();
        depthMapper = new HashMap<TreeNode, Integer>();
        nodeX.put (root, 0);
        List<TreeNode> putter = new ArrayList<TreeNode>();
        putter.add (root);
        mapper.put (0, putter);
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add (root);
        depthMapper.put (root,0);       
        while (!qu.isEmpty())
        {
            TreeNode parentNode = qu.poll();
            if (parentNode.left != null)
            {
                nodeX.put (parentNode.left, nodeX.get(parentNode)-1);
                //System.out.println(parentNode.left +" "+ depthMapper.get(parentNode));
                depthMapper.put (parentNode.left, depthMapper.get(parentNode)+1);
                if (!mapper.containsKey(nodeX.get(parentNode.left)))
                {
                    List<TreeNode> put = new ArrayList<TreeNode>();
                    put.add (parentNode.left);
                    mapper.put (nodeX.get(parentNode.left), put);
                }
                else
                {
                    List<TreeNode> gets = mapper.get(nodeX.get(parentNode.left));
                    gets.add (parentNode.left);                    
                }
                qu.add (parentNode.left);
            }
            
            if (parentNode.right != null)
            {
                nodeX.put (parentNode.right, nodeX.get(parentNode)+1);
                depthMapper.put (parentNode.right, depthMapper.get(parentNode)+1);
                if (!mapper.containsKey(nodeX.get(parentNode.right)))
                {
                    List<TreeNode> put = new ArrayList<TreeNode>();
                    put.add (parentNode.right);
                    mapper.put (nodeX.get(parentNode.right), put);
                }
                else
                {
                    List<TreeNode> gets = mapper.get(nodeX.get(parentNode.right));
                    gets.add (parentNode.right);                    
                }
                 qu.add (parentNode.right);
            }
        }
        
        List<List<TreeNode>> lister=  new ArrayList<List<TreeNode>>(mapper.values());
        for (int i = 0 ;i< lister.size();i+=1)
        {
           Collections.sort (lister.get(i), new ttt());
        }   
        
        List<List<Integer>> newLister=  new ArrayList<List<Integer>>(); 
        for (int i =0; i< lister.size();i+=1)
        {
        List<Integer>  naya = new ArrayList<Integer>();
            for (int j =0; j< lister.get(i).size();j+=1)
            {
                naya.add (lister.get(i).get(j).val);                
            }
            newLister.add (naya);
        }
        
        ArrayList<TreeNode> ddd = new ArrayList<TreeNode>(depthMapper.keySet());
        // for(int i =0  ; i< ddd.size();i+=1)
        //     System.out.println(ddd.get(i).val +":"+depthMapper.get(ddd.get(i)));
        
         return newLister;   
    }
}

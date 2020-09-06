class GfG{
    
    public static Tree cloneTree(Tree tree){
        
    HashMap<Tree,Tree> mapper = new HashMap<Tree,Tree>();
    Tree duproot = new Tree(tree.data);
    mapper.put (tree,duproot);
    Queue<Tree> orig = new LinkedList<Tree>();
    Queue<Tree> newone = new LinkedList<Tree>();
    orig.add (tree);
    newone.add (duproot);
    
    while (!orig.isEmpty())
    {
        Tree curr = orig.poll();
        Tree dupcurr = newone.poll();
        if (curr.left != null)
        {
            Tree dupleft  = new Tree (curr.left.data);
            mapper.put (curr.left, dupleft);
            dupcurr.left = dupleft;
            orig.add (curr.left);
            newone.add (dupleft);
        }
        if (curr.right != null)
        {
            Tree dupright  = new Tree (curr.right.data);
            mapper.put (curr.right, dupright);
            dupcurr.right = dupright;
            orig.add (curr.right);
            newone.add (dupright);
        }
    }
    // random ptrs
    orig.add(tree);
    newone.add (duproot);
    while (!orig.isEmpty())
    {
        Tree curr=  orig.poll();
        Tree dupcurr = newone.poll();
        Tree getter = mapper.get(curr.random);
        dupcurr.random = getter;
        if (curr.left != null)
        {
            orig.add (curr.left);
            newone.add (dupcurr.left);            
        }
        if (curr.right != null)
        {
            orig.add (curr.right);
            newone.add (dupcurr.right);            
        }
    }
    
    return duproot;
    
     }
}

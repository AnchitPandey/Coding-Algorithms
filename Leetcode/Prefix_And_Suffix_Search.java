class Trie{
    
    char ch;
    HashMap<Character, Trie> children;
    int val;
    Trie (char ch)
    {
        this.ch = ch;
        this.children = new HashMap();
    }
}
class MapSum {

    /** Initialize your data structure here. */
    HashMap<String, Integer> mapper;
    Trie root;
    public MapSum() {
        mapper = new HashMap();
        root = new Trie ('$');
    }
    public void traverseTrie (Trie curr, String key, int index, int val)
    {
        if (index == key.length())
            return;
        char currentCharacter = key.charAt(index);
        if (!curr.children.containsKey (currentCharacter))
        {
            Trie child = new Trie (currentCharacter);
            curr.children.put (currentCharacter, child);
        }
        Trie child = curr.children.get(currentCharacter);
        if (mapper.containsKey (key))
            child.val -= mapper.get(key);    
        child.val += val;
        traverseTrie(child, key, index+1, val);
        
    }
    public void insert(String key, int val) {
        traverseTrie (root,key, 0, val);
        mapper.put (key,val);
    }
    
    public int returnSumTraverse (Trie curr, String prefix, int index)
    {
        if (index == prefix.length())
        {
            if (curr==null)
                return 0;
            return curr.val;
        }
        char currentCharacter = prefix.charAt(index);
        if (!curr.children.containsKey (currentCharacter))
            return 0;
        Trie child = curr.children.get(currentCharacter);
        return returnSumTraverse(child, prefix, index+1);
    }
    
    public int sum(String prefix) {
       return returnSumTraverse (root,prefix, 0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

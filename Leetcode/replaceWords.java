class trie
{
    char value;
    HashMap<Character, trie> children;
   public  trie (char value)
    {
        this.value = value;
        children = new HashMap<Character, trie>();
    }
    
}




class replaceWords {
    
    public void makeTrie(String word, trie curr, int index)
    {
        if (index == word.length())
        {
            trie lastnode = new trie ('$');
            curr.children.put ('$', lastnode);
            return;
        }
        
        if (curr.children.containsKey(word.charAt(index)))
            makeTrie (word, curr.children.get(word.charAt(index)), index+1);
        
        else
        {
            trie child = new trie (word.charAt(index));
                curr.children.put (word.charAt(index), child);
            makeTrie (word, child, index+1);
        }          
    }
    public String replaceWithRoot (trie curr, String word, int index, StringBuilder sb)
    {
        if (curr.children.containsKey('$'))
            return sb.toString();
        if (index == word.length())
        {
            if(curr.children.containsKey('$'))
                return sb.toString();
            else
                return "";
        }
        if (curr.children.containsKey(word.charAt(index)))
        {
            sb.append (word.charAt(index));
            return replaceWithRoot (curr.children.get(word.charAt(index)), word, index+1, sb);        
        }
        
        else
            return "";
    }
    
    public String replaceWords(List<String> dict, String sentence) {
      
        trie root = new trie ('#');

        for (int i =0; i < dict.size();i+=1)
            makeTrie (dict.get(i), root,0);   
        
        HashMap<String, String> mapper = new HashMap<String,String>();
        String[] words = sentence.split("\\s+");
        for (int  i=0; i< words.length;i+=1)
        {
            StringBuilder sb = new StringBuilder();
           String replacer =  replaceWithRoot(root, words[i], 0, sb); 
            if (replacer.equals ("") == false)
                mapper.put (words[i], replacer);                
        }
        String fa = "";
        for (int i =0 ; i < words.length;i+=1)
        {
            if (mapper.containsKey(words[i]))
                fa += mapper.get(words[i]);
            else
                fa += words[i];
            if (i != words.length-1)
                fa += " ";
        }
            return fa;
    }
}

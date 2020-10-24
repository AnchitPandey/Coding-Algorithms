class MagicDictionary {

    /** Initialize your data structure here. */
    HashMap<String, Integer> mapper;
    char[] ref;  
    public MagicDictionary() {
        mapper = new HashMap<String, Integer>();
        ref = new char[26];
        for (int i =0 ; i< 26;i+=1)
            ref[i] = (char)(97 + i);
        
     
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        
        int len = dict.length;
        for (int i= 0 ;i<len;i+=1)
            mapper.put (dict[i],1);
        
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    
    
    public boolean search(String word) {
    
    //System.out.println("########################");        
    //System.out.println("start word is "+ word); 
    //String z ="";
        int flag = 0;
        if (mapper.containsKey (word))
       {
            flag =1;
            mapper.remove (word);            
        }
    char[] arr = word.toCharArray();

    for (int i = 0 ;i< arr.length;i+=1)
    {  
        char t= arr[i];
        for (int j =0; j< 26;j+=1) 
        {    
            arr[i] = ref [j];
            String d = new String (arr);
//            String d = arr[i].toString();
    //        System.out.println(d);
            if (mapper.containsKey (d))
            {
                if (flag==1)
                    mapper.put (word,1);
                return true;
            }
            arr[i] = t;
        }        
    }
        if (flag ==1)
            mapper.put (word,1);
        return false;
    }   
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */

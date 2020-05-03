class ransomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mapper = new HashMap<Character,Integer>();
        for (int i = 0; i< magazine.length();i+=1)
            mapper.put (magazine.charAt(i), mapper.getOrDefault(magazine.charAt(i),0)+1);
     
        for (int i =0 ;i< ransomNote.length();i+=1)
        {
            if (!mapper.containsKey(ransomNote.charAt(i)))
                return false;      
            else
            {
                mapper.put (ransomNote.charAt(i), mapper.get(ransomNote.charAt(i)) -1);
                if (mapper.get(ransomNote.charAt(i)) ==0)
                    mapper.remove(ransomNote.charAt(i));
            }
        }
        return true;
    }
}

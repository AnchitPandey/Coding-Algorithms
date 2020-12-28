public class Codec {

    String letters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> mapper;
    Random rand;
    
    Codec () {
        mapper= new HashMap<String,String>();
        rand = new Random();
    }
    
    public String getRand () {
            
        StringBuilder sb = new StringBuilder ();
        for (int i =0  ;i< 6;i+=1)
            sb.append (letters.charAt(rand.nextInt(62)));    
        return sb.toString();
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
       String key = getRand();
       while (mapper.containsKey (key))
           key = getRand();
       
        mapper.put (key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return mapper.get(shortUrl);        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

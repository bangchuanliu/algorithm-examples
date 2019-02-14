package tag.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeandDecodeTinyURL {
    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random random = new Random();
    Map<String,String> maps = new HashMap<>();
    
    public String getRanStr() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str += chars.charAt(random.nextInt(62));
        }
        
        return str;
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String str = getRanStr();
        while (maps.containsKey(str)) {
            str = getRanStr();
        }
        
        maps.put(str, longUrl);
        return "http://tinyurl.com/" + str;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String longUrl = maps.get(shortUrl.replace("http://tinyurl.com/", ""));
        return longUrl;
    }
    
    public static void main(String[] args) {
        EncodeandDecodeTinyURL instance = new EncodeandDecodeTinyURL();
        String str = instance.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(str);
        System.out.println(instance.decode(str));
    }
}

/**
 * Functionality
 * This class uses base64 to do the encoding of longUrls.
 * We generate UUID for every Url and put that id and original url into our Database(db).
 * Then we generate a key corresponding to our id and generate encoded url.
 * When we need to decode the Url, we decode the key using base64 and generate the id.
 * Then we look for that id into our Database and retrieve the original Url.
 *
 * Requirements
 * Given a URL, our service should generate a shorter and unique alias of it.
 * When users access a short link, our service should redirect them to the original link.
 *
 * Limitations
 * Because we are storing all urls into db, for large number of requests it would affect our storage.
 * We need to consider the expiration time so that unused url and create space for new requests.
 * nextInt() provides limited scope(bound has been kept) and we might need to consider a better hashing algorithm,
 * as this algorithm is prone to hacking.
 *
*/

import java.util.*;

public class Que04 {
    private static final String BASE = "https://shorturl.com/";
    private static final String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_=";
    private static char[] b64;
    private static Map<Character, Integer> b64toIndex = new HashMap<Character, Integer>();

    private Map<Integer, String> db = new HashMap<Integer, String>();
    private int id = 0;

    static {
        b64 = CHARS.toCharArray();
        int j = 0;
        for (char c: b64) b64toIndex.put(c, j++);
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int id = nextId();
        db.put(id, longUrl);
        String key = toB64(id);
        return BASE + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.replace(BASE, "");
        int id = toB10(key);
        return db.get(id);
    }

    private String toB64(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(b64[num % 64]);
        num /= 64;
        while (num > 0) {
            sb.append(b64[num % 64]);
            num /= 64;
        }
        return sb.reverse().toString();
    }

    private int toB10(String slug) {
        int res = 0;
        for (char c: slug.toCharArray()) {
            res = res * 64 + b64toIndex.get(c);
        }
        return res;
    }

    private synchronized int nextId() {
        id = id + 1 + new Random().nextInt(10000);
        return id;
    }
}
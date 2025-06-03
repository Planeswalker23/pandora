package io.walkers.planes.pandora.jdk;

/**
 * @author 范逸东(东稚)
 */
import java.util.HashMap;
import java.util.Map;

public class ShortUrlGenerator {

    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int BASE = ALPHABET.length();
    private static final String HOST = "http://short.example.com/";
    private static final Long MAX_ID = 100000L;

    private Long id = 0L;
    private Map<Long, String> urlMap = new HashMap<>();

    public String getShortUrl(String originalUrl) {
        Long key = id % MAX_ID;
        String shortUrl = convertKeyToShortUrl(key);

        urlMap.put(id, originalUrl);
        id++;

        return HOST + shortUrl;
    }

    private String convertKeyToShortUrl(Long key) {
        StringBuilder sb = new StringBuilder();
        do {
            int index = (int) (key % BASE);
            sb.append(ALPHABET.charAt(index));
            key /= BASE;
        } while (key > 0);

        return sb.toString();
    }

    public String getOriginalUrl(String shortUrl) {
        String key = shortUrl.replace(HOST, "");
        Long id = convertShortUrlToKey(key);
        return urlMap.get(id);
    }

    private Long convertShortUrlToKey(String shortUrl) {
        Long key = 0L;
        for (int i = 0; i < shortUrl.length(); i++) {
            char c = shortUrl.charAt(i);
            int index = ALPHABET.indexOf(c);
            if (index < 0) {
                throw new IllegalArgumentException("Invalid character in URL");
            }
            key = key * BASE + index;
        }

        return key;
    }

    private static final String BASE62_CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String encode(long num) {
        StringBuilder sb = new StringBuilder();
        do {
            int remainder = (int) (num % 62);
            sb.insert(0, BASE62_CHARACTERS.charAt(remainder));
            num /= 62;
        } while (num != 0);
        return sb.toString();
    }

    public static void main(String[] args) {
        String url = "https://www.baidu.com";

        ShortUrlGenerator generator = new ShortUrlGenerator();
        System.out.println(generator.getShortUrl(url));
        System.out.println(generator.encode(580086598));
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * DNSCacheSystem
 *
 * Simulates a DNS caching system with TTL.
 *
 * Features:
 * - Domain → IP mapping
 * - TTL expiration
 * - Cache hit/miss tracking
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class DNSCacheSystem {

    private HashMap<String, DNSEntry> cache;

    private int cacheHits;
    private int cacheMisses;

    public DNSCacheSystem() {
        cache = new HashMap<>();
        cacheHits = 0;
        cacheMisses = 0;
    }

    /**
     * Resolve domain
     */
    public String resolve(String domain) {

        DNSEntry entry = cache.get(domain);

        if (entry != null && !entry.isExpired()) {

            cacheHits++;

            System.out.println("Cache HIT for " + domain);

            return entry.ipAddress;

        } else {

            cacheMisses++;

            System.out.println("Cache MISS for " + domain);

            String ip = queryUpstreamDNS(domain);

            DNSEntry newEntry = new DNSEntry(domain, ip, 10);

            cache.put(domain, newEntry);

            return ip;
        }
    }

    /**
     * Simulate upstream DNS query
     */
    private String queryUpstreamDNS(String domain) {

        Random rand = new Random();

        return "172.217." + rand.nextInt(255) + "." + rand.nextInt(255);
    }

    /**
     * Display cache statistics
     */
    public void getCacheStats() {

        int total = cacheHits + cacheMisses;

        double hitRate = total == 0 ? 0 : ((double) cacheHits / total) * 100;

        System.out.println("\n===== Cache Statistics =====");
        System.out.println("Cache Hits: " + cacheHits);
        System.out.println("Cache Misses: " + cacheMisses);
        System.out.println("Hit Rate: " + hitRate + "%");
    }

    /**
     * Main method demo
     */
    public static void main(String[] args) throws InterruptedException {

        DNSCacheSystem dns = new DNSCacheSystem();

        System.out.println("Resolving google.com → " + dns.resolve("google.com"));

        System.out.println("Resolving google.com → " + dns.resolve("google.com"));

        System.out.println("Resolving openai.com → " + dns.resolve("openai.com"));

        Thread.sleep(11000); // simulate TTL expiration

        System.out.println("Resolving google.com → " + dns.resolve("google.com"));

        dns.getCacheStats();
    }
}
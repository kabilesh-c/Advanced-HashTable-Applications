/**
 * DNSEntry
 *
 * Represents a cached DNS record.
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class DNSEntry {

    String domain;
    String ipAddress;
    long timestamp;
    long expiryTime;

    public DNSEntry(String domain, String ipAddress, long ttlSeconds) {

        this.domain = domain;
        this.ipAddress = ipAddress;

        this.timestamp = System.currentTimeMillis();

        this.expiryTime = timestamp + (ttlSeconds * 1000);
    }

    /**
     * Check if cache entry expired
     */
    public boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}
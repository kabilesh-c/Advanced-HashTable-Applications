import java.util.HashMap;

/**
 * APIRateLimiter
 *
 * Implements a distributed API rate limiter using Token Bucket algorithm.
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class APIRateLimiter {

    // clientId -> token bucket
    private HashMap<String, TokenBucket> clientBuckets;

    private final int MAX_REQUESTS = 1000;

    private final int REFILL_RATE = 1000; // tokens per hour equivalent

    public APIRateLimiter() {
        clientBuckets = new HashMap<>();
    }

    /**
     * Check if request allowed
     */
    public boolean checkRateLimit(String clientId) {

        clientBuckets.putIfAbsent(
                clientId,
                new TokenBucket(MAX_REQUESTS, REFILL_RATE)
        );

        TokenBucket bucket = clientBuckets.get(clientId);

        return bucket.allowRequest();
    }

    /**
     * Get status
     */
    public void getRateLimitStatus(String clientId) {

        TokenBucket bucket = clientBuckets.get(clientId);

        if (bucket == null) {
            System.out.println("Client not registered");
            return;
        }

        System.out.println(
                "Remaining requests: " + bucket.getRemainingTokens()
        );
    }

    /**
     * Demo
     */
    public static void main(String[] args) {

        APIRateLimiter limiter = new APIRateLimiter();

        String client = "client_ABC123";

        for (int i = 1; i <= 5; i++) {

            boolean allowed = limiter.checkRateLimit(client);

            if (allowed) {
                System.out.println("Request " + i + " → Allowed");
            } else {
                System.out.println("Request " + i + " → Rate limit exceeded");
            }
        }

        limiter.getRateLimitStatus(client);
    }
}
/**
 * TokenBucket
 *
 * Represents a token bucket for rate limiting.
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class TokenBucket {

    private int tokens;
    private final int maxTokens;
    private final int refillRate;
    private long lastRefillTime;

    public TokenBucket(int maxTokens, int refillRate) {
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        this.tokens = maxTokens;
        this.lastRefillTime = System.currentTimeMillis();
    }

    /**
     * Refill tokens based on elapsed time
     */
    private void refill() {

        long now = System.currentTimeMillis();

        long elapsedTime = now - lastRefillTime;

        int tokensToAdd = (int) (elapsedTime / 1000) * refillRate;

        if (tokensToAdd > 0) {

            tokens = Math.min(maxTokens, tokens + tokensToAdd);

            lastRefillTime = now;
        }
    }

    /**
     * Try to consume token
     */
    public synchronized boolean allowRequest() {

        refill();

        if (tokens > 0) {
            tokens--;
            return true;
        }

        return false;
    }

    public int getRemainingTokens() {
        return tokens;
    }
}
import java.util.*;

/**
 * MultiLevelCache
 *
 * Implements a multi-level caching system similar to Netflix CDN architecture.
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class MultiLevelCache {

    // L1 Cache (fastest)
    private LinkedHashMap<String, VideoData> L1;

    // L2 Cache
    private HashMap<String, VideoData> L2;

    // L3 Database simulation
    private HashMap<String, VideoData> database;

    private int L1_CAPACITY = 3;

    public MultiLevelCache() {

        L1 = new LinkedHashMap<>(L1_CAPACITY, 0.75f, true);

        L2 = new HashMap<>();

        database = new HashMap<>();

        // Preload database
        database.put("v1", new VideoData("v1", "Java Tutorial"));
        database.put("v2", new VideoData("v2", "System Design"));
        database.put("v3", new VideoData("v3", "Data Structures"));
        database.put("v4", new VideoData("v4", "Spring Boot Guide"));
    }

    /**
     * Get video from cache hierarchy
     */
    public VideoData getVideo(String videoId) {

        // L1 cache
        if (L1.containsKey(videoId)) {

            System.out.println("L1 Cache HIT");

            return L1.get(videoId);
        }

        // L2 cache
        if (L2.containsKey(videoId)) {

            System.out.println("L2 Cache HIT → Promoting to L1");

            VideoData video = L2.get(videoId);

            addToL1(videoId, video);

            return video;
        }

        // Database
        if (database.containsKey(videoId)) {

            System.out.println("Database HIT → Adding to L2");

            VideoData video = database.get(videoId);

            L2.put(videoId, video);

            return video;
        }

        System.out.println("Video not found");

        return null;
    }

    /**
     * Add to L1 with LRU eviction
     */
    private void addToL1(String videoId, VideoData video) {

        if (L1.size() >= L1_CAPACITY) {

            String oldest = L1.keySet().iterator().next();

            L1.remove(oldest);

            System.out.println("L1 Eviction → " + oldest);
        }

        L1.put(videoId, video);
    }

    /**
     * Statistics
     */
    public void showStats() {

        System.out.println("L1 Cache Size: " + L1.size());

        System.out.println("L2 Cache Size: " + L2.size());
    }

    /**
     * Demo
     */
    public static void main(String[] args) {

        MultiLevelCache cache = new MultiLevelCache();

        cache.getVideo("v1");
        cache.getVideo("v2");
        cache.getVideo("v3");

        cache.getVideo("v1"); // should hit L2 or L1

        cache.getVideo("v4");

        cache.showStats();
    }
}
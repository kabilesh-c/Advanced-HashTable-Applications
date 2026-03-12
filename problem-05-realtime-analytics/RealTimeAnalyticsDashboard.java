import java.util.*;

/**
 * RealTimeAnalyticsDashboard
 *
 * Processes website traffic events in real time.
 *
 * Features:
 * - Page visit counting
 * - Unique visitor tracking
 * - Traffic source analysis
 * - Top pages ranking
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class RealTimeAnalyticsDashboard {

    // pageUrl -> visit count
    private HashMap<String, Integer> pageViews;

    // pageUrl -> unique visitors
    private HashMap<String, Set<String>> uniqueVisitors;

    // source -> traffic count
    private HashMap<String, Integer> trafficSources;

    public RealTimeAnalyticsDashboard() {

        pageViews = new HashMap<>();
        uniqueVisitors = new HashMap<>();
        trafficSources = new HashMap<>();
    }

    /**
     * Process page view event
     */
    public void processEvent(PageViewEvent event) {

        // Update page views
        pageViews.put(
                event.url,
                pageViews.getOrDefault(event.url, 0) + 1
        );

        // Track unique visitors
        uniqueVisitors
                .computeIfAbsent(event.url, k -> new HashSet<>())
                .add(event.userId);

        // Track traffic source
        trafficSources.put(
                event.source,
                trafficSources.getOrDefault(event.source, 0) + 1
        );
    }

    /**
     * Get Top N pages
     */
    public void displayTopPages(int n) {

        List<Map.Entry<String, Integer>> pages =
                new ArrayList<>(pageViews.entrySet());

        pages.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("\nTop Pages:");

        for (int i = 0; i < Math.min(n, pages.size()); i++) {

            String url = pages.get(i).getKey();
            int views = pages.get(i).getValue();
            int unique = uniqueVisitors.get(url).size();

            System.out.println(
                    (i + 1) + ". " + url +
                            " - " + views + " views (" +
                            unique + " unique)"
            );
        }
    }

    /**
     * Display traffic sources
     */
    public void displayTrafficSources() {

        System.out.println("\nTraffic Sources:");

        int total = trafficSources.values().stream().mapToInt(i -> i).sum();

        for (Map.Entry<String, Integer> entry : trafficSources.entrySet()) {

            double percent =
                    (entry.getValue() * 100.0) / total;

            System.out.println(
                    entry.getKey() + ": " +
                            String.format("%.2f", percent) + "%"
            );
        }
    }

    /**
     * Demo main
     */
    public static void main(String[] args) {

        RealTimeAnalyticsDashboard analytics =
                new RealTimeAnalyticsDashboard();

        analytics.processEvent(new PageViewEvent(
                "/article/breaking-news", "user_1", "google"));

        analytics.processEvent(new PageViewEvent(
                "/article/breaking-news", "user_2", "facebook"));

        analytics.processEvent(new PageViewEvent(
                "/sports/championship", "user_3", "google"));

        analytics.processEvent(new PageViewEvent(
                "/sports/championship", "user_4", "direct"));

        analytics.processEvent(new PageViewEvent(
                "/sports/championship", "user_3", "google"));

        analytics.displayTopPages(10);

        analytics.displayTrafficSources();
    }
}
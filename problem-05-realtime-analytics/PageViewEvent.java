/**
 * PageViewEvent
 *
 * Represents a single website visit event.
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class PageViewEvent {

    String url;
    String userId;
    String source;

    public PageViewEvent(String url, String userId, String source) {
        this.url = url;
        this.userId = userId;
        this.source = source;
    }
}
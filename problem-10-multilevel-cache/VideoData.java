/**
 * VideoData
 *
 * Represents a video stored in the cache system.
 *
 * Author: Kabilesh C
 * Email: kabileshc.dev@gmail.com
 */

public class VideoData {

    String videoId;
    String title;

    public VideoData(String videoId, String title) {
        this.videoId = videoId;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Video{id='" + videoId + "', title='" + title + "'}";
    }
}
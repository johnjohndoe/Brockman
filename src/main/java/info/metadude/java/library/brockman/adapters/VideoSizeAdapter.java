package info.metadude.java.library.brockman.adapters;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;
import info.metadude.java.library.brockman.models.VideoSize;

import java.util.Arrays;

public class VideoSizeAdapter {

    @ToJson
    public int[] toJson(VideoSize videoSize) {
        if (videoSize == null) {
            throw new NullPointerException("Expected video size not to be null.");
        }
        return new int[]{videoSize.width, videoSize.height};
    }

    @FromJson
    public VideoSize fromJson(int[] dimensions) throws Exception {
        if (dimensions == null) {
            throw new NullPointerException("Expected dimensions not to be null.");
        }
        if (dimensions.length != 2) {
            throw new Exception("Expected 2 elements but was " + Arrays.toString(dimensions));
        }
        int width = dimensions[0];
        int height = dimensions[1];
        return new VideoSize(width, height);
    }

}

package info.metadude.java.library.brockman.models;

import java.util.Objects;

public class VideoSize {

    public final int height;

    public final int width;

    public VideoSize(int width, int height) {
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        VideoSize videoSize = (VideoSize) other;
        return height == videoSize.height && width == videoSize.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }

    @Override
    public String toString() {
        return "VideoSize{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

}
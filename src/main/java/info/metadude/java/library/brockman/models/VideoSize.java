package info.metadude.java.library.brockman.models;

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
        int result = height;
        result = 31 * result + width;
        return result;
    }

    @Override
    public String toString() {
        return "VideoSize{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

}

package info.metadude.java.library.brockman.models;

public class Stream {

    public final String display;

    public final boolean isTranslated;

    public final String slug;

    public final String type;

    public final VideoSize videoSize;

    public final Urls urls;

    public Stream(String display,
                  boolean isTranslated,
                  String slug,
                  String type,
                  VideoSize videoSize,
                  Urls urls) {
        this.display = display;
        this.isTranslated = isTranslated;
        this.slug = slug;
        this.type = type;
        this.videoSize = videoSize;
        this.urls = urls;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Stream stream = (Stream) other;
        return isTranslated == stream.isTranslated &&
                !(display != null ? !display.equals(stream.display) : stream.display != null) &&
                !(slug != null ? !slug.equals(stream.slug) : stream.slug != null) &&
                !(type != null ? !type.equals(stream.type) : stream.type != null) &&
                !(videoSize != null ? !videoSize.equals(stream.videoSize) : stream.videoSize != null) &&
                !(urls != null ? !urls.equals(stream.urls) : stream.urls != null);
    }

    @Override
    public int hashCode() {
        int result = display != null ? display.hashCode() : 0;
        result = 31 * result + (isTranslated ? 1 : 0);
        result = 31 * result + (slug != null ? slug.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (videoSize != null ? videoSize.hashCode() : 0);
        result = 31 * result + (urls != null ? urls.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Stream{" +
                "display='" + display + '\'' +
                ", isTranslated=" + isTranslated +
                ", slug='" + slug + '\'' +
                ", type='" + type + '\'' +
                ", videoSize=" + videoSize +
                ", urls=" + urls +
                '}';
    }

}

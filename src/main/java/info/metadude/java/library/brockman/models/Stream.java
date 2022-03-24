
package info.metadude.java.library.brockman.models;

import java.util.List;
import java.util.Objects;

public class Stream {

    public enum TYPE {
        AUDIO("audio"),
        MUSIC("music"),
        SLIDES("slides"),
        VIDEO("video"),
        UNKNOWN("Unknown stream type");

        private final String text;

        TYPE(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }

    }

    public final String display;

    public final boolean isTranslated;

    public final String slug;

    public final TYPE type;

    public final VideoSize videoSize;

    public final List<Url> urls;

    public Stream(String display,
                  boolean isTranslated,
                  String slug,
                  TYPE type,
                  VideoSize videoSize,
                  List<Url> urls) {
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
                Objects.equals(display, stream.display) &&
                Objects.equals(slug, stream.slug) &&
                type == stream.type &&
                Objects.equals(videoSize, stream.videoSize) &&
                Objects.equals(urls, stream.urls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(display, isTranslated, slug, type, videoSize, urls);
    }

    @Override
    public String toString() {
        return "Stream{" +
                "display='" + display + '\'' +
                ", isTranslated=" + isTranslated +
                ", slug='" + slug + '\'' +
                ", type=" + type +
                ", videoSize=" + videoSize +
                ", urls=" + urls +
                '}';
    }

}

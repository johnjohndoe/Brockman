
package info.metadude.java.library.brockman.models;

import java.util.Objects;

public class Url {

    public enum TYPE {
        MP3("mp3"),
        OPUS("opus"),
        WEBM("webm"),
        HLS("hls"),
        UNKNOWN("Unknown URL type");

        private final String text;

        TYPE(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }

    }

    public final TYPE type;

    public final String display;

    public final String tech;

    public final String url;

    public Url(TYPE type, String display, String tech, String url) {
        this.type = type;
        this.display = display;
        this.tech = tech;
        this.url = url;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Url otherUrl = (Url) other;
        return type == otherUrl.type &&
                Objects.equals(display, otherUrl.display) &&
                Objects.equals(tech, otherUrl.tech) &&
                Objects.equals(url, otherUrl.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, display, tech, url);
    }

    @Override
    public String toString() {
        return "Url{" +
                "type=" + type +
                ", display='" + display + '\'' +
                ", tech='" + tech + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}

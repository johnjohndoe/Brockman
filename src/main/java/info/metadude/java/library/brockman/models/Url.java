
package info.metadude.java.library.brockman.models;

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
                !(display != null ? !display.equals(otherUrl.display) : otherUrl.display != null) &&
                !(tech != null ? !tech.equals(otherUrl.tech) : otherUrl.tech != null) &&
                !(url != null ? !url.equals(otherUrl.url) : otherUrl.url != null);

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (display != null ? display.hashCode() : 0);
        result = 31 * result + (tech != null ? tech.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
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

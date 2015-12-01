
package info.metadude.java.library.brockman.models;

public class Mp3 {

    public final String display;

    public final String tech;

    public final String url;

    public Mp3(String display, String tech, String url) {
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
        Mp3 mp3 = (Mp3) other;
        return !(display != null ? !display.equals(mp3.display) : mp3.display != null) &&
                !(tech != null ? !tech.equals(mp3.tech) : mp3.tech != null) &&
                !(url != null ? !url.equals(mp3.url) : mp3.url != null);

    }

    @Override
    public int hashCode() {
        int result = display != null ? display.hashCode() : 0;
        result = 31 * result + (tech != null ? tech.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mp3{" +
                "display='" + display + '\'' +
                ", tech='" + tech + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}

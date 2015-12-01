
package info.metadude.java.library.brockman.models;

public class Opus {

    public final String display;

    public final String tech;

    public final String url;

    public Opus(String display, String tech, String url) {
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
        Opus opus = (Opus) other;
        return !(display != null ? !display.equals(opus.display) : opus.display != null) &&
                !(tech != null ? !tech.equals(opus.tech) : opus.tech != null) &&
                !(url != null ? !url.equals(opus.url) : opus.url != null);
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
        return "Opus{" +
                "display='" + display + '\'' +
                ", tech='" + tech + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}

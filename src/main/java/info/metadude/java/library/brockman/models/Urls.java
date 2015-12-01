
package info.metadude.java.library.brockman.models;

public class Urls {

    public final Mp3 mp3;

    public final Opus opus;

    public Urls(Mp3 mp3, Opus opus) {
        this.mp3 = mp3;
        this.opus = opus;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Urls urls = (Urls) other;
        return !(mp3 != null ? !mp3.equals(urls.mp3) : urls.mp3 != null) &&
                !(opus != null ? !opus.equals(urls.opus) : urls.opus != null);
    }

    @Override
    public int hashCode() {
        int result = mp3 != null ? mp3.hashCode() : 0;
        result = 31 * result + (opus != null ? opus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Urls{" +
                "mp3=" + mp3 +
                ", opus=" + opus +
                '}';
    }

}

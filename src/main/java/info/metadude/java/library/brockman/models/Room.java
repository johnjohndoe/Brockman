
package info.metadude.java.library.brockman.models;

import java.util.List;

public class Room {

    public final String display;

    public final String link;

    public final String schedulename;

    public final String slug;

    public final List<Stream> streams;

    public final String thumb;

    public Room(String display,
                String link,
                String schedulename,
                String slug,
                List<Stream> streams,
                String thumb) {
        this.display = display;
        this.link = link;
        this.schedulename = schedulename;
        this.slug = slug;
        this.streams = streams;
        this.thumb = thumb;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Room room = (Room) other;
        return !(display != null ? !display.equals(room.display) : room.display != null) &&
                !(link != null ? !link.equals(room.link) : room.link != null) &&
                !(schedulename != null ? !schedulename.equals(room.schedulename) : room.schedulename != null) &&
                !(slug != null ? !slug.equals(room.slug) : room.slug != null) &&
                !(streams != null ? !streams.equals(room.streams) : room.streams != null) &&
                !(thumb != null ? !thumb.equals(room.thumb) : room.thumb != null);
    }

    @Override
    public int hashCode() {
        int result = display != null ? display.hashCode() : 0;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (schedulename != null ? schedulename.hashCode() : 0);
        result = 31 * result + (slug != null ? slug.hashCode() : 0);
        result = 31 * result + (streams != null ? streams.hashCode() : 0);
        result = 31 * result + (thumb != null ? thumb.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "display='" + display + '\'' +
                ", link='" + link + '\'' +
                ", schedulename='" + schedulename + '\'' +
                ", slug='" + slug + '\'' +
                ", streams=" + streams +
                ", thumb='" + thumb + '\'' +
                '}';
    }

}

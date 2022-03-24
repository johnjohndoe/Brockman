
package info.metadude.java.library.brockman.models;

import com.squareup.moshi.Json;

import java.util.List;
import java.util.Objects;

public class Room {

    public final String display;

    public final String link;

    @Json(name = "schedulename")
    public final String scheduleName;

    public final String slug;

    public final List<Stream> streams;

    public final String thumb;

    public Room(String display,
                String link,
                String scheduleName,
                String slug,
                List<Stream> streams,
                String thumb) {
        this.display = display;
        this.link = link;
        this.scheduleName = scheduleName;
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
        return Objects.equals(display, room.display) &&
                Objects.equals(link, room.link) &&
                Objects.equals(scheduleName, room.scheduleName) &&
                Objects.equals(slug, room.slug) &&
                Objects.equals(streams, room.streams) &&
                Objects.equals(thumb, room.thumb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(display, link, scheduleName, slug, streams, thumb);
    }

    @Override
    public String toString() {
        return "Room{" +
                "display='" + display + '\'' +
                ", link='" + link + '\'' +
                ", scheduleName='" + scheduleName + '\'' +
                ", slug='" + slug + '\'' +
                ", streams=" + streams +
                ", thumb='" + thumb + '\'' +
                '}';
    }

}

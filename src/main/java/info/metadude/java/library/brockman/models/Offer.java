
package info.metadude.java.library.brockman.models;

import java.util.List;

public class Offer {

    public final String group;

    public final List<Room> rooms;

    public Offer(String group, List<Room> rooms) {
        this.group = group;
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Offer offer = (Offer) other;
        return !(group != null ? !group.equals(offer.group) : offer.group != null) &&
                !(rooms != null ? !rooms.equals(offer.rooms) : offer.rooms != null);
    }

    @Override
    public int hashCode() {
        int result = group != null ? group.hashCode() : 0;
        result = 31 * result + (rooms != null ? rooms.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "group='" + group + '\'' +
                ", rooms=" + rooms +
                '}';
    }

}

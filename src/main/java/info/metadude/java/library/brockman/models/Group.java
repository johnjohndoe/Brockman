package info.metadude.java.library.brockman.models;

import java.util.List;
import java.util.Objects;

public class Group {

    public final String group;

    public final List<Room> rooms;

    public Group(String group, List<Room> rooms) {
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
        Group otherGroup = (Group) other;
        return Objects.equals(group, otherGroup.group) &&
                Objects.equals(rooms, otherGroup.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, rooms);
    }

    @Override
    public String toString() {
        return "Group{" +
                "group='" + group + '\'' +
                ", rooms=" + rooms +
                '}';
    }

}

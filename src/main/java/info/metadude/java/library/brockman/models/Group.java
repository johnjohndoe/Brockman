package info.metadude.java.library.brockman.models;

import java.util.List;

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
        Group groupObject = (Group) other;
        return group != null ? group.equals(groupObject.group) : groupObject.group == null
                && (rooms != null ? rooms.equals(groupObject.rooms) : groupObject.rooms == null);
    }

    @Override
    public int hashCode() {
        int result = group != null ? group.hashCode() : 0;
        result = 31 * result + (rooms != null ? rooms.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "group='" + group + '\'' +
                ", rooms=" + rooms +
                '}';
    }

}

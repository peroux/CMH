package src.main.java.cmh.backend;

import java.util.ArrayList;
import java.util.List;


public class Group {
    private List<Guest> group;
    private static List<Group> allGroups = new ArrayList<Group>();

    public Group() {
        group = new ArrayList<Guest>();
        allGroups.add(this);
    }

    public void addGuest(Guest guest) {
        group.add(guest);
    }

    public List<Guest> getGroup() {
        return group;
    }

    public Guest getGuest(int index) {
        return group.get(index);
    }

    public int getGroupSize() {
        return group.size();
    }

    public void removeGuest(int index) {
        group.remove(index);
    }

    public void removeGuest(Guest guest) {
        group.remove(guest);
    }

    public void clear() {
        group.clear();
    }

    public static List<Group> getGroups() {
        return allGroups;
    }

    public static Group getGroupByIndex(int index) {
        return allGroups.get(index);
    }

    public static void removeGroup(int index) {
        allGroups.remove(index);
    }

}


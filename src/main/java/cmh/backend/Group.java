package src.main.java.cmh.backend;

import java.util.ArrayList;
import java.util.List;


public class Group {
    private String name;
    private List<Guest> group;
    private static List<Group> allGroups = new ArrayList<Group>();

    public Group(String name, List<Guest> group) {
        this.name = name;
        this.group = group;
        allGroups.add(this);
    }

    public Group(String name) {
        this.name = name;
        this.group = new ArrayList<Guest>();
        allGroups.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public static void removeGroup(Group group) {
        allGroups.remove(group);
    }

    public static void clearAllGroups() {
        allGroups.clear();
    }

    public String toString() {
        return "Group: " + name;
    }

    public void toStringDetail(Group group) {
        String str = "Group: " + group.getName();
        for (Guest guest : group.getGroup()) {
            str += "\n" + guest.toString();
        }
        str += "\nTotal Guests: " + group.getGroupSize();
        System.out.println(str);
    }

}


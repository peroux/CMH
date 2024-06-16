package src.main.java.cmh.backend;

public class GroupController {

    public boolean addGroup(String name) {
        Group newGroup = new Group(name);
        return newGroup != null;
    }

    public static Group getGroup(String name) {
        for (Group group : Group.getGroups()) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        return null;
    }

    public boolean removeGroup(String name) {
        Group group = getGroup(name);
        if (group != null) {
            return Group.getGroups().remove(group);
        }
        return false;
    }

    public boolean addGuestToGroup(String groupName, String guestName) {
        Group group = getGroup(groupName);
        Guest guest = GuestController.getGuest(guestName);
        if (group != null && guest != null) {
            group.addGuest(guest);
            return true;
        }
        return false;
    }

    public boolean removeGuestFromGroup(String groupName, String guestName) {
        Group group = getGroup(groupName);
        Guest guest = GuestController.getGuest(guestName);
        if (group != null && guest != null) {
            group.removeGuest(guest);
            return true;
        }
        return false;
    }

    public boolean clearGroup(String name) {
        Group group = getGroup(name);
        if (group != null) {
            group.clear();
            return true;
        }
        return false;
    }

    public boolean editGroup(String name, String newName) {
        Group group = getGroup(name);
        if (group != null) {
            group.setName(newName);
            return true;
        }
        return false;
    }
    
}

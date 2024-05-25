package src.main.java.cmh.frontend;

import src.main.java.cmh.backend.*;
import java.util.List;

public class UserInteraction {
    private static User currentlyLoggedInUser = null;
    private static int guestID = -1;

    public static User getCurrentlyLoggedInUser() {
        return currentlyLoggedInUser;
    }

    public static boolean login(String username, String password) {
        User user = UserController.login(username, password);
        if(user != null) {
            currentlyLoggedInUser = user;
            return true;
        } else {
            return false;
        }
    }

public static boolean createUser(String username, String password, String email, String name, String phoneNumber, boolean isAdmin) {
    if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
        return false;
    }
    return UserController.createUser(username, password, email, name, phoneNumber, isAdmin);
    }

    public static boolean deleteUser(String username) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        return UserController.deleteUser(username);
    }

    public static boolean updateUser(String username, String password, String email, String name, String phoneNumber, boolean isAdmin) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        return UserController.updateUser(username, password, email, name, phoneNumber, isAdmin);
    }

    public static List<User> viewUsers() {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return null;
        }
        return User.getUsers();
    }

    public static List<Group> viewGroups() {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return null;
        }
        return Group.getGroups();
    }

    public static List<Guest> viewGuests() {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return null;
        }

        return Guest.getAllGuests();
    }

    public static boolean createGroup() {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        Group newGroup = new Group();
        return newGroup != null;
    }

    public static boolean deleteGroup(int groupID) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        Group.removeGroup(groupID);
        return Group.getGroupByIndex(groupID) == null;
    }

    public static boolean addGuestToGroup(int groupID, Guest guest) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        Group.getGroupByIndex(groupID).addGuest(guest);
        return Group.getGroupByIndex(groupID).getGroup().contains(guest);
    }

    public static boolean removeGuestFromGroup(int groupID, int guestID) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        Group.getGroupByIndex(groupID).removeGuest(guestID);
        return !Group.getGroupByIndex(groupID).getGroup().contains(Guest.getGuestByIndex(guestID));
    }

    public static boolean clearGroup(int groupID) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        Group.getGroupByIndex(groupID).clear();
        return Group.getGroupByIndex(groupID).getGroupSize() == 0;
    }

    public static boolean deleteGroupAndGuests(int groupID) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        for(Guest guest : Group.getGroupByIndex(groupID).getGroup()) {
            guestID = Guest.getIndexByGuest(guest);
            Guest.removeGuest(guestID);
        }
        Group.removeGroup(groupID);
        return Group.getGroupByIndex(groupID) == null;
    }

    public static Room getRoom(int roomID) {
        if(currentlyLoggedInUser == null) {
            return null;
        }
        for(HousingUnit unit : HousingUnit.getAllHousingUnits()) {
            for(Room room : unit.getRooms()) {
                if(room.getRoomNumber() == roomID) {
                    return room;
                }
            }
        }
        return null;
    }

    public static List<HousingUnit> getHousingUnits() {
        if(currentlyLoggedInUser == null) {
            return null;
        }
        return HousingUnit.getAllHousingUnits();
    }

    public static void logout() {
        currentlyLoggedInUser = null;
    }

}
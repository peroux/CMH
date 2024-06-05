package src.main.java.cmh.frontend;

import src.main.java.cmh.backend.*;
import java.util.List;

/**
 * This class provides methods for user interaction with the system.
 * The current list of methods are as follows:
 * - login
 * - createUser
 * - deleteUser
 * - updateUser
 * - viewUsers
 * - getUser
 * - viewGroups
 * - viewGuests
 * - createGroup
 * - deleteGroup
 * - addGuestToGroup
 * - removeGuestFromGroup
 * - clearGroup
 * - deleteGroupAndGuests
 * - getRoom
 * - getHousingUnits
 * - logout
 * - createRoom
 * - deleteRoom
 * - updateRoom
 * - getRoom
 * methods to be added are:
 * - createGuest
 * - deleteGuest
 * - updateGuest
 * - viewGuest
 * - getGuest
 * - viewRoom
 * - createHousingUnit
 * - deleteHousingUnit
 * - updateHousingUnit
 * - viewHousingUnit
 * - getHousingUnit
 * TODO: Add the remaining methods and possibly organize them more
 */

public class UserInteraction {
    private static User currentlyLoggedInUser = null;
    private static int guestID = -1;

    public static User getCurrentlyLoggedInUser() {
        return currentlyLoggedInUser;
    }

    /**
     * Logs in a user with the given username and password.
     * 
     * @param username the username of the user
     * @param password the password of the user
     * @return true if the login is successful, false otherwise
     */
    public static boolean login(String username, String password) {
        User user = UserController.login(username, password);
        if(user != null) {
            currentlyLoggedInUser = user;
            return true;
        } else {
            return false;
        }
    }

    public static void logout() {
        currentlyLoggedInUser = null;
    }




    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\\
    //----------------------------------------------------------------------------------------------\\
    //                                      USER METHODS                                            \\
    //----------------------------------------------------------------------------------------------\\
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\\





/**
 * Creates a new user with the specified details.
 *
 * @param username     the username of the user
 * @param password     the password of the user
 * @param email        the email address of the user
 * @param name         the name of the user
 * @param phoneNumber  the phone number of the user
 * @param isAdmin      a flag indicating whether the user is an admin or not
 * @return true if the user is created successfully, false otherwise
 */
public static boolean createUser(String username, String password, String email, String name, String phoneNumber, boolean isAdmin) {
    if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
        return false;
    }
    return UserController.createUser(username, password, email, name, phoneNumber, isAdmin);
    }

    /**
     * Deletes a user from the system.
     * 
     * @param username the username of the user to be deleted
     * @return true if the user was successfully deleted, false otherwise
     */
    public static boolean deleteUser(String username) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        return UserController.deleteUser(username);
    }

    /**
     * Updates a user's information in the system.
     *
     * @param username     the username of the user
     * @param password     the password of the user
     * @param email        the email address of the user
     * @param name         the name of the user
     * @param phoneNumber  the phone number of the user
     * @param isAdmin      a flag indicating whether the user is an admin or not
     * @return true if the user was successfully updated, false otherwise
     */
    public static boolean updateUser(String username, String password, String email, String name, String phoneNumber, boolean isAdmin) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        return UserController.updateUser(username, password, email, name, phoneNumber, isAdmin);
    }

    /**
     * Retrieves a list of users.
     * 
     * @return A list of User objects if the currently logged-in user is an admin, null otherwise.
     */
    public static List<User> viewUsers() {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return null;
        }
        return User.getUsers();
    }

    /**
     * Retrieves a User object based on the provided username.
     * 
     * @param username the username of the user to retrieve
     * @return the User object associated with the provided username, or null if the currently logged-in user is not an admin or if no user with the given username exists
     */
    public static User getUser(String username) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return null;
        }
        return User.getUser(username);
    }





    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\\
    //----------------------------------------------------------------------------------------------\\
    //                                      GUEST METHODS                                           \\
    //----------------------------------------------------------------------------------------------\\
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\\





    /**
     * Retrieves a list of guests.
     * 
     * @return a list of guests if the currently logged-in user is an admin, otherwise null.
     */
    public static List<Guest> viewGuests() {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return null;
        }

        return Guest.getAllGuests();
    }




    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\\
    //----------------------------------------------------------------------------------------------\\
    //                                      GROUP METHODS                                           \\
    //----------------------------------------------------------------------------------------------\\
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\\





    /**
     * Retrieves a list of groups.
     * 
     * @return a list of groups if the currently logged-in user is an admin, otherwise null.
     */
    public static List<Group> viewGroups() {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return null;
        }
        return Group.getGroups();
    }

    /**
     * Creates a new group with the given name.
     * 
     * @param name the name of the group
     * @return true if the group is successfully created, false otherwise
     */
    public static boolean createGroup(String name) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        Group newGroup = new Group(name);
        return newGroup != null;
    }

    /**
     * Deletes a group with the specified group ID.
     * 
     * @param groupID the ID of the group to be deleted
     * @return true if the group was successfully deleted, false otherwise
     */
    public static boolean deleteGroup(int groupID) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        Group.removeGroup(groupID);
        return Group.getGroupByIndex(groupID) == null;
    }

    /**
     * Adds a guest to a group.
     *
     * @param groupID the ID of the group to add the guest to
     * @param guest the guest to be added to the group
     * @return true if the guest was successfully added to the group, false otherwise
     */
    public static boolean addGuestToGroup(int groupID, Guest guest) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        Group.getGroupByIndex(groupID).addGuest(guest);
        return Group.getGroupByIndex(groupID).getGroup().contains(guest);
    }

    /**
     * Removes a guest from a group.
     *
     * @param groupID  the ID of the group
     * @param guestID  the ID of the guest to be removed
     * @return true if the guest was successfully removed, false otherwise
     */
    public static boolean removeGuestFromGroup(int groupID, int guestID) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        Group.getGroupByIndex(groupID).removeGuest(guestID);
        return !Group.getGroupByIndex(groupID).getGroup().contains(Guest.getGuestByIndex(guestID));
    }

    /**
     * Clears the specified group by removing all members from it.
     * Only an admin user can clear a group.
     *
     * @param groupID the ID of the group to be cleared
     * @return true if the group is cleared successfully and has no members, false otherwise
     */
    public static boolean clearGroup(int groupID) {
        if(currentlyLoggedInUser == null || !currentlyLoggedInUser.getIsAdmin()) {
            return false;
        }
        Group.getGroupByIndex(groupID).clear();
        return Group.getGroupByIndex(groupID).getGroupSize() == 0;
    }

    /**
     * Deletes a group and all its associated guests.
     *
     * @param groupID the ID of the group to be deleted
     * @return true if the group and its guests were successfully deleted, false otherwise
     */
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





    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\\
    //----------------------------------------------------------------------------------------------\\
    //                                      ROOM METHODS                                            \\
    //----------------------------------------------------------------------------------------------\\
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\\



    
    /**
     * Represents a room in a housing unit.
     * 
     * @param roomID the ID of the room to retrieve
     * @return the Room object associated with the provided room ID, or null if there is no currently logged in user 
     *         or if no room with the given ID exists
     */
    public static Room getRoom(int roomID,String prefix) {
        if(currentlyLoggedInUser == null) {
            return null;
        }
        return RoomController.getRoom(roomID, prefix);
    }

    public static boolean removeRoom(int roomNumber, String prefix) {
        if(currentlyLoggedInUser == null) {
            return false;
        }
        return RoomController.removeRoom(roomNumber, prefix);
    }

    public static boolean updateRoom(String currPrefix, int currRoomNumber, String newPrefix, int newRoomNumber, int capacity, boolean hasAC, boolean isOccupied, boolean isAvailable, boolean isReserved, boolean privBath, String phoneNumber) {
        if(currentlyLoggedInUser == null) {
            return false;
        }
        return RoomController.editRoom(currPrefix, currRoomNumber, newPrefix, newRoomNumber, capacity, hasAC, isOccupied, isAvailable, isReserved, privBath, phoneNumber);
    }

    public static boolean addRoom(String prefix, int roomNumber, int capacity, boolean hasAC, boolean isOccupied, boolean isAvailable, boolean isReserved, boolean privBath, String phoneNumber) {
        if(currentlyLoggedInUser == null) {
            return false;
        }
        return RoomController.addRoom(prefix, roomNumber, capacity, hasAC, isOccupied, isAvailable, isReserved, privBath, phoneNumber);
    }





    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\\
    //----------------------------------------------------------------------------------------------\\
    //                                      HOUSING UNIT METHODS                                    \\
    //----------------------------------------------------------------------------------------------\\
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\\
 




    /**
     * Retrieves a list of housing units.
     *
     * @return a list of housing units, or null if no user is currently logged in
     */
    public static List<HousingUnit> getHousingUnits() {
        if(currentlyLoggedInUser == null) {
            return null;
        }
        return HousingUnit.getAllHousingUnits();
    }
}
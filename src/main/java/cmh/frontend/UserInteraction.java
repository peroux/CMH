package src.main.java.cmh.frontend;

import src.main.java.cmh.backend.*;
import java.util.List;
import java.util.Date;

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
    private static boolean user = false;
    private static boolean admin = false;

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
        User u = UserController.login(username, password);
        if(u != null) {
            currentlyLoggedInUser = u;
            user = currentlyLoggedInUser != null;
            admin = currentlyLoggedInUser.getIsAdmin() && user;
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
        if(admin) {
            return UserController.createUser(username, password, email, name, phoneNumber, isAdmin);
        }
    return false;
    }

    /**
     * Deletes a user from the system.
     * 
     * @param username the username of the user to be deleted
     * @return true if the user was successfully deleted, false otherwise
     */
    public static boolean deleteUser(String username) {
        if(admin) {
            return UserController.deleteUser(username);
        }
        return false;
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
        if(admin) {
            return UserController.updateUser(username, password, email, name, phoneNumber, isAdmin);
        }
        return false;
    }

    /**
     * Retrieves a list of users.
     * 
     * @return A list of User objects if the currently logged-in user is an admin, null otherwise.
     */
    public static List<User> viewUsers() {
        if(admin) {
            return User.getUsers();
        }
        return null;
    }

    /**
     * Retrieves a User object based on the provided username.
     * 
     * @param username the username of the user to retrieve
     * @return the User object associated with the provided username, or null if the currently logged-in user is not an admin or if no user with the given username exists
     */
    public static User getUser(String username) {
        if(admin) {
            return User.getUser(username);
        }
        return null;
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
        if(admin) {
            return Guest.getAllGuests();
        }

        return null;
    }

    public static boolean addGuest(int gender, boolean staff, String name, String key, String otherInfo, Date checkIn, Date checkOut) {
        if(admin) {
            return GuestController.addGuest(gender, staff, name, key, checkIn, checkOut, otherInfo);
        }
        return false;
    }

    public static Guest getGuest(String name) {
        if(admin) {
            return GuestController.getGuest(name);
        }
        return null;
    }

    public static boolean removeGuest(String name) {
        if(admin) {
            return GuestController.removeGuest(name);
        }
        return false;
    }

    public static boolean editGuest(String name, String newName, int newGender, boolean newStaff, String newKey, Date newCheckIn, Date newCheckOut) {
        if(admin) {
            return GuestController.editGuest(name, newName, newGender, newStaff, newKey, newCheckIn, newCheckOut);
        }
        return false;
    }

    public static boolean addGuestToRoom(String name, String prefix, int roomNumber) {
        if(admin) {
            return GuestController.addGuestToRoom(name, prefix, roomNumber);
        }
        return false;
    }

    public static boolean removeGuestFromRoom(String name) {
        if(admin) {
            return GuestController.removeGuestFromRoom(name);
        }
        return false;
    }

    public static boolean checkInGuest(String name) {
        if(admin) {
            return GuestController.checkInGuest(name);
        }
        return false;
    }

    public static boolean checkOutGuest(String name) {
        if(admin) {
            return GuestController.checkOutGuest(name);
        }
        return false;
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
        if(admin) {
            return Group.getGroups();
        }
        return null;
    }

    /**
     * Creates a new group with the given name.
     * 
     * @param name the name of the group
     * @return true if the group is successfully created, false otherwise
     */
    public static boolean createGroup(String name) {
        if(admin) {
            Group newGroup = new Group(name);
            return newGroup != null;
        }
        return false;
    }

    /**
     * Deletes a group with the specified group ID.
     * 
     * @param groupID the ID of the group to be deleted
     * @return true if the group was successfully deleted, false otherwise
     */
    public static boolean deleteGroup(int groupID) {
        if(admin) {
            Group.removeGroup(groupID);
            return Group.getGroupByIndex(groupID) == null;
        }
        return false;
    }

    /**
     * Adds a guest to a group.
     *
     * @param groupID the ID of the group to add the guest to
     * @param guest the guest to be added to the group
     * @return true if the guest was successfully added to the group, false otherwise
     */
    public static boolean addGuestToGroup(int groupID, Guest guest) {
        if(admin) {
            
            Group.getGroupByIndex(groupID).addGuest(guest);
            return Group.getGroupByIndex(groupID).getGroup().contains(guest);
        }
        return false;
    }

    /**
     * Removes a guest from a group.
     *
     * @param groupID  the ID of the group
     * @param guestID  the ID of the guest to be removed
     * @return true if the guest was successfully removed, false otherwise
     */
    public static boolean removeGuestFromGroup(int groupID, int guestID) {
        if(admin) {
            
            Group.getGroupByIndex(groupID).removeGuest(guestID);
            return !Group.getGroupByIndex(groupID).getGroup().contains(Guest.getGuestByIndex(guestID));
        }
        return false;
    }

    /**
     * Clears the specified group by removing all members from it.
     * Only an admin user can clear a group.
     *
     * @param groupID the ID of the group to be cleared
     * @return true if the group is cleared successfully and has no members, false otherwise
     */
    public static boolean clearGroup(int groupID) {
        if(admin) {
            Group.getGroupByIndex(groupID).clear();
            return Group.getGroupByIndex(groupID).getGroupSize() == 0;
        }
        return false;
    }

    /**
     * Deletes a group and all its associated guests.
     *
     * @param groupID the ID of the group to be deleted
     * @return true if the group and its guests were successfully deleted, false otherwise
     */
    public static boolean deleteGroupAndGuests(int groupID) {
        if(admin) {
            for(Guest guest : Group.getGroupByIndex(groupID).getGroup()) {
                guestID = Guest.getIndexByGuest(guest);
                Guest.removeGuest(guestID);
            }
            Group.removeGroup(groupID);
            return Group.getGroupByIndex(groupID) == null;
        }
        return false;
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
        if(user) {
            return RoomController.getRoom(roomID, prefix);
        }
        return null;
        
    }

    public static boolean removeRoom(int roomNumber, String prefix) {
        if(admin) {
            return RoomController.removeRoom(roomNumber, prefix);
        }
        return false;
    }

    public static boolean editRoom(String currPrefix, int currRoomNumber, String newPrefix, int newRoomNumber, int capacity, boolean hasAC, boolean isOccupied, boolean isAvailable, boolean isReserved, boolean privBath, String phoneNumber) {
        if(admin) {
            return RoomController.editRoom(currPrefix, currRoomNumber, newPrefix, newRoomNumber, capacity, hasAC, isOccupied, isAvailable, isReserved, privBath, phoneNumber);
        }
        return false;
    }

    public static boolean addRoom(String prefix, int roomNumber, int capacity, boolean hasAC, boolean isOccupied, boolean isAvailable, boolean isReserved, boolean privBath, String phoneNumber) {
        if(admin) {
            return RoomController.addRoom(prefix, roomNumber, capacity, hasAC, isOccupied, isAvailable, isReserved, privBath, phoneNumber);
        }
        return false;
    }

    public static String viewRoom(int roomNumber, String prefix, boolean detail) {
        if(user && !detail) {
            return RoomController.viewRoom(roomNumber, prefix, detail);
        } 
        else if(admin && detail) {
            return RoomController.viewRoom(roomNumber, prefix, detail);
        }
        return null;
    }

    public static boolean viewRoomDatabase() {
        if(admin) {
            for(Room room : Room.getRooms()) {
                System.out.println(room.toString());
            }
            return true;
        }
        return false;
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
        if(user) {
            return HousingUnit.getAllHousingUnits();
        }
        return null;
    }

    public static boolean addHousingUnit(String prefix, String name) {
        if(admin) {
            return HousingUnitController.addHousingUnit(prefix, name);
        }
        return false;
    }

    public static boolean removeHousingUnit(String prefix) {
        if(admin) {
            return HousingUnitController.removeHousingUnit(prefix);
        }
        return false;
    }

    public static boolean editHousingUnit(String currPrefix, String newPrefix, String name) {
        if(admin) {
            return HousingUnitController.editHousingUnit(currPrefix, newPrefix, name);
        }
        return false;
    }
}
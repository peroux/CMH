package src.main.java.cmh.backend;
import java.util.Date;

@SuppressWarnings("unused")
public class GuestController {

    public static boolean addGuest(int gender, boolean staff, String name, String key, Date checkIn, Date checkOut, String otherInfo) {
        if(otherInfo.isEmpty()) {
            Guest newGuest = new Guest(gender, staff, name, key, checkIn, checkOut);
        }
        Guest newGuest = new Guest(gender, staff, name, key, checkIn, checkOut, otherInfo);
        return newGuest != null;
    }

    public static Guest getGuest(String name) {
        for (Guest guest : Guest.getAllGuests()) {
            if (guest.getName().equals(name)) {
                return guest;
            }
        }
        return null;
    }

    public static boolean removeGuest(String name) {
        Guest guest = getGuest(name);
        if (guest != null) {
            return Guest.getAllGuests().remove(guest);
        }
        return false;
    }
    
    public static boolean editGuest(String name, String newName, int newGender, boolean newStaff, String newKey, Date newCheckIn, Date newCheckOut) {
        Guest guest = getGuest(name);
        if (guest != null) {
            guest.setName(newName);
            guest.setGender(newGender);
            guest.setStaff(newStaff);
            guest.setKey(newKey);
            guest.setCheckIn(newCheckIn);
            guest.setCheckOut(newCheckOut);
            return true;
        }
        return false;
    }

    public static boolean addGuestToRoom(String name, String prefix, int roomNumber) {
        Guest guest = getGuest(name);
        Room room = RoomController.getRoom(roomNumber, prefix);
        if (guest != null && room != null) {
            String key = prefix + roomNumber;
            guest.setKey(key);
            return true;
        }
        return false;
    }

    public static boolean removeGuestFromRoom(String name) {
        Guest guest = getGuest(name);
        if (guest != null) {
            guest.setKey("");
            return true;
        }
        return false;
    }

    public static boolean checkInGuest(String name) {
        Guest guest = getGuest(name);
        if (guest != null) {
            guest.setCheckedIn(true);
            return true;
        }
        return false;
    }

    public static boolean checkOutGuest(String name) {
        Guest guest = getGuest(name);
        if (guest != null) {
            guest.setCheckedIn(false);
            return true;
        }
        return false;
    }
    
}

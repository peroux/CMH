package src.main.java.cmh.backend;

public class RoomController {

    public static boolean addRoom(String prefix, int roomNumber, int capacity, boolean hasAC, boolean isOccupied, boolean isAvailable, boolean isReserved, boolean privBath, String phoneNumber) {
        Room newRoom = new Room(prefix, roomNumber, capacity, hasAC, isOccupied, isAvailable, isReserved, privBath, phoneNumber);
        return newRoom != null;
    }

    public static Room getRoom(int roomNumber, String prefix) {
        for (Room room : Room.getRooms()) {
            if (room.getRoomNumber() == roomNumber && room.getPrefix().equals(prefix)) {
                return room;
            }
        }
        return null;
    }

    public static boolean removeRoom(int roomNumber, String prefix) {
        Room room = getRoom(roomNumber, prefix);
        if (room != null) {
            return Room.getRooms().remove(room);
        }
        return false;
    }

    public static boolean editRoom(String currPrefix, int currRoomNumber, String newPrefix, int newRoomNumber, int capacity, boolean hasAC, boolean isOccupied, boolean isAvailable, boolean isReserved, boolean privBath, String phoneNumber) {
        Room room = getRoom(currRoomNumber, currPrefix);
        HousingUnit oldUnit = HousingUnitController.getHousingUnit(currPrefix);
        HousingUnit newUnit = HousingUnitController.getHousingUnit(newPrefix);

        if (room != null && newUnit != null) {
            oldUnit.removeRoom(room);
            room.editRoom(newUnit, room, newRoomNumber, capacity, hasAC, isOccupied, isAvailable, isReserved, privBath, phoneNumber);
            newUnit.addRoom(room);
            return true;
        }
        return false;
    }

    public static boolean reserveRoom(int roomNumber, String prefix) {
        Room room = getRoom(roomNumber, prefix);
        if (room != null) {
            room.setIsReserved(true);
            return true;
        }
        return false;
    }

    public static boolean unreserveRoom(int roomNumber, String prefix) {
        Room room = getRoom(roomNumber, prefix);
        if (room != null) {
            room.setIsReserved(false);
            return true;
        }
        return false;
    }

    public static String viewRoom(int roomNumber, String prefix, boolean detail) {
        Room room = getRoom(roomNumber, prefix);
        if (room != null) {
            if (detail) {
                return room.toStringDetailed();
            }
            return room.toString();
        }
        return "Room not found";
    }

}

package backend;

import java.util.List;
import java.util.ArrayList;

public class HousingUnit {
    private String name;
    private List<Room> rooms;


    public HousingUnit(String name) {
        this.name = name;
        this.rooms = new ArrayList<Room>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public boolean editRoom(Room room, int newRoomNumber, int newCapacity, boolean newHasAC, boolean newIsOccupied, boolean newIsAvailable, boolean newIsReserved) {
        if (rooms.contains(room)) {
            room.setRoomNumber(newRoomNumber);
            room.setCapacity(newCapacity);
            room.setHasAC(newHasAC);
            room.setIsOccupied(newIsOccupied);
            room.setIsAvailable(newIsAvailable);
            room.setIsReserved(newIsReserved);
            return true;
        }
        return false;
    }

    public Room getRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

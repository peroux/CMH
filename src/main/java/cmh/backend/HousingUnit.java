package src.main.java.cmh.backend;


import java.util.List;
import java.util.ArrayList;

public class HousingUnit {
    private String name;
    private List<Room> rooms;
    private String prefix;
    private static List<HousingUnit> allHousingUnits = new ArrayList<HousingUnit>();


    public HousingUnit(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
        this.rooms = new ArrayList<Room>();
        allHousingUnits.add(this);
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public static List<HousingUnit> getAllHousingUnits() {
        return allHousingUnits;
    }

    public String toString() {
        return name;
    }

    public void toStringHousingDetail(HousingUnit unit) {
        String markers = "";
       for (int i = 0; i < unit.getName().length(); i++) {
        markers += "~";
       }
        System.out.println(markers);
        System.out.println(unit.getName());
        System.out.println(markers);
        for (Room room : unit.getRooms()) {
            System.out.println("Room " + unit.getPrefix() + room.getRoomNumber() + " (holds " + room.getCapacity() + "): " + (room.getHasAC() ? "Has AC" : "No AC") + (room.getPrivBath() ? ", Private Bath" : "") + (room.getIsOccupied() ? ", Occupied" : "") + (room.getIsReserved() ? ", Reserved" : ""));
            
        }

    }

}

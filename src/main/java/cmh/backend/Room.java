package src.main.java.cmh.backend;

import java.util.List;
import java.util.ArrayList;
//import java.util.Date;



//add day in day out, move to group

public class Room {
    private String prefix;
    private int roomNumber;
    private int capacity;
    private boolean hasAC;
    private boolean isOccupied;
    private boolean isAvailable;
    private boolean isReserved;
    private boolean privBath;
    private String phoneNumber;
    private static List<Room> rooms = new ArrayList<Room>();

    public Room(String prefix, int roomNumber, int capacity, boolean hasAC, boolean isOccupied, boolean isAvailable, boolean isReserved, boolean privBath, String phoneNumber) {
        this.prefix = prefix;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.hasAC = hasAC;
        this.isOccupied = isOccupied;
        this.isAvailable = isAvailable;
        this.isReserved = isReserved;
        this.privBath = privBath;
        this.phoneNumber = phoneNumber;
        rooms.add(this);

    }

    public Room(int roomNumber, int capacity, boolean hasAC, boolean isOccupied, boolean isAvailable, boolean isReserved, boolean privBath, String phoneNumber) {
        this.prefix = "";
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.hasAC = hasAC;
        this.isOccupied = isOccupied;
        this.isAvailable = isAvailable;
        this.isReserved = isReserved;
        this.privBath = privBath;
        rooms.add(this);

    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public int getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean getHasAC() {
        return hasAC;
    }

    public void setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public void setPrivBath(boolean privBath){
        this.privBath=privBath;
    }

    public boolean getPrivBath(){
        return privBath;
    }

     public void editRoom(HousingUnit HousingUnit, Room room, int newRoomNumber, int newCapacity, boolean newHasAC, boolean newIsOccupied, boolean newIsAvailable, boolean newIsReserved, boolean privBath, String phoneNumber) {
            room.setPrefix(HousingUnit.getPrefix());
            room.setRoomNumber(newRoomNumber);
            room.setCapacity(newCapacity);
            room.setHasAC(newHasAC);
            room.setIsOccupied(newIsOccupied);
            room.setIsAvailable(newIsAvailable);
            room.setIsReserved(newIsReserved);
            room.setPrivBath(privBath);
            room.setPhoneNumber(phoneNumber);
    }


    public static List<Room> getRooms() {
        
        return rooms;
    }

    public static void setRooms(List<Room> rooms) {
        Room.rooms = rooms;
    }

    public String toString() {
        return "Room Number: " + roomNumber + " Prefix: " + prefix;
    }

    public String toStringDetailed() {
        return "Room Number: " + roomNumber + " Prefix: " + prefix + " Capacity: " + capacity + " Has AC: " + hasAC + " Is Occupied: " + isOccupied + " Is Available: " + isAvailable + " Is Reserved: " + isReserved + " Private Bath: " + privBath + " Phone Number: " + phoneNumber;
    }


}

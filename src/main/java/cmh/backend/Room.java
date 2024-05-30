package src.main.java.cmh.backend;

import java.util.List;
import java.util.ArrayList;
//import java.util.Date;



//add day in day out, move to group

public class Room {
    private int roomNumber;
    private int capacity;
    private boolean hasAC;
    private boolean isOccupied;
    private boolean isAvailable;
    private boolean isReserved;
    private boolean privBath;
    private String phoneNumber;
    //private Date checkIn;
    //private Date checkOut;
    private List<Room> rooms = new ArrayList<Room>();

    public Room(int roomNumber, int capacity, boolean hasAC, boolean isOccupied, boolean isAvailable, boolean isReserved, boolean privBath, String phoneNumber) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.hasAC = hasAC;
        this.isOccupied = false;
        this.isAvailable = true;
        this.isReserved = false;
        this.privBath = privBath;
        this.phoneNumber = phoneNumber;
        rooms.add(this);

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

     public boolean editRoom(HousingUnit HousingUnit, Room room, int newRoomNumber, int newCapacity, boolean newHasAC, boolean newIsOccupied, boolean newIsAvailable, boolean newIsReserved, boolean privBath, String phoneNumber) {
            room.setRoomNumber(newRoomNumber);
            room.setCapacity(newCapacity);
            room.setHasAC(newHasAC);
            room.setIsOccupied(newIsOccupied);
            room.setIsAvailable(newIsAvailable);
            room.setIsReserved(newIsReserved);
            room.setPrivBath(privBath);
            room.setPhoneNumber(phoneNumber);
            return true;
    }


    public List<Room> getRooms() {
        return rooms;
    }
}

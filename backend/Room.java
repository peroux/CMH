package backend;

public class Room {
    private int roomNumber;
    private int capacity;
    private boolean hasAC;
    private boolean isOccupied;
    private boolean isAvailable;
    private boolean isReserved;

    public Room(int roomNumber, int capacity, boolean hasAC, boolean isOccupied, boolean isAvailable, boolean isReserved) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.hasAC = hasAC;
        this.isOccupied = false;
        this.isAvailable = true;
        this.isReserved = false;
    }

    public int getRoomNumber() {
        return roomNumber;
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
    
}

package src.main.java.cmh.backend;

import java.util.List;
import java.util.ArrayList;

public class Guest {
    private int gender; // 0 for men, 1 for women, 2 for other
    private boolean staff;
    private String name;
    private String key;
    private String otherInfo;
    private static List<Guest> allGuests = new ArrayList<Guest>();

//non extra info costructior for normal guests 
    public Guest(int gender, boolean staff, String name, String key) {
        this.gender = gender;
        this.staff = staff;
        this.name = name;
        this.key = key;
        allGuests.add(this);

    }
//extra info for the "special" guests
     public Guest(int gender, boolean staff, String name, String key, String otherInfo) {
        this.gender = gender;
        this.staff = staff;
        this.name = name;
        this.key = key;
        this.otherInfo=otherInfo;
    }


    public String getOtherInfo() {
        if (this.otherInfo==null){
            return "No extra info associated with the guest";
        }
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }


    // Getter and Setter for gender
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    // Getter and Setter for staff
    public boolean isStaff() {
        return staff;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for key
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    // Getter and Setter for allGuests
    public static List<Guest> getAllGuests() {
        return allGuests;
    }

    public static void setAllGuests(List<Guest> allGuests) {
        Guest.allGuests = allGuests;
    }

    public static void removeGuest(int index) {
        allGuests.remove(index);
    }

    public static int getIndexByGuest(Guest guest) {
        List<Group> allGroups = Group.getGroups();
        for (Group group : allGroups) {
            if (group.getGroup().contains(guest)) {
                return allGroups.indexOf(group);
            }
        }
        return -1;
    }

    public static Guest getGuestByIndex(int index){
        return allGuests.get(index);
    }

}

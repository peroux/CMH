package src.main.java.cmh.backend;



public class Guest {
    private int gender; // 0 for men, 1 for women, 2 for other
    private boolean staff;
    private String name;
    private String key;
    private String otherInfo;

//non extra info costructior for normal guests 
    public Guest(int gender, boolean staff, String name, String key) {
        this.gender = gender;
        this.staff = staff;
        this.name = name;
        this.key = key;
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
}

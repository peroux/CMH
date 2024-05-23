package src.main.java.cmh.backend;

import java.util.ArrayList;
import java.util.List;


public class Group {
    private List<Guest> group;

    public Group() {
        group = new ArrayList<Guest>();
    }

    public void addGuest(Guest guest) {
        group.add(guest);
    }

    public List<Guest> getGroup() {
        return group;
    }

    public Guest getGuest(int index) {
        return group.get(index);
    }

    public int getGroupSize() {
        return group.size();
    }

    public void removeGuest(int index) {
        group.remove(index);
    }

    public void removeGuest(Guest guest) {
        group.remove(guest);
    }

    public void clear() {
        group.clear();
    }
}


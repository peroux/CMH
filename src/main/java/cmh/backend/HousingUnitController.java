package src.main.java.cmh.backend;

public class HousingUnitController {

    public static boolean addHousingUnit(String name, String prefix) {
        HousingUnit newHousingUnit = new HousingUnit(name, prefix);
        return newHousingUnit != null;
    }

    public static HousingUnit getHousingUnit(String prefix) {
        for (HousingUnit housingUnit : HousingUnit.getAllHousingUnits()) {
            if (housingUnit.getPrefix().equals(prefix)) {
                return housingUnit;
            }
        }
        return null;
    }

    public static boolean removeHousingUnit(String prefix) {
        HousingUnit housingUnit = getHousingUnit(prefix);
        if (housingUnit != null) {
            return HousingUnit.getAllHousingUnits().remove(housingUnit);
        }
        return false;
    }

    public static boolean editHousingUnit(String currPrefix, String newPrefix, String name) {
        HousingUnit housingUnit = getHousingUnit(currPrefix);
        if (housingUnit != null) {
            housingUnit.setPrefix(newPrefix);
            housingUnit.setName(name);
            return true;
        }
        return false;
    }

    public static boolean addRoomToHousingUnit(String prefix, int roomNumber) {
        HousingUnit housingUnit = getHousingUnit(prefix);
        Room room = RoomController.getRoom(roomNumber, prefix);
        if (housingUnit != null && room != null) {
            housingUnit.addRoom(room);
            return true;
        }
        return false;
    }

    public static boolean removeRoomFromHousingUnit(String prefix, int roomNumber) {
        HousingUnit housingUnit = getHousingUnit(prefix);
        Room room = RoomController.getRoom(roomNumber, prefix);
        if (housingUnit != null && room != null) {
            housingUnit.removeRoom(room);
            return true;
        }
        return false;
    }

    public static String viewHousingUnit(String prefix, boolean detail) {
        HousingUnit housingUnit = getHousingUnit(prefix);
        if (housingUnit != null) {
            if (detail) {
                return housingUnit.toStringDetail();
            }
            return housingUnit.toString();
        }
        return null;
    }
    
}

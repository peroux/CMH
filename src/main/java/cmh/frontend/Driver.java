package src.main.java.cmh.frontend;

import java.util.Scanner;
import src.main.java.cmh.backend.*;
import java.util.Date;

public class Driver {
    public static void main(String[] args) {
        intializeFakeTrialData();
        Scanner s = new Scanner(System.in);
        while(true){
            clearScreen();
            if(UserInteraction.getCurrentlyLoggedInUser() == null) {
                topMenu(s);
            } else {
                mainMenu(s);
            }
        }
    }
/**
 * Initializes fake trial data for testing purposes.
 * This method creates and initializes various objects such as users, housing units, rooms, guests, and groups.
 */
@SuppressWarnings("unused")
public static void intializeFakeTrialData(){

    Date currentDate = new Date();
    Date futureDate = new Date(currentDate.getTime() + 1000000000);

    User user1 = new User("Peter", "pass", "pheroux001@csbsju.edu", "Peter Heroux", "320-290-1234", true);
    User user2 = new User("John", "word", "john@gmail.com", "John Doe", "320-240-1244", false);
    User user3 = new User("Aidan", "secure", "amath001@csbsju.edu", "Aidan Math", "320-230-1214", true);

    



    HousingUnit unit1 = new HousingUnit("Mary Hall", "MA");
    HousingUnit unit2 = new HousingUnit("Tommy Hall", "T");

    Room room1 = new Room(101, 1, true, true, false, false, true, "1111");
    Room room2 = new Room(102, 4, true, false, true, false, true, "2222");
    Room room3 = new Room(103, 2, true, false, true, true, true, "3333");
    Room room4 = new Room(104, 2, false, false, true, false, true, "4444");
    Room room5 = new Room(105, 2, true, false, true, false, true, "5555");
    Room room6 = new Room(106, 2, true, false, true, false, false, "6666");

    Guest guest1 = new Guest(0, false, "bar", "", currentDate, futureDate);
    Guest guest2 = new Guest(1, false, "foo", "",currentDate, futureDate);
    Guest guest3 = new Guest(0, true, "baz", "", currentDate, futureDate, "extra info");
    Guest guest4 = new Guest(2, false, "qux", "", currentDate,futureDate);

    Group group1 = new Group("Group 1");
    Group group2 = new Group("Group 2");

    group1.addGuest(guest1);
    group1.addGuest(guest2);
    group2.addGuest(guest3);
    group2.addGuest(guest4);

    unit1.addRoom(room1);
    unit1.addRoom(room2);
    unit1.addRoom(room3);

    unit2.addRoom(room4);
    unit2.addRoom(room5);
    unit2.addRoom(room6);

}

	/**
     * From CMC By: Peter Ohmann
	 * Displays the top menu of the Choose My Housing (CMH) application.
	 * Prompts the user to log in with a username and password.
	 * If the login is successful, redirects the user to the main menu.
	 *
	 * @param s the Scanner object used for user input
	 */
	private static void topMenu(Scanner s) {
		printHeader("Welcome to Choose My Housing (CMH)!");
		System.out.println("Please log in.");

		String username = "";
		while (username.isBlank()) {
			System.out.print("Username: ");
			username = s.nextLine();
		}

		System.out.print("Password: ");
		String password = s.nextLine();

		boolean success = UserInteraction.login(username, password);

		if (success)
			System.out.println("Redirecting to main menu.");
	}

    /**
     * Displays the main menu options and performs the corresponding actions based on user input.
     *
     * @param s the Scanner object used for user input
     */
    public static void mainMenu(Scanner s){
        printHeader("Main Menu");
        User user = UserInteraction.getCurrentlyLoggedInUser();
        System.out.println("Hello, " + user.getName() + "!\n\nSelect an option:");
        System.out.println("1. User Tab");
        System.out.println("2. Guest Tab");
        System.out.println("3. Group Tab");
        System.out.println("4. Room Tab");
        System.out.println("5. Housing Unit Tab");
        System.out.print("Enter a number: ");
        int choice = s.nextInt();
        s.nextLine();

        switch (choice) {
            case 1 -> userOptions(s);
            case 2 -> guestOptions(s);
            case 3 -> groupMenu(s);
            case 4 -> roomOptions(s);
            case 5 -> housingUnitOptions(s);
            default -> {
                System.out.println("Invalid choice.");
            }
        }
    }





    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\\
    //----------------------------------------------------------------------------------------------\\
    //                                        USER MENU                                             \\
    //----------------------------------------------------------------------------------------------\\
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\\






    public static void userOptions(Scanner s){
        clearScreen();
        printHeader("User Options");
        System.out.println("1. Create User");
        System.out.println("2. Delete User");
        System.out.println("3. Update User");
        System.out.println("4. View Users");
        System.out.println("5. Get User");
        System.out.println("6. Log Out");
        System.out.println("Leave blank to return to main menu.");

        System.out.print("Enter a number: ");
        int choice = s.nextInt();
        s.nextLine();

        switch (choice) {

            case 1 -> createUser(s);
            case 2 -> deleteUser(s);
            case 3 -> updateUser(s);
            case 4 -> viewUsers();
            //case 5 -> getUser(s);
            case 6 -> UserInteraction.logout();

            default -> {
                System.out.println("Returning to main menu.");
            }
        }
    }

    /**
    * Creates a new user based on user input.
    *
    * @param s the Scanner object used for user input
    */
    public static void createUser(Scanner s){
        clearScreen();
        boolean isAdmin = false;
        printHeader("Create User");
        System.out.print("Enter username: ");
        String username = s.nextLine();
        System.out.print("Enter password: ");
        String password = s.nextLine();
        System.out.print("Enter email: ");
        String email = s.nextLine();
        System.out.print("Enter name: ");
        String name = s.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = s.nextLine();
        System.out.print("Is admin? (true/false): ");
        try{
        isAdmin = s.nextBoolean();
        s.nextLine();
        } catch (Exception e){
            System.out.println("Invalid input. Please enter true or false.");
            sleep(2000);
            s.nextLine();
            createUser(s);
            return;
        }

        boolean success = UserInteraction.createUser(username, password, email, name, phoneNumber, isAdmin);
        if(success){
            System.out.println("User created successfully.");
        } else {
            System.out.println("Failed to create user.");
        }

        returnOptions(s);
    }

    /**
    * Deletes a user based on user input.
    *
    * @param s the Scanner object used for user input
    */
    public static void deleteUser(Scanner s){
        clearScreen();
        printHeader("Delete User");
        System.out.print("Enter username: ");
        String username = s.nextLine();
        boolean success = UserInteraction.deleteUser(username);
        if(success){
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("Failed to delete user.");
        }

        returnOptions(s);
    }

    /**
    * Updates a user's information based on user input.
    *
    * @param s the Scanner object used for user input
    */
    public static void updateUser(Scanner s){
        clearScreen();
        boolean isAdmin = false;
        printHeader("Update User");
        System.out.print("Enter username: ");
        String username = s.nextLine();
        if (UserInteraction.getUser(username) == null){
            System.out.println("User not found. Restarting...");
            sleep(2000);
            updateUser(s);
            return;
        }
        System.out.print("Enter password: ");
        String password = s.nextLine();
        if (password.isBlank()){
            password = UserInteraction.getUser(username).getPassword();
        }
        System.out.print("Enter email: ");
        String email = s.nextLine();
        if (email.isBlank()){
            email = UserInteraction.getUser(username).getEmail();
        }
        System.out.print("Enter name: ");
        String name = s.nextLine();
        if (name.isBlank()){
            name = UserInteraction.getUser(username).getName();
        }
        System.out.print("Enter phone number: ");
        String phoneNumber = s.nextLine();
        if (phoneNumber.isBlank()){
            phoneNumber = UserInteraction.getUser(username).getPhoneNumber();
        }
        System.out.print("Is admin? (true/false): ");
        try{
        isAdmin = s.nextBoolean();
        s.nextLine();
        } catch (Exception e){
            isAdmin = UserInteraction.getUser(username).getIsAdmin();
        }

        boolean success = UserInteraction.updateUser(username, password, email, name, phoneNumber, isAdmin);
        if(success){
            System.out.println("User updated successfully.");
        } else {
            System.out.println("Failed to update user.");
        }

        returnOptions(s);
    }

    /**
    * Displays the list of users and their details.
    */
    public static void viewUsers(){
        clearScreen();
        printHeader("Users");
        for(User user : UserInteraction.viewUsers()){
            System.out.println(user.toString());
            System.out.println("");
        }
        returnOptions(new Scanner(System.in));
    }




    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\\
    //----------------------------------------------------------------------------------------------\\
    //                                        GUEST MENU                                            \\
    //----------------------------------------------------------------------------------------------\\
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\\





    public static void guestOptions(Scanner s){
        clearScreen();
        printHeader("Guest Options");
        System.out.println("1. View Guest");
        System.out.println("2. Add Guest");
        System.out.println("3. Get Guest");
        System.out.println("4. Remove Guest");
        System.out.println("5. Edit Guest");
        System.out.println("6. Add Guest to Room");
        System.out.println("7. Remove Guest from Room");
        System.out.println("8. Check In Guest");
        System.out.println("9. Check Out Guest");
        System.out.println("10. Log Out");
        System.out.println("Leave blank to return to main menu.");

        System.out.print("Enter a number: ");
        int choice = s.nextInt();
        s.nextLine();

        switch (choice) {

            case 1 -> viewGuests();
            //case 2 -> addGuest(s);
            //case 3 -> getGuest(s);
            //case 4 -> removeGuest(s);
            //case 5 -> editGuest(s);
            //case 6 -> addGuestToRoom(s);
            //case 7 -> removeGuestFromRoom(s);
            //case 8 -> checkInGuest(s);
            //case 9 -> checkOutGuest(s);
            case 10 -> UserInteraction.logout();

            default -> {
                System.out.println("Returning to main menu.");
            }
        }
    }

    /**
     * Displays the list of guests and their details.
     */
    public static void viewGuests(){
        clearScreen();
        printHeader("Guests");
        for(Guest guest : UserInteraction.viewGuests()){
            System.out.println(guest.toString());
            System.out.println("");
        }
        returnOptions(new Scanner(System.in));
    }





    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\\
    //----------------------------------------------------------------------------------------------\\
    //                                        GROUP MENU                                            \\
    //----------------------------------------------------------------------------------------------\\
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\\






    public static void groupMenu(Scanner s){
        clearScreen();
        printHeader("Group Options");
        System.out.println("1. View Groups");
        System.out.println("2. Create Group");
        System.out.println("3. Delete Group");
        System.out.println("4. Delete Group and Guests");
        System.out.println("5. Update Group");
        System.out.println("6. Add Guest to Group");
        System.out.println("7. Remove Guest from Group");
        System.out.println("8. Clear Group");
        System.out.println("9. Log Out");
        System.out.println("Leave blank to return to main menu.");

        System.out.print("Enter a number: ");
        int choice = s.nextInt();
        s.nextLine();

        switch (choice) {

            case 1 -> viewGroups();
            //case 2 -> addGroup(s);
            //case 3 -> removeGroup(s);
            //case 4 -> removeGroupAndGuests(s);
            //case 5 -> editGroup(s);
            //case 6 -> addGuestToGroup(s);
            //case 7 -> removeGuestFromGroup(s);
            //case 8 -> clearGroup(s);
            case 9 -> UserInteraction.logout();

            default -> {
                System.out.println("Returning to main menu.");
            }
        }
    }

        /**
     * Displays the list of groups and their details.
     */
    public static void viewGroups(){
        clearScreen();
        printHeader("Groups");
        for(Group group : UserInteraction.viewGroups()){
            group.toStringDetail(group);
            System.out.println("\n\n\n");
        }


        returnOptions(new Scanner(System.in));
    }





    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\\
    //----------------------------------------------------------------------------------------------\\
    //                                        ROOM MENU                                             \\
    //----------------------------------------------------------------------------------------------\\
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\\



    

    public static void roomOptions(Scanner s){
        clearScreen();
        printHeader("Room Options");
        System.out.println("1. Find Room");
        System.out.println("2. Remove Room");
        System.out.println("3. Edit Room");
        System.out.println("4. Add Room");
        System.out.println("5. View Room Database");
        System.out.println("6. Log Out");
        System.out.println("Leave blank to return to main menu.");


        System.out.print("Enter a number: ");
        int choice = s.nextInt();
        s.nextLine();

        switch (choice) {

            case 1 -> viewRoom(s);
            case 2 -> removeRoom(s);
            case 3 -> editRoom(s);
            case 4 -> addRoom(s);
            case 5 -> viewRoomDatabase();
            case 6 -> UserInteraction.logout();

            default -> {
                System.out.println("Returning to main menu.");
            }
        }
    }

    /**
     * Search for a room by room prefix and number.
     */
    public static void viewRoom(Scanner s){
        clearScreen();
        printHeader("View Room");
        System.out.print("Enter room prefix: ");
        String prefix = s.nextLine();
        System.out.print("Enter room number: ");
        int number = s.nextInt();
        s.nextLine();
        Room room = UserInteraction.getRoom(number, prefix); //TODO: swap these parameters in the controller method. 
                                                             // Given the prefix T and room number 232 the params should look 
                                                             // like T232 instead of 232T
        if(room == null){
            System.out.println("Room not found.");
        } else {
            System.out.println(UserInteraction.viewRoom(room.getRoomNumber(), room.getPrefix(), true)); //TODO: Make this output easy to read
        }

        returnOptions(s);
    }

    /**
     * Removes a room from the system.
     */

    public static void removeRoom(Scanner s){
        clearScreen();
        printHeader("Remove Room");
        System.out.print("Enter room prefix: ");
        String prefix = s.nextLine();
        System.out.print("Enter room number: ");
        int number = s.nextInt();
        s.nextLine();
        boolean success = UserInteraction.removeRoom(number, prefix);
        if(success){
            System.out.println("Room removed successfully.");
        } else {
            System.out.println("Failed to remove room.");
        }

        returnOptions(s);
    }

    /**
     * Edits a room's information.
     */

    public static void editRoom(Scanner s){
        clearScreen();
        String currPrefix;
        int currNumber;
        printHeader("Edit Room");
        System.out.print("Enter room prefix: ");
        String prefix = s.nextLine();
        System.out.print("Enter room number: ");
        int number = s.nextInt();
        s.nextLine();
        Room room = UserInteraction.getRoom(number, prefix);
        if(room == null){
            System.out.println("Room not found.");
            returnOptions(s);
            return;
        } else {
            currPrefix = room.getPrefix();
            currNumber = room.getRoomNumber();
        }
        System.out.print("Enter new room prefix: ");
        String newPrefix = s.nextLine();
        System.out.print("Enter new room number: ");
        int newNumber = s.nextInt();
        s.nextLine();
        System.out.print("Enter new capacity: ");
        int capacity = s.nextInt();
        s.nextLine();
        System.out.print("Enter new isOccupied: ");
        boolean isOccupied = s.nextBoolean();
        s.nextLine();
        System.out.print("Enter new isReserved: ");
        boolean isReserved = s.nextBoolean();
        s.nextLine();
        System.out.print("Enter new isHandicap: ");
        boolean isHandicap = s.nextBoolean();
        s.nextLine();
        System.out.print("Enter new isPrivate: ");
        boolean isPrivate = s.nextBoolean();
        s.nextLine();
        System.out.print("Enter new isAvailable: ");
        boolean isAvailable = s.nextBoolean();
        s.nextLine();
        System.out.print("Enter new key: ");
        String key = s.nextLine();
        boolean success = UserInteraction.editRoom(currPrefix, currNumber, newPrefix, newNumber, capacity, isOccupied, isReserved, isHandicap, isPrivate, isAvailable, key);
        if(success){
            System.out.println("Room updated successfully.");
        } else {
            System.out.println("Failed to update room.");
        }

        returnOptions(s);
    }

    /**
     * Adds a room to the system.
     */

    public static void addRoom(Scanner s){
        clearScreen();
        printHeader("Add Room");
        System.out.print("Enter room prefix: ");
        String prefix = s.nextLine();
        System.out.print("Enter room number: ");
        int number = s.nextInt();
        s.nextLine();
        System.out.print("Enter capacity: ");
        int capacity = s.nextInt();
        s.nextLine();
        System.out.print("Enter isOccupied: ");
        boolean isOccupied = s.nextBoolean();
        s.nextLine();
        System.out.print("Enter isReserved: ");
        boolean isReserved = s.nextBoolean();
        s.nextLine();
        System.out.print("Enter isHandicap: ");
        boolean isHandicap = s.nextBoolean();
        s.nextLine();
        System.out.print("Enter isPrivate: ");
        boolean isPrivate = s.nextBoolean();
        s.nextLine();
        System.out.print("Enter isAvailable: ");
        boolean isAvailable = s.nextBoolean();
        s.nextLine();
        System.out.print("Enter key: ");
        String key = s.nextLine();
        boolean success = UserInteraction.addRoom(prefix, number, capacity, isOccupied, isReserved, isHandicap, isPrivate, isAvailable, key);
        if(success){
            System.out.println("Room added successfully.");
        } else {
            System.out.println("Failed to add room.");
        }

        returnOptions(s);
    }

    /**
     * Displays the list of rooms and their details.
     */

    public static void viewRoomDatabase(){
        clearScreen();
        printHeader("Rooms");
        UserInteraction.viewRoomDatabase();
        returnOptions(new Scanner(System.in));
    }





    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\\
    //----------------------------------------------------------------------------------------------\\
    //                                     HOUSING UNIT MENU                                        \\
    //----------------------------------------------------------------------------------------------\\
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\\
 





    public static void housingUnitOptions(Scanner s){
        clearScreen();
        printHeader("Housing Unit Options");
        System.out.println("1. View Housing Units");
        System.out.println("2. Create Housing Unit");
        System.out.println("3. Delete Housing Unit");
        System.out.println("4. Update Housing Unit");
        System.out.println("5. Get Housing Unit");
        System.out.println("6. Log Out");
        System.out.println("Leave blank to return to main menu.");

        System.out.print("Enter a number: ");
        int choice = s.nextInt();
        s.nextLine();

        switch (choice) {
            case 1 -> viewHousingUnits();
            //case 2 -> addHousingUnit(s);
            //case 3 -> removeHousingUnit(s);
            //case 4 -> editHousingUnit(s);
            //case 5 -> getHousingUnit(s); TODO: add getHousingUnit to HousingUnitController; currently not implemented
            case 6 -> UserInteraction.logout();

            default -> {
                System.out.println("Returning to main menu.");
            }
        }
    }

    /**
     * Displays the details of all housing units.
     */
    public static void viewHousingUnits(){
        clearScreen();
        printHeader("Housing Units");
        for(HousingUnit unit : UserInteraction.getHousingUnits()){
            System.out.println(unit.toStringDetail());
        }

        returnOptions(new Scanner(System.in));
    }

    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\\
    //----------------------------------------------------------------------------------------------\\
    //                                       HELPER METHODS                                         \\
    //----------------------------------------------------------------------------------------------\\
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\\


	/**
     * From CMC By: Peter Ohmann
	 * Prints a header with a given title.
	 * 
	 * @param title the title of the header
	 */
	private static void printHeader(String title) {
		String dashes = "";
		for (int i = 0; i < title.length(); i++) {
			dashes += "-";
        }
		System.out.println(dashes);
		System.out.println(title);
		System.out.println(dashes);
    }

    /**
     * Clears the console screen.
     */
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the return options for the user.
     *
     * @param s the Scanner object used for user input
     */
    public static void returnOptions(Scanner s){
        System.out.println("\n\n\n");
        System.out.println("1. Return to main menu");
        System.out.println("2. Log out");
        System.out.print("Enter a number: ");
        int choice = s.nextInt();
        s.nextLine();
        if(choice == 1){
            return;
        } else if(choice == 2){
            UserInteraction.logout();
        } else {
            System.out.println("Invalid choice... returning to main menu.");
            sleep(2000);
        }
    }
}


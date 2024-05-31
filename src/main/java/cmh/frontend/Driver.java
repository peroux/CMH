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
        System.out.println("1. View Housing Units");
        System.out.println("2. View Groups");
        System.out.println("3. View Guests");
        System.out.println("4. View Users");
        System.out.println("5. Create User");
        System.out.println("6. Delete User");
        System.out.println("7. Update User");
        System.out.println("8. Log Out");

        System.out.print("Enter a number: ");
        int choice = s.nextInt();
        s.nextLine();

        switch (choice) {
            case 1 -> viewHousingUnits();
            case 2 -> viewGroups();
            case 3 -> viewGuests();
            case 4 -> viewUsers();
            case 5 -> createUser(s);
            case 6 -> deleteUser(s);
            case 7 -> updateUser(s);
            case 8 -> UserInteraction.logout();
            default -> System.out.println("Invalid choice.");
        }
    }

    /**
     * Displays the details of all housing units.
     */
    public static void viewHousingUnits(){
        clearScreen();
        printHeader("Housing Units");
        for(HousingUnit unit : UserInteraction.getHousingUnits()){
            unit.toStringHousingDetail(unit);
        }
        returnOptions(new Scanner(System.in));
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
            System.out.println("Press enter to continue.");
            s.nextLine();
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
            System.out.println("User not found.");
            returnOptions(s);
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
        }
    }
}


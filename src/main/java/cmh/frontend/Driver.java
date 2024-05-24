package src.main.java.cmh.frontend;

import java.util.Scanner;
import src.main.java.cmh.backend.*;

public class Driver {
    public static void main(String[] args) {
        intializeFakeTrialData();
        while(true){
            Scanner s = new Scanner(System.in);
            if(UserInteraction.getCurrentlyLoggedInUser() == null) {
                topMenu(s);
            } else {
                mainMenu(s);
            }
        }
    }
public static void intializeFakeTrialData(){
    User user1 = new User("Peter", "pass", "pheroux001@csbsju.edu", "Peter Heroux", "320-290-1234", true);
    User user2 = new User("John", "word", "john@gmail.com", "John Doe", "320-240-1244", false);
    User user3 = new User("aidan", "secure", "amath001@csbsju.edu", "Aidan Math", "320-230-1214", true);

    



    HousingUnit unit1 = new HousingUnit("Mary Hall");
    HousingUnit unit2 = new HousingUnit("Tommy Hall");

    Room room1 = new Room(101, 2, true, false, true, false, true, "1111");
    Room room2 = new Room(102, 2, true, false, true, false, true, "2222");
    Room room3 = new Room(103, 2, true, false, true, false, true, "3333");
    Room room4 = new Room(104, 2, true, false, true, false, true, "4444");
    Room room5 = new Room(105, 2, true, false, true, false, true, "5555");
    Room room6 = new Room(106, 2, true, false, true, false, true, "6666");

    Guest guest1 = new Guest(0, false, "bar", "");
    Guest guest2 = new Guest(1, false, "foo", "");
    Guest guest3 = new Guest(0, true, "baz", "", "I am a goofy member");
    Guest guest4 = new Guest(2, false, "qux", "");

    Group group1 = new Group();
    Group group2 = new Group();

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
            case 1:
                //viewHousingUnits();
                break;
            case 2:
                //viewGroups();
                break;
            case 3:
                //viewGuests();
                break;
            case 4:
                //viewUsers();
                break;
            case 5:
                //createUser(s);
                break;
            case 6:
                //deleteUser(s);
                break;
            case 7:
                //updateUser(s);
                break;
            case 8:
                UserInteraction.logout();
                break;
            default:
                System.out.println("Invalid choice.");
        }
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
}


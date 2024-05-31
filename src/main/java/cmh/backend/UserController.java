package src.main.java.cmh.backend;

public class UserController {

    /**
     * Logs in a user with the given username and password.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return the user if the login was successful, null otherwise
     */
    public static User login(String username, String password) { //this method may be going elsewhere when we add SQL
        for (User user : User.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Creates a new user with the given information.
     *
     * @param username     the username of the user
     * @param password     the password of the user
     * @param email        the email of the user
     * @param name         the name of the user
     * @param phoneNumber  the phone number of the user
     * @param isAdmin      true if the user is an admin, false otherwise
     * @return true if the user was successfully created, false otherwise
     */
    public static boolean createUser(String username, String password, String email, String name, String phoneNumber, boolean isAdmin) {
            User newUser = new User(username, password, email, name, phoneNumber, isAdmin);
            return newUser != null;
        }
    

    /**
     * Deletes a user with the specified username.
     *
     * @param username the username of the user to be deleted
     * @return true if the user was successfully deleted, false otherwise
     */
    public static boolean deleteUser(String username) {
            for (User user : User.getUsers()) {
                if (user.getUsername().equals(username)) {
                    User.getUsers().remove(user);
                    return true;
                }
            }
            return false;
        }
    

    /**
     * Updates the user with the specified username.
     *
     * @param username    the username of the user to update
     * @param password    the new password for the user
     * @param email       the new email for the user
     * @param name        the new name for the user
     * @param phoneNumber the new phone number for the user
     * @param isAdmin     the new admin status for the user
     * @return true if the user was successfully updated, false otherwise
     */
    public static boolean updateUser(String username, String password, String email, String name, String phoneNumber, boolean isAdmin) {
            for (User user : User.getUsers()) {
                if (user.getUsername().equals(username)) {
                    user.setPassword(password);
                    user.setEmail(email);
                    user.setName(name);
                    user.setPhoneNumber(phoneNumber);
                    user.setIsAdmin(isAdmin);
                    return true;
                }
            }
            return false;
        }


}

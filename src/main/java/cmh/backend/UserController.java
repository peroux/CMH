package src.main.java.cmh.backend;

public class UserController {

    public static User login(String username, String password) { //this method may be going elsewhere when we add SQL
        for (User user : User.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static boolean createUser(String username, String password, String email, String name, String phoneNumber, boolean isAdmin) {
            User newUser = new User(username, password, email, name, phoneNumber, isAdmin);
            return newUser != null;
        }
    

    public static boolean deleteUser(String username) {
            for (User user : User.getUsers()) {
                if (user.getUsername().equals(username)) {
                    User.getUsers().remove(user);
                    return true;
                }
            }
            return false;
        }
    

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

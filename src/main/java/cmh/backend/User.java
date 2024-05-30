package src.main.java.cmh.backend;

import java.util.ArrayList;
import java.util.List;

public class User{
    private String username;
    private String password;
    private String email;
    private String name;
    private String phoneNumber;
    private boolean isAdmin;
    private static List<User> users = new ArrayList<User>();

    public User(String username, String password, String email, String name, String phoneNumber, boolean isAdmin){
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
        users.add(this);
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public boolean getIsAdmin(){
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }

    public static List<User> getUsers(){
        return users;
    }

    public static void setUsers(List<User> users){
        User.users = users;
    }

    public static User getUser(String username){
        for (User user : users){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public String toString(){
        return "Username: " + this.username + "\nPassword: " + this.password + "\nEmail: " + this.email + "\nName: " + this.name + "\nPhone Number: " + this.phoneNumber + "\nIs Admin: " + this.isAdmin;
    }

}
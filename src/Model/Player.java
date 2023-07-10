package Model;

import java.util.Date;
import java.util.logging.Logger;

public class Player {

    private String username;
    private String password;
    private String phoneNumber;
    private String eMail;
    private boolean gender;
    private int age;

    public Player() {
    }

    public Player(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public Player(String username, String password, String phoneNumber, String eMail, boolean gender, int age) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Player{" + "username=" + username + ", password=" + password + ", phoneNumber=" + phoneNumber + ", eMail=" + eMail + ", gender=" + gender + ", age=" + age + '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}

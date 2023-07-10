package View;

import Model.Player;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class ViewController {

    int size = 1;
    
    public ViewController() {

    }

    public boolean validateEmail(String email) {

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);

        boolean isValid = pattern.matcher(email).matches();

        if (!isValid) {
            JOptionPane.showMessageDialog(null, "The email you have entered is not valid");
        }

        return isValid;
    }

    //Validate date of birth by checking if the age is above 12 years old
    public boolean validateDateOfBirth(Date date) {

        boolean isValid = true;

        try {
            Calendar now = Calendar.getInstance();
            Calendar dob = Calendar.getInstance();
            dob.setTime(date);

            int years = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
            if (dob.get(Calendar.DAY_OF_YEAR) > now.get(Calendar.DAY_OF_YEAR)) {
                years--;
            }

            if (years < 12) {
                isValid = false;
                JOptionPane.showMessageDialog(null, "You are too young to play the game");
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Date is missing, please enter a date");
            isValid = false;
        }

        return isValid;
    }

    //Validate phone number by checking if valid phone codes are used, and correct length is given
    public boolean validatePhoneNumber(String phoneNumber) {
        boolean isValid = false;
        phoneNumber = phoneNumber.replaceAll("\\s", ""); // remove all spaces
        if (phoneNumber.matches("^(\\+27|27|0)\\d{9}$")) {
            isValid = true;
            return true;
        } else {

            isValid = false;
        }

        if (!isValid) {
            JOptionPane.showMessageDialog(null, "Your number is incorrect, please enter a correct number, make sure of the length and the country codes");
        }
        return isValid;
    }

    //Check if valid password is entered, this method checks if password is of correct length,
    //has enough characters, includes special characters and numbers
    public boolean validatePassword(String password) {

        int length = password.length();
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;

        if (length >= 10) {
            for (int i = 0; i < length; i++) {
                char c = password.charAt(i);
                if (Character.isUpperCase(c)) {
                    hasUpperCase = true;
                } else if (Character.isLowerCase(c)) {
                    hasLowerCase = true;
                } else if (!Character.isLetterOrDigit(c)) {
                    hasSpecialChar = true;
                }
            }
            return hasUpperCase && hasLowerCase && hasSpecialChar;

        }

        if (!(hasUpperCase && hasLowerCase && hasSpecialChar)) {
            JOptionPane.showMessageDialog(null, "Your password is incorrect, please check spesifications, and re-enter a new password");
        }

        return false;
    }
    //Validates the username
    public boolean validateUsername(String username) {
        boolean isValid = true;

        //Validating if input is given(Presence check)
        if (username.isEmpty()) {

            JOptionPane.showMessageDialog(null, "You have not entered the username, please enter a valid username.");
            isValid = false;
        }
        //Validate if Username is in suitable range (Range check)  
        if (username.length() > 13) {
            JOptionPane.showMessageDialog(null, "The username cannot exceed 13 characters");
            isValid = false;
        }
        return isValid;
    }

    public boolean checkOverallValidation(boolean username, boolean password, boolean email, boolean phoneNumber, boolean date, boolean gender) {

        boolean isValid = username && password && email && phoneNumber && date && gender;

        if (isValid) {

            JOptionPane.showMessageDialog(null, "Your login was succesful");
            
            
        }
        return isValid;
    }
    
        
    public void writeToFile(String username, String password, String phoneNumber, String email, boolean gender, int age) {
        Player player = new Player(username, password, phoneNumber, email, gender, age);
        
        try {
            FileWriter writer = new FileWriter("Players.txt", true);
            BufferedWriter bWriter = new BufferedWriter(writer);
            bWriter.write("" + username + "§" + password + "§" + phoneNumber + "§" + email + "§" + age + "\n");
            bWriter.close();
            writer.close();
            
            
        } catch (IOException e) {
            System.out.println("Error with writing to file");
        }
    
    }
    
    public Player[] playersFromTxtFileToArray() {
        String username, password;
        int count = 0;
        
        Player[] PlayersArr = new Player[1];
        
        try {
            Scanner ScFile = new Scanner(new File("Players.txt"));
            
            while (ScFile.hasNextLine()) {
                String next = ScFile.nextLine();
                
                Scanner ScLine = new Scanner(next).useDelimiter("§");
                username = ScLine.next(); 
                password = ScLine.next();
                ScLine.close();
                
                PlayersArr[count] = new Player(username, password);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error" + e);
        }
        
        
        return PlayersArr;
    }

    public boolean validateSignUp(String username, String password, Player[] PlayersArr) {
        
        for (int i = 0; i < PlayersArr.length; i++) {
            if (PlayersArr[i].getUsername().equals(username) && PlayersArr[i].getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
 
    public String printArr(Player[] PlayerArr) {
        String temp = "";
        
        for (int i = 0; i < PlayerArr.length; i++) {
            temp += PlayerArr[i].toString() + "\n";
            
        }
        
        
        return temp;
    }

    private javax.swing.JButton jButtonLogin;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JRadioButton jRadioFemale;
    private javax.swing.JRadioButton jRadioMale;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextPhoneNumber;
    private javax.swing.JTextField jTextUsername;
}

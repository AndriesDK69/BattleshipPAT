
package View;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;



public class ViewController {

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
         
         //Validate dob
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
    
    //Check if valid password
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
        
        public void checkOverallValidation(boolean username, boolean password, boolean email, boolean phoneNumber, boolean date, boolean gender) {

        boolean isValid = username && password && email && phoneNumber && date && gender;

        if (isValid) {

            JOptionPane.showMessageDialog(null, "Your login was succesfull");

        }

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

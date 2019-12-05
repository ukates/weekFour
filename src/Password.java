/*

   Derrick Cates
   Bellevue University
   CIS 402A-305J
   November 30, 2019

   The purpose of this program is to create an application
   called Password, that accepts a user input as a password
   and requires that input to be between 6 and 10 characters
   and include at least one character and number.  The program
   should also verify the correct password after one has been
   selected by asking to re enter the original password and
   not continue unless the re entry matches the original password.

*/
//import JOptionPane
import javax.swing.JOptionPane;
//create password class
public class Password {
    //main method
    public static void main(String[] args) {
        //declare password variables
        String pass;
        String confirm;
        //assign pass with JOption pane dialog boxes
        pass = JOptionPane.showInputDialog(null,
            "Please enter a valid password: ", "Login",
            JOptionPane.INFORMATION_MESSAGE);
        //call check password function in while loop
        while(!checkPassword(pass)) {
            //will loop and ask for re-entry until password meets requirements
            pass = JOptionPane.showInputDialog(null,
                "***YOUR ENTRY WAS INVALID***\n\nPasswords Requirements:" +
                    "\n    Have 6 to 10 characters\n    Contain letters and " +
                    "numbers\n\nPlease enter a valid password: ", "Login",
                JOptionPane.INFORMATION_MESSAGE);
        }
        //assign re entered password to confirm variable
        confirm = JOptionPane.showInputDialog(null,
            "To confirm that our information is correct, " +
                "please re-enter your password: ",
            "Login: Re-Enter Password", JOptionPane.INFORMATION_MESSAGE);
        //will call confirm password method in while loop
        while(!confirmPassword(pass, confirm)) {
            //continue to prompt for correct password until re entry matches original
            confirm = JOptionPane.showInputDialog(null,
                "The password you have re-entered does not match your" +
                    " original password.\n\nPlease re-enter your original password: ",
                "Login: Re-Enter Password", JOptionPane.INFORMATION_MESSAGE);
        }
        //display access granted window
        JOptionPane.showMessageDialog(null, "   ***ACCESS" +
            " GRANTED***", "You got in!", JOptionPane.INFORMATION_MESSAGE);
    }
    //method for checking password
    private static boolean checkPassword(String str) {
        //check if more than 6 less than 10 characters
        if (str.length() < 6 || str.length() > 10) {
            return false;
        }
        //variables for has digit and char
        boolean hasDigit = false;
        boolean hasChar = false;
        //loop through string to check for digits
        for(int x = 0; x < str.length(); x++) {
            //if string has a digit, will break and assign hasDigit true
            if(Character.isDigit(str.charAt(x))) {
                hasDigit = true;
                break;
            }
        }
        //if string has char, will break and assign hasChar true
        for(int y = 0; y < str.length(); y++) {
            if(Character.isLetter(str.charAt(y))) {
                hasChar = true;
                break;
            }
        }
        //return true if haschar and hasdigit true / false if not
        return hasDigit && hasChar;
    }
    //method to check if strings equal
    private static boolean confirmPassword(String inputOne, String inputTwo) {
        //will return true if input 1 and 2 are equal
        return(inputOne.equals(inputTwo));
    }
}

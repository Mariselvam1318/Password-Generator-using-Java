import java.util.*;
import java.util.Random;

public class Passwordgenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Password Services..\n");
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit\n"); 
        while(true){
            System.out.println("Enter Your Choice :");
            int ch = sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Hello, welcome to the Password Generator :) answer the following questions by Yes or No ");
                    passwordgen(sc);
                    break;
                case 2:
                    System.out.println("Enter Your Password:");
                    sc.nextLine();
                    String password =sc.nextLine();
                    String strengthmsg = checkPwdStrength(password);
                    System.out.println(strengthmsg); 
                    break;
                case 3:
                    System.out.println("1.Length: Longer passwords are stronger.\n"+//
                                       "2.Complexity: Include a mix of uppercase and lowercase letters, numbers, and special symbols.\n" + //
                                       "3.Randomness: Avoid easily guessable patterns or common words.\n" + //
                                       "4.Unique: Use different passwords for each account.\n" + //
                                       "5.Regular Updates: Change passwords periodically.\n" + //
                                       "6.Two-Factor Authentication: Enable 2FA for added security.\n" + //
                                       "7.Avoid Phishing: Be cautious of suspicious emails or websites requesting passwords.\n");
                    break;
                case 4:
                    System.out.println("Quiting the Program Password services!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid choice!!");
                    break;
                                           
            }
        }
    }
    
    static void passwordgen(Scanner sc){
        System.out.print("Include lowercase letters? (yes/no): \n");
        boolean lowercase = sc.next().equalsIgnoreCase("yes");
        
        System.out.print("Include uppercase letters? (yes/no): \n");
        boolean uppercase = sc.next().equalsIgnoreCase("yes");
        
        System.out.print("Include numbers? (yes/no): \n");
        boolean numbers = sc.next().equalsIgnoreCase("yes");
        
        System.out.print("Include symbols? (yes/no): \n");
        boolean symbols = sc.next().equalsIgnoreCase("yes");
        
        System.out.print("Enter the length of the password: \n");
        int length = sc.nextInt();
    
        String password = generatePassword(lowercase, uppercase, numbers, symbols, length);
        
        System.out.println("Generated Password: " + password+"\n");
    }
    
    private static String generatePassword(boolean lowercase, boolean uppercase, boolean numbers, boolean symbols, int length) {
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String symbolChars = "!@#$%^&*()-_=+[{]}|;:,<.>/?";
        
        String pwd = "";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
    
        if (lowercase) {
            pwd += lowercaseChars;
        }
        if (uppercase) {
            pwd += uppercaseChars;
        }
        if (numbers) {
            pwd += numberChars;
        }
        if (symbols) {
            pwd += symbolChars;
        }
        
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(pwd.length());
            password.append(pwd.charAt(randomIndex));
        }
        
        return password.toString();
    }
    public static String checkPwdStrength(String password) {
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;
        
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (ch >= 65 && ch <= 90) { 
                hasUppercase = true;
            } else if (ch >= 97 && ch <= 122) { 
                hasLowercase = true;
            } else if (ch >= 48 && ch <= 57) { 
                hasDigit = true;
            } else { 
                hasSymbol = true;
            }
        }
        int score = 0;
        if (hasUppercase) score++;
        if (hasLowercase) score++;
        if (hasDigit) score++;
        if (hasSymbol) score++;
        if (password.length() >= 8) score++;
        if (password.length() >= 16) score++;
        if (score == 6) {
            return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines\n";
        } else if (score >= 4) {
            return "This is a good password :) but you can still do better\n";
        } else if (score >= 3) {
            return "This is a medium password :/ try making it better\n";
        } else {
            return "This is a weak password :( definitely find a new one\n";
        }
    }
}

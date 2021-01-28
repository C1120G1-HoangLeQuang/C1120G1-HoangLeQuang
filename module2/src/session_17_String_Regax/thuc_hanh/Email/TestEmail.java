package session_17_String_Regax.thuc_hanh.Email;

import session_17_String_Regax.thuc_hanh.Email.CheckEmail;

public class TestEmail {
    private static CheckEmail checkEmail;
    public static final String[] validEmail = new String[] {"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com"};
    public static final String[] invalidEmail = new String[] {"@gmail.com", "ab@gmail.", "@#abc@gmail.com" };

    public static void main(String[] args) {
        checkEmail = new CheckEmail();
        for (String email : validEmail) {
            boolean isValid = checkEmail.validate(email);
            System.out.println("Email: " + email + " is valid: " + isValid);
        }
        for (String email : invalidEmail) {
            boolean isValid = checkEmail.validate(email);
            System.out.println("Email: " + email + " is valid: " + isValid);
        }
    }
}

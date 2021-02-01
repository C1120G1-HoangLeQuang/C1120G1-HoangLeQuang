package Regex.CustomerRegex;

import Exception.CustomerException.CustomerException;
import Exception.CustomerException.EmailException;

import java.util.regex.Pattern;

public class EmailRegex {
    public static boolean checkEmail(String email) {
        try {
            if (!Pattern.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", email)) {
                throw new CustomerException("Information is not correct by format(abc@abc.abc)");
            }
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        return Pattern.matches("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", email);
    }
}

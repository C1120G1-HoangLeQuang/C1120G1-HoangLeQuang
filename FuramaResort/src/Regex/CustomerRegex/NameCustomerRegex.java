package Regex.CustomerRegex;

import Exception.CustomerException.CustomerException;
import java.util.regex.Pattern;

public class NameCustomerRegex {
    public static boolean checkNameCustomer(String nameCustomer) {
        try {
            if (!Pattern.matches("^[A-Z][a-z]{0,}[\\s|-]?[A-Z][a-z]{0,}[\\s|-]?([A-Z][a-z]{0,})?([\\s|-]?([A-Z][a-z]{0,})?)([\\s|-]?([A-Z][a-z]{0,})?)$", nameCustomer)) {
                throw new CustomerException("The first letter of the last name, middle name and first name is not capitalized");
            }
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        return Pattern.matches("^[A-Z][a-z]{0,}[\\s|-]?[A-Z][a-z]{0,}[\\s|-]?([A-Z][a-z]{0,})?([\\s|-]?([A-Z][a-z]{0,})?)([\\s|-]?([A-Z][a-z]{0,})?)$", nameCustomer);
    }
}

package Validate;

import java.util.regex.Pattern;

public class NameCustomerRegex {
    public static boolean nameCustomer(String nameCustomer) {
        if (!Pattern.matches("^[A-Z][a-z]{0,}[\\s|-]?[A-Z][a-z]{0,}[\\s|-]?([A-Z][a-z]{0,})?([\\s|-]?([A-Z][a-z]{0,})?)([\\s|-]?([A-Z][a-z]{0,})?)$", nameCustomer)) {
            System.out.println("The first letter of the last name, middle name and first name is not capitalized");
        }
        return Pattern.matches("^[A-Z][a-z]{0,}[\\s|-]?[A-Z][a-z]{0,}[\\s|-]?([A-Z][a-z]{0,})?([\\s|-]?([A-Z][a-z]{0,})?)([\\s|-]?([A-Z][a-z]{0,})?)$", nameCustomer);
    }
}

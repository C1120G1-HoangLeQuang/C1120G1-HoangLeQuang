package common;

import java.util.regex.Pattern;

public class CustomerRegex {
    public static boolean checkIdCustomer(String idCustomer) {
        try {
            if (!Pattern.matches("^KH-[0-9]{4}$", idCustomer)) {
               throw new CustomerException ("Information is not correct by format(KH-XXXX)");
            }
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        return Pattern.matches("^KH-[0-9]{4}$", idCustomer);
    }
}

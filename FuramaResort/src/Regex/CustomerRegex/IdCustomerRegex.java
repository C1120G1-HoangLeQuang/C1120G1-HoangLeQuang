package Regex.CustomerRegex;

import Exception.CustomerException.CustomerException;
import Exception.CustomerException.IdCustomerException;

import java.util.regex.Pattern;

public class IdCustomerRegex {
    public static boolean checkIdCustomer(int idCustomer)  {
        String idCustomerConvert = Integer.toString(idCustomer);
        try {
            if (!Pattern.matches("^[\\d]{9}$", idCustomerConvert)) {
                throw new CustomerException("Information is not correct by format(XXXXXXXXX)");
            }
        }catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        return Pattern.matches("^[\\d]{9}$", idCustomerConvert);
    }
}

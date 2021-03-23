package common;

import java.util.regex.Pattern;

public class ServiceRegex {
    public static boolean checkIdService(String idService) {
        try {
            if (!Pattern.matches("^DV-[0-9]{4}$", idService)) {
               throw new CustomerException("Information is not correct by format(DV-XXXX)");
            }
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
        }
        return Pattern.matches("^DV-[0-9]{4}$", idService);
    }
}

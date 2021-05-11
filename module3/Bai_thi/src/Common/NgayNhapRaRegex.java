package Common;

import java.util.regex.Pattern;

public class NgayNhapRaRegex {
    public static boolean ngayNhapRa(String ngay) {
        if (!Pattern.matches("^((0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/(190[1-9]|19[1-9]\\d|2\\d{3}))$", ngay)) {
            System.out.println("Ngay is not correct format(dd/mm/yyyy)");
        }
        return Pattern.matches("^((0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/(190[1-9]|19[1-9]\\d|2\\d{3}))$", ngay);
    }
}

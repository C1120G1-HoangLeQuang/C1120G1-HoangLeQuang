package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String REGEX_MA_NHANVIEN = "$KH-[0-9]{4}$";
    private static final String REGEX_CMND = "^[\\d]{9}$";
    private static final String REGEX_NGAYSINH = "^((0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/(190[1-9]|19[1-9]\\d|2\\d{3}))$";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public static void checkIdCustomer(String idCustomer) throws CustomerException {
        pattern = Pattern.compile(REGEX_MA_NHANVIEN) ;
        matcher = pattern.matcher(idCustomer);
        if(!matcher.find()) throw new CustomerException ("Information is not correct by format(KH-XXXX)");
    }

    public static void checkIdCard(String idCard)  throws IdCardException{
        pattern = Pattern.compile(REGEX_CMND) ;
        matcher = pattern.matcher(idCard);
        if(!matcher.find()) throw new IdCardException("Information is not correct by format(XXXXXXXXX)");
    }

    public static void checkDate(String date) throws DateException{
        pattern = Pattern.compile(REGEX_NGAYSINH) ;
        matcher = pattern.matcher(date);
        if(!matcher.find()) throw new DateException("Information is not correct by format(dd/mm/yyyy)");
    }

    public static void checkEmail(String email) throws EmailException {
        pattern = Pattern.compile(REGEX_EMAIL) ;
        matcher = pattern.matcher(email);
        if(!matcher.find()) throw new EmailException("Information is not correct by format(abc@abc.abc)");
    }
}

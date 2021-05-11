package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String REGEX_MA_NHANVIEN = "^(PT-)\\d{3}$";
    private static final String REGEX_CMND = "^[\\d]{9}$";
    private static final String REGEX_NGAYSINH = "^((0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/(190[1-9]|19[1-9]\\d|2\\d{3}))$";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String REGEX_NAME = "^[A-Z][a-z]{0,}[\\s|-]?[A-Z][a-z]{0,}[\\s|-]?([A-Z][a-z]{0,})?([\\s|-]?([A-Z][a-z]{0,})?)([\\s|-]?([A-Z][a-z]{0,})?)$";
    private static final String REGEX_PRICE = "^([1]{1,}[0]{1,}[0-9])$";
    private static final String REGEX_STOCK = "^([1]{1,}[0-9])$";

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

    public static void checkPrice(double price) throws PriceException {
        String priceParse = Double.toString(price);
        pattern = Pattern.compile(REGEX_PRICE) ;
        matcher = pattern.matcher(priceParse);
        if(!matcher.find()) throw new PriceException("Number have to be bigger than 100");
    }

    public static void checkStock(int stock) throws StockException {
        String stockParse = Integer.toString(stock);
        pattern = Pattern.compile(REGEX_STOCK) ;
        matcher = pattern.matcher(stockParse);
        if(!matcher.find()) throw new StockException("The first letter of the last name, middle name and first name is not capitalized");
    }
}

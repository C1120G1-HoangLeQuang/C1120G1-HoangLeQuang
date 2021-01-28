package session_17_String_Regax.bai_tap.TelephoneNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckTelephoneNumber {
    private static final String TELEPHONE_REGEX = "^\\([\\d]{2}\\)-\\([0][\\d]{9}\\)$";

    public CheckTelephoneNumber() {
    }
    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(TELEPHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

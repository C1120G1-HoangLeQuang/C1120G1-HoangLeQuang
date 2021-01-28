package session_17_String_Regax.bai_tap.ClassName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckClass {
    public static final String CLASS_REGEX = "^[CAP][\\d]{4}[GHIKLM]$";

    public CheckClass() {
    }
    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

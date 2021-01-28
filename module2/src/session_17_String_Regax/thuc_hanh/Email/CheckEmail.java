package session_17_String_Regax.thuc_hanh.Email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEmail {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public CheckEmail() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

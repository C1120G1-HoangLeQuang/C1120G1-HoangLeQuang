package session_17_String_Regax.thuc_hanh.Account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckAccount {
    private static final String ACCOUNT_REGEX = "^[a-z0-9]{6,}$";

    public CheckAccount() {
    }
    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

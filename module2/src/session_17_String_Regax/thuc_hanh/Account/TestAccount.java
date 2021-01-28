package session_17_String_Regax.thuc_hanh.Account;

public class TestAccount {
    private static CheckAccount checkAccount;
    public static final String[] validAccount = new String[] {"123abc_", "_abc123", "______", "123456","abcdefgh"};
    public static final String[] inValidAcc = new String[] {".@", "12345", "1234_", "abcde"};

    public static void main(String[] args) {
        checkAccount = new CheckAccount();
        for (String account : validAccount) {
            boolean isValid = checkAccount.validate(account);
            System.out.println("Account: " + account + " is valid: " + isValid);
        }
        for (String account : inValidAcc) {
            boolean isValid = checkAccount.validate(account);
            System.out.println("Account: " + account + " is valid: " + isValid);
        }
    }
}

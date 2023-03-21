package socialmedia;
import java.util.*;



public class Account{
    public static final HashMap<Integer, Account> account_map = new HashMap<>();
    public static final HashMap<String, Integer> id_map = new HashMap<>();
    static int account_id;
    static String handle;
    static String account_description;
    static int account_popularity;
    static boolean account_most_pop;

    public Account(int account_id, String handle, String account_description, int account_popularity) {
        this.account_id = account_id;
        this.handle = handle;
        this.account_description = account_description;
        this.account_popularity = account_popularity;
        this.account_most_pop = account_most_pop;
    }

    public static int getAccount_id() {return account_id;}
    public static String getHandle() {return handle;}
    public static String getAccount_description() {return account_description;}
    public static int getAccount_popularity() {return account_popularity;}
    public static boolean getAccount_most_pop() {return account_most_pop;}

    public String toString() {
        return ("Account ID: " + getAccount_id()
                + ".\n Account Handle: " + getHandle()
                + ".\n Account Description: " + getAccount_description()
                + ".\n Account Popularity: " + getAccount_popularity()
                + ".\nThis is the Most Popular Account: " + getAccount_most_pop());
    }

    public static Account createAccount(String handle) {
        Account output_account
                = new Account(1, handle," ", 0) ;
        return output_account;
    }
    

}

class Original_Post {

}

package socialmedia;
import java.util.*;



public class Account{
    public static final HashMap<Integer, Account> account_map = new HashMap<>();
    public static final HashMap<String, Integer> id_map = new HashMap<>();
    int account_id;
    String handle;
    String account_description;
    int account_popularity;
    int postNumber;
    boolean account_most_pop;

    public Account(int account_id, String handle, String account_description, int account_popularity) {
        this.account_id = account_id;
        this.handle = handle;
        this.account_description = account_description;
        this.account_popularity = account_popularity;
        this.account_most_pop = account_most_pop;
        this.postNumber = postNumber;
    }

    public int getAccount_id() {return account_id;}
    public String getHandle() {return handle;}
    public String getAccount_description() {return account_description;}
    public int getAccount_popularity() {return account_popularity;}
    public int getPostCount() {return postNumber;}
    public boolean getAccount_most_pop() {return account_most_pop;}

    public String toString() {
        return ("ID: " + getAccount_id()
                + ".\n Handle: " + getHandle()
                + ".\n Description: " + getAccount_description()
                + ".\n Post Count: " + getPostCount()
                + ".\n Endorse Count: " + getAccount_popularity());
    }

    public static Account makeAccount(int id, String handle) {
        Account output_account
                = new Account(id, handle," ", 0) ;
        return output_account;
    }
    public static void main(String[] args)
    {
        Account output1 = makeAccount(1, "Hat");
        Account output2 = makeAccount(2, "Coat");
        //output1 = makeAccount(1, "Hat");
        account_map.put(1, output1);
        //output2 = makeAccount(2, "Coat");
        account_map.put(2, output2);
        account_map.get(2).account_popularity = 4;
        //System.out.println(account_map);
        //Object accountArray = account_map.values().toArray(new Account[0]);
        //System.out.println(accountArray);
        int max = 0;
        int maxKey = 0;
        System.out.println(account_map.get(3));
    }

}

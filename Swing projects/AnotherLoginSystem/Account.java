package AnotherLoginSystem;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Account {
    static String firstName;
    static String lastName;
    static String cellNumber;
    static String email;
    static String password;
    static Account account;
    Account(String firstName, String lastName, String cellNumber, String email, String password){
        Account.firstName = firstName;
        Account.lastName = lastName;
        Account.cellNumber = cellNumber;
        Account.email = email;
        Account.password = password;

    }

    public static void saveAccount(String firstName, String lastName, String cellNumber, String email, String password){
        try {
            FileOutputStream fos = new FileOutputStream("account.dat");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            AccountStorage accountData = new AccountStorage();

            Account account = new Account(firstName, lastName, cellNumber, email, password);
            accountData.firstNameAccount = account.firstName;
            accountData.lastNameAccount = account.lastName;
            accountData.cellNumberAccount = account.cellNumber;
            accountData.emailAccount = account.email;
            accountData.passwordAccount = account.password;

            oos.writeObject(accountData);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadAccount(){
        try {
            FileInputStream fis = new FileInputStream("account.dat");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            AccountStorage accountData = (AccountStorage)ois.readObject();
            account.firstName = accountData.firstNameAccount;
            account.lastName = accountData.lastNameAccount;
            account.cellNumber = accountData.cellNumberAccount;
            account.email = accountData.emailAccount;
            account.password = accountData.passwordAccount;

            //System.out.println(account.firstName);
            

            ois.close();

        } catch (IOException e) {
           e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

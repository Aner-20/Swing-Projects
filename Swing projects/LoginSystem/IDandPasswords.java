package LoginSystem;

import java.util.HashMap;

public class IDandPasswords {
    
    HashMap<String, String> loginInfo = new HashMap<String,String>();

    IDandPasswords(){
        loginInfo.put("Bro", "pizza");
        loginInfo.put("Code", "password");
        loginInfo.put("John", "123");
    }
    
    protected HashMap getLoginInfo(){
        return loginInfo;
    }

}

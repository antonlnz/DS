package e3;

import java.util.HashMap;
import java.util.Objects;

public class LoginTelephone implements LoginStrategy{
    HashMap<String, String> hashMap;

    public LoginTelephone(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public boolean validateId(String id) {
        int max = id.length();
        if(max != 9){
            return false;
        }
        for (int i = 0; i < max; i++) {
            if (id.charAt(i) < '0' || id.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean authenticatePassword(String id, String password) {
        if(!this.hashMap.containsKey(id)){
            return false;
        }
        else{
            return hashMap.get(id).equals(password);
        }
    }
}

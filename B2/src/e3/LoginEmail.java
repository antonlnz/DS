package e3;

import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Objects;

public class LoginEmail implements LoginStrategy {
    HashMap<String, String> hashMap;
    public LoginEmail(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public boolean validateId(String id) {
        if (!id.contains("@") || !id.contains(".")) {
            return false;
        } else {
            String[] parts = id.split("@");
            String user = parts[0];
            String[] parts2 = parts[1].split("\\.");
            String organization = parts2[0];
            String domain = parts2[1];

            return (user != null && organization != null && domain != null);
        }
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

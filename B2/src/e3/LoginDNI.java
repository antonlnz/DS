package e3;

import java.util.HashMap;
import java.util.Objects;

public class LoginDNI implements LoginStrategy{
    HashMap<String, String> hashMap;
    public LoginDNI(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public boolean validateId(String id) {
        char[] caracteres = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};

        if(id.length() != 9){
            return false;
        }
        String numeros = "";
        for (int i = 0; i < 8; i++) {
            if (id.charAt(i) < '0' || id.charAt(i) > '9') {
                return false;
            }
            numeros = numeros.concat(String.valueOf(id.charAt(i)));
        }
        char letra = id.charAt(8);

        if(caracteres[Integer.parseInt(numeros) % 23] == letra)
            return true;
        else
            return false;
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

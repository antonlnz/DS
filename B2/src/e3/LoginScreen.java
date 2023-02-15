package e3;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Objects;

public class LoginScreen {
    LoginStrategy loginStrategy;
    MfaStrategy mfaStrategy;
    HashMap<String,String> users;
    String mfa;
    public LoginScreen() {
        this.users = new HashMap<>();
        this.loginStrategy = new LoginEmail(users);
        this.mfaStrategy = new MfaEmail();
    }
    public LoginScreen(LoginStrategy loginStrategy, MfaStrategy mfaStrategy){
        this.loginStrategy = loginStrategy;
        this.users = new HashMap<>();
        this.mfaStrategy = mfaStrategy;
    }
    void setLogin(LoginStrategy loginStrategy){
        this.loginStrategy = loginStrategy;
    }
    void setMfaStrategy(MfaStrategy mfaStrategy){
        this.mfaStrategy = mfaStrategy;
    }
    void signIn(User user){
        if(this.users.containsKey(user.id))
            System.out.println(user.id + " is already used");
        else{
            if(this.loginStrategy.validateId(user.id)){
                this.users.put(user.id,user.password);
                System.out.println("User: " + user.id + " with password: ***** has been registered." );
            }
            else
                System.out.println(user.id + " is not a valid id");
        }
    }
    void signIn(String id, String password){
        if(this.users.containsKey(id))
            System.out.println(id + " is already used");
        else{
            if(this.loginStrategy.validateId(id)){
                this.users.put(id,password);
                System.out.println("User: " + id + " with password: ***** has been registered." );
            }
            else
                System.out.println( id + " is not a valid id");
        }
    }
    boolean validateMfa(String mfa) {
        if(mfa.length() != this.mfa.length()){
            return false;
        }
        else{
            for(int i=0; i< mfa.length(); i++){
                if(mfa.charAt(i) != this.mfa.charAt(i)){
                    return false;
                }
            }
            return true;
        }
    }


}

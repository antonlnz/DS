package e3;

public class MfaEmail implements MfaStrategy{
    @Override
    public String generateCode() {
        String letter =String.valueOf ( (char) (65+ (Math.random() * 100 % 26)));
        String mfa = String.valueOf ((int)(Math.random() * 1000));
        String mfa2 = String.valueOf ((int)(Math.random() * 1000));

        if(mfa.length() < 3){
            mfa = mfa + "0";
        }
        if(mfa2.length() < 3){
            mfa2 = "0"+ mfa2;
        }
        return mfa + letter + mfa2 + letter;
    }
}

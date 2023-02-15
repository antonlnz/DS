package e3;

public class MfaSMS implements MfaStrategy{
    @Override
    public String generateCode() {

        int mfa = (int) (Math.random() * 10000);
        String mfaStr = String.valueOf(mfa);
        while(mfaStr.length()<4){
            mfaStr = "0".concat(mfaStr);
        }
        return mfaStr;
    }
}

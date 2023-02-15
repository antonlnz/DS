package e3;

public class MfaApp implements MfaStrategy{
    @Override
    public String generateCode() {
        int mfa = (int) (Math.random() * 1000000);
        String mfaStr = String.valueOf(mfa);
        while(mfaStr.length()<5){
            mfaStr = mfaStr.concat("0");
        }
        while(mfaStr.length()<6){
            mfaStr = "0".concat(mfaStr);
        }
        return mfaStr;
    }
}

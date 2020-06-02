package chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int metCnt = getMetCriteriaCounts(s);

        if (metCnt <= 1) {
            return PasswordStrength.WEAK;
        }
        if (metCnt == 2) {
            return PasswordStrength.NORMAL;
        }
//        if (lengthEnough && !containsNum && !containsUpper) {
//            return PasswordStrength.WEAK;
//        }
//
//        if (!lengthEnough) {
//            return PasswordStrength.NORMAL;
//        }
//
//        if (!containsNum){
//            return PasswordStrength.NORMAL;
//        }
//
//        if (!containsUpper) {
//            return PasswordStrength.NORMAL;
//        }

        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String s) {
        int metCnt = 0;

        boolean containsNum = meetsContainingNumberCriteria(s);
        boolean containsUpper = meetsContainingUpperCriteria(s);
        boolean lengthEnough = s.length() >= 8;

        if (containsNum) {
            metCnt++;
        }
        if (containsUpper) {
            metCnt++;
        }
        if (lengthEnough) {
            metCnt++;
        }

        return metCnt;
    }

    private boolean meetsContainingNumberCriteria(String s){
        for(char c: s.toCharArray()){
            if(c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }
    private boolean meetsContainingUpperCriteria(String s){
        for(char c: s.toCharArray()){
            if(Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
}

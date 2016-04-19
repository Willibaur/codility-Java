package main;

public class PhoneNumberFormatter {
    public String solution(String phoneNumber) {
        return formatPhoneNumber(removeNonDigits(phoneNumber));
    }

    private String removeNonDigits(String s) {
        return s.replaceAll("[^0-9]", "");
    }

    private String formatPhoneNumber(String s) {
        String tempNumber = "";
        int dashCounter = 0;
        for(int i = 0; i < s.length(); i++) {
            if (dashCounter < 3) {
                tempNumber = tempNumber.concat(s.substring(i, i+1));
                dashCounter++;
            } else {
                tempNumber = tempNumber.concat("-");
                tempNumber = tempNumber.concat(s.substring(i, i+1));
                dashCounter = 1;
            }
        }
        return tempNumber;
    }

    public static void main(String args[]) {
    }

}

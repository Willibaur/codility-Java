package main;

public class PhoneNumberFormatter {
    public String solution(String phoneNumber) {
        phoneNumber = removeNonDigits(phoneNumber);
        return formatPhoneNumber(phoneNumber, checkNumberSize(phoneNumber));
    }

    private Boolean checkNumberSize(String phoneNumber) {
        return phoneNumber.length() % 3 == 1;
    }

    private String removeNonDigits(String s) {
        return s.replaceAll("[^0-9]", "");
    }

    private String formatPhoneNumber(String s, boolean lastGroup) {
        String tempNumber = "";
        int dashCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dashCounter < 3) {
                tempNumber = tempNumber.concat(s.substring(i, i + 1));
                dashCounter++;
            } else if (dashCounter == 3){
                tempNumber = tempNumber.concat("-");
                tempNumber = tempNumber.concat(s.substring(i, i + 1));
                dashCounter = 1;
            }
        }
        if (lastGroup) {
            char[] temp =  tempNumber.toCharArray();
            temp[temp.length - 2] = temp[temp.length - 3];
            temp[temp.length - 3] = '-';
            tempNumber = new String(temp);
        }
        return tempNumber;
    }
}

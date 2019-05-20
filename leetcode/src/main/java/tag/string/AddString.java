package tag.string;

public class AddString {
    
    public String addStrings(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }

        if (num2 == null) {
            return num1;
        }

        int adv = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {

            if (i >= 0) {
                adv += num1.charAt(i--) - '0';
            }

            if (j >= 0) {
                adv += num2.charAt(j--) - '0';
            }

            sb.append(adv % 10);
            adv = adv / 10;
        }
        if (adv > 0) {
            sb.append(adv);
        }

        return sb.reverse().toString();
    }
}

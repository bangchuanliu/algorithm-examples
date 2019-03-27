package tag.string;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {

    private static Map<Integer, String> numberWordMap = new HashMap<>();
    private static Map<Integer, String> numberUnitMap = new HashMap<>();

    static {
        numberWordMap.put(0, "");
        numberWordMap.put(1, "One");
        numberWordMap.put(2, "Two");
        numberWordMap.put(3, "Three");
        numberWordMap.put(4, "Four");
        numberWordMap.put(5, "Five");
        numberWordMap.put(6, "Six");
        numberWordMap.put(7, "Seven");
        numberWordMap.put(8, "Eight");
        numberWordMap.put(9, "Nine");
        numberWordMap.put(10, "Ten");
        numberWordMap.put(11, "Eleven");
        numberWordMap.put(12, "Twelve");
        numberWordMap.put(13, "Thirteen");
        numberWordMap.put(14, "Fourteen");
        numberWordMap.put(15, "Fifteen");
        numberWordMap.put(16, "Sixteen");
        numberWordMap.put(17, "Seventeen");
        numberWordMap.put(18, "Eighteen");
        numberWordMap.put(19, "Nineteen");
        numberWordMap.put(20, "Twenty");
        numberWordMap.put(30, "Thirty");
        numberWordMap.put(40, "Forty");
        numberWordMap.put(50, "Fifty");
        numberWordMap.put(60, "Sixty");
        numberWordMap.put(70, "Seventy");
        numberWordMap.put(80, "Eighty");
        numberWordMap.put(90, "Ninety");

        numberUnitMap.put(3, " Billion ");
        numberUnitMap.put(2, " Million ");
        numberUnitMap.put(1, " Thousand ");
        numberUnitMap.put(0, "");
    }

    public String numberToWords(int num) {
        String result = "";
        String str = String.valueOf(num);
        while (str.length() % 3 != 0) {
            str = "0" + str;
        }

        int units = (str.length() - 1) / 3;

        while (units >= 0) {
            if (!helper(str.substring(0, 3)).trim().equals("")) {
                result += helper(str.substring(0, 3)).trim() + numberUnitMap.get(units);    
            }
            str = str.substring(3);
            units--;
        }

        return result.equals("") ? "Zero" : result.trim().replaceAll("\\s+"," ");
    }

    public String helper(String str) {
        String ret = "";

        if (str.charAt(0) != '0') {
            ret += numberWordMap.get(str.charAt(0) - '0') + " Hundred ";
        }

        int num = Integer.parseInt(str.substring(1));
        if (numberWordMap.containsKey(num)) {
            ret += numberWordMap.get(num);
        } else {
            int n2 = num % 10;
            int n1 = num - n2;

            ret += numberWordMap.get(n1);
            ret += " " + numberWordMap.get(n2);
        }
        return ret;
    }

    public static void main(String[] args) {
        IntegerToEnglishWords ins = new IntegerToEnglishWords();
        System.out.println(ins.numberToWords(1000000));
    }
}

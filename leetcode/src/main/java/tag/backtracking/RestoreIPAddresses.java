package tag.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIpAddresses(result, s, "");

        return result;
    }


    public void restoreIpAddresses(List<String> result, String s, String temp) {
        if (temp.split("\\.").length > 4) {
            return;
        }
        if (s.length() == 0 && temp.split("\\.").length == 4) {
            result.add(temp.substring(0, temp.length() - 1));
            return;
        }

        for (int i = 1; i <= s.length() && i <= 3; i++) {
            String subs = s.substring(0, i);
            if (i == 1 || (i > 1 && subs.charAt(0) != '0' && Integer.parseInt(subs) < 256)) {
                restoreIpAddresses(result, s.substring(i), temp + subs + ".");
            }
        }
    }

}

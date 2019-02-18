package difficulty.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String[] strs = email.split("@");
            String temp = strs[0].split("\\+")[0].replace(".", "");
            set.add(temp + "@" + strs[1]);
        }

        return set.size();
    }
    
    public static void main(String[] args) {
        String[] str = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        String string = "test.email+alex";
        String temp = "test.email".replace(".", "");
        System.out.println(temp);
        UniqueEmailAddresses uniqueEmailAddresses = new UniqueEmailAddresses();
        System.out.println(uniqueEmailAddresses.numUniqueEmails(str));
    }
}

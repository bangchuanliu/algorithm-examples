package company.airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PalindromePairs {

    public static List<List<Integer>> palindromePairs(String[] words) {
        Map<String, List<Integer>> maps = new HashMap<>();
        Set<List<Integer>> result = new HashSet<>();
        for (int k = 0; k < words.length; k++) {
            String str = words[k];
            String temp = "";
            int i = 0;
            while (i <= str.length()) {
                temp = i == str.length() ? "" : str.charAt(i) + temp;
                if (temp.equals(str)) {
                    i++;
                    continue;
                }
                if (isPalindrome(str + temp)) {
                    List<Integer> list = new ArrayList<>();
                    if (maps.containsKey(temp)) {
                        list = maps.get(temp);
                    }
                    list.add(k);
                    maps.put(temp, list);
                }
                i++;
            }

            temp = "";
            int j = str.length() - 1;
            while (j >= -1) {
                temp = j == -1 ? "" : temp + str.charAt(j);
                if (temp.equals(str)) {
                    j--;
                    continue;
                }
                if (isPalindrome(temp + str)) {
                    List<Integer> list = new ArrayList<>();
                    if (maps.containsKey(temp)) {
                        list = maps.get(temp);
                    }
                    list.add(-k);
                    maps.put(temp, list);
                }
                j--;
            }
        }

        for (int i = 0; i < words.length; i++) {
            if (maps.containsKey(words[i])) {
                List<Integer> list = maps.get(words[i]);
                for (Integer index : list) {
                    List<Integer> pair = new ArrayList<>();
                    if (index < 0) {
                        pair.add(i);
                        pair.add(-index);
                        result.add(pair);
                    } else if (index > 0) {
                        pair.add(index);
                        pair.add(i);
                        result.add(pair);
                    } else {
                        if (isPalindrome(words[index] + words[i])) {
                            pair.add(index);
                            pair.add(i);
                            result.add(pair);
                        }
                        if (isPalindrome(words[i] + words[index])) {
                            List<Integer> pair2 = new ArrayList<>();
                            pair2.add(i);
                            pair2.add(index);
                            result.add(pair2);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"a", ""};
        System.out.println(Arrays.deepToString(palindromePairs(words).toArray()));
    }
}

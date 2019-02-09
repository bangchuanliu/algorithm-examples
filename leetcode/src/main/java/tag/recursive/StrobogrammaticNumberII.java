package tag.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumberII {


    public List<String> findStrobogrammatic(int n) {
        char[] chars = {'0','1', '6', '9', '8'};
        Map<Character, Character> maps = new HashMap<>();
        maps.put('1', '1');
        maps.put('8', '8');
        maps.put('6', '9');
        maps.put('9', '6');
        maps.put('0', '0');
        List<String> result = new ArrayList<>();

        findStrobogrammatic(n, result, maps, chars, new ArrayList<>());

        return result;
    }

    public void findStrobogrammatic(int n, List<String> result, Map<Character, Character> maps, char[] chars, List<Character> temp) {
        if (n == temp.size()) {
            String str = isStrobogrammatic(temp, maps);
            if (str != null) {
                result.add(str);
            }
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            temp.add(chars[i]);
            findStrobogrammatic(n, result, maps, chars, temp);
            temp.remove(temp.size() - 1);
        }
    }


    public String isStrobogrammatic(List<Character> temp, Map<Character, Character> maps) {
        int i = 0;
        int j = temp.size() - 1;
        while (i <= j) {
            if (temp.get(i) != maps.get(temp.get(j))) {
                return null;
            }
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        if (temp.size() > 1 && temp.get(0) == '0') {
            return null;
        }
        for (Character c : temp) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StrobogrammaticNumberII instance = new StrobogrammaticNumberII();
        System.out.println(Arrays.toString(instance.findStrobogrammatic(3).toArray()));
    }
}

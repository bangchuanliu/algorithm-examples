package tag.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UF uf = new UF();
        Map<String, String> emailNameMap = new HashMap<>();
        Map<String, Integer> emailIDMap = new HashMap<>();
        int id = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                emailNameMap.put(account.get(i), name);
                if (!emailIDMap.containsKey(account.get(i))) {
                    emailIDMap.put(account.get(i), id++);
                }
                uf.union(emailIDMap.get(account.get(1)), emailIDMap.get(account.get(i)));
            }
        }

        Map<Integer, TreeSet<String>> map = new HashMap<>();
        for (String email : emailIDMap.keySet()) {
            int source = uf.find(emailIDMap.get(email));
            TreeSet<String> set = map.getOrDefault(source, new TreeSet<>());
            set.add(email);
            map.put(source, set);
        }
        List<List<String>> result = new ArrayList<>();

        for (TreeSet<String> emails : map.values()) {
            List<String> emailList = new ArrayList<>(emails);
            String email = emailList.get(0);
            emailList.add(0, emailNameMap.get(email));
            result.add(emailList);
        }

        return result;
    }


    class UF {
        int[] id;

        UF() {
            id = new int[10001];
            for (int i = 0; i < id.length; i++) {
                id[i] = i;
            }
        }

        public int find(int x) {
            while (x != id[x]) {
                x = id[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int p = find(x);
            int q = find(y);
            if (p == q) {
                return;
            }
            id[p] = q;
        }

    }

    public static void main(String[] args) {
        String[][] strings = {{"Ethan", "Ethan1@m.co", "Ethan2@m.co", "Ethan0@m.co"}, {"David", "David1@m.co", "David2@m.co", "David0@m.co"}, {"Lily", "Lily0@m.co", "Lily0@m.co", "Lily4@m.co"}, {"Gabe", "Gabe1@m.co", "Gabe4@m.co", "Gabe0@m.co"}, {"Ethan", "Ethan2@m.co", "Ethan1@m.co", "Ethan0@m.co"}};
        List<List<String>> accounts = new ArrayList<>();
        for (String[] strs : strings) {
            accounts.add(Arrays.asList(strs));
        }
        AccountsMerge accountsMerge = new AccountsMerge();
        System.out.println(Arrays.deepToString((accountsMerge.accountsMerge(accounts).toArray())));
    }
}

package tag.graph;

import java.util.HashMap;
import java.util.Map;

public class SentenceSimilarityII {

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        UF uf = new UF(words1, words2);
        
        for (int i = 0; i < pairs.length; i++) {
            uf.setId(pairs[i][0]);
            uf.setId(pairs[i][1]);
            uf.union(pairs[i][0], pairs[i][1]);    
        }

        for (int i = 0; i < words1.length; ++i) {
            String w1 = words1[i], w2 = words2[i];
            if (uf.find(w1) != uf.find(w2))
                return false;
        }
        return true;
    }

    class UF {
        Map<String, String> id;
        int count;

        UF(String[] words1, String[] words2) {
            id = new HashMap<>();
            for (String str : words1) {
                id.putIfAbsent(str, str);
            }
            for (String str : words2) {
                id.putIfAbsent(str, str);
            }
            count = id.size();
        }
        
        public void setId(String str) {
            if (!id.containsKey(str)) {
                count++;
                id.put(str, str);    
            }
        }

        public String find(String str) {
            while (!str.equals(id.get(str))) {
                str = id.get(str);
            }
            return str;
        }

        public boolean union(String a, String b) {
            String ra = find(a);
            String rb = find(b);
            if (!ra.equals(rb)) {
                count--;
                id.put(ra, rb);
                return true;
            } else {
                return false;
            }
        }
    }
    
    public static void main(String[] args) {
        SentenceSimilarityII sentenceSimilarityII = new SentenceSimilarityII();
        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "drama", "talent"};
//        String[] words1 = {};
//        String[] words2 = {};
        String[][] pairs = {{"great", "good"}, {"fine", "good"}, {"drama","acting"}, {"skills","talent"}};

        System.out.println(sentenceSimilarityII.areSentencesSimilarTwo(words1,words2, pairs));
    }
}

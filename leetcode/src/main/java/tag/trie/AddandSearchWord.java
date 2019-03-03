package tag.trie;

import java.util.Map;

public class AddandSearchWord {

    private TrieNode root;

    public AddandSearchWord() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            Map<Character, TrieNode> children = curr.children;
            if (!children.containsKey(word.charAt(i))) {
                TrieNode newNode = new TrieNode(word.charAt(i));
                children.put(word.charAt(i), newNode);
                curr = newNode;
            } else {
                curr = children.get(word.charAt(i));
            }
        }
        curr.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {

        return search(word, root);
    }

    public boolean search(String word, TrieNode root) {
        if (word.isEmpty()) {
            return root.isLeaf;
        }

        if (root.children.containsKey(word.charAt(0))) {
            return search(word.substring(1), root.children.get(word.charAt(0)));
        } else if (word.charAt(0) == '.') {
            for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
                if (search(word.substring(1), entry.getValue())) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        AddandSearchWord instance = new AddandSearchWord();
//        instance.addWord("bad");
//         instance.addWord("dad");
        instance.addWord("a");
        instance.addWord("ab");

//        System.out.println(instance.search("pad"));
//        System.out.println(instance.search("bad"));
//        System.out.println(instance.search(".ad"));
//        System.out.println(instance.search("b.."));
        System.out.println(instance.search("abc"));
    }
}

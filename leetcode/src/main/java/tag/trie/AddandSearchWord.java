package tag.trie;

public class AddandSearchWord {

    private TrieNode root;

    public AddandSearchWord() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            if (!curr.children.containsKey(word.charAt(i))) {
                TrieNode node = new TrieNode(word.charAt(i));
                curr.children.put(word.charAt(i), node);
            }
            curr = curr.children.get(word.charAt(i));
        }
        curr.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {

        return search(word, root);
    }

    public boolean search(String word, TrieNode root) {
        if (root == null) {
            return false;
        }

        if (word.isEmpty()) {
            return root.isLeaf;
        }

        if (root.children.containsKey(word.charAt(0))) {
            return search(word.substring(1), root.children.get(word.charAt(0)));
        } else if (word.charAt(0) == '.') {
            for (char c : root.children.keySet()) {
                if (search(word.substring(1), root.children.get(c))) {
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

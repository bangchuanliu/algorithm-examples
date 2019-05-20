package tag.trie;

public class AddandSearchWord {

    private TrieNode root;

    public AddandSearchWord() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                TrieNode node = new TrieNode(c);
                cur.children.put(c, node);
            }
            cur = cur.children.get(c);
        }

        cur.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {

        return search(word, root);
    }

    public boolean search(String word, TrieNode node) {
        if (word.isEmpty()) {
            return node.isLeaf;
        }

        char c = word.charAt(0);
        if (node.children.containsKey(c)) {
            return search(word.substring(1), node.children.get(c));
        }else if (c == '.') {
            for (char ch : node.children.keySet()) {
                if (search(word.substring(1), node.children.get(ch))) {
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

package leetcode.easy.trie;

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

		return search(root, word);
	}

	public boolean search(TrieNode curr, String word) {

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == '.') {
				for (Map.Entry<Character, TrieNode> node : curr.children.entrySet()) {
					if (search(node.getValue(), word.substring(i + 1))) {
						return true;
					}
				}
				return false;
			} else {
				if (!curr.children.containsKey(word.charAt(i))) {
					return false;
				} else {
					curr = curr.children.get(word.charAt(i));
				}
			}
		}

		return curr.isLeaf;
	}

	public static void main(String[] args) {
		AddandSearchWord instance = new AddandSearchWord();
		instance.addWord("ab");
		// instance.addWord("b");
		System.out.println(instance.search("a."));
	}
}

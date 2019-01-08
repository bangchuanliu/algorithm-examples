package leetcode.easy.trie;

import java.util.Map;

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
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

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {
			Map<Character, TrieNode> children = curr.children;
			if (!children.containsKey(word.charAt(i))) {
				return false;
			} else {
				curr = children.get(word.charAt(i));
			}
		}

		return curr.isLeaf;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode curr = root;

		for (int i = 0; i < prefix.length(); i++) {
			Map<Character, TrieNode> children = curr.children;
			if (!children.containsKey(prefix.charAt(i))) {
				return false;
			} else {
				curr = children.get(prefix.charAt(i));
			}
		}

		return true;
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
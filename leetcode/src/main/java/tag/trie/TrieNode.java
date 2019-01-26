package tag.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	char letter;
	Map<Character, TrieNode> children;
	boolean isLeaf;

	// Initialize your data structure here.
	public TrieNode() {
		children = new HashMap<>();
	}

	public TrieNode(char letter) {
		this.letter = letter;
		children = new HashMap<>();
	}
}

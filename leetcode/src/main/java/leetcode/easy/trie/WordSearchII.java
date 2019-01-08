package leetcode.easy.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

	public List<String> findWords(char[][] board, String[] words) {

		if (board == null || words == null) {
			return new ArrayList<>();
		}

		Trie trie = new Trie();

		for (String word : words) {
			trie.insert(word);
		}

		Set<String> wordsList = new HashSet<>();
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				StringBuilder word = new StringBuilder();
				boolean[][] used = new boolean[board.length][board[0].length];
				word.append(board[i][j]);
				search(used, board, word, i, j, trie, wordsList);
			}
		}
		
		return new ArrayList<>(wordsList);
	}
	
	public void search(boolean[][] used, char[][] board, StringBuilder word, int i, int j, Trie trie, Set<String> wordsList) {
		if (trie.search(word.toString())) {
			wordsList.add(word.toString());
			return;
		} 
		
		if (trie.startsWith(word.toString())) {
			if (i > 0 && !used[i-1][j]) {
				used[i-1][j] = true;
				word.append(board[i-1][j]);
				search(used, board, word, i - 1, j, trie, wordsList);
				word.deleteCharAt(word.length()-1);
			}
			
			if (i < board.length - 1 && !used[i+1][j]) {
				used[i+1][j] = true;
				word.append(board[i+1][j]);
				search(used, board, word, i + 1, j, trie, wordsList);
				word.deleteCharAt(word.length()-1);
			}
			
			if (j > 0 && !used[i][j-1]) {
				used[i][j-1] = true;
				word.append(board[i][j-1]);
				search(used, board, word, i, j - 1, trie, wordsList);
				word.deleteCharAt(word.length()-1);
			}
			
			if (j < board[0].length - 1 && !used[i][j + 1]) {
				used[i][j + 1] = true;
				word.append(board[i][j + 1]);
				search(used, board, word, i, j + 1, trie, wordsList);
				word.deleteCharAt(word.length()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		//char[][] board = {'a','a'};
	}
}

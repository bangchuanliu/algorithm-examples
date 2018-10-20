package leetcode.unionfind;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

	public void solve(char[][] board) {

		if (board == null || board.length == 0) {
			return;
		}

		Queue<Integer> queue = new LinkedList<>();
		
		int m = board.length;
		int n = board[0].length;
		
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				bfs(queue, board, i, 0);
			}
			
			if (board[i][n-1] == 'O') {
				bfs(queue, board, i, n-1);
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (board[0][i] == 'O') {
				bfs(queue, board, 0, i);
			}
			
			if (board[m-1][i] == 'O') {
				bfs(queue, board, m-1, i);
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '#') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
		
	}
	
	public void bfs(Queue<Integer> queue, char[][] board, int i, int j){
		
		int n = board[0].length;
		
		fillCell(board, i, j, queue);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int x = cur / n;
			int y = cur % n;
			
			fillCell(board, x + 1, y, queue);
			fillCell(board, x - 1, y, queue);
			fillCell(board, x, y + 1, queue);
			fillCell(board, x, y - 1, queue);
		}	
	}

	public void fillCell(char[][] board, int i, int j, Queue<Integer> queue){
		
		int m = board.length;
		int n = board[0].length;
		
		if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
			return;
		}
		
		queue.offer(i * n + j);
		board[i][j] = '#';
	}
	
	
	
	
	public static void main(String[] args) {
		SurroundedRegions instance = new SurroundedRegions();
		char[][] board = {{'X','X','X'},{'X','O','X'},{'X','X','X'}};
		char[][] board2 = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		char[][] board3 = {{'O'}};
		instance.solve(board3);
		System.out.println(Arrays.deepToString(board3));
	}
}

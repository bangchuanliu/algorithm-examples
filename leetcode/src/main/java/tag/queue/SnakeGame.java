package tag.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeGame {
    int width;
    int height;
    Queue<int[]> foods;
    LinkedList<int[]> snake;
    Map<String, Integer[]> maps = new HashMap<>();
    int score = 0;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        foods = new LinkedList<>();
        for (int[] f : food) {
            foods.add(f);
        }
        snake = new LinkedList<>();
        snake.add(new int[]{0, 0});

        maps.put("U", new Integer[]{-1, 0});
        maps.put("D", new Integer[]{1, 0});
        maps.put("L", new Integer[]{0, -1});
        maps.put("R", new Integer[]{0, 1});
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        int[] head = snake.peek();
        Integer[] offset = maps.get(direction);
        int[] newPos = new int[]{head[0] + offset[0], head[1] + offset[1]};
        if (newPos[0] < 0 || newPos[0] >= height || newPos[1] < 0 || newPos[1] >= width) {
            return -1;
        }
        for (int i = 0; i < snake.size(); i++) {
            if (snake.get(i)[0] == newPos[0] && snake.get(i)[1] == newPos[1]) {
                return -1;
            }
        }

        snake.addFirst(newPos);
        if (!foods.isEmpty() && newPos[0] == foods.peek()[0] && newPos[1] == foods.peek()[1]) {
            score++;
            foods.poll();
        } else {
            snake.removeLast();
        }
        return score;
    }

    public static void main(String[] args) {
        int[][] food = {{2, 0}, {0, 0}, {0, 2},{2, 2}};
        SnakeGame snakeGame = new SnakeGame(3, 3, food);
        String[] dir = {"D","D","R","U","U","L","D","R","R","U","L","D"};
        for (String str : dir) {
            System.out.println(snakeGame.move(str));
        }
    }
}

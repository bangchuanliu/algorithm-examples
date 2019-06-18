package tag.dfs;

import java.util.HashSet;
import java.util.Set;

public class RobotCleaner {

    public void cleanRoom(Robot robot) {
        dfs(robot, new HashSet<>(), 0, 0, 0);
    }


    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void dfs(Robot robot, Set<String> visited, int row, int col, int arrow) {
        String tmp = row + "-" + col;

        if (visited.contains(tmp)) {
            return;
        }
        visited.add(tmp);

        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                int x = dir[arrow][0];
                int y = dir[arrow][1];

                dfs(robot, visited, x, y, arrow);


                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }

            robot.turnRight();
            arrow = (arrow + 1) % 4;
        }
    }
}

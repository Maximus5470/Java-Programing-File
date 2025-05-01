import java.util.*;

public class RoboArena {
    static int n;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // Up, Down, Left, Right
    static int[] dy = {0, 0, -1, 1};

    static class Robot {
        int x, y, score;
        List<String> path;

        Robot(int x, int y) {
            this.x = x;
            this.y = y;
            this.score = 0;
            this.path = new ArrayList<>();
            addPosition();
        }

        void addPosition() {
            path.add("(" + x + ", " + y + ")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String row = sc.next();
            grid[i] = row.toCharArray();
        }

        int r1x = sc.nextInt() - 1, r1y = sc.nextInt() - 1;
        int r2x = sc.nextInt() - 1, r2y = sc.nextInt() - 1;

        Robot robot1 = new Robot(r1x, r1y);
        Robot robot2 = new Robot(r2x, r2y);

        // Mark initial positions as visited
        visited[r1x][r1y] = true;
        visited[r2x][r2y] = true;

        boolean robot1Moved, robot2Moved;

        do {
            robot1Moved = moveRobot(robot1);
            robot2Moved = moveRobot(robot2);
        } while (robot1Moved || robot2Moved);

        System.out.print("Robot 1 score: " + robot1.score + ", Path: " + robot1.path);
        System.out.println();
        System.out.print("Robot 2 score: " + robot2.score + ", Path: " + robot2.path);
    }

    static boolean moveRobot(Robot robot) {
        int bestX = -1, bestY = -1;
        boolean foundMove = false;

        for (int dir = 0; dir < 4; dir++) {
            int newX = robot.x + dx[dir];
            int newY = robot.y + dy[dir];

            if (isValid(newX, newY)) {
                if (!visited[newX][newY] && grid[newX][newY] != 'T') {
                    if (grid[newX][newY] == 'R') {
                        // Prefer rewards
                        robot.score++;
                        bestX = newX;
                        bestY = newY;
                        foundMove = true;
                        break;
                    } else if (!foundMove) {
                        // Otherwise pick any free spot
                        bestX = newX;
                        bestY = newY;
                        foundMove = true;
                    }
                }
            }
        }

        if (foundMove) {
            robot.x = bestX;
            robot.y = bestY;
            visited[bestX][bestY] = true;
            robot.addPosition();
        }

        return foundMove;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}

import java.util.Stack;

class Position {
    int row, col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Q10 {
    private static final int PATH = 0;
    private static final int WALL = 1;
    private static final int VISITED = 2;

    public static void main(String[] args) {

        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };

        Position start = new Position(1, 1);
        Position exit = new Position(5, 6);

        if (solveMaze(maze, start, exit)) {
            System.out.println("Path to exit found!");
        } else {
            System.out.println("No path to exit exists.");
        }
    }

    private static boolean solveMaze(int[][] maze, Position start, Position exit) {
        Stack<Position> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            Position current = stack.pop();

            if (current.row == exit.row && current.col == exit.col) {

                maze[current.row][current.col] = VISITED;
                printMaze(maze);
                return true;
            }

            if (maze[current.row][current.col] == PATH) {

                maze[current.row][current.col] = VISITED;


                if (isValidMove(maze, current.row - 1, current.col)) {
                    stack.push(new Position(current.row - 1, current.col));
                }
                if (isValidMove(maze, current.row + 1, current.col)) {
                    stack.push(new Position(current.row + 1, current.col));
                }
                if (isValidMove(maze, current.row, current.col - 1)) {
                    stack.push(new Position(current.row, current.col - 1));
                }
                if (isValidMove(maze, current.row, current.col + 1)) {
                    stack.push(new Position(current.row, current.col + 1));
                }
            }
        }


        return false;
    }

    private static boolean isValidMove(int[][] maze, int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == PATH;
    }

    private static void printMaze(int[][] maze) {
        for (int[] row : maze) {
            for (int cell : row) {
                if (cell == WALL) {
                    System.out.print("| ");
                } else if (cell == PATH) {
                    System.out.print("~ ");
                } else if (cell == VISITED) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}


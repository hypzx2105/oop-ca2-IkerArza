import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class Q4 {
    static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        @Override
        public String toString() {
            return "Cell(" + row + ", " + col + ")";
        }
    }

    public static void floodFill() {
        final int size = 10;
        int[][] grid = new int[size][size];
        Scanner scanner = new Scanner(System.in);




        int horizontalLineRow = 5;
        for (int col = 0; col < size; col++) {
            grid[horizontalLineRow][col] = -1;
        }


        System.out.println("Enter starting row (0-9): ");
        int startRow = scanner.nextInt();

        System.out.println("Enter starting column (0-9): ");
        int startCol = scanner.nextInt();

        if (startRow < 0 || startRow >= size || startCol < 0 || startCol >= size) {
            System.out.println("You entered an invalid starting position.");
            return;
        }

        Deque<Cell> stack = new ArrayDeque<>();
        stack.push(new Cell(startRow, startCol));


        int i = 1;
        while (!stack.isEmpty()) {
            Cell current = stack.pop();
            int row = current.getRow();
            int col = current.getCol();

            if (grid[row][col] == 0) {
                grid[row][col] = i++;

                if (row > 0) {
                    if (grid[row - 1][col] == 0) {
                        stack.push(new Cell(row - 1, col));
                    }
                }

                if (row < size - 1) {
                    if (grid[row + 1][col] == 0) {
                        stack.push(new Cell(row + 1, col));
                    }
                }

                if (col > 0) {
                    if (grid[row][col - 1] == 0) {
                        stack.push(new Cell(row, col - 1));
                    }
                }

                if (col < size - 1) {
                    if (grid[row][col + 1] == 0) {
                        stack.push(new Cell(row, col + 1));
                    }
                }
            }
        }

        printGrid(grid);
    }

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.printf("%3d", cell);
            }
            System.out.println();
        }
    }
}

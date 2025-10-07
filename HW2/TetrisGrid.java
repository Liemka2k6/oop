//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
    private boolean[][] grid;

    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }

    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {
        int width = grid.length;
        int height = grid[0].length;

        int nexty = 0;
        for (int y = 0; y < height; y++) {
            if (!isFullRow(y)) {
                for (int x = 0; x < width; x++) {
                    grid[x][nexty] = grid[x][y];
                }
                nexty++;
            }
        }

        for (int y = nexty; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = false;
            }
        }
    }

    private boolean isFullRow(int y) {
        for (int x = 0; x < grid.length; x++) {
            if (!grid[x][y]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the internal 2d grid array.
     * @return 2d grid array
     */
    boolean[][] getGrid() {
        return grid;
    }

    public static void main(String[] args) {
        boolean[][] board = new boolean[][] {
                {false, true,  true,  true},
                {true,  true,  true,  true},
                {true,  true,  false, true}
        };

        TetrisGrid tg = new TetrisGrid(board);

        System.out.println("Before clear:");
        printGrid(tg.getGrid());

        tg.clearRows();

        System.out.println("After clear:");
        printGrid(tg.getGrid());
    }

    private static void printGrid(boolean[][] grid) {
        int width = grid.length;
        int height = grid[0].length;
        for (int y = height - 1; y >= 0; y--) {
            for (int x = 0; x < width; x++) {
                System.out.print(grid[x][y] ? "X " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

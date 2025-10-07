// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int rows = grid.length;
        int cols = grid[0].length;
        int minRow = rows, maxRow = -1;
        int minCol = cols, maxCol = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == ch) {
                    if (i < minRow) {
                        minRow = i;
                    }

                    if (i > maxRow) {
                        maxRow = i;
                    }

                    if (j < minCol) {
                        minCol = j;
                    }

                    if (j > maxCol) {
                        maxCol = j;
                    }
                }
            }
        }

        if (maxRow == -1) return 0;
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     * @return number of + in grid
     */
    public int countPlus() {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int arm = armLength(i, j);
                if (arm >= 2) {
                    count++;
                }
            }
        }
        return count;
    }

    private int armLength(int r, int c) {
        char ch = grid[r][c];
        int up = 0, down = 0, left = 0, right = 0;

        for (int i = r - 1; i >= 0 && grid[i][c] == ch; i--) {
            up++;
        }

        for (int i = r + 1; i < grid.length && grid[i][c] == ch; i++) {
            down++;
        }

        for (int j = c - 1; j >= 0 && grid[r][j] == ch; j--) {
            left++;
        }

        for (int j = c + 1; j < grid[0].length && grid[r][j] == ch; j++) {
            right++;
        }

        if (up >= 2 && up == down && up == left && up == right) {
            return up;
        }

        return -1;
    }

    public static void main(String[] args) {
        char[][] testGrid1 = {
                {'a', 'b', 'c'},
                {'d', 'a', 'c'},
                {'a', 'a', 'c'}
        };
        CharGrid cg1 = new CharGrid(testGrid1);
        System.out.println("charArea('a') = " + cg1.charArea('a'));
        System.out.println("charArea('c') = " + cg1.charArea('c'));
        System.out.println("charArea('z') = " + cg1.charArea('z'));

        char[][] testGrid2 = {
                {'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x'}
        };
        CharGrid cg2 = new CharGrid(testGrid2);
        System.out.println("countPlus = " + cg2.countPlus());
    }
}

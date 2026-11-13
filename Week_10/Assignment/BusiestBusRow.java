package Week_10.Assignment;

public class BusiestBusRow {

    public static int[] busiestRow(int[][] grid) {
        int maxRow = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowSum = 0;
            for (int c = 0; c < grid[r].length; c++) {
                rowSum += grid[r][c];
            }
            
            if (rowSum > maxTotal) {
                maxTotal = rowSum;
                maxRow = r;
            }
        }

        return new int[]{maxRow, maxTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}
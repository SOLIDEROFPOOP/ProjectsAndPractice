public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0 , endRow = matrix.length - 1;

        while (startRow <= endRow){
            int middleRow = startRow + (endRow - startRow) / 2;
            int startCol = 0 , endCol = matrix[middleRow].length - 1;
            while (startCol <= endCol){
                int middleCol = startCol + (endCol - startCol) / 2;
                if (matrix[middleRow][middleCol] == target) return true;
                if (matrix[middleRow][middleCol] < target) startCol = middleCol + 1;
                else endCol = middleCol - 1;
            }
            if (matrix[middleRow][0] > target){
                endRow = middleRow - 1;
            }
            else startRow = middleRow + 1;
        }
        return false;
    }
}

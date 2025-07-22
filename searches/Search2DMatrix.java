package searches;
public class Search2DMatrix {
    public static boolean searchTargetInMatrix(int[][] sortedMatrix, int targetValue) {
        int rowCount = sortedMatrix.length;
        if (rowCount == 0) return false;
        int columnCount = sortedMatrix[0].length;
        int leftIndex = 0;
        int rightIndex = rowCount * columnCount - 1;
        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            int rowIndex = middleIndex / columnCount;
            int columnIndex = middleIndex % columnCount;
            int currentElement = sortedMatrix[rowIndex][columnIndex];
            if (currentElement == targetValue) return true;
            if (currentElement < targetValue) leftIndex = middleIndex + 1;
            else rightIndex = middleIndex - 1;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        boolean found = searchTargetInMatrix(matrix, 3);
        System.out.println(found);
    }
} 
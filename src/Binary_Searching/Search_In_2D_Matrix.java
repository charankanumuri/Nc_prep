package Binary_Searching;

/**
 * Search_In_2D_Matrix
 */
public class Search_In_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = cols - 1;

        while(i < rows && j >= 0) {
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
        // int left = 0, right = rows * cols;
        // while(left < right) {
        //     int mid = (left + right) / 2;
        //     if(matrix[mid / cols][mid % cols] == target)
        //         return true;
        //     else if(matrix[mid / cols][mid % cols] > target)
        //         right--;
        //     else
        //         left++;
        // }
        // return false;
    }
}
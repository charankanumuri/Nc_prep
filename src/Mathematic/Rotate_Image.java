Package Mathematic;

class Rotate_Image {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1    2   3
        // 4    5   6
        // 7    8   9

        // transpose of a matrix.
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 1    4   7
        // 2    5   8
        // 3    6   9

        // to flip the matrix horizontally.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

    }
}
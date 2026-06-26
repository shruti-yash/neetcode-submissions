class NumMatrix {

    int[][] sumMat;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        sumMat = new int[rows+1][cols+1];

        for (int r = 1; r <= rows; r++) {
            int prefix = 0;
            for (int c = 1; c <= cols; c++) {
                prefix += matrix[r-1][c-1];
                int above = sumMat[r-1][c];
                sumMat[r][c] = prefix + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        int totalSum = sumMat[row2 + 1][col2 + 1];
        int above = sumMat[row1][col2 + 1];
        int left = sumMat[row2 + 1][col1];
        int commonArea = sumMat[row1][col1];

        return totalSum - above - left + commonArea;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean isPresent = false;
        for(int i = 0; i < matrix.length; i++){

            if(matrix[i][0] <= target && target <= matrix[i][matrix[i].length-1]){
                for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] == target)
                        return true;
                }
            }
        }
        return isPresent;
    }
}

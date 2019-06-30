package company.facebook;

public class LeftMostOne {
    
    public int findLeftMostOne(int[][] matrix) {
        int i = 0;
        int j = matrix.length - 1;
        int index = -1;
        while (i < matrix.length) {
            while (j >= 0 && matrix[i][j] == 1) {
                index = j;
                j--;
            }
            i++;
        }
        
        return index;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,1,1},{0,0,1}};
        LeftMostOne leftMostOne = new LeftMostOne();
        System.out.println(leftMostOne.findLeftMostOne(matrix));
    }
}
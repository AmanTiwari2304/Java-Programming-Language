public class MatrixArray {
    public static void numberOfSevens(int key){
        int matrix[][] = {{4,7,8},{8,8,7}};
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == key) {
                    count ++;
                    count += count;
                }
            }
            
        }
        System.out.println("Total numbers of key is " + count);
    }

    public static void transposeMatrix(int matrix[][]){
        int row = 2, col = 3;
        int transpose[][] = new int [col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col ; j++) {
                transpose[j][i] = matrix[i][j];
            
            }  
        }
        System.out.println("Your transpose matrix is : ");  
        printMatrix(transpose);  
    }

    public static void printMatrix(int matrix[][]){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.err.println();
        }
    }

    public static void main(String[] args) {
        int key = 7;
        int matrix[][] = {{11, 12, 13},{21, 22, 23}};
        printMatrix(matrix);
        // numberOfSevens(key);
        transposeMatrix(matrix);
        

        
    }
}

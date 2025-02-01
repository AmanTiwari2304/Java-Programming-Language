import java.util.*;

public class matrixArray {
    public static boolean search(int matrix[][] , int key){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                if (matrix[i][j] == key) {
                    System.out.print("Found at cell " + "( " + i + "," + j + " )");
                    return true;
                }   
            }
        }
        System.out.println("Key not found ");
        return false;
    }
    
    public static void searchMaxValue(int matrix[][] , int maxNum , int minNum){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                if (matrix[i][j] > maxNum) {
                    maxNum = Math.max(maxNum, matrix[i][j]);
                }
                if (matrix[i][j] < minNum) {
                    minNum = Math.min(minNum, matrix[i][j]);
                }   
            }
        }
        System.out.println("Maximum number in this matrix is : " + maxNum );
        System.out.println("Minimum number in this matrix is : " + minNum );
    }

    public static void spiralPrintOfMatrix(int matrix[][]){
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1 ;
        int endCol = matrix[0].length - 1 ;

        while (startRow <= endRow && startCol<= endCol) {
            
            //Top , here row will be fix
            for (int j = startCol; j <= endCol ; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            //Right , here column will be fix 
            for (int i = startRow+1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            //Bottom , here row will be fix
            for (int j = endCol-1; j >= startCol; j--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            //Left , here column will be fix
            for (int i = endRow-1; i >= startRow +1; i--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
    }

    public static void diagonalSum(int matrix[][]){ // O(n^2)
        int primarySum = 0;
        int secondarySum = 0;
        // int startRow = 0;
        // int endCol = matrix[0].length -1 ;

        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //        if (i == j) {
        //         primarySum = primarySum + matrix[i][j] ;
        //        } 
        //        else if (i==startRow && j==endCol && i!=j) {
        //         secondarySum = secondarySum + matrix[i][j] ;
        //        }
        //     }
        //     startRow++;
        //     endCol--;

        // }

        for (int i = 0; i < matrix.length; i++) {
            primarySum += matrix[i][i];

            if (i != matrix.length -i -1) {
                secondarySum += matrix[i][matrix.length -i -1];
            }
        }


        System.out.println("Primary sum : " + primarySum);
        System.out.println("Secondary sum : " + secondarySum);
        System.out.println("Diagonal sum : " + (primarySum+secondarySum));
    }

    public static boolean staircaseSearchFirstMethod(int matrix[][], int key){
        int row = 0 , col = matrix[0].length-1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Found key at (" + row + "," + col +")");
                return true;
            }
            else if (key < matrix[row][col]) {
                col -- ;
            }
            else {
                row ++ ;
            }
        }

        return false;
    }

    public static boolean staircaseSearchSecondMethod(int matrix[][], int key){
        int row = matrix.length -1 , col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == key) {
                System.out.println("Found key at ("+ row + "," + col +")");
                return true;
            }
            else if (key < matrix[row][col]) {
                row -- ;
            }
            else {
                col ++ ;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        // int matrix[][] = new int[3][3];
        int matrix[][] =  { {1, 2, 3, 4 },
                            {5, 6, 7, 8 },
                            {9, 10, 11, 12},
                            {13, 14, 15, 16}};
        int n = matrix.length;
        int m = matrix[0].length;
        int key = 14;
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
    

        // Scanner sc = new Scanner(System.in);
        // for (int i = 0; i < n ; i++) {
        //     for (int j = 0; j < m ; j++) {
        //         matrix[i][j] = sc.nextInt(); 
        //     }
        // }

        //Output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.err.println();
        }

        // search(matrix, key);
        // searchMaxValue(matrix, maxNum, minNum);
        // spiralPrintOfMatrix(matrix);
        // diagonalSum(matrix);
        // staircaseSearchFirstMethod(matrix , key);
        staircaseSearchSecondMethod(matrix , key);
        
    }
}

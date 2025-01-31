import java.util.*;

public class matrixArray {
    public static boolean search(int martix[][] , int key){
        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < martix[0].length ; j++) {
                if (martix[i][j] == key) {
                    System.out.print("Found at cell " + "( " + i + "," + j + " )");
                    return true;
                }   
            }
        }
        System.out.println("Key not found ");
        return false;
    }
    
    public static void searchMaxValue(int martix[][] , int maxNum , int minNum){
        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < martix[0].length ; j++) {
                if (martix[i][j] > maxNum) {
                    maxNum = Math.max(maxNum, martix[i][j]);
                }
                if (martix[i][j] < minNum) {
                    minNum = Math.min(minNum, martix[i][j]);
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
            for (int j = endCol-1; j >= startRow; j--) {
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

    public static void diagonalSum(int martix[][]){
        int primarySum = 0;
        int secondarySum = 0;
        int startRow = 0;
        int endCol = martix[0].length -1 ;

        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < martix[0].length; j++) {
               if (i == j) {
                primarySum = primarySum + martix[i][j] ;
               } 
               else if (i==startRow && j==endCol && i!=j) {
                secondarySum = secondarySum + martix[i][j] ;
               }
            }
            startRow++;
            endCol--;

        }


        System.out.println("Primary sum : " + primarySum);
        System.out.println("Secondary sum : " + secondarySum);
        System.out.println("Diagonal sum : " + (primarySum+secondarySum));
    }

    
    public static void main(String[] args) {
        // int martix[][] = new int[3][3];
        int martix[][] =  { {1, 2, 3, 4 },
                            {5, 6, 7, 8 },
                            {9, 10, 11, 12},
                            {13, 14, 15, 16}};
        int n = martix.length;
        int m = martix[0].length;
        int key = 5;
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
    

        // Scanner sc = new Scanner(System.in);
        // for (int i = 0; i < n ; i++) {
        //     for (int j = 0; j < m ; j++) {
        //         martix[i][j] = sc.nextInt(); 
        //     }
        // }

        //Output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(martix[i][j] + " ");
            }
            System.err.println();
        }

        // search(martix, key);
        // searchMaxValue(martix, maxNum, minNum);
        // spiralPrintOfMatrix(martix);
        diagonalSum(martix);
        
    }
}

package Backtracking;

public class backtracking {
    private static void printMazePathTwoDirection(int sr, int sc, int er, int ec, String str){
        // BASE
        if (sr>er || sc>ec) {
            return ;
        }
        if (sr==er && sc==ec) {
            System.out.println(str);
            return;
        }

        // KAAM 
        // GO DOWN 
        printMazePathTwoDirection(sr+1, sc, er, ec, str+"D");
        // GO RIGHT 
        printMazePathTwoDirection(sr, sc+1, er, ec, str+"R");
    }

    private static void printMazePathFourDirection(int sr, int sc, int er, int ec, String str, boolean[][] isVisited){
        // BASE
        if (sr<0 || sc<0) {
            return ;
        }
        if (sr>er || sc>ec) {
            return ;
        }
        if (isVisited[sr][sc] == true) {
            return ; 
        }
        if (sr==er && sc==ec) {
            System.out.println(str);
            return;
        }

        // KAAM 
        isVisited[sr][sc] = true;
        // GO DOWN 
        printMazePathFourDirection(sr+1, sc, er, ec, str+"D",isVisited);
        // GO RIGHT 
        printMazePathFourDirection(sr, sc+1, er, ec, str+"R",isVisited);
        // GO LEFT 
        printMazePathFourDirection(sr, sc-1, er, ec, str+"L",isVisited);
        // GO UP 
        printMazePathFourDirection(sr-1, sc, er, ec, str+"U",isVisited);

        // backtracking
        isVisited[sr][sc] = false;

    }

    private static void printMazePath(int sr, int sc, int er, int ec, String str,int maze[][]){
        // BASE
        if (sr<0 || sc<0) {
            return ;
        }
        if (sr>er || sc>ec) {
            return ;
        }
        if (maze[sr][sc] == 0) { //blocked cell
            return ; 
        }
        if (maze[sr][sc] == -1) {
            return ; 
        }
        if (sr==er && sc==ec) {
            System.out.println(str);
            return;
        }

        // KAAM 
        maze[sr][sc] = -1;
        // GO DOWN 
        printMazePath(sr+1, sc, er, ec, str+"D",maze);
        // GO RIGHT 
        printMazePath(sr, sc+1, er, ec, str+"R",maze);
        // GO LEFT 
        printMazePath(sr, sc-1, er, ec, str+"L",maze);
        // GO UP 
        printMazePath(sr-1, sc, er, ec, str+"U",maze);

        // backtracking
        maze[sr][sc] = 1;

    }



    public static void main(String[] args) {
        int rows = 3, cols = 4;
        // printMazePathTwoDirection(1, 1, rows, cols, "");

        // boolean isVisited[][] = new boolean[rows][cols];
        // printMazePathFourDirection(0, 0, rows-1, cols-1, "", isVisited);

        // RAT MAZE OPTIMIZED :- With Some cell are blocked to visit (0 represent blocked cell) 
        int maze[][] = {{1, 0, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 0, 1}};                       
        printMazePath(0, 0, rows-1, cols-1, "", maze);

    }
}

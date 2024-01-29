package maze;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazeGame {
    public static final int HEIGHT = 19;
    public static final int WIDTH = 39;
    private static final int COL = 1;
    private static final int ROW = 0;
    private Scanner playerInput;
    private boolean[][] blocked;
    private boolean[][] visited;
    private int[] player;
    private int[] goal;
    private int[] start;

    public MazeGame(String mazeFile) throws FileNotFoundException {
        this(mazeFile, new Scanner(System.in));
    }

    public MazeGame(String mazeFile, Scanner playerInput) throws FileNotFoundException {
        loadMaze(mazeFile);
        this.playerInput = playerInput;
    }

    public void playGame() {
        boolean quit = false;
        while (!quit) {
            prompt();
            String move = this.playerInput.next();
            quit = makeMove(move);
        }

        if (playerAtGoal()) {
            System.out.println("You Won!");
        } else {
            System.out.println("Goodbye!");
        }
    }

    public void printMaze() {
        System.out.println("*---------------------------------------*");
        for (int i = 0; i < HEIGHT; i++) {
            System.out.print("|");
            for (int j = 0; j < WIDTH; j++) {
                if (i == this.player[ROW] && j == this.player[COL]) {
                    System.out.print("@");
                } else if (i == this.goal[ROW] && j == this.goal[COL]) {
                    System.out.print("G");
                } else if (i == this.start[ROW] && j == this.start[COL]) {
                    System.out.print("S");
                } else if (this.blocked[i][j]) {
                    System.out.print("X");
                } else if (this.visited[i][j]) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("|");
            System.out.println();
    
        }
        System.out.println("*---------------------------------------*");
    }

    public int getPlayerRow() {
        return this.player[ROW];
    }

    public int getPlayerCol() {
        return this.player[COL];
    }

    public int getGoalRow() {
        return this.goal[ROW];
    }

    public int getGoalCol() {
        return this.goal[COL];
    }

    public int getStartRow() {
        return this.start[ROW];
    }

    public int getStartCol() {
        return this.start[COL];
    }

    public boolean[][] getBlocked() {
        return copyTwoDimBoolArray(blocked);
    }

    public boolean[][] getVisited() {
        return copyTwoDimBoolArray(visited);
    }

    public Scanner getPlayerInput() {
        return this.playerInput;
    }

    public void setPlayerRow(int row) {
        if (row >= 0 && row < HEIGHT) {
            this.player[ROW] = row;
        }
    }

    public void setPlayerCol(int col) {
        if (col >= 1 && col < WIDTH) {
            this.player[COL] = col;
        }
    }

    public void setGoalRow(int row) {
        if (row >= 0 && row < HEIGHT) {
            this.goal[ROW] = row;
        }
    }

    public void setGoalCol(int col) {
        if (col >= 1 && col < WIDTH) {
            this.goal[COL] = col;
        }
    }

    public void setStartRow(int row) {
        if (row >= 0 && row < HEIGHT) {
            this.start[ROW] = row;
        }
    }

    public void setStartCol(int col) {
        if (col >= 1 && col < WIDTH) {
            this.start[COL] = col;
        }
    }

    public void setBlocked(boolean[][] blocked) {
        boolean[][] copy = copyTwoDimBoolArray(blocked);
        this.blocked = copy;
    }

    public void setVisited(boolean[][] visited) {
        boolean[][] copy = copyTwoDimBoolArray(visited);
        this.visited = copy;
    }

    public void setPlayerInput(Scanner playerInput) {
        this.playerInput = playerInput;
    }

    private boolean[][] copyTwoDimBoolArray(boolean[][] arrayToCopy) {
        boolean[][] copy = new boolean[arrayToCopy.length][arrayToCopy[0].length];
        for (int i = 0; i < arrayToCopy.length; i++) {
            for (int j = 0; j < arrayToCopy[0].length; j++) {
                copy[i][j] = arrayToCopy[i][j];
            }
        }
        return copy;
    }

    private void prompt() {
        printMaze();
        System.out.print("Enter your move (up, down, left, right, or q to quit): ");
    }

    private boolean playerAtGoal() {
        return this.player[ROW] == this.goal[ROW] && this.player[COL] == this.goal[COL];
    }

    private boolean valid(int row, int col) {
        return row >= 0 && row < HEIGHT && col >= 0 && col < WIDTH && !this.blocked[row][col];
    }   

    private void visit(int row, int col) {
        this.visited[row][col] = true;
    }

    private void loadMaze(String mazeFile) throws FileNotFoundException {
        setBlocked(new boolean[HEIGHT][WIDTH]);
        setVisited(new boolean[HEIGHT][WIDTH]);
        this.player = new int[2];
        this.goal = new int[2];
        this.start = new int[2];

        Scanner fileScanner = new Scanner(new File(mazeFile));

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                String ch = fileScanner.next();
    
                switch (ch) {
                    case "S":
                        this.start[0] = i;
                        this.start[1] = j;
                        this.player[0] = i;
                        this.player[1] = j;
                        break;
                    case "G":
                        this.goal[0] = i;
                        this.goal[1] = j;
                        break;
                    case "1":
                        this.blocked[i][j] = true;
                        break;
                    case "0":
                        this.blocked[i][j] = false;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private boolean makeMove(String move) {
        move = move.toLowerCase();
    
        int newRow = getPlayerRow();
        int newCol = getPlayerCol();
    
        switch (move.charAt(0)) {
            case 'q':
                return true;
            case 'd':
                newRow++;
                break;
            case 'u':
                newRow--;
                break;
            case 'l':
                newCol--;
                break;
            case 'r':
                newCol++;
                break;
            default:
                break;
        }
    
        if (valid(newRow, newCol)) {
            visit(newRow, newCol);
            setPlayerRow(newRow);
            setPlayerCol(newCol);
            return playerAtGoal();
        } else {
            return false;
        }
    }
}
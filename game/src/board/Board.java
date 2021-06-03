package board;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board
{
    /**
     * Fields:
     */
    boolean[][] board2D; //2D Representation of the Board
    boolean[][][] board3D; //3D Representation of the Board
    int lenX, lenY, lenZ; //x, y and z dimensions of the board

    /**
     * Constructors:
     */
    public Board(boolean[][] board2D)
    {
        this.board2D = board2D;
    }

    public Board(boolean[][][] board3D)
    {
        this.board3D = board3D;
    }

    /**
     * Constructor to create a 2D Board From a Filename that represents a .txt file with the board
     *  Boards come in this format: T = alive, F = dead
     *
     *  file:
     *  5 5
     *  T T T T T
     *  F T F T F
     *  T F T F T
     *  F F F F F
     *
     *  The File's first line contains the dimensions of the grid, then subsequent lines represent the grid's contents
     * @param filename is the name of the file as a String(this String includes the path as well)
     */
    public Board(String filename) //this won't work, remake with 2 scanners, one for the row and another to scan each row
    {
        try{
            File f = new File(filename);
            Scanner sc = new Scanner(f);

            lenX = sc.nextInt();
            lenY = sc.nextInt();

            board2D = new boolean[lenX][lenY];

            String row;

            for(int i=0; i<lenX;++i){
                 row = sc.nextLine();

                for(int j=0;j<row.length();++j){
                    if(row.charAt(j) != ' '){
                        if(row.charAt(j) == 'T') board2D[i][j/2] = true;
                        else if(row.charAt(j) == 'F') board2D[i][j/2] = false;
                        else throw new IllegalArgumentException();
                    }
                }
            }

        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IllegalArgumentException e){
            System.out.println("File Format is Incorrect, Cells must be Populated by Either T or F");
            e.printStackTrace();
        }

    }

    /**
     * Void to Update the Board According to the Game of Life:
     *  DA RULEZ:
     *      1. Any live cell with fewer than 2 live neighbors dies, as if by underpopulation
     *      2. Any live cell with 2 or 3 neighbors lives to the next generation
     *      3. Any live cell with more than 3 neighbors dies, as if by overpopulation
     *      4. Any dead cell with exactly 3 live neighbors becomes a live cell, as if by reproduction
     */
    public void updateBoard2D()
    {
        for(int i=0;i<lenX;++i){
            for(int j=0;j<lenY;++j){

            }
        }
    }

    /**
     * Finds the number of adjacent live neighbors
     * @param x is the x coordinate of the cell
     * @param y is the y coordinate of the cell
     * @return the number of live neighbors as an integer
     */
    public int findLiveNeighbors(int x, int y)
    {
        //X = ROW
        //Y = COLUMN
        int numLiving=0;

        if(x==0 && y==0) { //upper left corner
            //TODO: Search the [x+1][y], [x][y+1] and [x+1][y+1] cells
            for(int i=0;i<=1;++i){ //rows
                for(int j=0;j<=1;++j){ //cols
                    if(i==0 && j==0); //skip at (0,0)
                    else{
                        if(board2D[x+i][y+j] == true) numLiving++;
                    }
                }
            }
        } else if(x==lenX-1 && y==0){ //lower left corner
            //TODO: Search the [x+1][y], [x][y-1] and [x+1][y-1] cells
            for(int i=0;i<=1;++i){ //rows
                for(int j=0;j<=1;++j){ //cols
                    if(i==x && j==y); //skip at (lenX, 0)
                    else{
                        if(board2D[x+i][y-j] == true) numLiving++;
                    }
                }
            }
        } else if(x==0 && y==lenY-1){ //upper right corner
            //TODO: Find [x][y-1], [x+1][y-1] and [x+1][y] cells
            for(int i=0;i<=1;++i){ //rows
                for(int j=0;j<=1;++j){ //cols
                    if(i==)
                }
            }
        } else if(x==lenX-1 &&y==lenY-1){ //lower right corner
            //TODO: Find [x][y-1], [x-1][y-1] and [x-1][y] cells
        } else if(y==0 && (x!=0 || x!=lenX-1)){ //left edge
            //TODO: Find [x-1][y], [x-1][y+1], [x][y+1], [x+1][y+1] and [x+1][y] cells
        } else if(y==lenY-1 && (x!=0 || x!=lenX-1)){ //right edge
            //TODO: Find [x-1][y], [x-1][y-1], [x][y-1], [x+1][y-1] and [x+1][y-1] cells
        }else if(x==0 && (y!=0 || y!=lenY-1)){ //top edge
            //TODO: Find [x][y-1], [x+1][y-1], [x+1][y], [x+1][y+1] and [x][y+1] cells
        }else if(x==lenX-1 && (y!=0 || y!=lenY-1)){ //bottom edge
            //TODO: Find [x-1][y], [x-1][y-1], [x][y-1], [x+1][y-1] and [x+1][y] cells
        } else{ //normal cell
            //TODO: Find all Neighbors
        }
        return numLiving;
    }
}

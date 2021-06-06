import board.Board;

import java.util.Scanner;

public class MainApplication
{
    public static void main(String[] args)
    {
        //initialize scanners and fields
        Scanner sc = new Scanner(System.in);
        String filename;
        int numCycles;

        //Take in the File
        System.out.println("Welcome to Conway's Game of Life!");
        System.out.println("Please Enter the Path and Filename of the Board You Want to Use:\n");
        filename = sc.nextLine();
        sc.nextLine();

        //Create the Board
        Board b = new Board(filename);

        //Take in the Number of Iterations for the Board to Go Through
        System.out.println("How many iterations do you want the game to go through?");
        System.out.println("Please Enter an Integer Amount Below:");
        numCycles = sc.nextInt();
        sc.nextLine();

        sc.close();

        //Run the Program
        for(int i=0;i<numCycles;++i){
            System.out.println("Cycle: " + i);
            System.out.println(b.toString());
        }
        System.out.println("Done!");
    }
}

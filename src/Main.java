import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main
{
    //Variables
    static int rows = 6;
    static int columns = 7;
    static String[][] array = new String[rows][columns];
    static int counter= 0;
    //Object Lists
    static List<Positions> positionslist = new ArrayList<Positions>();
    static List<Positions> availablePos = new ArrayList<Positions>();

    public static void setUpBoard()
    {
        for(int i = 0; i<rows; i++)
            for(int j = 0; j<columns; j++)
                array[i][j] = "*";
        for(int i =0;i<rows;i++) {
            array[i][2] = "|";
            array[i][4] = "|";
            array[i][0] = " ";
            array[i][6] = " ";
        }
        for(int j=0;j<columns;j++)
        {
            array[2][j] = "-";
            array[0][j] = " ";
            array[4][j] = "-";
        }

        Positions TL = new Positions("TL","-",0,1,1);
        Positions TM = new Positions("TM","-",0,1,3);
        Positions TR = new Positions("TR","-",0,1,5);

        Positions MR = new Positions("MR","-",0,3,5);
        Positions MM = new Positions("MM","-",0,3,3);
        Positions ML = new Positions("ML","-",0,3,1);

        Positions BL = new Positions("BL","-",0,5,1);
        Positions BM = new Positions("BM","-",0,5,3);
        Positions BR = new Positions("BR","-",0,5,5);
        positionslist.add(TL);
        positionslist.add(TM);
        positionslist.add(TR);
        positionslist.add(MR);
        positionslist.add(MM);
        positionslist.add(ML);
        positionslist.add(BL);
        positionslist.add(BM);
        positionslist.add(BR);
        return;
    }
    public static void printBoard()
    {



        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<columns; j++)
            {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

   // public static String[] checkMoves()
   // {


       // return playerMoves;
    //}


    public static void main(String[] args) {
        boolean active = true;
        boolean moved;

        Player playerone = new Player(0, "x", 0);
        Player playertwo = new Player(1, "o", 1);

        //Game Board

        setUpBoard();
        printBoard();

        /*
| X | X | X |
|   |   |   |
| x | X | X |
|   |   |   |
| X | X | X |
 */
        while (active) {
            moved = false;
            System.out.println(" ");
            checkAvailable();
            if (playerone.turn() == counter) {
                System.out.println("Player One Choose Your Turn");
            } else {
                System.out.println("Player Two Choose Your Turn");
            }
            System.out.println("Avilable Moves");
            for (Positions pos : availablePos) {
                System.out.print(" " + pos.getName() + " ");
            }
            System.out.println(" ");
            //  BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
           // while (moved) {
            if(!moved) {
                try {
                    // get input
                    InputStreamReader in = new InputStreamReader(System.in);
                    BufferedReader br = new BufferedReader(in);
                    String line = br.readLine();
                    // if input is in the available list
                    if(movement(line,counter))
                    {
                        moved=true;
                        if(counter == 0)
                        {
                            //move to player 2
                            counter++;
                        }
                        else
                        {
                            // go back to player one
                            counter =0;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

                printBoard();
                if(wincheck())
                {
                    active = false;
                }
                moved = false;
            }
        }
    //}

    private static void checkAvailable() {
        availablePos.clear();
        for(Positions pos :positionslist)
        {
            if(pos.getFilled() != 1)
            {
                availablePos.add(pos);
            }
        }
    }
    private static boolean wincheck()
    {
        if((array[1][1]=="x")&&(array[1][3]=="x")&&(array[1][5]=="x"))
        {
            System.out.println("Player One Wins");
            return true;
        }
        if((array[1][1]=="o")&&(array[1][3]=="o")&&(array[1][5]=="o"))
        {
            System.out.println("Player Two Wins");
            return true;
        }
        if((array[3][1]=="o")&&(array[3][3]=="o")&&(array[3][5]=="o"))
        {
            System.out.println("Player Two Wins");
            return true;
        }

        if((array[3][1]=="x")&&(array[3][3]=="x")&&(array[3][5]=="x"))
        {
            System.out.println("Player One Wins");
            return true;
        }
        if((array[5][1]=="x")&&(array[5][3]=="x")&&(array[5][5]=="x"))
        {
            System.out.println("Player One Wins");
            return true;
        }
        if((array[5][1]=="o")&&(array[5][3]=="o")&&(array[5][5]=="o"))
        {
            System.out.println("Player Two Wins");
            return true;
        }
        if((array[1][1]=="o")&&(array[3][1]=="o")&&(array[5][1]=="o"))
        {
            System.out.println("Player Two Wins");
            return true;
        }
        if((array[1][1]=="x")&&(array[3][1]=="x")&&(array[5][1]=="x"))
        {
            System.out.println("Player One Wins");
            return true;
        }
        if((array[1][3]=="x")&&(array[3][3]=="x")&&(array[5][3]=="x"))
        {
            System.out.println("Player One Wins");
            return true;
        }
        if((array[1][3]=="o")&&(array[3][3]=="o")&&(array[5][3]=="o"))
        {
            System.out.println("Player Two Wins");
            return true;
        }
        if((array[1][5]=="x")&&(array[3][5]=="x")&&(array[5][5]=="x"))
        {
            System.out.println("Player One Wins");
            return true;
        }
        if((array[1][5]=="o")&&(array[3][5]=="o")&&(array[5][5]=="o"))
        {
            System.out.println("Player Two Wins");
            return true;
        }
        if((array[1][1]=="o")&&(array[3][3]=="o")&&(array[5][5]=="o"))
        {
            System.out.println("Player Two Wins");
            return true;
        }
        if((array[1][1]=="x")&&(array[3][3]=="x")&&(array[5][5]=="x"))
        {
            System.out.println("Player One Wins");
            return true;
        }
        return false;
    }
    private static boolean movement(String input,int player)
    {
        for (Positions pos : availablePos) {
            if(pos.getName().equals(input))
            {
                int row = pos.getRow();
                int col = pos.getCol();
                if(player == 1)
                {
                    pos.setCounter("x");
                    array[row][col]="x";
                }
                else
                {
                    pos.setCounter("o");
                    array[row][col]="o";
                }
                pos.setFilled(1);
                return true;
            }
        }return false;
    }
}
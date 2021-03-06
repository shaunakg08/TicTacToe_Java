import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static String[] gameBoard= {" "," "," "," "," "," "," "," "," "};

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!!");
        dispgameBoard();
        int pos=0;

        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number (1-9) to insert X ");
            String input = sc.nextLine();

            try {
                int in=Integer.valueOf(input);
                pos=in;
            }
            catch (NumberFormatException e)
            {                System.out.println("Invalid input. Please enter Relevant!!");            }

            if(isValidMove(pos)==true){
                placepiece(1,pos);
            }
            else
            {  System.out.println("Invalid Move. Position already taken!");
                continue; 
            }
            
            dispwinner();
            computerMove();
            dispwinner();          
            System.out.print("\u000c");
            dispgameBoard(); 
        }
    }

    private static void dispgameBoard() 
    {        
        System.out.println("/---|---|---\\"+"\n"+"| " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " |"+"\n"+"|-----------|"+"\n"+"| " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " |"+"\n"+"|-----------|"+"\n"+"| " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " |"+"\n"+"\\---|---|---/");
    }

    private static void placepiece(int player, int pos) {
        String symbol=(player==1)?"X":"0";        

        switch(pos){

            case 1 :
            gameBoard[0] = symbol;
            break;
            case 2 :
            gameBoard[1] = symbol;
            break;
            case 3 :
            gameBoard[2] = symbol;
            break;
            case 4 :
            gameBoard[3] = symbol;
            break;
            case 5 :
            gameBoard[4] = symbol;
            break;
            case 6 :
            gameBoard[5] = symbol;
            break;
            case 7:
            gameBoard[6] = symbol;
            break;
            case 8 :
            gameBoard[7] = symbol;
            break;
            case 9 :
            gameBoard[8] = symbol;
            break;

        }
    }

    private static boolean isValidMove(int move){

        switch (move){
            case 1:
            return (gameBoard[0]==" ")?true:false;
            case 2:
            return (gameBoard[1]==" ")?true:false;
            case 3:
            return (gameBoard[2]==" ")?true:false;        
            case 4:
            return (gameBoard[3]==" ")?true:false;
            case 5:
            return (gameBoard[4]==" ")?true:false;
            case 6:
            return (gameBoard[5]==" ")?true:false;
            case 7:
            return (gameBoard[6]==" ")?true:false;
            case 8:
            return (gameBoard[7]==" ")?true:false;
            case 9:
            return (gameBoard[8]==" ")?true:false;

            default:
            return false;
        }
    }

    private static void computerMove(){

        while(true){
            Random rand = new Random();
            int pcpos = rand.nextInt(9)+1;
            if(isValidMove(pcpos)==true)
            {    placepiece(0,pcpos);
                break;
            }
        }
    }

    private static int checkWinner(){
        int winner=99;
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                line = gameBoard[0] + gameBoard[1] + gameBoard[2];
                break;
                case 1:
                line = gameBoard[3] + gameBoard[4] + gameBoard[5];
                break;
                case 2:
                line = gameBoard[6] + gameBoard[7] + gameBoard[8];
                break;
                case 3:
                line = gameBoard[0] + gameBoard[3] + gameBoard[6];
                break;
                case 4:
                line = gameBoard[1] + gameBoard[4] + gameBoard[7];
                break;
                case 5:
                line = gameBoard[2] + gameBoard[5] + gameBoard[8];
                break;
                case 6:
                line = gameBoard[0] + gameBoard[4] + gameBoard[8];
                break;
                case 7:
                line = gameBoard[2] + gameBoard[4] + gameBoard[6];
                break;
            }

            if (line.equals("XXX")) {
                winner=1;
                break;

            } else if (line.equals("OOO")) {
                winner=0;
                break;
            }
            else{
                boolean isFull = true;
                for(String s : gameBoard) {
                    if(s == " ") {
                        isFull = false;
                        break;
                    }
                }
                if(isFull==true)
                    winner=-1;
            }            
        }        
        return winner;        
    }

    private static void dispwinner(){
        if(checkWinner() == 1)
        {   System.out.print("\u000c");
            dispgameBoard();
            System.out.println("Player Won!");
            System.out.println("Thanks for playing");
            System.exit(0);
        }
        else if(checkWinner() == 0)
        {   System.out.print("\u000c");
            dispgameBoard();
            System.out.println("Computer Won!");
            System.out.println("Thanks for playing");
            System.exit(0);
        }else if(checkWinner()==-1)
        {   System.out.print("\u000c");
            dispgameBoard();
            System.out.println("ITS A DRAW!");
            System.out.println("Thanks for playing");            
            System.exit(0);
        }
    }
}

import java.util.Scanner;
import java.util.Random;


public class TicTacToe {

    static String[] gameBoard= {" "," "," "," "," "," "," "," "," "};
   

    public static void main() {

        System.out.println("Welcome to Tic Tac Toe!!");
        dispgameBoard();
        int pos=0;

        while(true){
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter a number (1-9) to insert X ");
            String input = scan.nextLine();

            try {
                int in=Integer.valueOf(input);
                pos=in;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input");
            }

            if(isValidMove(pos)==true){
                placepiece(1,pos);
            }
            else
            {  System.out.println("Invalid Move");
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
        System.out.println("/---|---|---\\");
        System.out.println("| " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " |");
        System.out.println("\\---|---|---/");

    }

    private static void placepiece(int player, int pos) {

        String symbol;
        if(player==1){
            symbol = "X";
        }else{
            symbol = "O";
        }

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

            default:
            System.out.println("invalid input");
            break;

        }

    }

    private static boolean isValidMove(int move){

        switch (move){
            case 1:
            if(gameBoard[0] == " "){
                return true;
            } else{
                return false;
            }
            case 2:
            if(gameBoard[1] == " "){
                return true;
            } else{
                return false;
            }
            case 3:
            if(gameBoard[2] == " "){
                return true;
            } else{
                return false;
            }

            case 4:
            if(gameBoard[3] == " "){
                return true;
            } else{
                return false;
            }
            case 5:
            if(gameBoard[4] == " "){
                return true;
            } else{
                return false;
            }
            case 6:
            if(gameBoard[5] == " "){
                return true;
            } else{
                return false;
            }
            case 7:
            if(gameBoard[6] == " "){
                return true;
            } else{
                return false;
            }
            case 8:
            if(gameBoard[7] == " "){
                return true;
            } else{
                return false;
            }
            case 9:
            if(gameBoard[8] == " "){
                return true;
            } else{
                return false;
            }

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
        //Horizontal Wins
        if(gameBoard[0] == "X"&& gameBoard[1] == "X" && gameBoard [2] == "X" ){
            winner=1;

        }else
        if(gameBoard[0] == "O"&& gameBoard[1] == "O" && gameBoard [2] == "O" ){
            winner=0;

        }else
        if(gameBoard[3] == "X"&& gameBoard[4] == "X" && gameBoard [5] == "X" ){
            winner=1;

        }else
        if(gameBoard[3] == "O"&& gameBoard[4] == "O" && gameBoard [5] == "O" ){
            winner=0;

        }else
        if(gameBoard[6] == "X"&& gameBoard[7] == "X" && gameBoard [8] == "X" ){
            winner=1;

        }else
        if(gameBoard[6] == "O" && gameBoard[7] == "O" && gameBoard [8] == "O" ) {
            winner=0;

        }

        //Vertical Wins
        if(gameBoard[0] == "X"&& gameBoard[3] == "X" && gameBoard [6] == "X" ){
            winner=1;

        }else
        if(gameBoard[0] == "O"&& gameBoard[3] == "O" && gameBoard [6] == "O" ){
            winner=0;

        }else

        if(gameBoard[1] == "X"&& gameBoard[4] == "X" && gameBoard [7] == "X" ){
            winner=1;

        }else
        if(gameBoard[1] == "O"&& gameBoard[4] == "O" && gameBoard [7] == "O" ){
            winner=0;

        }else if(gameBoard[2] == "X"&& gameBoard[5] == "X" && gameBoard [8] == "X" ){
            winner=1;

        }else
        if(gameBoard[2] == "O"&& gameBoard[5] == "O" && gameBoard [8] == "O" ){
            winner=0;

        }

        //Diagonal Wins
        if(gameBoard[0] == "X"&& gameBoard[4] == "X" && gameBoard [8] == "X" ){
            winner=1;

        }else
        if(gameBoard[0] == "O"&& gameBoard[4] == "O" && gameBoard [8] == "O" ){
            winner=0;

        }else

        if(gameBoard[2] == "X"&& gameBoard[4] == "X" && gameBoard [6] == "X" ){
            winner=1;

        }else
        if(gameBoard[2] == "O"&& gameBoard[4] == "O" && gameBoard [6] == "O" ){
            winner=0;

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
            System.out.println("ITS A DRAW!");
            System.exit(0);
        }

    }

}

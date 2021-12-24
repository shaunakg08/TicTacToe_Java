import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static String[] gameBoard= {" "," "," "," "," "," "," "," "," "};;

    public static void main(String[] args
	) {
        int count= 0 ;

        System.out.println("Welcome to Tic Tac Toe!!");
        dispgameBoard();

        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a number (1-9) to insert X ");
            int pos = scan.nextInt();

            if(isValidMove(pos)==true){
                placepiece(1,pos);
                count++;
            }
            else
            {  System.out.println("Invalid Move");
                continue; 
            }
            
            if(checkWinner()==true)
            {   
                dispgameBoard();
                checkWinner();
                System.out.println("Thanks for playing");
                System.exit(0);
            }

            computerMove();
            count++;
            System.out.print("\u000c");

            if(checkWinner()==true)
            {   dispgameBoard();
                checkWinner();
                System.out.println("Thanks for playing");
                System.exit(0);
            }else if(count==9){
                System.out.println("Its a DRAW!");
            }
            else 
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
            int pospc = rand.nextInt(9)+1;
            if(isValidMove(pospc)==true)
            {    placepiece(0,pospc);
                break;
            }

        }

    }

    private static boolean checkWinner(){

        //Horizontal Wins
        if(gameBoard[0] == "X"&& gameBoard[1] == "X" && gameBoard [2] == "X" ){
            System.out.println("Player Wins");

            return true;
        }else
        if(gameBoard[0] == "O"&& gameBoard[1] == "O" && gameBoard [2] == "O" ){
            System.out.println("Computer Wins");

            return true;
        }else
        if(gameBoard[3] == "X"&& gameBoard[4] == "X" && gameBoard [5] == "X" ){
            System.out.println("Player Wins");

            return true;
        }else
        if(gameBoard[3] == "O"&& gameBoard[4] == "O" && gameBoard [5] == "O" ){
            System.out.println("Computer Wins");

            return true;
        }else
        if(gameBoard[6] == "X"&& gameBoard[7] == "X" && gameBoard [8] == "X" ){
            System.out.println("Player Wins");

            return true;
        }else
        if(gameBoard[6] == "O" && gameBoard[7] == "O" && gameBoard [8] == "O" ) {
            System.out.println("Computer Wins");

            return true;
        }

        //Vertical Wins
        if(gameBoard[0] == "X"&& gameBoard[3] == "X" && gameBoard [6] == "X" ){
            System.out.println("Player Wins");

            return true;
        }else
        if(gameBoard[0] == "O"&& gameBoard[3] == "O" && gameBoard [6] == "O" ){
            System.out.println("Computer Wins");

            return true;
        }else

        if(gameBoard[1] == "X"&& gameBoard[4] == "X" && gameBoard [7] == "X" ){
            System.out.println("Player Wins");

            return true;
        }else
        if(gameBoard[1] == "O"&& gameBoard[4] == "O" && gameBoard [7] == "O" ){
            System.out.println("Computer Wins");

            return true;
        }else if(gameBoard[2] == "X"&& gameBoard[5] == "X" && gameBoard [8] == "X" ){
            System.out.println("Player Wins");

            return true;
        }else
        if(gameBoard[2] == "O"&& gameBoard[5] == "O" && gameBoard [8] == "O" ){
            System.out.println("Computer Wins");

            return true;
        }

        //Diagonal Wins
        if(gameBoard[0] == "X"&& gameBoard[4] == "X" && gameBoard [8] == "X" ){
            System.out.println("Player Wins");

            return true;
        }else
        if(gameBoard[0] == "O"&& gameBoard[4] == "O" && gameBoard [8] == "O" ){
            System.out.println("Computer Wins");

            return true;
        }else

        if(gameBoard[2] == "X"&& gameBoard[4] == "X" && gameBoard [6] == "X" ){
            System.out.println("Player Wins");

            return true;
        }else
        if(gameBoard[2] == "O"&& gameBoard[4] == "O" && gameBoard [6] == "O" ){
            System.out.println("Computer Wins");

            return true;
        }

        return false;
    }
}


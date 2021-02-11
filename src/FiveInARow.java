/**Purpose:
 * The class named FiveInARow is a class for the game five in a row. which have 6 states
 * two int states: row,column ,two Person states: blackGuy, whiteGuy ,one boolean state and one char，
 * and 2-dimensional array gameBd.
 *
 * The class has one constructor with four parameters,it will get the row,column number and two players
 * to set up the game board size. the winner has a default value false.
 *
 * The class has setter and getter for five states except the gameBd.
 *
 * The class has a method named initialGameBoard() is to initialize the game board, it will set every position
 * available to put the piece with "-"
 *
 * the method has a overloading one which is initialGameBoard( int size) is to initialize the game board, it will set every position
 * available to put the piece with "-"
 *
 * The class has a method named printGameBoard(),it will print the game board, it will show the column
 * and row number and all items in the game board.
 *
 * The class has two method named setBlack() and setWhite(). When black player or white player put a piece
 * in row and column position,it will marks by "B" or "W"
 *
 * The class has a method named IsAvailableSetting(int theRow,int theColumn),which will return a boolean value, showing
 * whether the gameBoard position in the row and column can be putted a piece.
 *
 * The class has a method named getWinner(Person player),which will return a boolean value, showing whether
 * the player win the game.
 *
 * The class has a method named endTheGame(),which will return a boolean value , showing whether there's a place to put
 * more piece.if not return yes, otherwise return no
 *
 * The class has a static method named playGame(Person p1,Person p2) which is to play a game with two player.
 * If there's winner or there's no position to put the piece ,the game ends
 *
 *
 * Name:Dan Zhao
 * Date:Dec 16th 2020
 * */


//import the libraries
import java.util.InputMismatchException;
import java.util.Scanner;

public class FiveInARow {
    //six states
    private int row;
    private int column;
    private Person blackGuy;
    private Person whiteGuy;
    private Boolean winner;

    private char [][] gameBd;
    //the constructor with four parameters,
    FiveInARow(int theRow, int theColumn,Person black,Person white){
        row=theRow;
        column=theColumn;
        blackGuy=black;
        whiteGuy=white;
        gameBd= new char[row][column];
        winner=false;

    }



    //setter and getter
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Person getBlackGuy() {
        return blackGuy;
    }

    public void setBlackGuy(Person blackGuy) {
        this.blackGuy = blackGuy;
    }

    public Person getWhiteGuy() {
        return whiteGuy;
    }

    public void setWhiteGuy(Person whiteGuy) {
        this.whiteGuy = whiteGuy;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }



    //initialize the game board, it will set every position available to put the piece with "-"
    public void initialGameBoard(){
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                gameBd[i][j]='-';
            }
        }

    }
    //method overloading
    public void initialGameBoard(int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                gameBd[i][j]='-';
            }
        }

    }

    // check whether there's a place to put a piece, if not return true for endGame
    public boolean endTheGame(){
        int count =0;
        boolean endGame=false;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(gameBd[i][j]=='-'){
                    count++;
                }

            }
        }
        if(count==0){
            endGame=true;
        }
        return endGame;
    }




    //print the game board, it will show the column and row number and all items in the game board
    public void printGameBoard(){
        //print the position number of the column at the first line.
        System.out.print("   ");
        for (int i=0;i<column-1;i++){

            if(i/10==0)
            {
                System.out.print("0"+i+" ");
            }
            else{
                System.out.print((i)+" ");
            }

        }
        //print the position number of the row and all items of the game board.
        System.out.println(column-1);
        int position=0;
        for(int i=0;i<row;i++){

            for(int j=0;j<column-1;j++){
                if(j==0){

                    if(position/10==0)
                    {
                        System.out.print("0"+i+" ");
                    }
                    else{
                        System.out.print((i)+" ");
                    }
                    position++;
                }
                System.out.print(gameBd[i][j]+"  ");

            }
            System.out.println(gameBd[i][column-1]);
        }

    }


    //if black player put a piece in row and column position, it will marks by "B"
    public void setBlack(int theRow,int theColumn){
        Character blackChar= 'B';

        gameBd[theRow][theColumn]=blackChar.charValue();


    }
    //if black player put a piece in row and column position, it will marks by "W"
    public void setWhite(int theRow,int theColumn){
        Character whiteChar= 'W';

        gameBd[theRow][theColumn]=whiteChar.charValue();

    }

    //check whether the gameBoard position in row and column can be putted a piece.
    public boolean IsAvailableSetting(int theRow,int theColumn){

        boolean availableSetting;
        if(gameBd[theRow][theColumn]=='-'){
             availableSetting=true;
        }else{
             availableSetting=false;
        }
        return availableSetting;
    }
    //check whether the player win the game.
    public boolean getWinner(Person player){
        char colour =player.getColor().charAt(0);
        int count;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(gameBd[i][j]==colour){
                    //check whether 5 connected in a same row
                     if(winner==false) {
                         count = 1;
                         for (int n = 1; n + j < column && n < 5; n++) {
                             if (gameBd[i][j + n] == colour) {
                                 count++;
                             }
                         }
                         if (count == 5) {
                             winner = true;
                             System.out.println(player.getName() + " is" + " winner");
                         }

                     }

                    //check whether 5 connected in a same column

                    if(winner==false) {
                        count = 1;
                        for (int n = 1; n + i < row && n < 5; n++) {
                            if (gameBd[i+n][j] == colour) {
                                count++;
                            }
                        }
                        if (count == 5) {
                            winner = true;
                            System.out.println(player.getName() + " is " + " winner");
                        }

                    }
                    //check whether 5 from this to the clockwise diagonally
                    if(winner==false) {
                        count = 1;
                        for (int n = 1; n + j < row && i-n>-1&&n < 5; n++) {
                            if (gameBd[i-n][j+n] == colour) {
                                count++;

                            }
                        }
                        if (count == 5) {
                            winner = true;
                            System.out.println(player.getName() + " is " + " winner");
                        }

                    }
                    //check whether 5 from this to the counterclockwise diagonally
                    if(winner==false) {
                        count = 1;
                        for (int n = 1; j-n > -1 && i-n>-1 && n < 5; n++) {
                            if (gameBd[i-n][j-n] == colour) {
                                count++;

                            }
                        }
                        if (count == 5) {
                            winner = true;
                            System.out.println(player.getName() + " is " + " winner");
                        }

                    }




                }
            }
        }
        return winner;
    }

    //a static method to play a game with two player
    public static void playGame(Person p1,Person p2){
        while (true) {

            try {
                Scanner in2 = new Scanner(System.in);

                System.out.println("input the game board size");
                int gameBoardSize = in2.nextInt();
                //the game board size must bigger than 4
                while(gameBoardSize<5){
                    System.out.println("please input a number bigger than 4");
                    gameBoardSize=in2.nextInt();
                }
                //start a new game and print the game board
                FiveInARow newGame1 = new FiveInARow(gameBoardSize, gameBoardSize, p1, p2);

                newGame1.initialGameBoard();
                newGame1.printGameBoard();


                int round = 1;
                //if there's no winner and still has position to put the piece,keep going.
                // if they input wrong thing,let them input again
                while (newGame1.getWinner(p1) == false && newGame1.getWinner(p2) == false && !newGame1.endTheGame()) {

                    System.out.println("round:" + round);

                    //the black player's turn to put piece.
                    do {

                        try {
                            Scanner in = new Scanner(System.in);
                            System.out.println(p1.getName() + " please input your Row Number ");
                            int blackRow = in.nextInt();
                            System.out.println(p1.getName() + " input your column Number ");
                            int blackColumn = in.nextInt();

                            if (newGame1.IsAvailableSetting(blackRow, blackColumn)) {
                                newGame1.setBlack(blackRow, blackColumn);
                                newGame1.printGameBoard();
                                break;
                            } else {
                                System.out.println("You cannot set the black here ");
                            }

                        }
                        //if they input the wrong things, let them input again
                        catch (NegativeArraySizeException e){
                            System.out.println("please input available position");
                            continue;
                        }
                        catch (InputMismatchException e){
                            System.out.println("please input available position");
                            continue;
                        }
                        catch (ArrayIndexOutOfBoundsException e){
                            System.out.println("please input available position");
                            continue;
                        }


                    }while (!newGame1.endTheGame());
                    //if the black play does not win and there's still has position to put piece,
                    //then the white player do it
                    // if they input wrong thing,let them input again.
                    while (newGame1.getWinner(p1) == false && !newGame1.endTheGame()) {
                        try {
                            Scanner in = new Scanner(System.in);
                            System.out.println(p2.getName() + " please input your Row Number ");
                            int whiteRow = in.nextInt();
                            System.out.println(p2.getName() + " input your Column Number ");
                            int whiteColumn = in.nextInt();

                            if (newGame1.IsAvailableSetting(whiteRow, whiteColumn)) {
                                newGame1.setWhite(whiteRow, whiteColumn);
                                newGame1.printGameBoard();
                                break;
                            } else {
                                System.out.println("You cannot set the white here ");
                            }
                        }catch (NegativeArraySizeException e){
                            System.out.println("please input positive integer number");
                            continue;
                        }
                        catch (InputMismatchException e){
                            System.out.println("please input number of position");
                            continue;
                        }
                        catch (ArrayIndexOutOfBoundsException e){
                            System.out.println("please input integer number between 0 and "+(gameBoardSize-1));
                            continue;
                        }

                    }
                    round++;

                }
                //if the there's no place to put the piece, the game end and showing to players.
                if(newGame1.endTheGame()){
                    System.out.println("No place to put piece, the game is end");
                }
                break;
            }

            catch (NegativeArraySizeException e){
                System.out.println("please input available size of the game board");
                continue;
            }
            catch (InputMismatchException e){
                System.out.println("please input available size of the game board");
                continue;
            }
        }



    }


}

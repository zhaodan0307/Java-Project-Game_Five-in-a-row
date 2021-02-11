/*Purpose:
  the class named FiveInARowTestHarness is a test harness for the FiveInARow Class.
  In this class,first it will ask the player to input their name.
  then, the five in a row game will start to play.
  Name:Dan Zhao
  Date:Dec 16th 2020
  */
import java.util.Scanner;

public class FiveInARowTestHarness {
    public static void main(String[] args) {
        //ask the players to input their name
        Scanner in3 = new Scanner(System.in);
        System.out.println("please input the black player name ");
        Person p1 = new Person(in3.nextLine(), "Black");
        System.out.println("please input the white player name");
        Person p2 = new Person(in3.nextLine(), "White");
        //run the five in a row game
        FiveInARow.playGame(p1,p2);


    }
}

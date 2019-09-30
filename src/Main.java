import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        GameInterface game = new GameWorld();
//        while(true) {
//            System.out.println("Please enter a command");
//            String input = s.next();
//            System.out.println(game.handleInput(input));
//        }

        try {
            game.load("test1");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

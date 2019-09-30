import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Exception.InvalidCommandException;

public class GameWorld implements GameInterface{

    Character player;
    private ArrayList<ArrayList<Room>> rooms;


    //creates a world with 10*10 rooms
    GameWorld() {
        rooms = new ArrayList<>();
        for(int x = 0; x < 10; x++){
            ArrayList<Room> col = new ArrayList<>();
            for(int y = 0; y < 10; y++){
                col.add(new Room(x,y,String.format("Room (%d, %d)", x, y)));
            }
            rooms.add(col);
        }
    }


    void createCharacterRandomPosition(String name){
        Random r = new Random();
        int x = r.nextInt(10);
        int y = r.nextInt(10);
        player = new Character(name, x, y);
        getRoom(x, y).setC(player);
    }

    void createCharacter(String name, int x, int y){
        player = new Character(name, x, y);
        getRoom(x, y).setC(player);
    }

    //1 is UP
    //2 is DOWN
    //3 is LEFT
    //4 is RIGHT
    void playerMoveOneStep(int d) throws Exception {
        getRoom(player.getX(), player.getY()).setC(null);
        switch (d){
            case 1:{
                player.setY(player.getY()+1);
                break;
            }
            case 2:{
                player.setY(player.getY()-1);
                break;
            }
            case 3:{
                player.setX(player.getX()-1);
                break;
            }
            case 4:{
                player.setX(player.getX()+1);
                break;
            }
            default:{
                throw new Exception("movement has to be 1~4");
            }
        }

        getRoom(player.getX(), player.getY()).setC(player);
    }

    Room getRoom(int x, int y){
        return rooms.get(x).get(y);
    }

    public String printRooms() {
        StringBuilder s = new StringBuilder();
        for (ArrayList<Room> col : rooms) {
            for (Room room : col) {
                s.append(room);
                s.append("\n");
            }
        }
        return s.toString();
    }

    @Override
    public String toString() {
        return "Player status:" + player.toString();
    }

    @Override
    public String handleInput(String input) {
        StringBuilder stringBuilder = new StringBuilder();
//        if(input.startsWith("!")){
//            if(input.substring(1).equals("up")){
//                // input == !up
//                try {
//                    playerMoveOneStep(1);
//                    stringBuilder.append("Player has moved up one position \n");
//                } catch (Exception d) {
//                    stringBuilder.append("Player failed to move up");
//                }
//            }
//            else if (input.substring(1).equals("rooms")){
//                stringBuilder.append(printRooms());
//            }
//        }
        String option;
        try {
            option = CommandHandler.validateCommand(input);
        } catch (InvalidCommandException e) {
            stringBuilder.append("Command Entered is invalid");
            return stringBuilder.toString();
        }
        catch (IllegalArgumentException e){
            stringBuilder.append("This is not a command");
            return stringBuilder.toString();
        }
        return stringBuilder.toString();
    }

    @Override
    public void write(String documentName) throws FileNotFoundException {
        PrintWriter out = null;
        out = new PrintWriter(documentName);
        out.write(String.format("%d, %d", player.getX(), player.getY()));
        out.close();
    }

    @Override
    public void load(String documentName) throws FileNotFoundException{
        Scanner in = new Scanner(new File(documentName));
        int x = in.nextInt();
        int y = in.nextInt();

        createCharacter("ximin", x, y);
    }
}

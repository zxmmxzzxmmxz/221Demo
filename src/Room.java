import java.util.Scanner;

public class Room {
    private int x;
    private int y;
    private String label;
    private Character c;
    Scanner s;

    Room(int x, int y, String label){
        this.x = x;
        this.y = y;
        this.label = label;
        s = new Scanner(System.in);
    }

    Room(int x, int y, String label, Character c){
        this.x = x;
        this.y = y;
        this.label = label;
        this.c = c;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Character getC() {
        return c;
    }

    public void setC(Character c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return label +" "+ (c == null ? "" : c.toString());
    }
}

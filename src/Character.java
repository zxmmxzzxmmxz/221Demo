


public class Character {
    public static final int MAX_HP = 100;
    private String name;
    private int x;
    private int y;
    private int hp;

    Character(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.hp = MAX_HP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", hp=" + hp +
                '}';
    }
}

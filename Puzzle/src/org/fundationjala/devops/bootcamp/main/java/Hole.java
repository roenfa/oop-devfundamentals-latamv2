public class Hole {
    private int value;
    private Position position;

    public Hole(Position position) {
        this.value = 0;
        this.position = position;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
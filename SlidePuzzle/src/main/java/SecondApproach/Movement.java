package SecondApproach;

public class Movement {
    private Position position;
    private String direction;

    public Movement(Position position, String direction) {
        this.position = position;
        this.direction = direction;
    }

    public Movement() {

    }

    public Position getPosition() {
        return position;
    }

    public String getDirection() {
        return direction;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}

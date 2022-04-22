import java.util.ArrayList;
import java.util.List;

public class Movement {

    private String command;
    private Position movement;

    public Movement(){
    }
    public Movement(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void possibleMovements(Table table) {
        List<String> movements = new ArrayList<>();
        Position holePosition = table.getHole().getPosition();
        movements.add("up");
        movements.add("down");
        movements.add("left");
        movements.add("right");
        if (holePosition.getRow() == 0) {
            movements.remove("up");
        }
        if (holePosition.getRow() == table.getLimit() - 1) {
            movements.remove("down");
        }
        if (holePosition.getColumn() == 0) {
            movements.remove("left");
        }
        if (holePosition.getColumn() == table.getLimit() - 1) {
            movements.remove("right");
        }
        movements.forEach(System.out::println);
    }

    public void move(Table table, String command) {
        Position holePosition = table.getHole().getPosition();
        if (command.equals("up")) {
            Position valueToSwitch = new Position(holePosition.getRow() - 1, holePosition.getColumn());
            table.switchPositions(holePosition, valueToSwitch);
            setMovement(valueToSwitch);
        } else if (command.equals("down")) {
            Position valueToSwitch = new Position(holePosition.getRow() + 1, holePosition.getColumn());
            table.switchPositions(holePosition, valueToSwitch);
            setMovement(valueToSwitch);
        } else if (command.equals("left")) {
            Position valueToSwitch = new Position(holePosition.getRow(), holePosition.getColumn() - 1);
            table.switchPositions(holePosition, valueToSwitch);
            setMovement(valueToSwitch);
        } else if (command.equals("right")) {
            Position valueToSwitch = new Position(holePosition.getRow(), holePosition.getColumn() + 1);
            table.switchPositions(holePosition, valueToSwitch);
            setMovement(valueToSwitch);
        }
    }

    public void setMovement(Position movement) {
        this.movement = movement;
    }

    public Position getMovement() {
        return movement;
    }
}

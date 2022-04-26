import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Movement {

    private List<Position> movements;
    private Position movement;

    public Movement() {
        this.movements = new ArrayList<>();
    }

    public void addMovement(Position movement) {
        this.movements.add(movement);
    }

    public List<String> possibleMovements(Table table) {
        List<String> movements = new ArrayList<>();
        Position holePosition = table.getHole().getPosition();
        movements.add("up (w)");
        movements.add("down (s)");
        movements.add("left (a)");
        movements.add("right (d)");
        if (holePosition.getRow() == 0) {
            movements.remove("up (w)");
        }
        if (holePosition.getRow() == table.getLimit() - 1) {
            movements.remove("down (s)");
        }
        if (holePosition.getColumn() == 0) {
            movements.remove("left (a)");
        }
        if (holePosition.getColumn() == table.getLimit() - 1) {
            movements.remove("right (d)");
        }
        return movements;
    }

    public void move(Table table, String command) {
        Position holePosition = table.getHole().getPosition();
        if (command.equals("w") || command.equals("up (w)")) {
            if (holePosition.getRow() > 0) {
            Position valueToSwitch = new Position(holePosition.getRow() - 1, holePosition.getColumn());
            table.switchPositions(holePosition, valueToSwitch);
            setMovement(valueToSwitch);
            movements.add(valueToSwitch);
            } else {
                System.out.println("You can't move up");
            }
        }
        if (command.equals("s") || command.equals("down (s)")) {
            if (holePosition.getRow() < table.getLimit() - 1) {
                Position valueToSwitch = new Position(holePosition.getRow() + 1, holePosition.getColumn());
                table.switchPositions(holePosition, valueToSwitch);
                setMovement(valueToSwitch);
                movements.add(valueToSwitch);
            } else {
                System.out.println("You can't move down");
            }
        }
        if (command.equals("a") || command.equals("left (a)")) {
            if (holePosition.getColumn() > 0) {
                Position valueToSwitch = new Position(holePosition.getRow(), holePosition.getColumn() - 1);
                table.switchPositions(holePosition, valueToSwitch);
                setMovement(valueToSwitch);
                movements.add(valueToSwitch);
            } else {
                System.out.println("You can't move left");
            }
        }
        if (command.equals("d") || command.equals("right (d)")) {
            if (holePosition.getColumn() < table.getLimit() - 1) {
                Position valueToSwitch = new Position(holePosition.getRow(), holePosition.getColumn() + 1);
                table.switchPositions(holePosition, valueToSwitch);
                setMovement(valueToSwitch);
                movements.add(valueToSwitch);
            } else {
                System.out.println("You can't move right");
            }
        }
    }

    public void setRandomMovements(int movements, Table table) {
        Random random = new Random();
        for (int i = 0; i < movements; i++) {
            List<String> possibles= possibleMovements(table);
            int index = random.nextInt(possibles.size());
            String movementString = possibles.get(index);
            move(table, movementString);
        }
    }

    public void printMovements() {
        Collections.reverse(movements);
        int i = movements.size();
        for (Position movement : movements) {
            System.out.println(i + ". " + movement.toString());
            i--;
        }
    }

    public void setMovement(Position movement) {
        this.movement = movement;
    }

    public Position getMovement() {
        return movement;
    }
}
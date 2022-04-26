import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movement {

    private String command;
    private Position movement;
    private MovementStorage movementStorage;

    public Movement() {
        this.movementStorage = new MovementStorage();
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
            movementStorage.addMovement(valueToSwitch);
            } else {
                System.out.println("You can't move up");
            }
        }
        if (command.equals("s") || command.equals("down (s)")) {
            if (holePosition.getRow() < table.getLimit() - 1) {
                Position valueToSwitch = new Position(holePosition.getRow() + 1, holePosition.getColumn());
                table.switchPositions(holePosition, valueToSwitch);
                setMovement(valueToSwitch);
                movementStorage.addMovement(valueToSwitch);
            } else {
                System.out.println("You can't move down");
            }
        }
        if (command.equals("a") || command.equals("left (a)")) {
            if (holePosition.getColumn() > 0) {
                Position valueToSwitch = new Position(holePosition.getRow(), holePosition.getColumn() - 1);
                table.switchPositions(holePosition, valueToSwitch);
                setMovement(valueToSwitch);
                movementStorage.addMovement(valueToSwitch);
            } else {
                System.out.println("You can't move left");
            }
        }
        if (command.equals("d") || command.equals("right (d)")) {
            if (holePosition.getColumn() < table.getLimit() - 1) {
                Position valueToSwitch = new Position(holePosition.getRow(), holePosition.getColumn() + 1);
                table.switchPositions(holePosition, valueToSwitch);
                setMovement(valueToSwitch);
                movementStorage.addMovement(valueToSwitch);
            } else {
                System.out.println("You can't move right");
            }
        }
    }

    public MovementStorage getMovementStorage() {
        return movementStorage;
    }

    public void setMovementStorage(MovementStorage movementStorage) {
        this.movementStorage = movementStorage;
    }

    public void setMovement(Position movement) {
        this.movement = movement;
    }

    public Position getMovement() {
        return movement;
    }
/*
@Override
    public void keyPressed(KeyEvent e) {
        Position holePosition = table.getHole().getPosition();
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
          if(holePosition.getColumn() < table.getLimit() - 1){
                Position valueToSwitch = new Position(holePosition.getRow(), holePosition.getColumn() + 1);
                table.switchPositions(holePosition, valueToSwitch);
                setMovement(valueToSwitch);
           }
                else

            System.out.println("Cannot Move Right");
    }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
       {
            if(holePosition.getColumn() > 0){
                Position valueToSwitch = new Position(holePosition.getRow(), holePosition.getColumn() - 1);
              table.switchPositions(holePosition, valueToSwitch);
              setMovement(valueToSwitch);
           }
       else
                System.out.println("Cannot Move Left");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
                 {
          if(holePosition.getRow() < table.getLimit() - 1){
                   Position valueToSwitch = new Position(holePosition.getRow() + 1, holePosition.getColumn());
              table.switchPositions(holePosition, valueToSwitch);
               setMovement(valueToSwitch);
           }
            else
               System.out.println("Cannot Move Down");
       }
        if (e.getKeyCode() == KeyEvent.VK_UP)
      {
          if(holePosition.getRow() > 0){
              Position valueToSwitch = new Position(holePosition.getRow() - 1, holePosition.getColumn());
              table.switchPositions(holePosition, valueToSwitch);
              setMovement(valueToSwitch);
         }
          else
              System.out.println("Cannot Move Up");
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}


 */
}
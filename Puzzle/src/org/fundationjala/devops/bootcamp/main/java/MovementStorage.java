import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovementStorage {

    private List<Position> movements = new ArrayList<>();

    public MovementStorage() {
        this.movements = new ArrayList<>();
    }

    public List<Position> getMovements() {
        return movements;
    }

    public void addMovement(Position movement) {
        movements.add(movement);
    }

    public void printMovements() {
        movements.remove(0);
        Collections.reverse(movements);
        int i = movements.size();
        for (Position movement : movements) {
            System.out.println(i + ". " + movement.toString());
            i--;
        }
    }
}

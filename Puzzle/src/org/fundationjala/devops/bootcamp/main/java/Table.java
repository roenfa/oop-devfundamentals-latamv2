import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Table {

    private int limit = 1;
    private int[][] matriz;
    private Hole hole;

    public Table(int limit) {
        this.limit = limit;
        this.hole = new Hole(new Position(limit-1, limit-1));
        this.matriz = create(limit);

    }

    public int[][] create(int limit){
        int[][] matriz = new int[limit][limit];
        int l = 1;
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                matriz[i][j] = l++;
            }
        }
        matriz[limit-1][limit-1]= hole.getValue();
        System.out.println(hole.getPosition());
        return matriz;
    }

    public void printTable(){
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                if (matriz[i][j] > 9){
                    System.out.print(matriz[i][j] + " ");
                } else {
                    System.out.print(matriz[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    public void shuffle(int [][] matriz){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                list.add(matriz[i][j]);
            }
        }
        Collections.shuffle(list);
        int l = 1;
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                matriz[i][j] = list.get(l-1);
                l++;
            }
        }
        setMatriz(matriz);
        resetHole(matriz);
    }

    public void resetHole(int[][] matriz){
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                if (matriz[i][j] == 0) {
                    hole.setPosition(new Position(i, j));
                }
            }
        }
    }

    public void setRandomMovements(int movements) {
        Movement movement = new Movement();
        Random random = new Random();
        for (int i = 0; i < movements; i++) {
            List<String> possibles= movement.possibleMovements(this);
            int index = random.nextInt(possibles.size());
            String movementString = possibles.get(index);
            movement.move(this, movementString);
        }
        movement.getMovementStorage().printMovements();
    }

    public int getValue(int x, int y){
        return matriz[x][y];
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getLimit() {
        return limit;
    }

    public Hole getHole() {
        return hole;
    }

    public void setHole(Hole hole) {
        this.hole = hole;
    }

    public void switchPositions(Position holePosition, Position valueToSwitch) {
        //Value to switch
        int value = matriz[valueToSwitch.getRow()][valueToSwitch.getColumn()];
        //New value position
        matriz[holePosition.getRow()][holePosition.getColumn()] = value;
        //New hole position
        matriz[valueToSwitch.getRow()][valueToSwitch.getColumn()] = hole.getValue();
        hole.setPosition(valueToSwitch);
    }
}
